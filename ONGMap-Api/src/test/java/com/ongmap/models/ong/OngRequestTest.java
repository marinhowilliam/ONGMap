package com.ongmap.models.ong;

import org.junit.jupiter.api.Test;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

class OngRequestTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void testValidCnpj() {
            OngRequest request = new OngRequest("12345678901234", "Test Name", "Test Phone", new Endereco(), "Test Mission", AreaAtuacao.MEIO_AMBIENTE, true);
        assertTrue(validator.validate(request).isEmpty());
    }

    @Test
    void testInvalidCnpj() {
        OngRequest request = new OngRequest("12345", "Test Name", "Test Phone", new Endereco(), "Test Mission", AreaAtuacao.CULTURA, true);
        assertFalse(validator.validate(request).isEmpty());
    }

    // Similarly, you can add tests for other validations e.g. not blank fields

    @Test
    void testToOngConversion() {
        OngRequest request = new OngRequest("12345678901234", "Test Name", "Test Phone", new Endereco(), "Test Mission", AreaAtuacao.ASSISTENCIA_SOCIAL, true);
        Ong ong = request.toOng();

        assertEquals(request.cnpj(), ong.getCnpj());
        assertEquals(request.nome(), ong.getNome());
        assertEquals(request.telefone(), ong.getTelefone());
        assertEquals(request.endereco(), ong.getEndereco());
        assertEquals(request.missao(), ong.getMissao());
        assertEquals(request.areaAtuacao(), ong.getAreaAtuacao());
        assertEquals(request.ativo(), ong.isAtivo());
    }
}
