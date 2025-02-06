package com.robsoncaliban.emprestimo_service.entities;

import java.math.BigDecimal;

import com.robsoncaliban.emprestimo_service.entities.enums.EmprestimoTipo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
public class Emprestimo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EmprestimoTipo tipo;
    private BigDecimal taxaJuros;

    public Emprestimo(EmprestimoTipo tipo, BigDecimal taxaJuros) {
        this.tipo = tipo;
        this.taxaJuros = taxaJuros;
    }
}
