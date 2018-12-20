drop table if exists dev_api;

/*==============================================================*/
/* Table: dev_api                                               */
/*==============================================================*/
create table dev_api
(
   id                   bigint unsigned not null comment '主键id',
   api_name             varchar(30) comment '接口名称',
   return_type          varchar(25) comment '返回值类型',
   params               varchar(100) comment '接收参数',
   description          varchar(200) comment '功能描述',
   is_enabled           tinyint unsigned comment '是否启用',
   author               varchar(15) comment '作者',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   primary key (id)
) comment '接口存储表';
