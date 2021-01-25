--drop table li_huankjhzfdx;
create table li_huankjhzfdx
(
    nu_id         number not null
        constraint pk_li_huankjhzfdx
            primary key,
    nu_huanbfxIdFK number,
    nu_disfzhIdFK   number,
    vc_huanbfxbs  varchar2(10 char),
    vc_fukbz      varchar2(4000 char),
    dt_yaoqzfsj   date,
    vc_chuangjr   varchar2(100 char),
    dt_chuangjsj  date,
    vc_gengxr     varchar2(100 char),
    dt_gengxsj    date
)
;
comment on table li_huankjhzfdx is '还款计划支付对象';
comment on column li_huankjhzfdx.nu_id is 'ID';
comment on column li_huankjhzfdx.nu_huanbfxIdFK is '还本付息外键idFK';
comment on column li_huankjhzfdx.nu_disfzhIdfk is '第三方账户外键idFK';
comment on column li_huankjhzfdx.vc_huanbfxbs is '还本付息标识';
comment on column li_huankjhzfdx.vc_fukbz is '付款备注';
comment on column li_huankjhzfdx.dt_yaoqzfsj is '要求支付时间';
comment on column li_huankjhzfdx.vc_chuangjr is '创建人';
comment on column li_huankjhzfdx.dt_chuangjsj is '创建时间';
comment on column li_huankjhzfdx.vc_gengxr is '更新人';
comment on column li_huankjhzfdx.dt_gengxsj is '更新时间';
