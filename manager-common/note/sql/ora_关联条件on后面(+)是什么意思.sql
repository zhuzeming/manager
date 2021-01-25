左外连接：select A.a,B.a from A LEFT JOIN B ON A.b=B.b;
等价于  select A.a,B.a from A,B where A.b = B.b(+);