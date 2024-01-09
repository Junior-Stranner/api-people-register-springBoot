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
    private PessoaRepositorio pessoaRepositorio;


    //Método para cadastrar pessoas
    public ResponseEntity<?> cadastrar(Pessoa pessoa){
        
        if(pessoa.getNome().equals("")){
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem,HttpStatus.BAD_REQUEST);
        }else if(pessoa.getIdade()<0){
            mensagem.setMensagem("Informe uma idade válida");
            return new ResponseEntity<>(mensagem,HttpStatus.BAD_REQUEST);
        }else{
            
            return new ResponseEntity<>(pessoaRepositorio.save(pessoa),HttpStatus.CREATED);
        }

    }

    //Métoto para selecionar Pessoas
    public ResponseEntity<?> selecionar(){
        return new ResponseEntity<>(pessoaRepositorio.findAll(), HttpStatus.OK);

    }

    //Método para selecionar Pessoas atráves do código
    public ResponseEntity<?> selecionarPeloCodigo(int codigo){

        if(pessoaRepositorio.countByCodigo(codigo) == 0){
            mensagem.setMensagem("Não foi encontrado nenhuma pessoa");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else{
            return new ResponseEntity<>(pessoaRepositorio.findByCodigo(codigo),HttpStatus.OK);
        }

    }

    //Método para editar dados
    public ResponseEntity<?> editar(Pessoa pessoa){

        if(pessoaRepositorio.countByCodigo(pessoa.getCodigo()) == 0){
            mensagem.setMensagem("O código informado não existe .");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else if(pessoa.getNome().equals("")){
            mensagem.setMensagem("è necessário informar um nome");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
      /* */  }else if(pessoa.getIdade() < 0){
            mensagem.setMensagem("Informe um idade válida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(pessoaRepositorio.save(pessoa), HttpStatus.OK);
        }
    }

    //Método para remover dados
    public ResponseEntity<?> remover(int codigo){
        
        if(pessoaRepositorio.countByCodigo(codigo) == 0){
             mensagem.setMensagem("O código informado não existe .");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else{
           Pessoa pessoa = pessoaRepositorio.findByCodigo(codigo);
           pessoaRepositorio.delete(pessoa);

           mensagem.setMensagem("Pessoa Removida com Sucesso !");
           return new ResponseEntity<>(mensagem, HttpStatus.OK);

        }
    }

  }