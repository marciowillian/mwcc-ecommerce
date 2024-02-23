package com.mwcc.ecommerce.iniciandocomjpa;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.Pagamento;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class HerancaTest extends EntityManagerTest {

    @Test
    public void buscarPagamentos(){
        List<Pagamento> pagamentos = entityManager
                .createQuery("select p from Pagamento p")
                .getResultList();

        Assert.assertFalse(pagamentos.isEmpty());
    }

}
