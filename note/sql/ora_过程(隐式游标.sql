CREATE OR REPLACE PROCEDURE update_drain_account IS
BEGIN
    FOR k IN (
        SELECT NU_ID,
               VC_CONTRACT_NO_FK,
               VC_PROJECT_NAME,
               DEC_TOTAL_AMOUNT,
               CH_DEAL_LOGO,
               VC_CREATE_NAME,
               DT_CREATE_TIME,
               VC_UPDATE_NAME,
               DT_UPDATE_TIME,
               VC_OPEN_BANK_OLD,
               VC_OPEN_BANK_NO_OLD,
               VC_OPEN_BANK_ADDRESS_OLD,
               VC_CUSTOMER_NAME_OLD,
               VC_ACCOUNT_OLD,
               VC_ADDRESS_OLD,
               VC_OPEN_BANK_NEW,
               VC_OPEN_BANK_NO_NEW,
               VC_OPEN_BANK_ADDRESS_NEW,
               VC_CUSTOMER_NAME_NEW,
               VC_ACCOUNT_NEW,
               VC_ADDRESS_NEW
        FROM LI_ADJUST_DRAIN_HISTORY
        WHERE CH_DEAL_LOGO IS NULL
        )
        LOOP
            UPDATE BZ_HETGF
            SET VC_CHUZRKHZH  = k.VC_ACCOUNT_NEW,
                VC_CHUZRKHM   = k.VC_CUSTOMER_NAME_NEW,
                VC_CHUZRYHDZ  = k.VC_ADDRESS_NEW,
                VC_CHUZRKHX   = k.VC_OPEN_BANK_NEW,
                VC_CHUZRKHXXH = k.VC_OPEN_BANK_NO_NEW,
                VC_CHUZRKHXDZ = k.VC_OPEN_BANK_ADDRESS_NEW
            WHERE VC_HETBH = k.VC_CONTRACT_NO_FK;

            --更新变更表标示
            UPDATE LI_ADJUST_DRAIN_HISTORY SET CH_DEAL_LOGO = '1' WHERE CH_DEAL_LOGO IS NULL AND NU_ID = k.NU_ID;
            COMMIT;
        END LOOP;
END;
