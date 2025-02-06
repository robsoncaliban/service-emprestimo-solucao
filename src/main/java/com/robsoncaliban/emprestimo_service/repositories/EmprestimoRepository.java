package com.robsoncaliban.emprestimo_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robsoncaliban.emprestimo_service.entities.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{
    
}
