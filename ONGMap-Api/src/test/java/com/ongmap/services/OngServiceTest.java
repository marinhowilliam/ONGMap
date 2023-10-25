package com.ongmap.services;

import com.ongmap.models.ong.Ong;
import com.ongmap.repositories.OngRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collections;

import static org.mockito.Mockito.*;

class OngServiceTest {

    @Mock
    private OngRepository ongRepository;

    @InjectMocks
    private OngService ongService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        Ong ong = new Ong();
        when(ongRepository.save(ong)).thenReturn(ong);

        ongService.create(ong);

        verify(ongRepository).save(ong);
    }

    @Test
    void testGetByCnpj() {
        String cnpj = "12345678901234";
        Ong ong = new Ong();
        when(ongRepository.getReferenceById(cnpj)).thenReturn(ong);

        ongService.getBycpnj(cnpj);

        verify(ongRepository).getReferenceById(cnpj);
    }

    @Test
    void testDelete() {
        String cnpj = "12345678901234";

        ongService.delete(cnpj);

        verify(ongRepository).deleteById(cnpj);
    }

    @Test
    void testFindAll() {
        Page<Ong> ongPage = new PageImpl<>(Collections.singletonList(new Ong()));
        when(ongRepository.findAll(any(Pageable.class))).thenReturn(ongPage);

        ongService.findAll(Pageable.unpaged());

        verify(ongRepository).findAll(any(Pageable.class));
    }

    @Test
    void testUpdate() {
        Ong ong = new Ong();
        ong.setCnpj("12345678901234");
        Ong existingOng = new Ong();
        when(ongRepository.getReferenceById(ong.getCnpj())).thenReturn(existingOng);

        ongService.update(ong);

        verify(ongRepository).getReferenceById(ong.getCnpj());
        // You might also want to add verification for the setters if the fields are not null.
    }
}
