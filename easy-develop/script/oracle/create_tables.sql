drop table "dev_api" cascade constraints;

/*==============================================================*/
/* Table: "dev_api"                                             */
/*==============================================================*/
create table "dev_api" 
(
   "id"                 INTEGER              not null,
   "api_name"           VARCHAR2(30),
   "return_type"        VARCHAR2(25),
   "params"             VARCHAR2(100),
   "description"        VARCHAR2(200),
   "is_enabled"         INTEGER,
   "author"             VARCHAR2(15),
   "gmt_create"         DATE                 not null,
   "gmt_modified"       DATE                 not null,
   constraint PK_DEV_API primary key ("id")
);

comment on table "dev_api" is '接口表';
comment on column "dev_api"."id" is '主键id';
comment on column "dev_api"."api_name" is '接口名称';
comment on column "dev_api"."return_type" is '返回值类型';
comment on column "dev_api"."params" is '接收参数';
comment on column "dev_api"."description" is '功描述';
comment on column "dev_api"."is_enabled" is '是否启用';
comment on column "dev_api"."author" is '作者';
comment on column "dev_api"."gmt_create" is '创建时间';
comment on column "dev_api"."gmt_modified" is '修改时间';
