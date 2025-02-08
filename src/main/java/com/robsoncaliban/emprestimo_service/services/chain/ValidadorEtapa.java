package com.robsoncaliban.emprestimo_service.services.chain;


import com.robsoncaliban.emprestimo_service.dto.ClienteDtoRequest;
import com.robsoncaliban.emprestimo_service.services.chain.enums.ValidacaoTipo;

public abstract class ValidadorEtapa {
    protected ValidadorEtapa proximo;

    public ValidacaoTipo validarCredenciais(ClienteDtoRequest cliente){
        if(proximo != null){
            return proximo.validarCredenciais(cliente);
        }
        return ValidacaoTipo.INVALIDO;
    }

    public ValidadorEtapa getProximo(){
        return proximo;
    }
    public void setProximo(ValidadorEtapa proximo) {
        this.proximo = proximo;
    }
    
}
