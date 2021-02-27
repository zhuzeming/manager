-- 查询快照时刻数据
select * from SYS_PRIVILEGE as of timestamp to_timestamp('2019-10-10 19:00:00','yyyy-mm-dd hh24:mi:ss');
-- 表已更改。启动表的移动行
alter table SYS_PRIVILEGE enable row movement;
-- 闪回操作完成
flashback table SYS_PRIVILEGE to timestamp to_timestamp('2019-10-10 19:00:00','yyyy-mm-dd hh24:mi:ss');

-- 闪回整张表至删除前
FLASHBACK TABLE SYS_PRIVILEGE TO BEFORE DROP;
