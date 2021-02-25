insert into drinks (name, bottle_volume, price_for_bottle, quantity_in_warehouse) values ('vodka', '500', '10', '1500');
insert into drinks (name, bottle_volume, price_for_bottle, quantity_in_warehouse) values ('scoatch', '500', '40', '2000');

insert into roles(role_id, name) values(1,'USER');
insert into roles(role_id, name) values(2,'ADMIN');
insert into roles(role_id, name) values(3,'MANAGER');

-- password in plaintext: "password"
INSERT INTO USERS (user_id, login, password) VALUES (1, 'user', '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm');
INSERT INTO USERS (user_id, login, password) VALUES (2, 'admin', '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm');

INSERT INTO USERS_ROLES (user_user_id, roles_role_id) VALUES (1, 1);
INSERT INTO USERS_ROLES (user_user_id, roles_role_id) VALUES (2, 2);