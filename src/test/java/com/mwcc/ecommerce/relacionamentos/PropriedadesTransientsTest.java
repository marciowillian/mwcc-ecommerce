package com.mwcc.ecommerce.relacionamentos;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class PropriedadesTransientsTest extends EntityManagerTest {

    @Test
    public void deveConfigurarPrimeiroNome(){
        Cliente cliente = entityManager.find(Cliente.class, 2);

        Assert.assertEquals("Nitia", cliente.getPrimeiroNome());
    }

}
