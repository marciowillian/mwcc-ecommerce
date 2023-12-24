insert into Produto (id, nome, preco, descricao) values (1,'Kindle', 499.0, 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');
insert into Produto (id, nome, preco, descricao) values (3,'Câmera Canon v2', 5000.0, 'A melhor definição para suas fotos');

insert into mwcc_ecommerce.cliente (id, nome) values(2, 'Nitia Cristina');
insert into mwcc_ecommerce.cliente (id, nome) values(3, 'Antonio José');

-- Pedido 1
insert into mwcc_ecommerce.pedido(id, data_pedido, bairro, cep, cidade, complemento, estado, logradouro, numero, status, total) values(2, '2023-07-03 19:54:27.274131', 'Cohab', '65000000', 'São Luis', 'ao lado da ABBEM', 'MA', 'Rua Sampaio Correa', '256A', 'PAGO', 5000.00);
-- Pedido 2
INSERT INTO pedido (cliente_id, data_pedido, data_conclusao, nota_fiscal, status, total, enderecoEntrega_rua, enderecoEntrega_numero, enderecoEntrega_cidade, enderecoEntrega_estado, enderecoEntrega_cep) VALUES (2, '2023-01-01 10:00:00', '2023-01-02 12:00:00', 12345, 'CONCLUIDO', 150.50, 'Rua A', 123, 'Cidade A', 'Estado A', '12345-6789');

-- Pedido 2
INSERT INTO pedido (cliente_id, data_pedido, data_conclusao, nota_fiscal, status, total, enderecoEntrega_rua, enderecoEntrega_numero, enderecoEntrega_cidade, enderecoEntrega_estado, enderecoEntrega_cep) VALUES (3, '2023-02-01 11:30:00', '2023-02-02 14:45:00', 12346, 'EM_PROCESSAMENTO', 200.75, 'Rua B', 456, 'Cidade B', 'Estado B', '23456-7890');

-- Pedido 3
INSERT INTO pedido (cliente_id, data_pedido, data_conclusao, nota_fiscal, status, total, enderecoEntrega_rua, enderecoEntrega_numero, enderecoEntrega_cidade, enderecoEntrega_estado, enderecoEntrega_cep) VALUES (4, '2023-03-01 09:45:00', '2023-03-02 11:15:00', 12347, 'PENDENTE', 75.30, 'Rua C', 789, 'Cidade C', 'Estado C', '34567-8901');


insert into categoria(id, nome) values (1, 'Eletrônicos');