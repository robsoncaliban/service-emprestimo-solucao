package com.robsoncaliban.emprestimo_service.entities;

import java.math.BigDecimal;

import com.robsoncaliban.emprestimo_service.entities.enums.EmprestimoTipo;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class Emprestimo {
    
    private EmprestimoTipo tipo;
    private BigDecimal taxaJuros;

    public Emprestimo(EmprestimoTipo tipo, BigDecimal taxaJuros) {
        this.tipo = tipo;
        this.taxaJuros = taxaJuros;
    }
}
