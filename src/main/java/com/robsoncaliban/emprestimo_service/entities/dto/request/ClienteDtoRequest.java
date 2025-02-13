package com.robsoncaliban.emprestimo_service.entities.dto.request;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ClienteDtoRequest(
    @NotBlank
    String nome,

    @CPF
    String cpf,

    @NotNull
    @Min(value = 18, message = "Deve ter no mínimo 18 anos")
    int idade,
    
    @NotNull
    @Positive(message = "Somente valores positivos")
    BigDecimal salario,
    
    @NotBlank
    String localidade) {
    
}
