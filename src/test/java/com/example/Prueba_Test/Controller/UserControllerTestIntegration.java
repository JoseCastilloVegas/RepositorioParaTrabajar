package com.example.Prueba_Test.Controller;

import com.example.Prueba_Test.Service.UserService;
import com.example.Prueba_Test.domain.User;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTestIntegration {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserService userService;

    @BeforeEach
    void setUp() {
        userService.guardaUsuario(new User(null, "Manolo", "manoloEmail"));
    }

    @Test
    void crearUsuario() throws Exception {
        mockMvc.perform(post("/crearUsuario/Juan/juanEmail")
                        .header("Host", "8081")
                        .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void dameUsuario() throws Exception {

        mockMvc.perform(get("/dameUsuario/1")).andExpect(status().isOk());

        System.out.println("El nombre del usuario guardado es: " + userService.encuentraPorId(1L).getName());
    }

    @Test
    void cambiaNombreYEmail() throws Exception {

        userService.guardaUsuario(new User(null, "Tio camuñas", "tio camuñas email"));

        mockMvc.perform(patch("/cambiaNameEmail")
                        .param("nombreViejo", "tio camuñas email")
                        .param("name", "Josete")
                        .param("email", "elcrack@")
                ).andExpect(status().isAccepted())
                .andExpect(header().string("Content-Type", Matchers.containsString("application/json")))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void borra() throws Exception {
        mockMvc.perform(delete("/borraEsoXD")
                .param("id", "1")
        ).andExpect(status().isOk());
    }

    @Test
    void crearConBody() throws Exception {
        mockMvc.perform(post("/crearConBody")
                        .param("email", "manoloEmail")
                        .content("{\"nombre\":\"nombreInventado\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"nombreInventado\",\"email\":\"manoloEmail\"}"));
    }

    @Test
    void dameHeader() throws Exception {
        mockMvc.perform(get("/dameHeader")
                .header("Host", "8090")
        ).andExpect(status().isOk());

    }
}