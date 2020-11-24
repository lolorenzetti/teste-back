package com.example.teste.treinador;

import com.example.teste.external.BuscarPokemonService;
import com.example.teste.external.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class TreinadorService {
    @Autowired
    TreinadorRepository treinadorRepository;

    @Autowired
    BuscarPokemonService buscarPokemonService;

    public List<Treinador> findAll() {
        return treinadorRepository.findAll();
    }

    public Treinador save (TreinadorDTO treinadorDTO) {
        Pokemon pokemon = buscarPokemonService.buscarPokemon(geraAleatorio());
        Treinador treinador = new Treinador(treinadorDTO.getNome(), treinadorDTO.getIdade(), treinadorDTO.getCidade(), pokemon);
        return treinadorRepository.save(treinador);
    }


    public Treinador findById(Long id) {
        return treinadorRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }


    public Treinador editarTreinador(Long id, TreinadorDTO treinadorDTO){
        Treinador treinadorOld = findById(id);
        Treinador treinadorNew = new Treinador(treinadorDTO.getNome(), treinadorDTO.getIdade(), treinadorDTO.getCidade(), treinadorOld.getPokemon());
        return treinadorRepository.save(treinadorNew);
    }

    public Treinador trocarPokemon(Long id) {
        Treinador treinadorOld = findById(id);
        Pokemon pokemonNew = buscarPokemonService.buscarPokemon(geraAleatorio());
        treinadorOld.setPokemon(pokemonNew);
        return  treinadorRepository.save(treinadorOld);
    }

    public void delete(Long id) {
        treinadorRepository.deleteById(id);
    }

    public static int geraAleatorio() {
        Random random = new Random();
        return (random.nextInt(890) + 1);
    }

}
