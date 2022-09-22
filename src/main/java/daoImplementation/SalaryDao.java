package daoImplementation;

import daoInterfaces.ISalaryDAO;
import entity.Loan;
import entity.Salary;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SalaryDao extends DB_Connection implements ISalaryDAO {
    final String INSERT="INSERT INTO salary (employee_id, amount) VALUES (?,?)";
    final String UPDATE="UPDATE salary SET amount=? WHERE employee_id=?";
    final String DELETE="DELETE FROM salary WHERE employee_id=?";
    final String GETALL="SELECT * FROM salary";
    final String GETONE="SELECT * FROM salary WHERE employee_id=?";
    public SalaryDao(Connection connection) {
    }
    public Salary turnToSalary(ResultSet rs) throws SQLException {
        Integer employeeId= rs.getInt("employee_id");
        Integer amount= rs.getInt("amount");
        Salary salary=new Salary(employeeId,amount);
        return salary;
    }
    @Override
    public Salary getOne(Integer id) {
        Salary salary=null;
        try {
            connectToDB();
            statement=connection.prepareStatement(GETONE);
            statement.setInt(1,id);
            result= statement.executeQuery();
            if (result.next()){
                salary=turnToSalary(result);
            }
            connection.commit();
            System.out.println("GetOne succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return salary;
    }

    @Override
    public List<Salary> getAll() {
        List <Salary> salaryList=new ArrayList<>();
        try {
            connectToDB();
            statement=connection.prepareStatement(GETALL);
            result= statement.executeQuery();
            while (result.next()){
                salaryList.add(turnToSalary(result));
            }
            connection.commit();
            System.out.println("GetAll succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return salaryList;
    }

    @Override
    public void insert(Salary salary) {
        try {
            connectToDB();
            statement=connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,salary.getId_employee());
            statement.setInt(2,salary.getAmount());

            statement.executeUpdate();

            connection.commit();
            System.out.println("Insert succeed");
            ResultSet result=statement.getGeneratedKeys();
//            if (result.next()){
//                salary.setId_salary(result.getInt(1));//salary doesnt have id
//            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            disconnectToDB();
        }
    }

    @Override
    public void update(Salary salary, Integer id) {
        try {
            connectToDB();
            statement=connection.prepareStatement(UPDATE);
            statement.setInt(1,salary.getAmount());
            statement.setInt(2, id);

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
