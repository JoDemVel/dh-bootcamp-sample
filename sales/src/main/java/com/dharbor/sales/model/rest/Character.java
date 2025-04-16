package com.dharbor.sales.model.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    private Integer id;
    private String name;
    private String status;
    private String species;
}
