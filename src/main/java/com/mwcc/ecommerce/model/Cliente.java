package com.mwcc.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "cliente")
public class Cliente {

    @Id @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ElementCollection
    @CollectionTable(name = "cliente_contato",
                    joinColumns = @JoinColumn(name = "cliente_id"))
    @MapKeyColumn(name = "tipo")
    @Column(name = "descricao")
    private Map<String, String> contatos;

    @Transient
    private String primeiroNome;

    @Enumerated(EnumType.STRING)
    private SexoCliente sexo;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    @PostLoad
    public void configurarPrimeiroNome(){
        if (nome != null && !nome.isBlank()) {
            int index = nome.indexOf(" ");
            if(index > -1) {
                primeiroNome = nome.substring(0, index);
            }
        }
    }

}
