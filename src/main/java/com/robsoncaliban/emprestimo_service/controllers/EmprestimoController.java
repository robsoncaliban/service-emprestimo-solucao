package com.robsoncaliban.emprestimo_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robsoncaliban.emprestimo_service.dto.ClienteDtoRequest;
import com.robsoncaliban.emprestimo_service.dto.EmprestimoDtoRequest;
import com.robsoncaliban.emprestimo_service.dto.response.AnalisarEmprestimoDtoResponse;
import com.robsoncaliban.emprestimo_service.dto.response.EmprestimoDtoResponse;
import com.robsoncaliban.emprestimo_service.entities.Emprestimo;
import com.robsoncaliban.emprestimo_service.services.EmprestimoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/emprestimos")
public class EmprestimoController {
    private EmprestimoService emprestimoService;

    @PostMapping
    public ResponseEntity<AnalisarEmprestimoDtoResponse> analisarEmprestimo(
        @RequestBody 
        ClienteDtoRequest clienteDtoRequest){
            
        var emprestimo = emprestimoService.analisarEmprestimo(clienteDtoRequest);
        return ResponseEntity.ok().body(emprestimo);
    }
}
