package com.example.teste.treinador;


import com.example.teste.external.Pokemon;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Treinador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String nome;

    @NotNull
    private Integer idade;

    @NotNull
    private String cidade;

    @Embedded
    @NotNull
    private Pokemon pokemon;


    public Treinador(String nome, Integer idade, String cidade, Pokemon pokemon){
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.pokemon = pokemon;
    }

}
