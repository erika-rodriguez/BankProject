package daoImplementation;

import daoInterfaces.IUserDAO;
import entity.Loan;
import entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDao extends DB_Connection implements IUserDAO {
    final String INSERT="INSERT INTO user (user_name, password) VALUES (?,?)";
    final String UPDATE="UPDATE user SET user_name=?,password=? WHERE iduser=?";
    final String DELETE="DELETE FROM user WHERE iduser=?";
    final String GETALL="SELECT * FROM user";
    final String GETONE="SELECT * FROM user WHERE iduser=?";
    public UserDao(Connection connection) {
    }
    public User turnToUser(ResultSet rs) throws SQLException {
        String userName= rs.getString("user_name");
        String password= rs.getString("password");
        User user=new User(userName,password);
        user.setId_user(rs.getInt("iduser"));
        return user;
    }
    @Override
    public User getOne(Integer id) {
        User user=null;
        try {
            connectToDB();
            statement=connection.prepareStatement(GETONE);
            statement.setInt(1,id);
            result= statement.executeQuery();
            if (result.next()){
                user=turnToUser(result);
            }
            connection.commit();
            System.out.println("GetOne succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List <User> userList=new ArrayList<>();
        try {
            connectToDB();
            statement=connection.prepareStatement(GETALL);
            result= statement.executeQuery();
            while (result.next()){
                userList.add(turnToUser(result));
            }
            connection.commit();
            System.out.println("GetAll succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return userList;
    }

    @Override
    public void insert(User user) {
        try {
            connectToDB();
            statement=connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,user.getUserName());
            statement.setString(2,user.getPassword());
            statement.executeUpdate();

            connection.commit();
            System.out.println("Insert succeed");
            ResultSet result=statement.getGeneratedKeys();
            if (result.next()){
                user.setId_user(result.getInt(1));//set the id from result mysql into the java object, bc it is AI
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            disconnectToDB();
        }
    }

    @Override
    public void update(User user, Integer id) {
        try {
            connectToDB();
            statement=connection.prepareStatement(UPDATE);
            statement.setString(1,user.getUserName());
            statement.setString(2,user.getPassword());
            statement.setInt(3, id);

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
