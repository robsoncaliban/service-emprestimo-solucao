package com.robsoncaliban.emprestimo_service.services.chain;

import com.robsoncaliban.emprestimo_service.entities.dto.request.ClienteDtoRequest;
import com.robsoncaliban.emprestimo_service.services.chain.enums.ValidacaoTipo;

public class ValidadorIdadeLocalidade extends ValidadorEtapa {


    @Override
    public ValidacaoTipo validarCredenciais(ClienteDtoRequest cliente) {
        if(cliente.idade() < 30 && cliente.localidade().equals("SP")){
            return ValidacaoTipo.VALIDO_PESSOAL_COM_GARANTIA;
        }
        return super.validarCredenciais(cliente);
    }

    
    
}
