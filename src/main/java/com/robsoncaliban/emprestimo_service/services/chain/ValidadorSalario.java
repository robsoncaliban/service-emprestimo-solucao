package com.robsoncaliban.emprestimo_service.services.chain;

import java.math.BigDecimal;

import com.robsoncaliban.emprestimo_service.dto.ClienteDtoRequest;
import com.robsoncaliban.emprestimo_service.services.chain.enums.ValidacaoTipo;

public class ValidadorSalario extends ValidadorEtapa {

    @Override
    public ValidacaoTipo validarCredenciais(ClienteDtoRequest cliente) {
        var salario01 = BigDecimal.valueOf(3000);
        if(cliente.salario().compareTo(salario01) <= 0){
            return ValidacaoTipo.VALIDO_PESSOAL_COM_GARANTIA;
        }

        var salario02 = BigDecimal.valueOf(5000);
        if (cliente.salario().compareTo(salario02) < 0) {
            return super.validarCredenciais(cliente);
        }

        return ValidacaoTipo.VALIDO_CONSIGNADO;
    }
    // > 0 se o parametro do compareTo for menor 
    // < 0 se o parametro do compareTo for maior
}
