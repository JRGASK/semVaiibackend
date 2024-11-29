\connect db_vaiiSem

CREATE TABLE person (
                        name                 VARCHAR(255) NOT NULL,
                        surname              VARCHAR(255) NOT NULL,
                        email                VARCHAR(255) NOT NULL,
                        password             VARCHAR(255) NOT NULL,
                        role                 VARCHAR(255) NOT NULL,
                        phone_number         VARCHAR(255) NOT NULL,
                        CONSTRAINT chk_person_role CHECK (role IN ('ADMIN', 'CUSTOMER')),
                        CONSTRAINT xpkperson PRIMARY KEY (email)
);