package com.example.Prueba_Test.Controller;

import com.example.Prueba_Test.Service.UserService;
import com.example.Prueba_Test.domain.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTestUnitario {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;


    @Test
    void crearUsuario() throws Exception {

        when(userService.registerUser(anyString(), anyString()))
                .thenAnswer(invocation -> {
                    String nombre = invocation.getArgument(0);
                    String email = invocation.getArgument(1);
                    return new User(null, nombre, email);

                });

        mockMvc.perform(post("/crearUsuario/{name}/{email}", "Julian", "g"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andExpect(content().string("El usuario nuevo se llama Julian"));

    }

    @Test
    void dameUsuario() throws Exception {

        when(userService.encuentraPorId(anyLong())).thenReturn(new User(34L, "Manolo", "emailManolo"));

        mockMvc.perform(get("/dameUsuario/34"))
                .andExpect(status().isOk())

                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Manolo"))
                .andExpect(jsonPath("$.email").value("emailManolo"))
                .andExpect(jsonPath("$.id").value(34));

    }

    @Test
    void cambiaNombreYEmail() throws Exception {

        when(userService.getUserByEmail("@Nerd")).thenReturn(new User(56L, "Jesus", "@Nerd"));

        mockMvc.perform(patch("/cambiaNameEmail").param("name", "Josete")
                        .param("email", "@Malito")
                        .param("nombreViejo", "@Nerd")
                ).andExpect(status().isAccepted())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Josete"));
    }

    @Test
    void borra() throws Exception {
        doNothing().when(userService).borrar(anyLong());
        mockMvc.perform(delete("/borraEsoXD").param("id", "89"))
                .andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andExpect(content().string("Usuario con id " + 89 + " borrado con exito crack xdddd"));

    }

    @Test
    void crearConBody() throws Exception {
        User user = new User(56L, "Carlitos", "@carlos");
        when(userService.getUserByEmail(anyString())).thenReturn(user);

        mockMvc.perform(post("/crearConBody").param("email", "@carlos")
                        .content("{\"nombre\":\"Nuevo nombre malito\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":56,\"name\":\"Nuevo nombre malito\",\"email\":\"@carlos\"}"));
    }

    @Test
    void dameHeader() throws Exception {
        mockMvc.perform(get("/dameHeader").header("Host","1000"))
                .andExpect(status().isOk());
    }
}