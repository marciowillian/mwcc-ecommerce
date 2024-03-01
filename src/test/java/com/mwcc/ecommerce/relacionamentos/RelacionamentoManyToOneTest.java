package com.mwcc.ecommerce.relacionamentos;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class RelacionamentoManyToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento(){
        Cliente cliente = entityManager.find(Cliente.class, 2);

        Pedido pedido = new Pedido();
        pedido = Pedido.builder()
                .status(StatusPedido.AGUARDANDO)
                .dataCriacao(LocalDateTime.now())
                .cliente(cliente)
                .total(BigDecimal.TEN)
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());

        Assert.assertNotNull(pedidoVerificacao.getCliente());

    }

    @Test
    public void verificarRelacionemtoItemPedidoEPedido(){
        ItemPedido itemPedido = entityManager.find(ItemPedido.class, new ItemPedidoId(5, 1));
        Pedido pedido = entityManager.find(Pedido.class, 5);

        Assert.assertNotNull(pedido.getItensPedido());
        Assert.assertNotNull(itemPedido.getPedido());
        Assert.assertEquals(pedido.getTotal(), itemPedido.getPrecoProduto());
    }

}
