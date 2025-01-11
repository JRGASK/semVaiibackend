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

INSERT INTO customerOrder (email, vehicle, serviceId, dateOfCreate, date, price)
VALUES
    ('juraj@admin.com', 'ABC123456', 1, CURRENT_DATE, '2023-10-15', '70 EUR');

INSERT INTO customerOrder (email, vehicle, serviceId, dateOfCreate, date, price)
VALUES
    ('peter@admin.com', NULL, 2, CURRENT_DATE, '2023-11-01', '30 EUR');