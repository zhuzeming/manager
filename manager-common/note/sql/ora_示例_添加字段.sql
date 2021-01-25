-- Add/modify columns
alter table CA_YINGFXX add vc_chuangjr VARCHAR2(400);
-- Add comments to the columns
comment on column CA_YINGFXX.vc_chuangjr
    is '创建人';