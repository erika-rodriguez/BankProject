package  com.solvd.daoImplementation;

import  com.solvd.daoInterfaces.IAccountStatusDAO;
import  com.solvd.entity.AccountStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountStatusDao extends DB_Connection implements IAccountStatusDAO {
    final String INSERT="INSERT INTO account_status (status) VALUES (?)";
    final String UPDATE="UPDATE account_status SET status=? WHERE id_account_status=?";
    final String DELETE="DELETE FROM account_status WHERE id_account_status=?";
    final String GETALL="SELECT * FROM account_status";
    final String GETONE="SELECT * FROM account_status WHERE id_account_status=?";
    public AccountStatusDao(Connection connection) {
    }
    public AccountStatus turnToAccountStatus(ResultSet rs) throws SQLException {
        String status= rs.getString("status");

        AccountStatus accountStatus=new AccountStatus(status);
        accountStatus.setId_accountStatus(rs.getInt("id_account_status"));
        return accountStatus;
    }
    @Override
    public AccountStatus getOne(Integer id) {
        AccountStatus accountStatus=null;
        try {
            connectToDB();
            statement=connection.prepareStatement(GETONE);
            statement.setInt(1,id);
            result= statement.executeQuery();
            if (result.next()){
                accountStatus=turnToAccountStatus(result);
            }
            connection.commit();
            System.out.println("GetOne succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return accountStatus;
    }

    @Override
    public List<AccountStatus> getAll() {
        List <AccountStatus> accountStatusList=new ArrayList<>();
        try {
            connectToDB();
            statement=connection.prepareStatement(GETALL);
            result= statement.executeQuery();
            while (result.next()){
                accountStatusList.add(turnToAccountStatus(result));
            }
            connection.commit();
            System.out.println("GetAll succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return accountStatusList;
    }

    @Override
    public void insert(AccountStatus accountStatus) {
        try {
            connectToDB();
            statement=connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,accountStatus.getStatus());

            statement.executeUpdate();

            connection.commit();
            System.out.println("Insert succeed");
            ResultSet result=statement.getGeneratedKeys();
            if (result.next()){
                accountStatus.setId_accountStatus(result.getInt(1));//set the id from result mysql into the java object, bc it is AI
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            disconnectToDB();
        }
    }

    @Override
    public void update(AccountStatus accountStatus, Integer id) {
        try {
            connectToDB();
            statement=connection.prepareStatement(UPDATE);
            statement.setString(1, accountStatus.getStatus());
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
