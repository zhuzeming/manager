begin
    sys.dbms_scheduler.create_job(job_name            => 'DAY_DRAIN_ACCOUNT',
                                  job_type            => 'STORED_PROCEDURE',
                                  job_action          => 'update_drain_account',
                                  start_date          => to_date('12-05-2020 00:00:00', 'dd-mm-yyyy hh24:mi:ss'),
                                  repeat_interval     => 'Freq=Daily;Interval=1;ByHour=8',
                                  end_date            => to_date(null),
                                  job_class           => 'DEFAULT_JOB_CLASS',
                                  enabled             => true,
                                  auto_drop           => false,
                                  comments            => '回笼账户每天8点定时执行');
end;
/
