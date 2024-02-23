package com.mwcc.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "categoria")
public class Categoria extends EntidadeBaseInteger{

    private String nome;
    @ManyToOne
    @JoinColumn(name = "categoria_pai_id")
    private Categoria categoriaPai;

    @OneToMany(mappedBy = "categoriaPai")
    private List<Categoria> categorias;

    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos;

}
