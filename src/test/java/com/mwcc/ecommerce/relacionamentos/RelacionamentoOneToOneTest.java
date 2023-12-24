package com.mwcc.ecommerce.relacionamentos;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class RelacionamentoOneToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamentoPagamentoCartao(){
        Pedido pedido = Pedido.builder()
                .cliente(entityManager.find(Cliente.class, 2))
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();
        entityManager.clear();

        PagamentoCartao pagamentoCartao = PagamentoCartao.builder()
                .numero("1234")
                .status(StatusPagamento.PROCESSANDO)
                .pedido(pedido)
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(pagamentoCartao);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao.getPagamento());
    }

    @Test
    public void verificarRelacionamentoNotaFiscal(){
        Cliente cliente = entityManager.find(Cliente.class, 2);

        Pedido pedido = Pedido.builder()
                .cliente(cliente)
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();
        entityManager.clear();

        NotaFiscal notaFiscal = NotaFiscal.builder()
                .pedido(pedido)
                .xml("123456789012342312SP55001000000001111")
                .dataEmissao(new Date())
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(notaFiscal);
        entityManager.getTransaction().commit();
        entityManager.clear();

        NotaFiscal notaVerificacao = entityManager.find(NotaFiscal.class, notaFiscal.getId());

        Assert.assertNotNull(notaVerificacao.getPedido());
    }

    @Test
    public void verificarBuscaInner(){
        Pedido pedido = entityManager.find(Pedido.class, 2);
    }

}
