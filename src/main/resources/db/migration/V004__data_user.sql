INSERT INTO users (id, name, email, password) VALUES (1, 'Zezinho', 'zezinho@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');
INSERT INTO users (id, name, email, password) VALUES (2, 'Luizinho', 'luizinho@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');

INSERT INTO role (id, role_name) VALUES (1, 'ROLE_OPERATOR');
INSERT INTO role (id, role_name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO users_role (user_id, role_id) VALUES (1, 1);
INSERT INTO users_role (user_id, role_id) VALUES (2, 1);
INSERT INTO users_role (user_id, role_id) VALUES (2, 2);