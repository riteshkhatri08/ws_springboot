package com.ritesh.springaction.tacocloud.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity // JPA MAPPING
public class Taco {

    @Id // JPA MAPPING
    @GeneratedValue(strategy = GenerationType.AUTO) // JPA MAPPING to auto generate id
    private Long id;
    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 charaters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    @ManyToMany // JPA Mapping
    private List<Ingredient> ingredients;

}