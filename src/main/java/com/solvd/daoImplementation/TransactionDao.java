package  com.solvd.daoImplementation;

import  com.solvd.daoInterfaces.ITransactionDAO;
import  com.solvd.entities.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TransactionDao extends DB_Connection implements ITransactionDAO {
    final String INSERT="INSERT INTO transaction (account_id, transaction_type_id, date_of_transaction, amount) VALUES (?,?,?,?)";
    final String UPDATE="UPDATE transaction SET account_id=?,transaction_type_id=?,date_of_transaction=?,amount=? WHERE id_transaction=?";
    final String DELETE="DELETE FROM transaction WHERE id_transaction=?";
    final String GETALL="SELECT * FROM transaction";
    final String GETONE="SELECT * FROM transaction WHERE id_transaction=?";
    public TransactionDao(Connection connection) {
    }
    public Transaction turnToTransaction(ResultSet rs) throws SQLException {
        Integer accountId= rs.getInt("account_id");
        Integer transactionTypeId= rs.getInt("transaction_type_id");
        Date transactionDate= rs.getDate("date_of_transaction");
        Integer amount= rs.getInt("amount");
        Transaction transaction=new Transaction(accountId,transactionTypeId,transactionDate,amount);
        transaction.setId_transaction(rs.getInt("id_transaction"));
        return transaction;
    }
    @Override
    public Transaction getOne(Integer id) {
        Transaction transaction=null;
        try {
            connectToDB();
            statement=connection.prepareStatement(GETONE);
            statement.setInt(1,id);
            result= statement.executeQuery();
            if (result.next()){
                transaction=turnToTransaction(result);
            }
            connection.commit();
            System.out.println("GetOne succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return transaction;
    }

    @Override
    public List<Transaction> getAll() {
        List <Transaction> transactionList=new ArrayList<>();
        try {
            connectToDB();
            statement=connection.prepareStatement(GETALL);
            result= statement.executeQuery();
            while (result.next()){
                transactionList.add(turnToTransaction(result));
            }
            connection.commit();
            System.out.println("GetAll succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return transactionList;
    }

    @Override
    public void insert(Transaction transaction) {
        try {
            connectToDB();
            statement=connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,transaction.getAccountId());
            statement.setInt(2,transaction.getTransactionTypeId());
            statement.setDate(3,transaction.getTransactionDate());
            statement.setInt(4,transaction.getAmount());
            statement.executeUpdate();

            connection.commit();
            System.out.println("Insert succeed");
            ResultSet result=statement.getGeneratedKeys();
            if (result.next()){
                transaction.setId_transaction(result.getInt(1));//set the id from result mysql into the java object, bc it is AI
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            disconnectToDB();
        }
    }

    @Override
    public void update(Transaction transaction, Integer id) {
        try {
            connectToDB();
            statement=connection.prepareStatement(UPDATE);
            statement.setInt(1,transaction.getAccountId());
            statement.setInt(2,transaction.getTransactionTypeId());
            statement.setDate(3,transaction.getTransactionDate());
            statement.setInt(4,transaction.getAmount());
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
