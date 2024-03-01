package com.mwcc.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
@AllArgsConstructor @NoArgsConstructor
public class Atributo {

    @Column(length = 100, nullable = false)
    private String nome;
    private String valor;
}
