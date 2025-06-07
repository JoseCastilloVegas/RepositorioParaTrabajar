package com.example.Prueba_Test.Controller;


import com.example.Prueba_Test.Service.UserService;
import com.example.Prueba_Test.domain.User;
import com.example.Prueba_Test.dto.NombreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/crearUsuario/{name}/{email}")
    ResponseEntity<?> crearUsuario(@PathVariable String name, @PathVariable String email) {
        userService.registerUser(name, email);
        return ResponseEntity.ok().body("El usuario nuevo se llama " + name);
    }

    @GetMapping("/dameUsuario/{id}")
    User dameUsuario(@PathVariable Long id) {
        return userService.encuentraPorId(id);
    }


    @Transactional
    @PatchMapping("cambiaNameEmail")
    ResponseEntity<?> cambiaNombreYEmail(@RequestParam("nombreViejo") String oldName, @RequestParam String name, @RequestParam String email) {

        User user = userService.getUserByEmail(oldName);
        user.setName(name);
        user.setEmail((email));
        return ResponseEntity.accepted().body(user);
    }

    @Transactional
    @DeleteMapping("/borraEsoXD")
    ResponseEntity<?> borra(@RequestParam Long id) {
        userService.borrar(id);
        return ResponseEntity.ok().body("Usuario con id " + id + " borrado con exito crack xdddd");
    }

    @Transactional
    @PostMapping("/crearConBody")
    public User crearConBody(@RequestBody NombreDTO nombreDTO, @RequestParam String email) {
        System.out.println(nombreDTO.getNombre());
        User user=userService.getUserByEmail(email);
        user.setName(nombreDTO.getNombre());

        return user;



    }

    @GetMapping("/dameHeader")
    public void dameHeader(@RequestHeader("Host") String host){
        System.out.println("El host desde el que se ha hecho la peticion es: "+host);

        List<Integer> lista= List.of(1,2,3,4);

        Stream<Integer> listastream=lista.stream();

        Stream<String> listamap=listastream.map(s->"El numero es;" +s);

        System.out.println(listamap.toList());
    }

}
