package  com.solvd.daoImplementation;

import  com.solvd.daoInterfaces.IEmployeeDAO;
import  com.solvd.entities.Employee;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao extends DB_Connection implements IEmployeeDAO {
    final String INSERT="INSERT INTO employee (department_id, full_name, birth_date,hire_date) VALUES (?,?,?,?)";
    final String UPDATE="UPDATE employee SET department_id=?, full_name=?, birth_date=?,hire_date=? WHERE id_employee=?";
    final String DELETE="DELETE FROM employee WHERE id_employee=?";
    final String GETALL="SELECT * FROM employee";
    final String GETONE="SELECT * FROM employee WHERE id_employee=?";

    public EmployeeDao(Connection connection) {
        super();
    }


    public Employee turnToEmployee(ResultSet rs) throws SQLException {
        Integer department= rs.getInt("department_id");
        String fullName=rs.getString("full_name");
        LocalDate dob=rs.getDate("birth_date").toLocalDate();
        LocalDate hd=rs.getDate("hire_date").toLocalDate();
        Employee employee=new Employee(department,fullName,dob,hd);
        employee.setId_employee(rs.getInt("id_employee"));
        return employee;
    }

    @Override
    public Employee getOne(Integer id) {
        Employee employee=null;
        try {
            connectToDB();
            statement=connection.prepareStatement(GETONE);
            statement.setInt(1,id);
            result= statement.executeQuery();
            if (result.next()){
                employee=turnToEmployee(result);
            }
            connection.commit();
            System.out.println("GetOne succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return employee;
    }

    @Override
    public List<Employee> getAll() {

        List <Employee> employeeList=new ArrayList<>();
        try {
            connectToDB();
            statement=connection.prepareStatement(GETALL);
            result= statement.executeQuery();
            while (result.next()){
                employeeList.add(turnToEmployee(result));
            }
            connection.commit();
            System.out.println("GetAll succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return employeeList;
    }

    @Override
    public void insert(Employee employee) {
        try {
            connectToDB();
            statement=connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, employee.getDepartmentId());
            statement.setString(2, employee.getFullName());
            statement.setDate(3, Date.valueOf(employee.getBirth_date()));
            statement.setDate(4, Date.valueOf(employee.getHire_date()));

            statement.executeUpdate();

            connection.commit();
            System.out.println("Insert succeed");
            ResultSet result=statement.getGeneratedKeys();
            if (result.next()){
                employee.setId_employee(result.getInt(1));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            disconnectToDB();
        }
    }

    @Override
    public void update(Employee employee, Integer id) {
        try {
            connectToDB();
            statement=connection.prepareStatement(UPDATE);
            statement.setInt(1,employee.getId_employee());
            statement.setString(2, employee.getFullName());
            statement.setDate(3, Date.valueOf(employee.getBirth_date()));
            statement.setDate(4, Date.valueOf(employee.getHire_date()));
            statement.setInt(5, id);

            statement.executeUpdate();

            connection.commit();
            System.out.println("Update succeed");

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            disconnectToDB();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            connectToDB();
            statement=connection.prepareStatement(DELETE);
            statement.setInt(1,id);

            statement.executeUpdate();

            connection.commit();
            System.out.println("Delete succeed");

        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }

    }
}
