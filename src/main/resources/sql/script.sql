create database mytest;
use mytest;
create table goods
(
    id          bigint      not null comment '商品id'
        primary key,
    name        varchar(32) null comment '商品名称',
    type        varchar(32) null comment '商品类型',
    price       double      null comment '商品价格',
    size        int         null comment '商品数量',
    status      varchar(32) null comment '商品状态',
    description varchar(50) null comment '商品描述',
    modifyTime  varchar(20) null comment '修改时间',
    createTime  varchar(20) null comment '创建时间'
)
    comment '商品信息表' charset = utf8;

create table persons
(
    id         bigint      not null comment '武侠id'
        primary key,
    name       varchar(32) null comment '武侠姓名',
    age        bigint      null comment '武侠年龄',
    sex        varchar(10) null comment '武侠性别',
    address    varchar(50) null comment '武侠住址',
    sect       varchar(50) null comment '武侠门派',
    skill      varchar(50) null comment '武侠绝技',
    power      int         null comment '战力值',
    modifyTime varchar(20) null comment '修改时间',
    createTime varchar(20) null comment '创建时间'
)
    comment '武侠信息表' charset = utf8;
