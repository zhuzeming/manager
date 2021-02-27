-- 表有分区，如插入未映射到分区，插入一个分区即可。
-- 例如：
ALTER TABLE table_name SET INTERVAL(NUMTOYMINTERVAL(1, 'MONTH'));
