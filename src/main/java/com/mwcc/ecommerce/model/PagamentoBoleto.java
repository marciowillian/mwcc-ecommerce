package com.mwcc.ecommerce.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
//@Table(name = "pagamento_boleto")
@DiscriminatorValue("boleto")
public class PagamentoBoleto extends Pagamento {

    @Column(name = "codigo_barras")
    private String codigoBarras;
}
