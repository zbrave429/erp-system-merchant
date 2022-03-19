create table if not exists merchant
(
    id               bigint auto_increment comment 'ID'
        primary key,
    merchant_name    varchar(256) null comment '商户名称',
    address          varchar(512) null comment '地址',
    lng              varchar(64)  null comment '经度',
    lat              varchar(64)  null comment '纬度',
    merchant_type    int          null comment '商户分类',
    status           int          null comment '状态',
    register_channel int          null comment '注册渠道',
    master_user_id   bigint       null comment '主账号ID',
    logo             varchar(128) null comment 'logo图片名',
    add_by           varchar(64)  null,
    add_time         datetime     null,
    update_by        varchar(64)  null,
    update_time      datetime     null,
    `desc`           varchar(512) null comment '描述',
    is_delete        tinyint(1)   null
)
    comment '商户基础信息';

create index idx_merchant_base_add_time
    on merchant (add_time desc);

create table if not exists merchant_ext_param
(
    id          bigint auto_increment
        primary key,
    merchant_id bigint       null comment '商户ID',
    ext_code    varchar(128) null comment '扩展属性编码',
    ext_value   varchar(512) null comment '扩展属性数据',
    add_by      varchar(64)  null,
    add_time    datetime     null,
    update_by   varchar(64)  null,
    update_time datetime     null
)
    comment '商户扩展属性';

create index idx_merchant_ext_attr_merchant_id
    on merchant_ext_param (merchant_id desc);

create table if not exists shop
(
    id          bigint auto_increment
        primary key,
    merchant_id bigint       null comment '商户ID',
    shop_name   varchar(128) null comment '门店名称',
    shop_type   int          null comment '门店类型',
    logo        varchar(128) null comment 'logo图名字',
    status      int          null comment '状态',
    is_master   tinyint(1)   null comment '是否主账号',
    address     varchar(256) null comment '地址',
    add_by      varchar(128) null,
    add_time    datetime     null,
    update_by   varchar(128) null,
    update_time datetime     null,
    `desc`      varchar(512) null comment '描述',
    is_delete   tinyint(1)   null,
    lng         varchar(64)  null comment '经度',
    lat         varchar(64)  null comment '纬度'
)
    comment '门店基础信息';

create index idx_shop_base_merchant_id
    on shop (merchant_id desc);

create table if not exists shop_ext_param
(
    id          bigint auto_increment
        primary key,
    shop_id     bigint       null,
    ext_code    varchar(128) null,
    ext_value   varchar(512) null,
    add_by      varchar(128) null,
    add_time    datetime     null,
    update_by   varchar(128) null,
    update_time datetime     null
)
    comment '门店扩展信息';

create index idx_shop_ext_param_shop_id
    on shop_ext_param (shop_id desc);

create table if not exists user
(
    id          bigint auto_increment
        primary key,
    merchant_id bigint       null comment '商户ID',
    shop_id     bigint       null comment '门店ID',
    mobile_no   varchar(32)  null comment '手机号码',
    nickname    varchar(128) null comment '昵称',
    status      int          null comment '状态',
    add_by      varchar(128) null,
    add_time    datetime     null,
    update_by   varchar(128) null,
    update_time datetime     null,
    is_delete   tinyint(1)   null
)
    comment '用户';

