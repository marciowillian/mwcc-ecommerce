package com.mwcc.ecommerce.util;

import com.mwcc.ecommerce.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IniciarUnidadeDePersistencia {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("Ecommerce-PU");
        EntityManager entityManager = factory.createEntityManager();

        //Faça seus testes aqui
        Produto produto = entityManager.find(Produto.class, 1);
        System.out.println(produto.toString());

        entityManager.close();
        factory.close();
    }
}
