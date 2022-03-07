BEGIN;
DROP table if exists user_profile, user_credential, user_manager;
-- -----------------------------------------------------
-- Table `user_profile`
-- -----------------------------------------------------

create table if not exists user_profile (
    -- each column consists of column name, the type of data, the length of data and the constraint
    -- postgresql column constraints: NOT NULL, UNIQUE, PRIMARY KEY, FOREIGN KEY, CHECK
    id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    email text unique not null,
    password text not null,
    age int not null,
    phone text not null,
    role text NOT NULL CHECK (role in ('MGR', 'ADMIN', 'REPORTEE')),
    -- managerID text references user_manager(manager_id),
    address text NOT NULL,
    tag text not null default ''
);
-- -----------------------------------------------------
-- Table `user_credential`
-- -----------------------------------------------------

create table if not exists user_credential(
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    user_id int not null references  user_profile(id),
    user_name text not null references user_profile(email),
    password text not null,
    enabled BOOLEAN DEFAULT TRUE
);
-- -----------------------------------------------------
-- Table `user_manager`
-- -----------------------------------------------------
create table if not exists user_manager(
    user_id INTEGER NOT NULL REFERENCES user_profile,
    manager_id INTEGER NOT NULL REFERENCES user_profile,
    --unique the combination of user_id and manager_id across the table
    unique (user_id, manager_id)
);

--commit current transaction changes, which is guaranteed to be durable if a crash occurs
commit;
