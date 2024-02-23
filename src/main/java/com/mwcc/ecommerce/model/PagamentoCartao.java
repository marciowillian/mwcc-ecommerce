package com.mwcc.ecommerce.model;

import lombok.*;

import javax.persistence.*;

@Data
//@ToString
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "pagamento_cartao")
@DiscriminatorValue("cartao")
public class PagamentoCartao extends Pagamento {

    @Column(name = "numero_cartao")
    private String numeroCartao;
}
