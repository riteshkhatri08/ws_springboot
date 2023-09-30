package com.ritesh.springaction.tacocloud.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.ritesh.springaction.tacocloud.Type;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity // USED FOR JPA

// ? JPA REQUIRES ENTITIES TO HAVE NO ARGS CONSTRUCTOR
// ? But we dont want everyone to use it so we keep it private
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

// ? All arguments constructor for us to create ingredient objects;
@AllArgsConstructor
public class Ingredient implements Serializable {
    @Id // USED FOR JPA // Must uniquely identify
    private final String id;
    private final String name;

    @Enumerated(EnumType.STRING) // JPA MAPPING FOR ENUMS
    private final Type type;

}
