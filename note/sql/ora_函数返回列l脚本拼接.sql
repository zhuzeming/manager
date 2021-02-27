--15保证金
function fm_jingtxjl_mhis_baozj_table(months in integer) return number is
    table_column number(38, 2);
V_SQL VARCHAR2(4000);
begin
    V_SQL := '
    select sum(case
                 when ht.VC_BIZ = ''人民币'' or ht.VC_BIZ is null
                   then nvl(fyx.dec_jine, 0)
                 else
                   nvl(fyx.dec_jine, 0) * nvl(hl1.vc_huilz, 1) end)
    from rpt_zj_hetjyjgfyx fyx
           left join vi_zj_hetjbxx ht
                     on fyx.VC_HETBH = ht.VC_HETBH
           left join rpt_zj_zujhlxx hl
                     on hl.VC_HETBH = fyx.VC_HETBH
           left join ba_shujzd zd
                     on zd.vc_mingc = ht.vc_biz
                       and zd.vc_fujdid = ''currency_type''
           left join ap_huilxx_y hl1
                     on zd.vc_zhi = hl1.vc_yuanb
    where trunc(dt_shengxrq) = (select max(dt_shengxrq) from ap_huilxx_y)
          and hl1.vc_mubb = ''currency_type1''
          and (vc_feiymc = ''供应商保证金'' or vc_feiymc = ''承租人保证金'')
          and monthS_BETWEEN(TRUNC(ht.DT_SHIJQZR, ''mm''), TRUNC(sysdate, ''mm''))';
    if months < 60 then
        V_SQL := V_SQL || '=' || months;
    else
        V_SQL := V_SQL || '>=' || months;
    end if;
    EXECUTE IMMEDIATE V_SQL INTO table_column;
    return table_column;
end;
