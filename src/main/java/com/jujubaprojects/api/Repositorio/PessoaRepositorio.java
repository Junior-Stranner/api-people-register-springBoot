package com.jujubaprojects.api.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jujubaprojects.api.Model.Pessoa;

@Repository
public interface PessoaRepositorio extends CrudRepository <Pessoa , Integer>{
    
    List<Pessoa> findAll();

   // List<Pessoa> findByCodigo(int codigo)
   /*Encontra o Código da pessoa que vc queira */
    Pessoa findByCodigo(int codigo);


    /* MOstra todos os  dados em ordem alfabética */
    List<Pessoa> findByOrderByNome();


    /*Encontra a/s pessoa/s que comeca com a letra "J" .. 
    caso existem duas que comecam com a mesma letra , ele ordenará pela idade cererescente*/
    List<Pessoa> findByNomeOrderByIdade(String nome);


    /*Pega todos os dados que contem a letra "J"(letra Especifica) */
    List<Pessoa> findByNomeContaining(String termo);

    /*Mostra as pessoas que comecam com a letra "J"  (letra Especifica)*/
    List<Pessoa> findByNomeStartsWith(String termo);

    /*Mostra as pessoas que terminam com a letra "J" (letra Especifica)*/
    List<Pessoa> findByNomeEndsWith(String termo);

    /*Método para somar todas as idades que estão cadastradas */
    @Query(value = "Select sum(idade) from pessoa", nativeQuery = true)
    int somaIdades();

    /*iá conferir se a Idade que eu quero é maior ou igual a das pessoas
     * da minha lisra
     */
     @Query(value = "SELECT * FROM pessoa WHERE idade >= :idades", nativeQuery = true)
    List<Pessoa> idadeMaiorIgual(@Param("idades") int idade);

    int countByCodigo(int codigo);

}
