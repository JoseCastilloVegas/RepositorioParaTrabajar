package com.example.Prueba_Test.Service;

import com.example.Prueba_Test.Repository.UserRepository;
import com.example.Prueba_Test.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;

    public User registerUser(String name, String email) {
        User newUser = new User(null, name, email);

        return userRepository.save(newUser);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

    public User encuentraPorId(Long id) {

        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id no valido"));
    }

    public User guardaUsuario(User user) {

       return userRepository.save(user);
    }


    public final  User getUserByIdFinal(String email){
        return userRepository.findByEmail(email).orElseThrow();

    }

    public void getUserByIdException(Long id){
       User user=userRepository.findById(id).orElseThrow();
       System.out.println("El usuario encontrado ha sido "+ user.getName());
    }

    public void borrar(Long id){
        User user=userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }
}

