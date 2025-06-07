package com.example.Prueba_Test.Service.Integracion;

import com.example.Prueba_Test.Repository.UserRepository;
import com.example.Prueba_Test.Service.UserService;
import com.example.Prueba_Test.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class UserServiceTestIntegation {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    void registerUser() {


        User user=userService.registerUser("Jose","joseEmail");

        assertEquals("Jose",user.getName(),"El nombre no es correcto");
        assertEquals("joseEmail",user.getEmail());

        User userEnBaseDeDatos=userRepository.findById(user.getId()).orElseThrow();

       assertEquals(user.getId(),userEnBaseDeDatos.getId());
       assertEquals(user.getName(),userEnBaseDeDatos.getName());
       assertEquals(user,userEnBaseDeDatos);

System.out.println("El id es: "+user.getId());


    }
}