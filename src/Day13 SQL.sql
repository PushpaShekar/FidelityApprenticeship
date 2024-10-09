CREATE TABLE Customers (
    customer_id VARCHAR(10) PRIMARY KEY,
    customer_name VARCHAR(50),
    address VARCHAR(100),
    phone_number VARCHAR(15),
    email VARCHAR(50)
);

INSERT INTO Customers VALUES
('CUST11', 'John Bosco', '123 Main St', '1234567890', 'john@gmail.com'),
('CUST12', 'James Smith', '456 Elm St', '2345678901', 'james@yahoo.com'),
('CUST13', 'Bob Barren', '789 Oak St', '3456789012', 'bob@gmail.com'),
('CUST14', 'Jack Jones', '321 Pine St', '4567890123', 'jack@hotmail.com');

select * from Customers;

CREATE TABLE Hotel_details (
    hotel_id INT PRIMARY KEY,
    hotel_name VARCHAR(50),
    hotel_type VARCHAR(20),
    rating DECIMAL(3,1)
);

INSERT INTO Hotel_details VALUES
(1, 'A2B', 'VEG', 4.5),
(2, 'Pizza Hut', 'NON-VEG', 4.2),
(3, 'Dominos', 'NON-VEG', 4.0),
(4, 'KFC', 'NON-VEG', 3.8);

select * from Hotel_details;

CREATE TABLE Delivery_partners (
    partner_id INT PRIMARY KEY,
    partner_name VARCHAR(50),
    phone_number VARCHAR(15),
    rating DECIMAL(3,1)
);

INSERT INTO Delivery_partners VALUES
(101, 'Mike', '5678901234', 4.7),
(102, 'Sarah', '6789012345', 4.2),
(103, 'Tom', '7890123456', 3.9),
(104, 'Emily', '8901234567', 4.5);

select * from Delivery_partners;

CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    customer_id VARCHAR(10),
    hotel_id INT,
    order_date DATE,
    order_amount DECIMAL(10,2),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (hotel_id) REFERENCES Hotel_details(hotel_id)
);

INSERT INTO Orders VALUES
(1, 'CUST1001', 1, '2019-05-10', 500.00),
(2, 'CUST1002', 2, '2019-05-11', 750.00),
(3, 'CUST1003', 3, '2019-05-12', 600.00),
(4, 'CUST1004', 4, '2019-06-01', 800.00),
(5, 'CUST1001', 2, '2019-06-02', 700.00),
(6, 'CUST1002', 3, '2019-06-03', 550.00),
(7, 'CUST1003', 1, '2019-06-04', 450.00);

select * from Orders;

SELECT partner_id, partner_name, phone_number
FROM Delivery_partners
WHERE rating BETWEEN 3 AND 5
ORDER BY partner_id;

UPDATE Customers
SET phone_number = '9876543210'
WHERE customer_id = 'CUST1004';

SELECT customer_id, customer_name, address, phone_number
FROM Customers
WHERE email LIKE '%@gmail.com'
ORDER BY customer_id;

ALTER TABLE Customers
ALTER COLUMN customer_id TYPE INT USING customer_id::integer;

ALTER TABLE Hotel_Details
RENAME COLUMN Rating TO Hotel_Rating;

SELECT CONCAT(hotel_name, ' is a ', hotel_type, ' hotel') AS HOTEL_INFO
FROM Hotel_details
ORDER BY HOTEL_INFO DESC;

SELECT h.hotel_id, h.hotel_name, COUNT(*) AS NO_OF_ORDERS
FROM Hotel_details h
JOIN Orders o ON h.hotel_id = o.hotel_id
GROUP BY h.hotel_id, h.hotel_name
HAVING COUNT(*) > 5
ORDER BY h.hotel_id ASC;

SELECT DISTINCT h.hotel_id, h.hotel_name, h.hotel_type
FROM Hotel_details h
LEFT JOIN Orders o ON h.hotel_id = o.hotel_id AND TO_CHAR(o.order_date, 'YYYY-MM') = '2019-05'
WHERE o.order_id IS NULL
ORDER BY h.hotel_id ASC;

SELECT o.order_id, c.customer_name, h.hotel_name, o.order_amount
FROM Orders o
JOIN Customers c ON o.customer_id = c.customer_id
JOIN Hotel_details h ON o.hotel_id = h.hotel_id
ORDER BY o.order_id ASC;

CREATE TABLE PIZZA (
    pizza_id INT PRIMARY KEY,
    pizza_type VARCHAR(20),
    amount DECIMAL(10,2)
);

UPDATE PIZZA
SET amount = amount * 0.97
WHERE pizza_type = 'Extra Large';

CREATE TABLE IF NOT EXISTS salesman (
    salesman_id INT PRIMARY KEY,
    name VARCHAR(50)
	);

CREATE TABLE IF NOT EXISTS new_orders (
    order_id INT PRIMARY KEY,
    order_date DATE,
    amount DECIMAL(10, 2),
    salesman_id INT,
    FOREIGN KEY (salesman_id) REFERENCES salesman(salesman_id)
);

CREATE TABLE IF NOT EXISTS Supplier (
    supplier_id INT PRIMARY KEY,
    supplier_name VARCHAR(50)
);

ALTER TABLE Supplier
ADD CONSTRAINT check_supplier_name CHECK (LENGTH(supplier_name) > 0);

SELECT * FROM Supplier;













