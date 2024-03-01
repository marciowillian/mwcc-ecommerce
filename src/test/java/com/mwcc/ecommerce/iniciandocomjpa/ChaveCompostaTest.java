package com.mwcc.ecommerce.iniciandocomjpa;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

public class ChaveCompostaTest extends EntityManagerTest {

    @Test
    public void salvarItemPedido(){
        Cliente cliente = entityManager.find(Cliente.class, 2);
        Produto produto = entityManager.find(Produto.class, 1);
        Pedido pedido = entityManager.find(Pedido.class, 6);

        ItemPedido itemPedido = ItemPedido.builder()
//                .pedidoId(pedido.getId()) IdClass
//                .produtoId(produto.getId()) IdClass
                .id(new ItemPedidoId())
                .pedido(pedido)
                .produto(produto)
                .precoProduto(produto.getPreco())
                .quantidade(4)
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();
        entityManager.clear();

        ItemPedido itemPedidoVerificacao = entityManager.find(ItemPedido.class, new ItemPedidoId(pedido.getId(), produto.getId()));

        Assert.assertNotNull(itemPedidoVerificacao);
    }
}
