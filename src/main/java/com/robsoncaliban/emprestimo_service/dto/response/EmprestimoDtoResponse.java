package com.robsoncaliban.emprestimo_service.dto.response;

import java.math.BigDecimal;

import com.robsoncaliban.emprestimo_service.entities.Emprestimo;
import com.robsoncaliban.emprestimo_service.entities.enums.EmprestimoTipo;

public record EmprestimoDtoResponse(
    EmprestimoTipo tipo,
    BigDecimal taxa_juros
) {
    public EmprestimoDtoResponse(Emprestimo emprestimo) {
        this(emprestimo.getTipo(), emprestimo.getTaxaJuros());
    }
}
