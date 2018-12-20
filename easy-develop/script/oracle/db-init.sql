sqlplus / as sysdba

create user api_repo indentified by api_repo;

grant create session to api_repo;

grant dba to api_repo;