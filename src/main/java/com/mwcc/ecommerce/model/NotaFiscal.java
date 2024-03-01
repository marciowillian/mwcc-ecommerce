package com.mwcc.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "nota_fiscal")
public class NotaFiscal {

    @Id @EqualsAndHashCode.Include
    @Column(name = "pedido_id")
    private Integer id;

    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Lob
    @Column(nullable = false)
    private byte[] xml;

    @Column(name = "data_emissao", length = 6, nullable = false)
    private Date dataEmissao;
}
