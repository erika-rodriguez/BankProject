package  com.solvd.daoImplementation;

import  com.solvd.daoInterfaces.IDepartmentDAO;
import  com.solvd.entity.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DepartmentDao extends DB_Connection implements IDepartmentDAO {
    final String INSERT="INSERT INTO department (dept_name) VALUES (?)";
    final String UPDATE="UPDATE department SET dept_name=? WHERE id_department=?";
    final String DELETE="DELETE FROM department WHERE id_department=?";
    final String GETALL="SELECT * FROM department";
    final String GETONE="SELECT * FROM department WHERE id_department=?";
    public DepartmentDao(Connection connection) {
    }
    public Department turnToDepartment(ResultSet rs) throws SQLException {
        String deptName= rs.getString("dept_name");
        Department department=new Department(deptName);
        department.setId_department(rs.getInt("id_department"));
        return department;
    }
    @Override
    public Department getOne(Integer id) {
        Department department=null;
        try {
            connectToDB();
            statement=connection.prepareStatement(GETONE);
            statement.setInt(1,id);
            result= statement.executeQuery();
            if (result.next()){
                department=turnToDepartment(result);
            }
            connection.commit();
            System.out.println("GetOne succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return department;
    }

    @Override
    public List<Department> getAll() {
        List <Department> departmentList=new ArrayList<>();
        try {
            connectToDB();
            statement=connection.prepareStatement(GETALL);
            result= statement.executeQuery();
            while (result.next()){
                departmentList.add(turnToDepartment(result));
            }
            connection.commit();
            System.out.println("GetAll succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return departmentList;
    }

    @Override
    public void insert(Department department) {
        try {
            connectToDB();
            statement=connection.prepareStatement(INSERT);
            statement.setString(1, department.getDepartmentName());

            statement.executeUpdate();

            connection.commit();
            System.out.println("Insert succeed");

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            disconnectToDB();
        }
    }

    @Override
    public void update(Department department, Integer id) {
        try {
            connectToDB();
            statement=connection.prepareStatement(UPDATE);
            statement.setString(1, department.getDepartmentName());
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

