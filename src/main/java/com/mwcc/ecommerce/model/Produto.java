package com.mwcc.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name = "produto")
public class Produto extends EntidadeBaseInteger {

    private String nome;

    private String descricao;

    private BigDecimal preco;

    @OneToMany(mappedBy = "produto")
    private List<ItemPedido> itensPedido;

    @ManyToMany
    @JoinTable(name = "produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias;

    @OneToOne(mappedBy = "produto")
    private Estoque estoque;

    @Lob
    private byte[] foto;

    @ElementCollection
    @CollectionTable(name = "produto_tag",
            joinColumns = @JoinColumn(name = "produto_id"))
    @Column(name = "tag")
    private List<String> tags;

    @ElementCollection
    @CollectionTable(name = "produto_atributo",
                joinColumns = @JoinColumn(name = "produto_id"))
    private List<Atributo> atributos;
}
