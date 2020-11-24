package com.example.teste.treinador;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api
@RequestMapping(value = "/api/pokemon")
public class TreinadorController {

    @Autowired
    TreinadorService treinadorService;

    @ApiOperation("Busca todos os treinadores")
    @GetMapping(value = "/treinadores")
    public List<Treinador> findAll() {
        return treinadorService.findAll();
    }

    @ApiOperation("Cria um treinador e gera aleatoriamente o seu pokemon")
    @PostMapping(value = "/treinador")
    public Treinador save(@RequestBody TreinadorDTO treinadorDTO) {
        Treinador treinador = treinadorService.save(treinadorDTO);
        return treinador;
    }

    @ApiOperation("Busca um treinador pelo id")
    @GetMapping(value = "/treinador/{id}")
    public Treinador findById(@PathVariable Long id) {
        return treinadorService.findById(id);
    }

    @ApiOperation("Atualiza informacoes de um treinador")
    @PutMapping(value = "/treinador/{id}")
    public Treinador editarTreinador(@PathVariable Long id, @RequestBody TreinadorDTO treinadorDTO) {
        return treinadorService.editarTreinador(id, treinadorDTO);
    }

    @ApiOperation("Troca aleatoriamente o pokemon do treinador por outro")
    @PutMapping(value = "/trocar-pokemon/{idTreinador}")
    public Treinador trocarPokemon(@PathVariable Long idTreinador) {
        return treinadorService.trocarPokemon(idTreinador);
    }


    @ApiOperation("Exclui o treinador")
    @DeleteMapping(value = "/deletar-treinador/{id}")
    public void delete(@PathVariable Long id) {
        treinadorService.delete(id);
    }




}
