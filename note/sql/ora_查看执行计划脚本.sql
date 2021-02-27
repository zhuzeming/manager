explain plan for

SELECT count(*)
FROM PF_LICCPB lc
         join LE_JINRJGJDKR dkr
              ON dkr.NU_ID = lc.VC_JINRJG
                  AND dkr.vc_daikrlx = 'lender_type1';

select * from table (dbms_xplan.display);