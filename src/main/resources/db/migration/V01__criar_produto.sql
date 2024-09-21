                         CREATE TABLE produto (
                         id BIGSERIAL PRIMARY KEY,
                         nome VARCHAR(255) NOT NULL,
                         quantidade INT NOT NULL,
                         valor NUMERIC(15, 2) NOT NULL
                         );
