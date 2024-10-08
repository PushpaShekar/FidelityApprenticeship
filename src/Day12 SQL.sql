create table tblCustomers (
CustomerID int primary key,
CustomerName varchar(100) not null,
ContactName varchar(100),
Address varchar(255),
City varchar(100),
PostalCode varchar(20),
Country varchar(100) default 'Canada'
);

Insert into tblCustomers (CustomerID, CustomerName, ContactName, Address, City, PostalCode)
values 
(3,'Customer B', 'Jane Smith', '456 Oak St', 'Vancouver', 'VB6 8H7' );

SELECT * FROM tblCustomers;

Alter table tblCustomers
add email varchar(100);


create table tblSuppliers (
SupplierID int primary key,
SupplierName varchar(100) not null,
ContactName varchar(100),
Address varchar(255),
City varchar(100),
PostalCode varchar(20),
Country varchar(100)
);

Insert into tblSuppliers (SupplierId, SupplierName, ContactName, Address, City, PostalCode, Country)
values 
(1, 'Supplier X', 'Michael Brown', '789 Pine st', 'Montreal', 'H3B 2T5', 'Canada'),
(2, 'Supplier Y', 'Bruce lee', '675 Elm st', 'Calgary', 'T2P 4X1', 'Canada');

SELECT * FROM tblSuppliers;

create table tblShippers (
ShipperID int primary key,
ComapnyName varchar(100) not null unique,
Phone varchar(20)
);


Insert into tblShippers (ShipperID, ComapnyName, Phone)
values (1, 'Shipper 1', '123-456-7890'),
(2, 'Shipper 2', '923-456-7897');

SELECT * FROM tblShippers;

create table tblProducts (
ProductId int primary key,
ProductName varchar(100) not null,
SupplierId int,
UnitPrice Decimal(10, 2),
Foreign key (SupplierID) references tblSuppliers(SupplierID)
);

Insert into tblProducts (ProductID, ProductName, SupplierID, UnitPrice)
values (1, 'Product A', 1, 50.00),
 (2, 'Product B', 2, 85.00);

SELECT * FROM tblProducts;

Update tblProducts 
set UnitPrice = UnitPrice * 1.10
where ProductID = 2;

create table tblOrders (
OrderID int primary key,
CustomerID int,
ShipperID int,
OrderDate date,
ShippedDate date,
Foreign key (CustomerId) references tblCustomers(CustomerID),
Foreign key (ShipperID) references tblShippers(ShipperID),
Check (ShippedDate > OrderDate)
);

Insert into tblOrders(OrderID, CustomerID, ShipperID, OrderDate, ShippedDate)
values (1,1,1,'2024-10-05', '2024-10-03'),
(2,2,2,'2024-10-02', '2024-10-05');

SELECT * FROM tblOrders;

Delete from tblOrders 
where ShippedDate < '2024-10-01';


create table tblOrderDetails (
OrderDetailID int primary key,
OrderID int,
ProductID int,
Quantity int Check (Quantity > 10),
Foreign key (OrderID) references tblOrders(OrderID),
Foreign key (ProductID) references tblProducts(ProductID)
);

Insert into tblOrderDetails ( OrderDetailID, OrderID, ProductID, Quantity)
values ( 1, 1, 1, 3);

SELECT * FROM tblOrderDetails;

