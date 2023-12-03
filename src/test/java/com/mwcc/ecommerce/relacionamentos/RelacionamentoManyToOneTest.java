package com.mwcc.ecommerce.relacionamentos;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentoManyToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento(){
        Cliente cliente = entityManager.find(Cliente.class, 2);

        Pedido pedido = new Pedido();
        pedido = Pedido.builder()
                .status(StatusPedido.AGUARDANDO)
                .dataPedido(LocalDateTime.now())
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
    public void VerificarRelacionemtoItemPedidoEPedido(){
        Cliente cliente = entityManager.find(Cliente.class, 2);
        Pedido pedido = entityManager.find(Pedido.class, 2);
        Produto produto = entityManager.find(Produto.class, 1);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido = ItemPedido.builder()
                .pedido(pedido)
                .produto(produto)
                .precoProduto(BigDecimal.valueOf(19.98))
                .quantidade(2)
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        ItemPedido itemPedidoVirificacao = entityManager.find(ItemPedido.class, itemPedido.getId());
        Assert.assertNotNull(itemPedidoVirificacao.getPedido());
        Assert.assertNotNull(itemPedidoVirificacao.getProduto());
    }

}
