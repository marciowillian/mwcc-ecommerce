package com.mwcc.ecommerce.iniciandocomjpa;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

public class ChaveCompostaTest extends EntityManagerTest {

    @Test
    public void salvarItemPedido(){
        Cliente cliente = entityManager.find(Cliente.class, 2);
        Produto produto = entityManager.find(Produto.class, 1);
        Pedido pedido = Pedido.builder()
                .cliente(cliente)
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();
        entityManager.clear();

        ItemPedido itemPedido = ItemPedido.builder()
//                .pedidoId(pedido.getId()) IdClass
//                .produtoId(produto.getId()) IdClass
                .id(new ItemPedidoId(pedido.getId(), produto.getId()))
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();
        entityManager.clear();

        ItemPedido itemPedidoVerificacao = entityManager.find(ItemPedido.class, new ItemPedidoId(pedido.getId(), produto.getId()));

        Assert.assertNotNull(itemPedidoVerificacao);
    }
}
