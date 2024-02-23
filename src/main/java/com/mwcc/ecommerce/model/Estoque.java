package com.mwcc.ecommerce.model;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "estoque")
public class Estoque extends EntidadeBaseInteger{

    @OneToOne(optional = false)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private Integer quantidade;
}
