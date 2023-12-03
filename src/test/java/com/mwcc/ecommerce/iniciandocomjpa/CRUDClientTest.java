package com.mwcc.ecommerce.iniciandocomjpa;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.Cliente;
import com.mwcc.ecommerce.model.SexoCliente;
import org.junit.Assert;
import org.junit.Test;

public class CRUDClientTest extends EntityManagerTest {

    @Test
    public void cadastrarCliente(){

        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNome("Marcio Willian");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, 1);
        Assert.assertNotNull(clienteVerificacao);
    }

    @Test
    public void deveCadastrarClienteComSexoPreenchido(){
        Cliente cliente = new Cliente();
        cliente.setId(4);
        cliente.setNome("Joao Pedro");
        cliente.setSexo(SexoCliente.MASCULINO);

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, 4);

        Assert.assertEquals(cliente.getNome(), clienteVerificacao.getNome());
    }

    @Test
    public void bucarCLiente(){
        Cliente cliente = entityManager.find(Cliente.class, 2);

        Assert.assertNotNull(cliente);
    }

    @Test
    public void atualizarCliente(){
        Cliente cliente = entityManager.find(Cliente.class, 2);
        cliente.setNome("Nitia Cristina Chaves Cardoso");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, 2);
        Assert.assertEquals(cliente.getNome(), clienteVerificacao.getNome());
    }

    @Test
    public void removerCliente(){
        Cliente cliente = entityManager.find(Cliente.class, 3);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, 3);
        Assert.assertNull(clienteVerificacao);
    }

}
