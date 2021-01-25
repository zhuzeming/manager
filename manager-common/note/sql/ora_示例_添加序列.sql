--drop sequence s_li_huankjhzfdx;
create sequence s_li_huankjhzfdx
  minvalue 3000000
  maxvalue 9999999999999999999999999999
  start with 3000000
  increment by 1
  cache 20;


--得到序列的SQL语句
select seq_newsid.nextval from sys.dual;
--删除序列的SQL
DROP SEQUENCE seq_newsId；
