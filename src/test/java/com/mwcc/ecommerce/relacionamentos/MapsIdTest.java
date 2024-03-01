package com.mwcc.ecommerce.relacionamentos;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

public class MapsIdTest extends EntityManagerTest {

    @Test
    public void deveInserirItemPedido(){
        ItemPedido item1 = entityManager.find(ItemPedido.class, new ItemPedidoId(7, 1));

        Cliente cliente = entityManager.find(Cliente.class, 2);
        Produto produto = entityManager.find(Produto.class, 1);
        Pedido pedido = entityManager.find(Pedido.class, 7);

        ItemPedido itemPedido = ItemPedido.builder()
                .id(new ItemPedidoId())
                .pedido(pedido)
                .produto(produto)
                .precoProduto(produto.getPreco())
                .quantidade(1)
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();
        entityManager.clear();

        ItemPedido itemPedidoVerificacao = entityManager.find(ItemPedido.class,
                new ItemPedidoId(pedido.getId(), produto.getId()));
        Assert.assertNotNull(itemPedidoVerificacao);

    }

}
