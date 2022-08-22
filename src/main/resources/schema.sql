create table if not exists Robot_Order (
    id identity,
    delivery_Name varchar(50) not null,
    delivery_Street varchar(50) not null,
    delivery_City varchar(50) not null,
    delivery_State varchar(2) not null,
    delivery_Zip varchar(10) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_cvv varchar(3) not null,
    placed_at timestamp not null
    );

create table if not exists Robot (
    id identity,
    name varchar(50) not null,
    robot_order bigint not null,
    robot_order_key bigint not null,
    created_at timestamp not null
    );

create table if not exists Item_Ref (
    item varchar(6) not null,
    robot bigint not null,
    robot_key bigint not null
    );

create table if not exists Item (
    id varchar(6) unique not null,
    name varchar(25) not null,
    type varchar(15) not null
    );

alter table Robot add foreign key (robot_order) references Robot_Order(id);
alter table Item_Ref add foreign key (item) references Item(id);