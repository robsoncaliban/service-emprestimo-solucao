package com.robsoncaliban.emprestimo_service.services;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.robsoncaliban.emprestimo_service.dto.ClienteDtoRequest;
import com.robsoncaliban.emprestimo_service.dto.response.AnalisarEmprestimoDtoResponse;
import com.robsoncaliban.emprestimo_service.entities.Emprestimo;
import com.robsoncaliban.emprestimo_service.entities.enums.EmprestimoTipo;
import com.robsoncaliban.emprestimo_service.services.chain.ValidadorEtapa;
import com.robsoncaliban.emprestimo_service.services.chain.ValidadorIdadeLocalidade;
import com.robsoncaliban.emprestimo_service.services.chain.ValidadorSalario;
import com.robsoncaliban.emprestimo_service.services.chain.enums.ValidacaoTipo;

@Service
public class EmprestimoService {
    
    public AnalisarEmprestimoDtoResponse analisarEmprestimo(ClienteDtoRequest cliente){
        List<Emprestimo> emprestimosValidos = new ArrayList<>(); 
        if (validarTodasCrendeciais(cliente) == ValidacaoTipo.VALIDO_PESSOAL_COM_GARANTIA) {
            emprestimosValidos.add(new Emprestimo(EmprestimoTipo.PESSOAL, BigDecimal.valueOf(4)));
            emprestimosValidos.add(new Emprestimo(EmprestimoTipo.COM_GARANTIA, BigDecimal.valueOf(2)));
        }
        if (validarSalario(cliente) == ValidacaoTipo.VALIDO_CONSIGNADO) {
            emprestimosValidos.add(new Emprestimo(EmprestimoTipo.CONSIGNADO, BigDecimal.valueOf(3)));
        }
        return new AnalisarEmprestimoDtoResponse(cliente.nome(), emprestimosValidos);
    }
    
    private ValidacaoTipo validarTodasCrendeciais(ClienteDtoRequest cliente){
        ValidadorEtapa chain = new ValidadorSalario();
        chain.setProximo(new ValidadorIdadeLocalidade());
        return (chain.validarCredenciais(cliente));
    }

    private ValidacaoTipo validarSalario(ClienteDtoRequest cliente){
        ValidadorEtapa salarioValido = new ValidadorSalario();
        return (salarioValido.validarCredenciais(cliente));
    }
}
