package com.robsoncaliban.emprestimo_service.dto;

import java.math.BigDecimal;

import com.robsoncaliban.emprestimo_service.entities.enums.EmprestimoTipo;

public record EmprestimoDtoRequest(EmprestimoTipo tipo, BigDecimal taxaJuros) {
    
}
