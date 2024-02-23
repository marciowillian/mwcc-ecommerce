package com.mwcc.ecommerce.arquivonobanco;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SalvarFotoProdutoTest extends EntityManagerTest {

    @Test
    public void salvarProdutoComFoto(){

        Produto produto = Produto.builder()
                .nome("Cubo mágico")
                .descricao("Cubo mágico colorido")
                .preco(BigDecimal.valueOf(39.90))
                .foto(carregarFoto())
                .build();

        entityManager.getTransaction().begin();

        entityManager.persist(produto);

        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao.getFoto());
        /*
        *   Trecho que salva a foto do banco no diretorio home
        *
        try {
            OutputStream out = new FileOutputStream(
                    Files.createFile(Paths.get(
                            System.getProperty("user.home") + "/cubo-magico-foto.jpg")).toFile());
            out.write((produtoVerificacao.getFoto()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
         */

    }

    private static byte[] carregarFoto(){

        try {
            return SalvarFotoProdutoTest.class.getResourceAsStream(
                    "/cubo-magico.jpg"
            ).readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
