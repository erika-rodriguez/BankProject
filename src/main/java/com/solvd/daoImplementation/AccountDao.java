package  com.solvd.daoImplementation;

import  com.solvd.daoInterfaces.IAccountDAO;
import  com.solvd.entities.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao extends DB_Connection implements IAccountDAO {
    final String INSERT="INSERT INTO account (customer_id, branch_id, account_status_id,opening_date, balance) VALUES (?,?,?,?,?)";
    final String UPDATE="UPDATE account SET customer_id=?, branch_id=?, account_status_id=?,opening_date=?,balance=? WHERE id_account=?";
    final String DELETE="DELETE FROM account WHERE id_account=?";
    final String GETALL="SELECT * FROM account";
    final String GETONE="SELECT * FROM account WHERE id_account=?";
    public AccountDao(Connection connection) {
    }
    public Account turnToAccount(ResultSet rs) throws SQLException {
        Integer customerId= rs.getInt("customer_id");
        Integer branchId= rs.getInt("branch_id");
        Integer accountStatusId= rs.getInt("account_status_id");
        Date openingDate=rs.getDate("opening_date");
        Integer balance= rs.getInt("balance");

        Account account=new Account(customerId,branchId,accountStatusId,openingDate,balance);
        account.setId_account(rs.getInt("id_account"));
        return account;
    }
    @Override
    public Account getOne(Integer id) {
        Account account=null;
        try {
            connectToDB();
            statement=connection.prepareStatement(GETONE);
            statement.setInt(1,id);
            result= statement.executeQuery();
            if (result.next()){
                account=turnToAccount(result);
            }
            connection.commit();
            System.out.println("GetOne succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return account;
    }

    @Override
    public List<Account> getAll() {
        List <Account> accountList=new ArrayList<>();
        try {
            connectToDB();
            statement=connection.prepareStatement(GETALL);
            result= statement.executeQuery();
            while (result.next()){
                accountList.add(turnToAccount(result));
            }
            connection.commit();
            System.out.println("GetAll succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return accountList;
    }

    @Override
    public void insert(Account account) {
        try {
            connectToDB();
            statement=connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, account.getCustomerId());
            statement.setInt(2, account.getBranchId());
            statement.setInt(3, account.getAccountStatusId());
            statement.setDate(4, account.getOpeningDate());
            statement.setInt(5, account.getBalance());

            statement.executeUpdate();

            connection.commit();
            System.out.println("Insert succeed");
            ResultSet result=statement.getGeneratedKeys();
            if (result.next()){
                account.setId_account(result.getInt(1));//set the id from result mysql into the java object, bc it is AI
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            disconnectToDB();
        }
    }

    @Override
    public void update(Account account, Integer id) {
        try {
            connectToDB();
            statement=connection.prepareStatement(UPDATE);
            statement.setInt(1, account.getCustomerId());
            statement.setInt(2, account.getBranchId());
            statement.setInt(3, account.getAccountStatusId());
            statement.setDate(4, account.getOpeningDate());
            statement.setInt(5, account.getBalance());
            statement.setInt(6, id);

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
