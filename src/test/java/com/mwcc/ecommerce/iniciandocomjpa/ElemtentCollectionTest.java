package com.mwcc.ecommerce.iniciandocomjpa;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.Atributo;
import com.mwcc.ecommerce.model.Cliente;
import com.mwcc.ecommerce.model.Produto;
import com.mysql.cj.xdevapi.Client;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class ElemtentCollectionTest extends EntityManagerTest {

    @Test
    public void aplicarTags(){
        entityManager.getTransaction().begin();

        Produto produto = entityManager.find(Produto.class, 1);
        produto.setTags(Arrays.asList("ebook", "livro-digital"));

        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());

        Assert.assertEquals(2, produtoVerificacao.getTags().size());
        Assert.assertFalse(produtoVerificacao.getTags().isEmpty());
    }

    @Test
    public void aplicarAtributos(){

        entityManager.getTransaction().begin();

        Produto produto = entityManager.find(Produto.class, 1);
        produto.setAtributos(Arrays.asList(new Atributo("tela", "320x600")));

        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());

        Assert.assertFalse(produtoVerificacao.getAtributos().isEmpty());

    }

    @Test
    public void aplicarContato(){

        entityManager.getTransaction().begin();

        Cliente cliente = entityManager.find(Cliente.class, 2);
        cliente.setContatos(Collections.singletonMap("email", "nitia_cristina@gmail.com"));

        entityManager.getTransaction().commit();
        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());

        Assert.assertEquals("nitia_cristina@gmail.com", clienteVerificacao.getContatos().get("email"));

    }
}
