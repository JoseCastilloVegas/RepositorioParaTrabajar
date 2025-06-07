package com.example.Prueba_Test.Repository;

import com.example.Prueba_Test.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp(){

        User user =new User(null,"Perico","emialPerico");
        User user2=new User(null,"Koki","kokiEmail");
        User user3=new User(null,"Ortensia","ortensiaEmail");

        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user3);

    }

    @Test
    void findByEmail() {
        List<User> listaUser=userRepository.findAll();

        assertEquals(3,listaUser.size());

        User userByEmail=userRepository.findByEmail("kokiEmail").orElseThrow();

        assertEquals(2,userByEmail.getId());
        assertEquals("kokiEmail",userByEmail.getEmail());

    }
}