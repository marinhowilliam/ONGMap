package com.ongmap.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ongmap.models.doacao.DoacaoRequest;
import com.ongmap.services.DoacaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class DoacaoControllerTest {
    @Mock
    private DoacaoService doacaoService;

    @InjectMocks
    private DoacaoController doacaoController;
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(doacaoController).build();
        objectMapper = new ObjectMapper();
    }

//    @Test
//    void TestCreate() throws Exception{
//        DoacaoRequest request = new DoacaoRequest(
//        )
 //   }

    @Test
    void testDelete() throws Exception {

    }
}
