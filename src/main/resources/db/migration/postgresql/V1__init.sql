CREATE TABLE tb_user (
	id INTEGER NOT NULL,
	email VARCHAR(255) NOT NULL UNIQUE,
	password VARCHAR(255) NOT NULL,
	profile VARCHAR(50) NOT NULL,
	created_at TIMESTAMP without time zone default (now() at time zone 'utc'),
	updated_at TIMESTAMP without time zone default (now() at time zone 'utc')
);

CREATE TABLE tb_transaction (
	id INTEGER NOT NULL,
	user_id INTEGER NOT NULL,
	origin_currency VARCHAR(3) NOT NULL,
	origin_value DECIMAL(19,2) NOT NULL,
	target_currency VARCHAR(3) NOT NULL,
	conversion_rate DECIMAL(19,2) NOT NULL,
	date_transaction DATE NOT NULL,
	created_at TIMESTAMP without time zone default (now() at time zone 'utc'),
	updated_at TIMESTAMP without time zone default (now() at time zone 'utc')
);

-- Index for table tb_transaction
ALTER TABLE tb_user ADD CONSTRAINT pk_id_user PRIMARY KEY (id);

-- Index for table tb_transaction
ALTER TABLE tb_transaction ADD CONSTRAINT pk_id_transaction PRIMARY KEY (id);

--AUTO_INCREMENT for table tb_user
CREATE SEQUENCE tb_user_id_seq;
SELECT setval('tb_user_id_seq', (SELECT MAX(id) FROM tb_user));
ALTER TABLE tb_user ALTER COLUMN id SET DEFAULT nextval('tb_user_id_seq');

--AUTO_INCREMENT for table tb_transaction
CREATE SEQUENCE tb_transaction_id_seq;
SELECT setval('tb_transaction_id_seq', (SELECT MAX(id) FROM tb_transaction));
ALTER TABLE tb_transaction ALTER COLUMN id SET DEFAULT nextval('tb_transaction_id_seq');

--Constraints for table tb_transaction
ALTER TABLE tb_transaction ADD CONSTRAINT fk_id_tb_user FOREIGN KEY (user_id) REFERENCES tb_user(id);