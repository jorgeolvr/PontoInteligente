package com.group.pontointeligente.api.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.concurrent.ExecutionException;

public class PasswordUtilsTest {
    private static final String SENHA = "123456";

    // Instancia de BCryptPasswordEncoder para validar o hash no teste
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Test
    public void testSenhaNula() throws Exception {
        Assertions.assertNull(PasswordUtils.gerarBCrypt(null));
    }

    @Test
    public void testGerarHashSenha() throws Exception {
        String hash = PasswordUtils.gerarBCrypt(SENHA);
        Assertions.assertTrue(bCryptPasswordEncoder.matches(SENHA, hash));
    }
}
