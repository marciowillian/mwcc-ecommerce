package com.mwcc.ecommerce.model;

import com.mwcc.ecommerce.listener.GerarNotaFiscalListener;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners({ GerarNotaFiscalListener.class })
@Entity
@ToString
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "pedido")
public class Pedido {

    @Id @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itensPedido;

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_ultima_atualizacao", insertable = false)
    private LocalDateTime dataUltimaAtualizacao;

    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;

    @Column(name = "nota_fiscal")
    private Integer notaFiscalId;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @OneToOne(mappedBy = "pedido")
    private PagamentoCartao pagamento;

    @OneToOne(mappedBy = "pedido")
    private NotaFiscal notaFiscal;

    private BigDecimal total;

    @Embedded
    private EnderecoEntregaPedido enderecoEntrega;

    public boolean isPago() {
        return StatusPedido.PAGO.equals(status);
    }

    public void calcularTotal(){
        if(itensPedido != null) {
            total = itensPedido.stream().map(ItemPedido::getPrecoProduto)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }

    @PrePersist
    public void aoPersistir() {
        calcularTotal();
        System.out.println("Calculo de valor total dos itens do pedido ao salvar. Valor total: " + total );
    }

    @PreUpdate
    public void aoAtualizar() {
        calcularTotal();
        System.out.println("Calculo de valor total dos itens do pedido ao atualizar. Valor total: " + total);
    }
}
