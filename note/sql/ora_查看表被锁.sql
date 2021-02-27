-----查询出被锁的表
select a.object_name,
       b.session_id,
       c.serial#,
       c.program,
       c.username,
       c.command,
       c.machine,
       c.lockwait

from all_objects a, v$locked_object b, v$session c
where a.object_id = b.object_id
  and c.sid = b.session_id;

----释放被锁的表 session_id,serial
alter system kill session '970,1457';
