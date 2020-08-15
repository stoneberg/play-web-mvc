CREATE TABLE et_categories (
	"id" serial NOT NULL,
	description varchar(50) NOT NULL,
	title varchar(20) NOT NULL,
	total_expense numeric(10,2) DEFAULT 0.00,
	user_id int8,
	PRIMARY KEY ("id")
);

ALTER TABLE et_categories
	ADD FOREIGN KEY (user_id)
	REFERENCES et_users ("id");


CREATE TABLE et_transactions (
	"id" serial NOT NULL,
	amount numeric(10,2) DEFAULT 0.00,
	note varchar(50) NOT NULL,
	category_id int8,
	user_id int8,
	PRIMARY KEY ("id")
);

ALTER TABLE et_transactions
	ADD FOREIGN KEY (category_id)
	REFERENCES et_categories ("id");

ALTER TABLE et_transactions
	ADD FOREIGN KEY (user_id)
	REFERENCES et_users ("id");


CREATE TABLE et_users (
	"id" serial NOT NULL,
	email varchar(30) NOT NULL,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	"password" text NOT NULL,
	PRIMARY KEY ("id")
);

