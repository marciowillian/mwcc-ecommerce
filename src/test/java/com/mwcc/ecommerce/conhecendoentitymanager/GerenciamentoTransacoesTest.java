package com.mwcc.ecommerce.conhecendoentitymanager;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.Pedido;
import org.junit.Test;

public class GerenciamentoTransacoesTest extends EntityManagerTest {

    @Test
    public void abrirFecharCancelarTransacao(){

        Pedido pedido = new Pedido();
        pedido = entityManager.find(Pedido.class, 2);

        System.out.println(pedido.toString());
    }
}
