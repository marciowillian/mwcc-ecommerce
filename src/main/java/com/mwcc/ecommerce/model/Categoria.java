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
@Table(name = "categoria",
        uniqueConstraints = { @UniqueConstraint(name = "unq_nome", columnNames = "nome") },
        indexes = { @Index( name = "idx_nome", columnList = "nome") })
public class Categoria extends EntidadeBaseInteger{

    @Column(length = 100, nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "categoria_pai_id")
    private Categoria categoriaPai;

    @OneToMany(mappedBy = "categoriaPai")
    private List<Categoria> categorias;

    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos;

}
