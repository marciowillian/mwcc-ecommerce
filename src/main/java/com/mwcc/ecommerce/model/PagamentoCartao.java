package com.mwcc.ecommerce.model;

import lombok.*;

import javax.persistence.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "pagamento_cartao")
public class PagamentoCartao {

    @Id @EqualsAndHashCode.Include
    @Column(name = "pedido_id")
    private Integer id;

    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    private String numero;
}
