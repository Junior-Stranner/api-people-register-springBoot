package com.jujubaprojects.api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jujubaprojects.api.Model.Mensagem;
import com.jujubaprojects.api.Model.Pessoa;
import com.jujubaprojects.api.Repositorio.PessoaRepositorio;

@Service
public class Servico {
    
    @Autowired
    private Mensagem mensagem;

    @Autowired
    private PessoaRepositorio PessoaRepositorio;


    public ResponseEntity<?> cadastrar(Pessoa pessoa){
        
        if(pessoa.getNome().equals("")){
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem,HttpStatus.BAD_REQUEST);
        }else if(pessoa.getIdade()<0){
            mensagem.setMensagem("Informe uma idade válida");
            return new ResponseEntity<>(mensagem,HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(pessoa,HttpStatus.CREATED);
        }

    }
}
