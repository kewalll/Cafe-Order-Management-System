drop database project_java;
create database project_java;
use project_java;
CREATE TABLE CoffeeShop (
  cafe_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY (cafe_id)
);

CREATE TABLE Customer (
  cust_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  phone_no VARCHAR(15) NOT NULL,
  date_of_birth DATE,
  cafe_id INT NOT NULL,
  PRIMARY KEY (cust_id),
  FOREIGN KEY (cafe_id) REFERENCES CoffeeShop(cafe_id)
);

CREATE TABLE Orders (
  order_id INT NOT NULL AUTO_INCREMENT,
  date_and_time DATETIME NOT NULL,
  cust_id INT NOT NULL,
  PRIMARY KEY (order_id),
  FOREIGN KEY (cust_id) REFERENCES Customer(cust_id)
);

CREATE TABLE Items (
  item_id INT NOT NULL AUTO_INCREMENT,
  item_name VARCHAR(100) NOT NULL,
  price DECIMAL(10, 2) NOT NULL,
  cafe_id INT NOT NULL,
  PRIMARY KEY (item_id),
  FOREIGN KEY (cafe_id) REFERENCES CoffeeShop(cafe_id)
);

CREATE TABLE OrderItems (
  order_item_id INT NOT NULL AUTO_INCREMENT,
  order_id INT NOT NULL,
  item_id INT NOT NULL,
  qty INT NOT NULL DEFAULT 1,
  dish_name varchar(50),
  status VARCHAR(50) NOT NULL,
  PRIMARY KEY (order_item_id),
  FOREIGN KEY (order_id) REFERENCES Orders(order_id),
  FOREIGN KEY (item_id) REFERENCES Items(item_id)
);

CREATE TABLE Employee (
  emp_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  phone_no VARCHAR(15) NOT NULL,
  date_of_birth DATE,
  date_of_joining DATE,
  address VARCHAR(100),
  gender ENUM('Male', 'Female', 'Other'),
  cafe_id INT NOT NULL,
  PRIMARY KEY (emp_id),
  FOREIGN KEY (cafe_id) REFERENCES CoffeeShop(cafe_id)
);

CREATE TABLE Manager (
  emp_id INT NOT NULL PRIMARY KEY,
  experience VARCHAR(100) NOT NULL,
  FOREIGN KEY (emp_id) REFERENCES Employee(emp_id)
);

CREATE TABLE Chef (
  emp_id INT NOT NULL PRIMARY KEY,
  specialization VARCHAR(100) NOT NULL,
  FOREIGN KEY (emp_id) REFERENCES Employee(emp_id)
);

CREATE TABLE Barista (
  emp_id INT NOT NULL PRIMARY KEY,
  expertise VARCHAR(100) NOT NULL,
  FOREIGN KEY (emp_id) REFERENCES Employee(emp_id)
);

CREATE TABLE Bills (
  bill_id INT NOT NULL AUTO_INCREMENT,
  order_id INT NOT NULL,
  total_amt DECIMAL(10, 2) NOT NULL,
  tip_amt DECIMAL(10, 2),
  PRIMARY KEY (bill_id),
  FOREIGN KEY (order_id) REFERENCES Orders(order_id)
);

CREATE TABLE Login (
  username VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  role ENUM('admin', 'manager', 'kitchen') NOT NULL,
  PRIMARY KEY (username, role)
);

-- Populate CoffeeShop
INSERT INTO CoffeeShop (name) VALUES ('Cafe A');

-- Populate Customer
INSERT INTO Customer (name, email, phone_no, date_of_birth, cafe_id) VALUES
('John Doe', 'john@example.com', '1234567890', '1990-01-15', 1),
('Alice Smith', 'alice@example.com', '9876543210', '1985-05-20', 1),
('Bob Johnson', 'bob@example.com', '5551234567', '1998-09-10', 1),
('Emma Wilson', 'emma@example.com', '1234567890', '1993-06-10', 1),
('William Brown', 'william@example.com', '9876543210', '1979-09-20', 1),
('Ava Garcia', 'ava@example.com', '5551234567', '1992-04-15', 1),
('Noah Martinez', 'noah@example.com', '5559876543', '1988-07-05', 1),
('Mia Lee', 'mia@example.com', '3335557777', '2002-01-30', 1),
('James Taylor', 'james@example.com', '2224446666', '1980-12-12', 1),
('Charlotte Lopez', 'charlotte@example.com', '9998887777', '1997-03-25', 1),
('Ethan Harris', 'ethan@example.com', '1112223333', '1986-08-18', 1),
('Isabella Clark', 'isabella@example.com', '4443332222', '1990-11-08', 1),
('Alexander Rodriguez', 'alexander@example.com', '7778889999', '1984-05-03', 1),
('Sophia Hall', 'sophia@example.com', '6665554444', '1995-02-20', 1),
('Daniel Young', 'daniel@example.com', '3334445555', '1983-10-22', 1),
('Olivia King', 'olivia@example.com', '1112223333', '1976-12-15', 1),
('Logan Wright', 'logan@example.com', '9998887777', '1981-04-18', 1),
('Grace Scott', 'grace@example.com', '4445556666', '1998-09-05', 1);
-- Populate Orders
INSERT INTO Orders (date_and_time, cust_id) VALUES
('2024-04-18 10:00:00', 1),
('2024-04-18 11:30:00', 2),
('2024-04-18 12:45:00', 3),
('2024-04-18 14:00:00', 4),
('2024-04-19 09:00:00', 5),
('2024-04-19 11:45:00', 6),
('2024-04-19 14:30:00', 7),
('2024-04-20 08:30:00', 8),
('2024-04-20 12:15:00', 9),
('2024-04-20 15:00:00', 10),
('2024-04-21 10:45:00', 11),
('2024-04-21 13:30:00', 12),
('2024-04-22 09:15:00', 13),
('2024-04-22 11:00:00', 14),
('2024-04-22 14:45:00', 15),
('2024-04-23 10:30:00', 16),
('2024-04-23 12:45:00', 17),
('2024-04-23 15:15:00', 18);

-- Populate Items
INSERT INTO Items (item_name, price, cafe_id) VALUES
('Coffee', 2.50, 1),
('Tea', 2.00, 1),
('Sandwich', 5.00, 1),
('Cake', 3.50, 1),
('Burger', 6.00, 1),
('Fries', 2.50, 1),
('Latte', 3.50, 1),
('Cappuccino', 3.50, 1),
('Croissant', 4.00, 1),
('Muffin', 2.50, 1),
('Espresso', 2.00, 1),
('Macchiato', 3.00, 1),
('Bagel', 3.00, 1),
('Doughnut', 2.00, 1),
('Hot Chocolate', 4.00, 1),
('Fruit Salad', 5.00, 1),
('Pancakes', 6.50, 1),
('Waffles', 6.50, 1),
('Omelette', 7.00, 1),
('Frittata', 7.50, 1),
('French Toast', 6.00, 1);


-- Populate OrderItems
INSERT INTO OrderItems (order_id, item_id, qty, dish_name, status) VALUES
(1, 1, 2, 'Coffee','pending'),
(1, 2, 1, 'Tea','completed'),
(2, 3, 1,'Cold Coffee', 'completed'),
(2, 4, 2, 'Ice Tea','pending'),
(3, 5, 1, 'Coffee','pending'),
(3, 6, 1, 'Tea','pending'),
(4, 5, 2, 'Espresso', 'pending'),
(4, 6, 1, 'Macchiato', 'completed'),
(5, 7, 1, 'Bagel', 'completed'),
(5, 8, 2, 'Doughnut', 'pending'),
(6, 9, 1, 'Hot Chocolate', 'pending'),
(6, 10, 1, 'Fruit Salad', 'pending'),
(7, 11, 1, 'Pancakes', 'pending'),
(7, 12, 2, 'Waffles', 'pending'),
(8, 13, 1, 'Omelette', 'pending'),
(8, 14, 1, 'Frittata', 'pending'),
(9, 15, 2, 'French Toast', 'pending'),
(9, 1, 1, 'Latte', 'pending'),
(10, 2, 2, 'Cappuccino', 'pending'),
(10, 3, 1, 'Croissant', 'pending'),
(11, 4, 1, 'Muffin', 'pending');

-- Populate Employee
INSERT INTO Employee (name, phone_no, date_of_birth, date_of_joining, address, gender, cafe_id) VALUES
('Michael Scott', '555-1234', '1980-05-15', '2000-01-01', '123 Main St, Scranton, PA', 'Male', 1),
('Dwight Schrute', '555-5678', '1985-10-20', '2000-01-01', '456 Beet Rd, Scranton, PA', 'Male', 1),
('Pam Beesly', '555-2468', '1982-03-04', '2000-01-01', '789 Artist Ave, Scranton, PA', 'Female', 1),
('Jim Halpert', '555-1357', '1978-12-01', '2000-01-01', '321 Sales St, Scranton, PA', 'Male', 1),
('Stanley Hudson', '555-9876', '1960-07-12', '2000-01-01', '987 Crossword Ln, Scranton, PA', 'Male', 1),
('Emma Johnson', '555-1111', '1983-04-10', '2000-01-01', '123 Maple St, Scranton, PA', 'Female', 1),
('William Smith', '555-2222', '1975-07-20', '2000-01-01', '456 Oak St, Scranton, PA', 'Male', 1),
('Sophia Brown', '555-3333', '1990-12-15', '2000-01-01', '789 Elm St, Scranton, PA', 'Female', 1),
('Noah Davis', '555-4444', '1988-03-05', '2000-01-01', '321 Pine St, Scranton, PA', 'Male', 1),
('Mia Wilson', '555-5555', '2002-05-30', '2000-01-01', '987 Birch St, Scranton, PA', 'Female', 1),
('James Martinez', '555-6666', '1979-11-12', '2000-01-01', '654 Cedar St, Scranton, PA', 'Male', 1),
('Charlotte Taylor', '555-7777', '1997-02-25', '2000-01-01', '321 Oak St, Scranton, PA', 'Female', 1),
('Ethan Johnson', '555-8888', '1986-09-18', '2000-01-01', '456 Pine St, Scranton, PA', 'Male', 1),
('Isabella Harris', '555-9999', '1990-02-08', '2000-01-01', '789 Maple St, Scranton, PA', 'Female', 1),
('Alexander Clark', '555-1010', '1984-06-03', '2000-01-01', '987 Oak St, Scranton, PA', 'Male', 1),
('Sophia Young', '555-2020', '1995-03-20', '2000-01-01', '654 Maple St, Scranton, PA', 'Female', 1),
('Daniel Rodriguez', '555-3030', '1983-11-22', '2000-01-01', '321 Cedar St, Scranton, PA', 'Male', 1),
('Olivia Hall', '555-4040', '1976-01-15', '2000-01-01', '987 Pine St, Scranton, PA', 'Female', 1),
('Logan Young', '555-5050', '1981-04-18', '2000-01-01', '654 Elm St, Scranton, PA', 'Male', 1),
('Grace King', '555-6060', '1998-09-05', '2000-01-01', '123 Oak St, Scranton, PA', 'Female', 1);


-- Populate Manager, Chef, Barista
INSERT INTO Manager (emp_id, experience) VALUES
(1, '10 years'),
(2, '8 years'),
(16, '5 years'),
(17, '7 years');
INSERT INTO Chef (emp_id, specialization) VALUES
(3, 'Grilled'),
(4, 'Bakery'),
(18, 'Grilled'),
(19, 'Bakery');
INSERT INTO Barista (emp_id, expertise) VALUES
(5, 'Espresso'),
(1, 'Brewing'),
(10, 'Espresso'),
(11, 'Brewing');

-- Populate Bills
INSERT INTO Bills (order_id, total_amt, tip_amt) VALUES
(1, 7.00, 1.50),
(2, 8.50, 2.00),
(3, 8.50, NULL),
(4, 14.50, 2.50),
(5, 13.00, 2.00),
(6, 15.00, 3.00),
(7, 16.50, 3.50),
(8, 18.00, 4.00),
(9, 20.50, 4.50),
(10, 22.00, 5.00),
(11, 23.50, 5.50),
(12, 25.00, 6.00),
(13, 26.50, 6.50),
(14, 28.00, 7.00),
(15, 29.50, 7.50);

-- Populate Login
INSERT INTO Login (username, password, role) VALUES
('admin', 'admin123', 'admin'),
('manager', 'manager123', 'manager'),
('kitchen', 'kitchen123', 'kitchen');
