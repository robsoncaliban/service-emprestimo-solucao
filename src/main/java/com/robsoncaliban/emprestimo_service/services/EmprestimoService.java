package com.robsoncaliban.emprestimo_service.services;

import org.springframework.stereotype.Service;

import com.robsoncaliban.emprestimo_service.dto.EmprestimoDtoRequest;
import com.robsoncaliban.emprestimo_service.entities.Emprestimo;
import com.robsoncaliban.emprestimo_service.repositories.EmprestimoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmprestimoService {
    
    private EmprestimoRepository emprestimoRepository;


    public Emprestimo addEmprestimo(EmprestimoDtoRequest emprestimoDto){
        var novoEmprestimo = new Emprestimo(emprestimoDto.tipo(),emprestimoDto.taxaJuros());
        return emprestimoRepository.save(novoEmprestimo);
    }
    
}
