package com.robsoncaliban.emprestimo_service.entities.dto.response;

import java.util.List;

import com.robsoncaliban.emprestimo_service.entities.Emprestimo;

public record AnalisarEmprestimoDtoResponse(
    String nomeCliente,
    List<Emprestimo> emprestimos) {   
}
