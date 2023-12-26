package com.mwcc.ecommerce.service;

import com.mwcc.ecommerce.model.Pedido;

public class NotaFiscalService {

    public void gerar(Pedido pedido){
        System.out.println("Gerando nota fiscal do pedido " + pedido.getId() + ".");
    }
}
