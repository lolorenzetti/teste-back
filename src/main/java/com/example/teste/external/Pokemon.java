package com.example.teste.external;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {
    @NotNull
    private String nomePokemon;

    @NotNull
    private Integer pesoPokemon;

    @NotNull
    private Integer alturaPokemon;
}
