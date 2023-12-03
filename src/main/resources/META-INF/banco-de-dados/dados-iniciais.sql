insert into Produto (id, nome, preco, descricao) values (1,'Kindle', 499.0, 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');
insert into Produto (id, nome, preco, descricao) values (3,'Câmera Canon v2', 5000.0, 'A melhor definição para suas fotos');

insert into mwcc_ecommerce.cliente (id, nome) values(2, 'Nitia Cristina');
insert into mwcc_ecommerce.cliente (id, nome) values(3, 'Antonio José');

insert into mwcc_ecommerce.pedido(id, data_pedido, bairro, cep, cidade, complemento, estado, logradouro, numero, status, total) values(2, '2023-07-03 19:54:27.274131', 'Cohab', '65000000', 'São Luis', 'ao lado da ABBEM', 'MA', 'Rua Sampaio Correa', '256A', 'PAGO', 5000.00);
