package com.jujubaprojects.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jujubaprojects.api.Model.Cliente;
import com.jujubaprojects.api.Model.Pessoa;
import com.jujubaprojects.api.Repositorio.PessoaRepositorio;
import com.jujubaprojects.api.Services.Servico;

import jakarta.validation.Valid;

@RestController
//@RequestMapping("/api")
public class PessoaController {

    @Autowired
    private PessoaRepositorio PessoaRepositorio;

    @Autowired
    private Servico servico;

      
    @GetMapping("")
    public String mensagen(){
        return "Hello World !";
    }

     @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Seja Bem Vindo(a) ";
    }

      @GetMapping("/boasVindas/{nome}")
    public String boasVindas(@PathVariable String nome){
        return "Seja Bem Vindo(a) " +nome;
    }

    /*GetMapping não tem suporte ao @RequestBody */
 /*    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
        
    }*/

    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody Pessoa pessoa){
        return servico.cadastrar(pessoa);

    }

    @GetMapping("/api/acharPessoas")
    public ResponseEntity<?>  selecionar(){
        return servico.selecionar();
    }

     // List<Pessoa> findByCodigo(int codigo)
   /*Encontra o Código da pessoa que vc queira */
    @GetMapping("/apiCodigo/{codigo}")
    public ResponseEntity<?> selecionarPeloCodigo(@PathVariable int codigo){
        return servico.selecionarPeloCodigo(codigo);
        
    }

    @PutMapping("/apiEditar")
    public ResponseEntity<?>  editar(@RequestBody Pessoa pessoa){
        return servico.editar(pessoa);

    }

    @DeleteMapping("/apiDelete/{codigo}")
    public ResponseEntity<?> remover(@PathVariable int codigo){
    return servico.remover(codigo); 
   
    }

    @GetMapping("/api/contador")
    public Long contador(){
        return PessoaRepositorio.count();
    }

     /* MOstra todos os  dados em ordem alfabética */
    @GetMapping("/api/ordenarNomes")
    public List<Pessoa> ordenarNomes(){
        return PessoaRepositorio.findByOrderByNome();

    }
  /*Encontra a/s pessoa/s que comeca com a letra "J" .. 
    caso existem duas que comecam com a mesma letra , ele ordenará pela idade cererescente*/
    @GetMapping("/api/ordenarNome2")
    public List<Pessoa> ordenarIdade(){
        return PessoaRepositorio.findByNomeOrderByIdade("Junior");

    }

    /*Pega todos os dados que contem a letra "J"(letra Especifica) */
     @GetMapping("/api/nomeContem")
    public List<Pessoa> nomeContem(){
    return PessoaRepositorio.findByNomeContaining("d");
    }

    /*Mostra as pessoas que comecam com a letra "J"  (letra Especifica)*/
    @GetMapping("/api/iniciaCom")
    public List<Pessoa> iniciaCom(){
        return PessoaRepositorio.findByNomeStartsWith("J");

    }
 
    /*Mostra as pessoas que terminam com a letra "J" (letra Especifica)*/
      @GetMapping("/api/terminaCom")
     public List<Pessoa> terminaCom(){
        return PessoaRepositorio.findByNomeEndsWith("o");

    }

    /*Método para somar todas as idades que estão cadastradas */
    @GetMapping("api/somaIdades")
    public int somaIdades(){
        return  PessoaRepositorio.somaIdades();

    }

     /*iá conferir se a Idade que eu quero é maior ou igual a das pessoas
     * da minha lisra
     */
    @GetMapping("/api/idadeMaiorIgual")
    public List<Pessoa> idadeMaiorIgual(){
        return PessoaRepositorio.idadeMaiorIgual(25);

    }

    /*ResponseEntity<?>  --> é um objeto que eu não deixo explicido
     * por que se der certo eu retorno um tipo de objeto
     * e se falhar pode retornar outro objeto , msm assim irá retornar algo
     */
    @GetMapping("/status")
    public ResponseEntity<?> status(){
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PostMapping("/cliente")
    public void cliente(@Valid @RequestBody Cliente cliente){
        
    }
  
}
