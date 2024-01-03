package com.mwcc.ecommerce.notafiscal;

import com.mwcc.ecommerce.EntityManagerTest;
import com.mwcc.ecommerce.model.Cliente;
import com.mwcc.ecommerce.model.NotaFiscal;
import com.mwcc.ecommerce.model.Pedido;
import org.junit.Assert;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class GeradorNotaFiscalTest extends EntityManagerTest {

    @Test
    public void gerarNota (){
        String cnpj = "12345678901234"; // CNPJ da empresa (exemplo)
        String dataEmissao = new SimpleDateFormat("yyMM").format(new Date()); // MM para mês com 2 dígitos
        String uf = "SP"; // Código da Unidade Federativa (exemplo)
        String modelo = "55"; // Modelo do documento fiscal (exemplo)
        String serie = "001"; // Número da série (exemplo)
        String numero = "000000001"; // Número sequencial (exemplo)
        String tipoEmissao = "1"; // Tipo de emissão (exemplo)

        String chave = geraChave(cnpj, dataEmissao, uf, modelo, serie, numero, tipoEmissao);
        System.out.println("Chave da Nota Fiscal: " + chave);
    }

    public static String geraChave(String cnpj, String dataEmissao, String uf, String modelo,
                                   String serie, String numero, String tipoEmissao) {
        String chaveSemDV = cnpj + dataEmissao + uf + modelo + serie + numero + tipoEmissao;

        // Adiciona o dígito verificador
        String digitoVerificador = calculaDigitoVerificador(chaveSemDV);

        return chaveSemDV + digitoVerificador;
    }

    public static String calculaDigitoVerificador(String base) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hash = md.digest(base.getBytes());
            int resultado = hash[0] & 0x0F; // Pega apenas os 4 bits mais baixos
            return Integer.toString(resultado);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void deveSalvarNotaFiscal(){
        Pedido pedido = Pedido.builder()
                .cliente(entityManager.find(Cliente.class, 2))
                .build();

        Pedido pedido2 = Pedido.builder()
                .cliente(entityManager.find(Cliente.class, 2))
                .build();

        NotaFiscal notaFiscal = NotaFiscal.builder()
                .pedido(pedido2)
                .dataEmissao(new Date())
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.persist(pedido2);
        entityManager.persist(notaFiscal);
        entityManager.getTransaction().commit();
        entityManager.clear();

        NotaFiscal notaFiscalVerificacao = entityManager.find(NotaFiscal.class, notaFiscal.getId());

        Assert.assertNotNull(notaFiscalVerificacao);
    }

}

