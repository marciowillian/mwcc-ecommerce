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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "item_pedido")
public class ItemPedido {

    @EmbeddedId
    private ItemPedidoId id;

//    @MapsId("")
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
