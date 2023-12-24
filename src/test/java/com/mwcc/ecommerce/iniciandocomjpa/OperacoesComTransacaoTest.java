package com.mwcc.ecommerce.iniciandocomjpa;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoTest extends EntityManagerTest {

    @Test
    public void atualizarObjetoGerenciado(){
        Produto produto = entityManager.find(Produto.class, 3);


        entityManager.getTransaction().begin();
        produto.setNome("Celular Poco X3 128 g com 8 de ran");
        entityManager.getTransaction().commit();

        /**
         * É necessário limpar o entityManager para nao ser um falso positivo na comparação dos atributos
         * pelo fato do entityManager possuir em cache os dados do atributo.
         */
        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, 3);
        Assert.assertEquals(produto.getNome(), produtoVerificacao.getNome());
    }

    @Test
    public void atualizarObjeto(){
        Produto produto = entityManager.find(Produto.class, 1);

        produto.setNome("Celular Poco X3");
        produto.setDescricao("O melhor celular custo X benéficio da atualidade.");
        produto.setPreco(BigDecimal.valueOf(2200));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        /**
         * É necessário limpar o entityManager para nao ser um falso positivo na comparação dos atributos
         * pelo fato do entityManager possuir em cache os dados do atributo.
         */
        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, 1);
        Assert.assertEquals(produto.getId(), produtoVerificacao.getId());
        Assert.assertEquals(produto.getNome(), produtoVerificacao.getNome());
        Assert.assertEquals(produto.getDescricao(), produtoVerificacao.getDescricao());
    }

    @Test
    public void removerObjeto(){
        Produto produto = entityManager.find(Produto.class, 3);
        System.out.println("Removendo da base o " + produto.getId());

        entityManager.getTransaction().begin();
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        /**
         * Ao remover o objeto da base de dados, também é removido do entityManager
         * portanto não se faz necessário o uso do entityManager.clear();
         */
//        entityManager.clear(); Não é necessário para a asserção de remoção

        Produto produtoVerificacao = entityManager.find(Produto.class, 3);

        Assert.assertNull(produtoVerificacao);
    }

    @Test
    public void inserirOPrimeiroObjeto(){
        Produto produto = new Produto();
        produto.setNome("Câmero Canon");
        produto.setDescricao("A melhor definição para suas fotos");
        produto.setPreco(new BigDecimal(5000));

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
    }

    @Test
    public void abrirEFecharTrasacao(){
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
    }
}
