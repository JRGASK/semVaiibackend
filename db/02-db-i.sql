\connect db_vaiiSem

INSERT INTO person  (name, surname, email, role, password, phone_number) values ('Juraj', 'Admin', 'juraj@admin.com', 'ADMIN', '123ABC','0920204050');
INSERT INTO person  (name, surname, email, role, password, phone_number) values ('Peter', 'Customer', 'peter@admin.com', 'CUSTOMER', '123ABC','0920204050');

INSERT INTO vehicle (
    type,
    engine,
    make,
    model,
    vehicleRegistrationNumber,
    email,
    color
)
VALUES
    ('CAR', 'V8', 'SKODA', 'OCTAVIA-RS', 'ABC123456', 'juraj@admin.com','white');

INSERT INTO customerService (name, price, info)
VALUES
    ('Engine Diagnostics', '70 EUR', 'Comprehensive engine performance analysis');

INSERT INTO customerService (name, price, info)
VALUES
    ('Detailed Cleaning', '30 EUR', 'Complete interior and exterior vehicle cleaning');
