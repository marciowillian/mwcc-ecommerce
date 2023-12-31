package com.mwcc.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(ItemPedidoId.class)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "item_pedido")
public class ItemPedido {

    @Id @EqualsAndHashCode.Include
    @Column(name = "pedido_id")
    private Integer pedidoId;

    @Id @EqualsAndHashCode.Include
    @Column(name = "produto_id")
    private Integer produtoId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pedido_id", insertable = false, updatable = false)
    private Pedido pedido;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id", insertable = false, updatable = false)
    private Produto produto;

    @Column(name = "preco_produto")
    private BigDecimal precoProduto;

    private Integer quantidade;
}
