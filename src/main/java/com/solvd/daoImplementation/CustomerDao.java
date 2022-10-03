package  com.solvd.daoImplementation;

import  com.solvd.daoInterfaces.ICustomerDAO;
import  com.solvd.entities.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao extends DB_Connection implements ICustomerDAO {
    final String INSERT="INSERT INTO customer (full_name, city, date_of_birth,mail) VALUES (?,?,?,?)";
    final String UPDATE="UPDATE customer SET full_name=?, city=?, date_of_birth=?,mail=? WHERE id_customer=?";
    final String DELETE="DELETE FROM customer WHERE id_customer=?";
    final String GETALL="SELECT * FROM customer";
    final String GETONE="SELECT * FROM customer WHERE id_customer=?";

    public CustomerDao(Connection connection) {
        super();
    }
    public Customer turnToCustomer(ResultSet rs) throws SQLException {
        String fullName= rs.getString("full_name");
        String city= rs.getString("city");
        LocalDate dob=rs.getDate("date_of_birth").toLocalDate();
        String mail= rs.getString("mail");
        Customer customer=new Customer(fullName,city,dob,mail);
        customer.setId_customer(rs.getInt("id_customer"));
        return customer;
    }

    @Override
    public Customer getOne(Integer id) {
        Customer customer=null;
        try {
            connectToDB();
            statement=connection.prepareStatement(GETONE);
            statement.setInt(1,id);
            result= statement.executeQuery();
            if (result.next()){
                customer=turnToCustomer(result);
            }
            connection.commit();
            System.out.println("GetOne succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        List <Customer> customerList=new ArrayList<>();
        try {
            connectToDB();
            statement=connection.prepareStatement(GETALL);
            result= statement.executeQuery();
            while (result.next()){
                customerList.add(turnToCustomer(result));
            }
            connection.commit();
            System.out.println("GetAll succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return customerList;
    }

    @Override
    public void insert(Customer customer) {
        try {
            connectToDB();
            statement=connection.prepareStatement(INSERT);
            statement.setString(1, customer.getFullName());
            statement.setString(2, customer.getCity());
            statement.setDate(3, Date.valueOf(customer.getDateOfBirth()));
            statement.setString(4, customer.getMail());

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
    public void update(Customer customer,Integer id) {
        try {
            connectToDB();
            statement=connection.prepareStatement(UPDATE);
            statement.setString(1, customer.getFullName());
            statement.setString(2, customer.getCity());
            statement.setDate(3, Date.valueOf(customer.getDateOfBirth()));
            statement.setString(4, customer.getMail());
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
