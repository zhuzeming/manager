-- drop table test;
-- truncate table test;
create table test (
                       nu_id number,
                       vc_name varchar2(50 char),
                       dt_chuangjsj date
);
insert into test values (1, 'a1',sysdate);
insert into test values (1, 'a2',sysdate);
insert into test values (2, 'd1',sysdate);
insert into test values (2, 'd2',sysdate);
select * from test;
SELECT vc_name, nu_id, dt_chuangjsj
FROM (
         SELECT vc_name, nu_id, dt_chuangjsj,
                row_number() over (partition BY nu_id ORDER BY dt_chuangjsj asc ) rn
         FROM test)
WHERE rn = 1