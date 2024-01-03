package com.mwcc.ecommerce.relacionamentos;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentoOneToManyTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento(){
        Produto produto = entityManager.find(Produto.class, 1);
        Pedido pedido = Pedido.builder()
                .cliente(entityManager.find(Cliente.class, 2))
                .build();

        ItemPedido itemPedido = ItemPedido.builder()
                .id(new ItemPedidoId())
                .pedido(pedido)
                .produto(produto)
                .precoProduto(BigDecimal.valueOf(9.98))
                .quantidade(2)
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao.getItensPedido());

    }

    @Test
    public void testarRelacionamentoRetornoPedido(){
        Produto produto = entityManager.find(Produto.class, 1);

        Pedido pedido = Pedido.builder()
                .cliente(entityManager.find(Cliente.class, 2))
                .build();

        ItemPedido itemPedido = ItemPedido.builder()
                .id(new ItemPedidoId())
                .pedido(pedido)
                .produto(produto)
                .precoProduto(BigDecimal.valueOf(9.98))
                .quantidade(2)
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertFalse(pedidoVerificacao.getItensPedido().isEmpty());
    }

}
