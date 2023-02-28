package com.webflux.PokedexDio.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Pokemon {
    @Id
    private String id;
    private String name;
    private String category;
    private String skill;
    private Double weight;

    public Pokemon(String id, String name, String category, String skill, Double weight) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.skill = skill;
        this.weight = weight;
    }    
}
