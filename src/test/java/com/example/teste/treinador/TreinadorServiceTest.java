package com.example.teste.treinador;

import static org.mockito.BDDMockito.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import com.example.teste.external.BuscarPokemonService;
import com.example.teste.external.Pokemon;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TreinadorServiceTest {

    @Autowired
    private TreinadorService treinadorService;

    @Mock
    private TreinadorRepository treinadorRepository;

    @MockBean
    private BuscarPokemonService buscarPokemonService;

    @Test
    public void criarTreinador() {
        TreinadorDTO treinadorDTO = new TreinadorDTO("Renan", 24, "Santos");
        Pokemon pokemon = new Pokemon("Charizard", 905, 17);
        Treinador treinador = new Treinador(treinadorDTO.getNome(), treinadorDTO.getIdade(), treinadorDTO.getCidade(), pokemon);
        given(buscarPokemonService.buscarPokemon(6)).willReturn(pokemon);
        given(treinadorRepository.save(treinador)).willReturn(treinador);

        Treinador treinadorCriado = treinadorService.save(treinadorDTO);

        assertThat(treinadorCriado, instanceOf(Treinador.class));

    }

    @Test
    public void criarPokemon() {
        TreinadorDTO treinadorDTO = new TreinadorDTO("Renan", 24, "Santos");
        Pokemon pokemon = new Pokemon("Charizard", 905, 17);
        Treinador treinador = new Treinador(treinadorDTO.getNome(), treinadorDTO.getIdade(), treinadorDTO.getCidade(), pokemon);
        given(buscarPokemonService.buscarPokemon(6)).willReturn(pokemon);
        given(treinadorRepository.save(treinador)).willReturn(treinador);

        Treinador treinadorCriado = treinadorService.save(treinadorDTO);

        assertThat(treinadorCriado.getPokemon(), instanceOf(Pokemon.class));
    }

}
