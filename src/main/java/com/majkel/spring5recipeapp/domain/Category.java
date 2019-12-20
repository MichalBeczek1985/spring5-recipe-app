package com.majkel.spring5recipeapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "categories" )
    private Set<Recipe> recipes;
}
