package com.mwcc.ecommerce.relacionamentos;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

public class RelacionamentoOneToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamentoPagamentoCartao(){
//        ItemPedido itemPedido1 = ItemPedido.builder()
//                .produto(Produto.builder()
//                        .nome("Celular Lenovo")
//                        .preco(BigDecimal.valueOf(2500.97))
//                        .build())
//                .precoProduto(BigDecimal.valueOf(2500.97))
//                .build();
//
//        ItemPedido itemPedido2 = ItemPedido.builder()
//                .produto(Produto.builder()
//                        .nome("Notebook Acer Nitro 5")
//                        .preco(BigDecimal.valueOf(4750.90))
//                        .build())
//                .precoProduto(BigDecimal.valueOf(4750.90))
//                .build();
//
//        Pedido pedido = Pedido.builder()
//                .cliente(entityManager.find(Cliente.class, 2))
//                .itensPedido(Arrays.asList(itemPedido1, itemPedido2))
//                .status(StatusPedido.AGUARDANDO)
//                .build();
//
//        PagamentoCartao pagamentoCartao = PagamentoCartao.builder()
//                .numeroCartao("1234")
//                .build();
//
//        entityManager.getTransaction().begin();
//        entityManager.persist(pedido);
//        entityManager.persist(pagamentoCartao);
//        entityManager.getTransaction().commit();
//        entityManager.clear();
//
//        pedido = entityManager.find(Pedido.class, pedido.getId());
//        pedido.setStatus(StatusPedido.PAGO);
//
//        entityManager.getTransaction().begin();
//        entityManager.merge(pedido);
//        entityManager.getTransaction().commit();
//        entityManager.clear();
//
//        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
//        Assert.assertNotNull(pedidoVerificacao.getPagamento());
    }

//    @Test
//    public void verificarRelacionamentoNotaFiscal(){
//        Cliente cliente = entityManager.find(Cliente.class, 2);
//
//        Pedido pedido = Pedido.builder()
//                .cliente(cliente)
//                .build();
//
//        NotaFiscal notaFiscal = NotaFiscal.builder()
//                .pedido(pedido)
//                .xml("123456789012342312SP55001000000001111")
//                .dataEmissao(new Date())
//                .build();
//
//        entityManager.getTransaction().begin();
//        entityManager.persist(pedido);
//        entityManager.persist(notaFiscal);
//        entityManager.getTransaction().commit();
//        entityManager.clear();
//
//        NotaFiscal notaVerificacao = entityManager.find(NotaFiscal.class, notaFiscal.getId());
//
//        Assert.assertNotNull(notaVerificacao.getPedido());
//    }

    @Test
    public void verificarBuscaInner(){
        Pedido pedido = entityManager.find(Pedido.class, 2);
    }

}
