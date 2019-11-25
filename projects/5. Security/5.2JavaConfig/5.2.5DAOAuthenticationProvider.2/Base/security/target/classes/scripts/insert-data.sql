INSERT INTO users(username,password) VALUES ('INAM','$2a$10$z59TK3XhcZOcyeevNbCrxusYtR6Vi4KvrRCZGAjZdyQX.8GE95NU6');
INSERT INTO users(username,password) VALUES ('DAVID','$2a$10$z59TK3XhcZOcyeevNbCrxusYtR6Vi4KvrRCZGAjZdyQX.8GE95NU6');

/*Roles*/
INSERT INTO authorities(username,authority) VALUES ('INAM','USER');
INSERT INTO authorities(username,authority) VALUES ('INAM','HR');
INSERT INTO authorities(username,authority) VALUES ('DAVID','USER');
INSERT INTO authorities(username,authority) VALUES ('DAVID','ADMIN');