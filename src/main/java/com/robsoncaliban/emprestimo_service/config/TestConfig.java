package com.robsoncaliban.emprestimo_service.config;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.robsoncaliban.emprestimo_service.dto.EmprestimoDtoRequest;
import com.robsoncaliban.emprestimo_service.entities.enums.EmprestimoTipo;
import com.robsoncaliban.emprestimo_service.services.EmprestimoService;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class TestConfig implements CommandLineRunner{

    private EmprestimoService emprestimoService;

    @Override
    public void run(String... args) throws Exception {

        EmprestimoDtoRequest emprestimo01 = new EmprestimoDtoRequest(EmprestimoTipo.PESSOAL,
            BigDecimal.valueOf(4));
        EmprestimoDtoRequest emprestimo02 = new EmprestimoDtoRequest(EmprestimoTipo.CONSIGNADO,
            BigDecimal.valueOf(2));
        EmprestimoDtoRequest emprestimo03 = new EmprestimoDtoRequest(EmprestimoTipo.COM_GARANTIA,
            BigDecimal.valueOf(3));
        
        emprestimoService.addEmprestimo(emprestimo01);
        emprestimoService.addEmprestimo(emprestimo02);
        emprestimoService.addEmprestimo(emprestimo03);
    }
    
}
