package com.mwcc.ecommerce.iniciandocomjpa;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.Pagamento;
import com.mwcc.ecommerce.model.PagamentoCartao;
import com.mwcc.ecommerce.model.Pedido;
import com.mwcc.ecommerce.model.StatusPagamento;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class HerancaTest extends EntityManagerTest {

    @Test
    public void inserirPagamentoPedido(){
        Pedido pedido = entityManager.find(Pedido.class, 4);

        PagamentoCartao pagamentoCartao = new PagamentoCartao();
        pagamentoCartao.setPedido(pedido);
        pagamentoCartao.setStatus(StatusPagamento.PROCESSANDO);
        pagamentoCartao.setNumeroCartao("123");

        entityManager.getTransaction().begin();
        entityManager.persist(pagamentoCartao);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao.getPagamento());


    }

    @Test
    public void buscarPagamentos(){
        List<Pagamento> pagamentos = entityManager
                .createQuery("select p from Pagamento p")
                .getResultList();

        Assert.assertFalse(pagamentos.isEmpty());
    }

}
