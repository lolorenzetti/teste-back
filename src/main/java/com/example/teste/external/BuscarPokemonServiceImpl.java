package com.example.teste.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BuscarPokemonServiceImpl implements BuscarPokemonService{

    private static final String URL = "https://pokeapi.co/api/v2/pokemon/";

    @Autowired
    RestTemplate restTemplate;


    @Override
    public Pokemon buscarPokemon(Integer numeroPokemon) {
        PokemonDTO pokemonDTO = restTemplate.getForObject(URL + numeroPokemon, PokemonDTO.class);
        if ( pokemonDTO == null ) {
            throw new IllegalArgumentException();
        } else {
          return  retornarPokemon(pokemonDTO);
        }
    }

    private static Pokemon retornarPokemon(PokemonDTO pokemonDTO) {
        Pokemon pokemon = new Pokemon();
        pokemon.setNomePokemon(pokemonDTO.getNome());
        pokemon.setAlturaPokemon(pokemonDTO.getAltura());
        pokemon.setPesoPokemon(pokemonDTO.getPeso());
        return pokemon;
    }
}
