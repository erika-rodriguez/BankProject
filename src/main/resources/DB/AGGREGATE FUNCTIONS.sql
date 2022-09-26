USE bank;

#Queries without group by
SELECT COUNT(id_customer) AS 'Number of customers' FROM customer;
SELECT COUNT(id_employee) AS 'Number of employees' FROM employee;

SELECT AVG(balance) AS 'Average Balance' FROM account;
SELECT AVG(amount) AS 'Average salary' FROM salary;

#Queries with group by
SELECT d.dept_name as 'Department Name', COUNT(e.department_id) as 'Employees per Department'
FROM department as d
RIGHT JOIN employee as e ON e.department_id = d.id_department
GROUP BY e.department_id;

#Sum of Balance greater than 1000 per Branch
SELECT b.city as 'Branch', SUM(a.balance) as 'Sum of Balance >1000' 
FROM branch as b
LEFT JOIN account as a ON a.branch_id = b.id_branch
GROUP BY b.city HAVING SUM(a.balance) > 1000;

#Lower salary per department
SELECT e.full_name as 'Employee', d.dept_name AS 'Department', MIN(s.amount) as 'Lower salary' 
FROM employee as e
LEFT JOIN salary as s ON e.id_employee = s.employee_id
LEFT JOIN department as d ON e.department_id = d.id_department
GROUP BY d.dept_name HAVING MIN(s.amount);