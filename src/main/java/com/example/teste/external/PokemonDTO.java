package com.example.teste.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown=true)
public class PokemonDTO {

    @JsonProperty("name")
    @NotNull
    private String nome;

    @JsonProperty("weight")
    @NotNull
    private Integer peso;

    @JsonProperty("height")
    @NotNull
    private Integer altura;
}
