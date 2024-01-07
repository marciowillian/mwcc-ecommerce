package com.mwcc.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Embeddable
@AllArgsConstructor @NoArgsConstructor
public class Atributo {

    private String nome;
    private String valor;
}
