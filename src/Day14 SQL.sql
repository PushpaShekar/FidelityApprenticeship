Create table Worker (
Worker_ID int Primary Key,
Fisrt_Name varchar(50),
Last_Name varchar(50),
Salary Decimal(10, 2),
Joining_Date Date,
Department varchar(50)
);

Insert into Worker (Worker_ID, Fisrt_Name, Last_Name, Salary, Joining_Date, Department) values
(1, 'Monika', 'Arora', 100000, '2020-02-14', 'HR'),
(2, 'Niharika', 'Das', 80000, '2011-02-14', 'Admin'),
(3, 'Vishal', 'A', 300000, '2020-02-14', 'HR'),
(4, 'Amitabh', 'Singh', 500000, '2020-02-14', 'Admin'),
(5, 'Vivek', 'Bhatia', 500000, '2011-06-14', 'Admin'),
(6, 'Vipul', 'Vinod', 200000, '2011-06-14', 'Account'),
(7, 'Satish', 'Kumar', 750000, '2020-01-14', 'Account'),
(8, 'Jyothi', 'Rai', 100000, '2011-04-14', 'Admin');

Select * From Worker;

Create table Bonus (
Worker_Ref_ID int,
Bonus_Amount Decimal(10, 2),
Bonus_Date Date,
Foreign Key (Worker_Ref_ID) References Worker(Worker_ID)
);

Insert into Bonus (Worker_Ref_ID, Bonus_Amount, Bonus_Date) values
(1, 5000, '2020-02-16'),
(2, 3000, '2011-06-16'),
(3, 4000, '2020-02-16'),
(4, 4500, '2020-02-16'),
(5, 3500, '2011-02-16'),
(6, 4500, '2020-02-16'),
(7, 3500, '2011-02-16');

Select * From Bonus;

Create Table Title (
Worker_Ref_ID int,
Worker_Title varchar(50),
Affected_From Date,
Foreign key (Worker_Ref_ID) References Worker(Worker_ID)
);

Insert into Title (Worker_Ref_ID, Worker_Title, Affected_From) values
(1, 'Manager', '2016-02-14'),
(2, 'Executive', '2016-06-14'),
(3, 'Lead', '2016-06-14'),
(4, 'Assistent Manager', '2016-06-14'),
(5, 'Manager', '2016-06-14'),
(6, 'Lead', '2016-06-14'),
(7, 'Executive', '2016-06-14' ),
(8, 'Executive', '2016-06-14');

Select * From Title;

Select 
Worker.Fisrt_Name,
Worker.Salary,
Title.Worker_Title 
From 
Worker  
Left Join 
Title  on Worker.Worker_ID = Title.Worker_Ref_ID;

Create or Replace Function get_worker_count_by_nth_highest_salary(n int)
Returns int as $$
Begin 
Return (
Select count(*)
From Worker Where Salary = (
Select distinct Salary From Worker Order by Salary DESC offset n - 1 Limit 1
)
);
End;
$$ Language plpgsql;

Select get_worker_count_by_nth_highest_salary(4);
