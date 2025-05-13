DROP TABLE IF EXISTS bookings, rooms;
CREATE TABLE rooms (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       type VARCHAR(50) NOT NULL,
                       price DECIMAL(10, 2) NOT NULL
);
CREATE TABLE bookings (
                          id SERIAL PRIMARY KEY,
                          room_id INT REFERENCES rooms(id),
                          user_id INT,
                          status VARCHAR(20) DEFAULT 'PENDING' CHECK (status IN ('PENDING', 'APPROVED', 'REJECTED'))
);
INSERT INTO rooms (name, type, price) VALUES
                                          ('Room 101', 'Single', 50.00),
                                          ('Room 102', 'Double', 80.00),
                                          ('Room 201', 'Suite', 150.00);