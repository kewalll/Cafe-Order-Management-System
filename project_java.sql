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
('Bob Johnson', 'bob@example.com', '5551234567', '1998-09-10', 1);

-- Populate Orders
INSERT INTO Orders (date_and_time, cust_id) VALUES
('2024-04-18 10:00:00', 1),
('2024-04-18 11:30:00', 2),
('2024-04-18 12:45:00', 3);

-- Populate Items
INSERT INTO Items (item_name, price, cafe_id) VALUES
('Coffee', 2.50, 1),
('Tea', 2.00, 1),
('Sandwich', 5.00, 1),
('Cake', 3.50, 1),
('Burger', 6.00, 1),
('Fries', 2.50, 1);

-- Populate OrderItems
INSERT INTO OrderItems (order_id, item_id, qty, dish_name, status) VALUES
(1, 1, 2, 'Coffee','pending'),
(1, 2, 1, 'Tea','served'),
(2, 3, 1,'Cold Coffee', 'served'),
(2, 4, 2, 'Ice Tea','pending'),
(3, 5, 1, 'Coffee','pending'),
(3, 6, 1, 'Tea','pending');

-- Populate Employee
INSERT INTO Employee (name, phone_no, date_of_birth, date_of_joining, address, gender, cafe_id) VALUES
('Michael Scott', '555-1234', '1980-05-15', '2000-01-01', '123 Main St, Scranton, PA', 'Male', 1),
('Dwight Schrute', '555-5678', '1985-10-20', '2000-01-01', '456 Beet Rd, Scranton, PA', 'Male', 1),
('Pam Beesly', '555-2468', '1982-03-04', '2000-01-01', '789 Artist Ave, Scranton, PA', 'Female', 1),
('Jim Halpert', '555-1357', '1978-12-01', '2000-01-01', '321 Sales St, Scranton, PA', 'Male', 1),
('Stanley Hudson', '555-9876', '1960-07-12', '2000-01-01', '987 Crossword Ln, Scranton, PA', 'Male', 1);

-- Populate Manager, Chef, Barista
INSERT INTO Manager (emp_id, experience) VALUES
(1, '10 years'),
(2, '8 years');
INSERT INTO Chef (emp_id, specialization) VALUES
(3, 'Grilled'),
(4, 'Bakery');
INSERT INTO Barista (emp_id, expertise) VALUES
(5, 'Espresso'),
(1, 'Brewing');

-- Populate Bills
INSERT INTO Bills (order_id, total_amt, tip_amt) VALUES
(1, 7.00, 1.50),
(2, 8.50, 2.00),
(3, 8.50, NULL);

-- Populate Login
INSERT INTO Login (username, password, role) VALUES
('admin', 'admin123', 'admin'),
('manager', 'manager123', 'manager'),
('kitchen', 'kitchen123', 'kitchen');
