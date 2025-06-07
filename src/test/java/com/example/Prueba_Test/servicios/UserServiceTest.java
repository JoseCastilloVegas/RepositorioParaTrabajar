package com.example.Prueba_Test.servicios;

import com.example.Prueba_Test.Repository.UserRepository;
import com.example.Prueba_Test.Service.UserService;
import com.example.Prueba_Test.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;


    @Test
    void registerUserTest() {

        User user = new User(null, "Daniel", "email");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User newUser = userService.registerUser("Daniel", "email");

        assertEquals(newUser, user);

        verify(userRepository,never()).findById(anyLong());

        verifyNoMoreInteractions(userRepository);

        reset(userRepository);

        User user2=new User(2L,"Pedro","email2");

        when(userRepository.save(any(User.class))).thenReturn(user2);

        User newUser2=userService.registerUser("Pedro","email2");

        assertEquals(user2.getEmail(),newUser2.getEmail());

        verify(userRepository,times(1)).save(any(User.class));

    }

    @Test
    public void getUserByEmailTest() {

        User aurora = new User(1L, "Aurora", "email");

        when(userRepository.findByEmail("email")).thenReturn(Optional.of(aurora));

        User user = userService.getUserByEmail("email");

        verify(userRepository).findByEmail(stringArgumentCaptor.capture());

        assertEquals("email",stringArgumentCaptor.getValue());



        assertEquals("Aurora", user.getName());

        verify(userRepository).findByEmail(("email"));

    }

    @Test
    void encuentraPorIdTest() {

        when(userRepository.findById(12L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> {
            userService.encuentraPorId(12L);
        });
    }

    @Test
    void encuentraIdTestConException() {

        when(userRepository.findById(12L)).thenThrow(new DataAccessException("Fallo en la conexion") {
        });

        assertThrows(DataAccessException.class, () -> userService.encuentraPorId(12L));
    }

    @Test
    void testConAnswer() {

        List<User> listaTest = new ArrayList<>();

        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User user = invocation.getArgument(0);
            listaTest.add(user);
            return user;

        });

        User user = userService.guardaUsuario(new User(3L, "Maria", "email"));

        assertEquals(1, listaTest.size());
        assertNotEquals(true, listaTest.isEmpty());
        assertEquals("Maria", listaTest.getFirst().getName());
        assertEquals(user, listaTest.getFirst());

        verify(userRepository,times(1)).save(any(User.class));

    }

    @Test
    void getUserByIdTest(){
        User user=new User(2L,"Manolo","emailManolo");

        doReturn(Optional.of(user)).when(userRepository).findByEmail("emailManolo");

        User manolo=userService.getUserByIdFinal("emailManolo");

        assertEquals("Manolo",manolo.getName());

    }

@Test
    void getUserByIdExceptionTest(){
        doThrow(new DataAccessException("Fallo en la conexion") {}).when(userRepository).findById(5L);

        assertThrows(DataAccessException.class,()->userService.getUserByIdException(5L));
}

@Test
    void GetUserByIdExceptionTestReturn(){
        doReturn(Optional.empty()).when(userRepository).findById(1L);

        assertThrows(NoSuchElementException.class,()->userService.getUserByIdException(1L));

        verify(userRepository).findById(1L);
}


}

