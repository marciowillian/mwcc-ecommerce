package com.mwcc.ecommerce.relacionamentos;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.Categoria;
import org.junit.Assert;
import org.junit.Test;

public class AutoRelacionamentoTest extends EntityManagerTest {

    @Test
    public void deveTestarAutoRelacionamentoCategoria(){

        Categoria categoriaPai = Categoria.builder()
                .nome("Eletrônicos")
                .build();

        Categoria categoria = Categoria.builder()
                .nome("Celulares")
                .categoriaPai(categoriaPai)
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(categoriaPai);
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categoriaPaiVerificacao = entityManager.find(Categoria.class, categoriaPai.getId());
        Categoria categoriaFilhaVerificacao = entityManager.find(Categoria.class, categoria.getId());


        Assert.assertNotNull(categoriaPaiVerificacao);
        Assert.assertNotNull(categoriaFilhaVerificacao);

        Assert.assertEquals(categoriaPaiVerificacao.getNome().toUpperCase(),
                            categoria.getCategoriaPai().getNome().toUpperCase());

        Assert.assertFalse(categoriaPaiVerificacao.getCategorias().isEmpty());

    }
}
