package com.mwcc.ecommerce.iniciandocomjpa.mapeamentobasico;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.EnderecoEntregaPedido;
import com.mwcc.ecommerce.model.Pedido;

import com.mwcc.ecommerce.model.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeamentoObjetoEmbutidoTest extends EntityManagerTest {

    @Test
    public void analisarMapeamentoObjetoEmbutido(){
        EnderecoEntregaPedido endereco = EnderecoEntregaPedido.builder()
                .cep("65000000")
                .logradouro("Rua Santo Antonio, residencial Primavera")
                .numero("255b")
                .bairro("Cohab")
                .cidade("São Luis")
                .estado("MA")
                .build();

        Pedido pedido = Pedido.builder()
                .id(1)
                .dataPedido(LocalDateTime.now())
                .status(StatusPedido.AGUARDANDO)
                .total(BigDecimal.valueOf(785.10))
                .enderecoEntrega(endereco)
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class,1);
        Assert.assertNotNull(pedidoVerificacao);
        Assert.assertNotNull(pedidoVerificacao.getEnderecoEntrega());
        Assert.assertNotNull(pedidoVerificacao.getEnderecoEntrega().getCep());
    }

    @Test
    public void deveExcluirPedido(){
        Pedido pedido = entityManager.find(Pedido.class, 2);

        entityManager.getTransaction().begin();
        entityManager.remove(pedido);
        entityManager.getTransaction().commit();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, 2);
        Assert.assertNull(pedidoVerificacao);
    }


}
