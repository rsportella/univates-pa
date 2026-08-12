insert into cliente (nome, email) values
('Ana Silva',      'ana.silva@email.com'),
('Bruno Souza',    'bruno.souza@email.com'),
('Carla Oliveira', 'carla.oliveira@email.com'),
('Diego Santos',   'diego.santos@email.com'),
('Eduarda Lima',   'eduarda.lima@email.com'),
('Felipe Costa',   'felipe.costa@email.com');

insert into produto (nome, preco) values
('Notebook',        3500.00),
('Mouse',           80.00),
('Teclado',         150.00),
('Monitor',         900.00),
('Cadeira',         600.00),
('Webcam',          200.00),
('Headset',         250.00),
('Pen Drive',       45.00),
('HD Externo',      400.00),
('Estabilizador',   120.00);

insert into nota_fiscal (id_cliente, data_emissao) values
(1, '2026-08-01'),
(3, '2026-08-02');

insert into item_nota_fiscal (id_nota_fiscal, id_produto, quantidade, preco_unitario) values
(1, 1, 1, 3500.00),
(1, 2, 2, 80.00),
(1, 3, 1, 150.00),
(2, 4, 2, 900.00),
(2, 6, 1, 200.00);
