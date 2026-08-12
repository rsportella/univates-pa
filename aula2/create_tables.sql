create table cliente (
    id serial not null,
    nome varchar(150) not null,
    email varchar(200),
    constraint pk_cliente primary key (id)
);

create table produto (
    id serial not null,
    nome varchar(150) not null,
    preco numeric(10,2) not null,
    constraint pk_produto primary key (id)
);

create table nota_fiscal (
    id serial not null,
    id_cliente integer not null,
    data_emissao date not null,
    constraint pk_nota_fiscal primary key (id),
    constraint fk_nota_fiscal_cliente foreign key (id_cliente) references cliente (id)
);

create table item_nota_fiscal (
    id_nota_fiscal integer not null,
    id_produto integer not null,
    quantidade integer not null,
    preco_unitario numeric(10,2) not null,
    constraint pk_item_nota_fiscal primary key (id_nota_fiscal, id_produto),
    constraint fk_item_nota_fiscal foreign key (id_nota_fiscal) references nota_fiscal (id),
    constraint fk_item_produto foreign key (id_produto) references produto (id)
);
