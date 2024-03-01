insert into Produto (id, nome, data_criacao, preco, descricao) values (1,'Kindle', '2024-01-01' ,499.0, 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');
insert into Produto (id, nome, data_criacao, preco, descricao) values (3,'Câmera Canon v2', '2024-01-01',5000.0, 'A melhor definição para suas fotos');


insert into mwcc_ecommerce.cliente (id, nome, cpf) values(2, 'Nitia Cristina', '12345678910');
insert into mwcc_ecommerce.cliente (id, nome, cpf) values(3, 'Antonio José', '12345678911');
insert into mwcc_ecommerce.cliente (id, nome, cpf) values(4, 'Marcos Antonio', '12345678912');

insert into mwcc_ecommerce.cliente_detalhe (data_nascimento, sexo, cliente_id) values('1997-04-22', 'FEMININO', 2);
insert into mwcc_ecommerce.cliente_detalhe (data_nascimento, sexo, cliente_id) values('1997-04-19', 'MASCULINO', 3);
insert into mwcc_ecommerce.cliente_detalhe (data_nascimento, sexo, cliente_id) values('1993-05-26', 'MASCULINO', 4);

-- Pedido 1
--insert into mwcc_ecommerce.pedido(id, data_pedido, bairro, cep, cidade, complemento, estado, logradouro, numero, status, total) values(2, '2023-07-03 19:54:27.274131', 'Cohab', '65000000', 'São Luis', 'ao lado da ABBEM', 'MA', 'Rua Sampaio Correa', '256A', 'PAGO', 5000.00);
-- Pedido 2
--INSERT INTO pedido (cliente_id, data_pedido, data_conclusao, nota_fiscal, status, total, enderecoEntrega_rua, enderecoEntrega_numero, enderecoEntrega_cidade, enderecoEntrega_estado, enderecoEntrega_cep) VALUES (2, '2023-01-01 10:00:00', '2023-01-02 12:00:00', 12345, 'CONCLUIDO', 150.50, 'Rua A', 123, 'Cidade A', 'Estado A', '12345-6789');

-- Pedido 2
--INSERT INTO pedido (cliente_id, data_pedido, data_conclusao, nota_fiscal, status, total, enderecoEntrega_rua, enderecoEntrega_numero, enderecoEntrega_cidade, enderecoEntrega_estado, enderecoEntrega_cep) VALUES (3, '2023-02-01 11:30:00', '2023-02-02 14:45:00', 12346, 'EM_PROCESSAMENTO', 200.75, 'Rua B', 456, 'Cidade B', 'Estado B', '23456-7890');

-- Pedido 3
--INSERT INTO pedido (cliente_id, data_pedido, data_conclusao, nota_fiscal, status, total, enderecoEntrega_rua, enderecoEntrega_numero, enderecoEntrega_cidade, enderecoEntrega_estado, enderecoEntrega_cep) VALUES (4, '2023-03-01 09:45:00', '2023-03-02 11:15:00', 12347, 'PENDENTE', 75.30, 'Rua C', 789, 'Cidade C', 'Estado C', '34567-8901');

insert into pedido (id, cliente_id, data_criacao, total, status) values (4, 2, sysdate(), 998.0, 'AGUARDANDO');
insert into pedido (id, cliente_id, data_criacao, total, status) values (5, 3, sysdate(), 499.0, 'AGUARDANDO');
insert into pedido (id, cliente_id, data_criacao, total, status) values (6, 3, sysdate(), 499.0, 'AGUARDANDO');
insert into pedido (id, cliente_id, data_criacao, total, status) values (7, 3, sysdate(), 499.0, 'AGUARDANDO');
insert into pedido (id, cliente_id, data_criacao, total, status) values (8, 3, sysdate(), 499.0, 'AGUARDANDO');


insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) values (4, 1, 499, 2);
insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) values (5, 1, 499, 1);

--insert into pagamento_cartao (pedido_id, status, numero_cartao) values (5, 'PROCESSANDO', '123');

insert into pagamento (pagamento_tipo ,pedido_id, status, numero_cartao) values ('cartao' ,5, 'PROCESSANDO', '123456');


insert into categoria(id, nome) values (1, 'Eletrônicos');