package com.mwcc.ecommerce.iniciandocomjpa;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.Cliente;
import com.mwcc.ecommerce.model.SexoCliente;
import org.junit.Assert;
import org.junit.Test;

public class CRUDClientTest extends EntityManagerTest {

    @Test
    public void cadastrarCliente(){

        Cliente cliente = Cliente.builder()
                .nome("Antonieta da Silva")
                .sexo(SexoCliente.FEMININO)
                .cpf("35438024022")
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao);
    }

    @Test
    public void deveCadastrarClienteComSexoPreenchido(){
        Cliente cliente = Cliente.builder()
                .nome("Joao Pedro da Silva")
                .cpf("35438024027")
                .sexo(SexoCliente.MASCULINO)
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertEquals(cliente.getSexo(), clienteVerificacao.getSexo());
        Assert.assertNotNull(cliente.getSexo());
        Assert.assertNotNull(cliente.getId());
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
        cliente.setSexo(SexoCliente.FEMININO);

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertEquals(cliente.getNome(), clienteVerificacao.getNome());
        Assert.assertNotNull(cliente.getSexo());
    }

    @Test
    public void removerCliente(){
        Cliente cliente = entityManager.find(Cliente.class, 4);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNull(clienteVerificacao);
    }

}
