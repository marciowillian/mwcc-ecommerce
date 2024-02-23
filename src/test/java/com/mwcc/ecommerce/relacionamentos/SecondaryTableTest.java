package com.mwcc.ecommerce.relacionamentos;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.Cliente;
import com.mwcc.ecommerce.model.SexoCliente;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class SecondaryTableTest extends EntityManagerTest {

    @Test
    public void salvandoClienteTabelaSecondary(){

        Cliente cliente = Cliente.builder()
                .nome("Antonio Carlos de Abreu")
                .sexo(SexoCliente.MASCULINO)
                .dataNascimento(LocalDate.of(1995, 01, 19))
                .build();

        entityManager.getTransaction().begin();

        entityManager.persist(cliente);

        entityManager.getTransaction().commit();
        entityManager.clear();

        Cliente clienteVerificadao = entityManager.find(Cliente.class, cliente.getId());

        Assert.assertNotNull(clienteVerificadao.getDataNascimento());

    }

}
