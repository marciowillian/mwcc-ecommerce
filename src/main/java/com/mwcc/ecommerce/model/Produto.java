package com.mwcc.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name = "produto",
        uniqueConstraints = { @UniqueConstraint(name = "unq_nome", columnNames = { "nome" }) },
        indexes = { @Index(name = "idx_nome", columnList = "nome") })
public class Produto extends EntidadeBaseInteger {

    @Column(name = "data_criacao", updatable = false, length = 6, nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_ultima_atualizacao", length = 6)
    private LocalDateTime dataUltimaAtualizacao;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(columnDefinition = "varchar(275) not null default 'descricao'")
    private String descricao;

    @Column(precision = 19, scale = 2)
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
    @Column(name = "tag", length = 50, nullable = false)
    private List<String> tags;

    @ElementCollection
    @CollectionTable(name = "produto_atributo",
                joinColumns = @JoinColumn(name = "produto_id"))
    private List<Atributo> atributos;
}
