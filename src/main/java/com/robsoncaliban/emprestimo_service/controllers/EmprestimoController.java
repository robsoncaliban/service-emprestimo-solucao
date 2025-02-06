package com.robsoncaliban.emprestimo_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robsoncaliban.emprestimo_service.dto.EmprestimoDtoRequest;
import com.robsoncaliban.emprestimo_service.entities.Emprestimo;
import com.robsoncaliban.emprestimo_service.services.EmprestimoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/emprestimos")
public class EmprestimoController {
    private EmprestimoService emprestimoService;

    @PostMapping
    public ResponseEntity<Emprestimo> addEmprestimo(@RequestBody EmprestimoDtoRequest emprestimoDtoRequest){
        var emprestimo = emprestimoService.addEmprestimo(emprestimoDtoRequest);
        return ResponseEntity.ok().body(emprestimo);
    }
}
