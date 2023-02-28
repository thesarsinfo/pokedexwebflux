package com.webflux.PokedexDio.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.webflux.PokedexDio.model.Pokemon;

public interface PokemonRepository extends ReactiveMongoRepository<Pokemon,String>{
    
}


