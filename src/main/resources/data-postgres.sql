INSERT INTO et_roles (name) VALUES ('ROLE_USER');
INSERT INTO et_roles (name) VALUES ('ROLE_GUEST');
INSERT INTO et_roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO et_users (username, password, email) VALUES ('alex', '$2a$10$.tP2OH3dEG0zms7vek4ated5AiQ.EGkncii0OpCcGq4bckS9NOULu', 'alex@gomail.com');
INSERT INTO et_users (username, password, email) VALUES ('john', '$2a$10$E2UPv7arXmp3q0LzVzCBNeb4B4AtbTAGjkefVDnSztOwE7Gix6kea', 'john@gomail.com');
INSERT INTO et_users (username, password, email) VALUES ('admin', '$2a$10$IqTJTjn39IU5.7sSCDQxzu3xug6z/LPU6IF0azE/8CkHCwYEnwBX.', 'admin@gomail.com');

INSERT INTO et_user_roles (user_id, role_id) VALUES (1, 1); -- user alex has role USER
INSERT INTO et_user_roles (user_id, role_id) VALUES (1, 2); -- user alex has role GUEST
INSERT INTO et_user_roles (user_id, role_id) VALUES (2, 1); -- user john has role USER
INSERT INTO et_user_roles (user_id, role_id) VALUES (3, 3); -- user admin has role ADMIN

-- admins
INSERT INTO stone.et_admins  ("name") VALUES 	('King');
INSERT INTO stone.et_admins  ("name") VALUES 	('Queen');
INSERT INTO stone.et_admins  ("name") VALUES 	('Prince');
INSERT INTO stone.et_admins  ("name") VALUES 	('Princess');

-- clients
INSERT INTO stone.et_clients ("name") VALUES ('Duke');
INSERT INTO stone.et_clients ("name") VALUES ('Duchess');
INSERT INTO stone.et_clients ("name") VALUES ('Marquis');
INSERT INTO stone.et_clients ("name") VALUES ('Marchioness');
INSERT INTO stone.et_clients ("name") VALUES ('Earl');
INSERT INTO stone.et_clients ("name") VALUES ('Countess');
INSERT INTO stone.et_clients ("name") VALUES ('Viscount');
INSERT INTO stone.et_clients ("name") VALUES ('Viscountess');
INSERT INTO stone.et_clients ("name") VALUES ('Baron');
INSERT INTO stone.et_clients ("name") VALUES ('Baroness');
