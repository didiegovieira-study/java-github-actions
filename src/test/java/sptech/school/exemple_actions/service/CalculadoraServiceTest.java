package sptech.school.exemple_actions.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraServiceTest {

    @Test
    @DisplayName("Deve dividir dois números")
    public void testDividir() {
        // Arrange
        CalculadoraService calculadoraService = new CalculadoraService();
        double a = 10;
        double b = 2;
        double esperado = 5;

        // Act
        double resultado = calculadoraService.dividir(a, b);
        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Quando acionado com 10 e 0, então deve lançar uma exceção")
    public void testDividirPorZero() {
        // Arrange
        CalculadoraService calculadoraService = new CalculadoraService();
        double a = 10;
        double b = 0;
        var exceptedMessage = "400 BAD_REQUEST \"Divisão por zero não permitida\"";

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            // Act
            calculadoraService.dividir(a, b);
        });

        // Act
        assertEquals(exceptedMessage, exception.getMessage());
    }
}