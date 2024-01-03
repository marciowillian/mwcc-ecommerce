package com.mwcc.ecommerce.relacionamentos;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

public class MapsIdTest extends EntityManagerTest {

    @Test
    public void deveInserirItemPedido(){
        Cliente cliente = entityManager.find(Cliente.class, 2);
        Produto produto = entityManager.find(Produto.class, 1);
        Pedido pedido = Pedido.builder()
                .cliente(cliente)
                .build();


        ItemPedido itemPedido = ItemPedido.builder()
                .id(new ItemPedidoId())
                .pedido(pedido)
                .produto(produto)
                .quantidade(1)
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();
        entityManager.clear();

        ItemPedido itemPedidoVerificacao = entityManager.find(ItemPedido.class,
                new ItemPedidoId(pedido.getId(), produto.getId()));
        Assert.assertNotNull(itemPedidoVerificacao);

    }

}
