package com.ongmap.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ongmap.models.ong.*;
import com.ongmap.services.OngService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class OngControllerTest {

    @Mock
    private OngService ongService;

    @InjectMocks
    private OngController ongController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ongController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testCreate() throws Exception {
        Endereco endereco = new Endereco("A", "4636", "56", "a");  // Assuming you have a default constructor or some way to create an Endereco
          // Similarly, assuming you have a default constructor or some way to create an AreaAtuacao

        OngRequest request = new OngRequest(
                "12345678901234",   // CNPJ
                "Ong Name",         // Name
                "123-456-7890",     // Phone number
                endereco,           // Address object
                "Our mission is to help",  // Mission statement
                AreaAtuacao.EDUCACAO,
                true                // Active status
        );

        Ong ong = new Ong();
        when(ongService.create(any())).thenReturn(ong);

        mockMvc.perform(post("/ongs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());

        verify(ongService).create(any());
    }

    @Test
    void testGet() throws Exception {
        String cnpj = "12345678901234";
        Ong ong = new Ong();
        when(ongService.getBycpnj(cnpj)).thenReturn(ong);

        mockMvc.perform(get("/ongs/" + cnpj))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(new OngDetails(ong))));
    }

    @Test
    void testDelete() throws Exception {
        String cnpj = "12345678901234";

        mockMvc.perform(delete("/ongs/" + cnpj))
                .andExpect(status().isNoContent());
    }

    @Test
    void testFindAll() throws Exception {
        Ong ong = new Ong();
        when(ongService.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(Collections.singletonList(ong)));

        mockMvc.perform(get("/ongs"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Collections.singletonList(new OngDetails(ong)))));
    }
}