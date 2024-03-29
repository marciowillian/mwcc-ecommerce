package com.mwcc.ecommerce.iniciandocomjpa.mapeamentobasico;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.*;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

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

        Cliente cliente = Cliente.builder()
                .nome("Marcio Willian")
                .sexo(SexoCliente.MASCULINO)
                .cpf("99004593004")
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Pedido pedido = Pedido.builder()
                .cliente(cliente)
                .dataCriacao(LocalDateTime.now())
                .status(StatusPedido.AGUARDANDO)
                .total(BigDecimal.valueOf(785.10))
                .enderecoEntrega(endereco)
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao);
        Assert.assertNotNull(pedidoVerificacao.getEnderecoEntrega());
        Assert.assertNotNull(pedidoVerificacao.getEnderecoEntrega().getCep());
    }

    @Test
    public void deveExcluirPedido(){
        ItemPedido item1 = entityManager.find(ItemPedido.class, new ItemPedidoId(4, 1));

        Pedido pedido = Pedido.builder()
                .cliente(entityManager.find(Cliente.class, 2))
                .dataCriacao(LocalDateTime.now())
                .itensPedido(Arrays.asList(item1))
                .status(StatusPedido.PAGO)
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao);

        entityManager.getTransaction().begin();
        entityManager.remove(pedidoVerificacao);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Pedido pedidoVerificacaoEclusao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNull(pedidoVerificacaoEclusao);
    }


}
