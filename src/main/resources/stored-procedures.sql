CREATE EXTENSION IF NOT EXISTS pg_cron;

CREATE OR REPLACE PROCEDURE update_se_user_role()
LANGUAGE plpgsql
AS $$
DECLARE
  v_date_threshold DATE;

BEGIN

  v_date_threshold := CURRENT_DATE - INTERVAL '60 days';

  UPDATE se_user_role
  SET IS_BLOCKED = TRUE, DATE_BLOCKED = CURRENT_DATE
  WHERE IS_BLOCKED = FALSE
  AND DATE_CREATED <= v_date_threshold;
  

END;
$$;

SELECT cron.schedule('0 0 * * *', 'CALL update_se_user_role()');
