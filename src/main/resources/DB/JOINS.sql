#INNER JOIN
SELECT id_employee, full_name, birth_date , dept_name 
FROM department 
INNER JOIN employee
ON department.id_department=employee.department_id;

SELECT id_employee, full_name, birth_date , amount 
FROM salary 
INNER JOIN employee
ON salary.employee_id=employee.id_employee;

#LEFT JOIN
SELECT id_employee, full_name, birth_date , dept_name 
FROM department 
LEFT JOIN employee
ON department.id_department=employee.department_id;

SELECT id_employee, full_name, birth_date , amount 
FROM salary 
LEFT JOIN employee
ON salary.employee_id=employee.id_employee;

#RIGHT JOIN
SELECT id_employee, full_name, birth_date , amount 
FROM employee 
RIGHT JOIN salary
ON salary.employee_id=employee.id_employee;
