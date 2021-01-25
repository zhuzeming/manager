--=============================建表
create table test_a
(
    id  number,
    val varchar2(100)
);
create table test_b
(
    id  number,
    val varchar2(100)
);
create table test_c
(
    id  number,
    val varchar2(100)
);

--=================================初始数据
insert into test_a
values (1, '');
insert into test_a
values (2, '');
insert into test_a
values (3, '');

insert into test_b
values (2, '');
insert into test_b
values (1, '');

insert into test_c
values (1, '');

--================================测试脚本
select *
from test_a ta
         left join test_b tb
                   on ta.id = tb.id
         join test_c tc
              on tc.id = tb.id;
--结论： （先左再内不可）以内连接为准

select *
from test_a ta
         join test_b tb
              on ta.id = tb.id
         left join test_c tc
                   on tc.id = tb.id;
--结论： 先内再左可以

--=================================删除表
drop table test_a;
drop table test_b;
drop table test_c;


--===========================结论
先左再内：不可
先内再左：可