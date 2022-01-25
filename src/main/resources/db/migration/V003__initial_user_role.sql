create table users(

    id int PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(150) NOT NULL


);

create table role (

    id int PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL

);

create table users_role (

    user_id int NOT NULL,
    role_id int NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES role(id)
);