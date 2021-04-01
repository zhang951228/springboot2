--@date: 2021/04/01
---创建user表
create table t_user
(
    id        number(20),
    account   varchar2(20),
    password  varchar2(255),
    user_name varchar2(36),
    real_name varchar2(20),
    age       number(3),
    sex       number(2),
    birth_day date,
    role      number(5),
    status    number(11),
    create_time date,
    modify_time date,
    last_active_time date
);

-- Add comments to the table
comment
on table t_user
  is '登录用户信息表';
-- Add comments to the columns
comment
on column t_user.account is '登录账户';

-- Create/Recreate primary, unique and foreign key constraints
alter table t_user
    add primary key (account);
