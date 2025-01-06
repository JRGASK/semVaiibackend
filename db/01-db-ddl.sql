\connect db_vaiiSem

CREATE TABLE person (
                        name                 VARCHAR(255) NOT NULL,
                        surname              VARCHAR(255) NOT NULL,
                        email                VARCHAR(255) NOT NULL,
                        password             VARCHAR(255) NOT NULL,
                        role                 VARCHAR(255) NOT NULL,
                        phone_number         VARCHAR(255) NULL,
                        CONSTRAINT chk_person_role CHECK (role IN ('ADMIN', 'CUSTOMER')),
                        CONSTRAINT xpkperson PRIMARY KEY (email)
);

CREATE TABLE vehicle (
                        type                 VARCHAR(255) NULL,
                        engine               VARCHAR(255) NULL,
                        make                 VARCHAR(255) NULL,
                        model                VARCHAR(255) NULL,
                        color                VARCHAR(255) NULL,
                        vehicleRegistrationNumber                  VARCHAR(9)   NOT NULL,
                        email                VARCHAR(255)  NULL,
                        CONSTRAINT chk_vehicle_type CHECK (type IN ('CAR', 'BIKE','OTHER')),
                        CONSTRAINT xpkvehicle PRIMARY KEY (vehicleRegistrationNumber)

);

ALTER TABLE vehicle
    ADD CONSTRAINT r_vehicle_person FOREIGN KEY (email) REFERENCES person (email);


CREATE TABLE customerService (
                        serviceId             SERIAL PRIMARY KEY,
                        name                  VARCHAR(255) NULL,
                        price                 VARCHAR(255) NULL,
                        info                  VARCHAR(255) NULL
);