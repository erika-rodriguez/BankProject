package  com.solvd.daoImplementation;

import  com.solvd.daoInterfaces.ITransactionTypeDAO;
import  com.solvd.entities.TransactionType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransactionTypeDao extends DB_Connection implements ITransactionTypeDAO {
    final String INSERT="INSERT INTO transaction_type (transaction) VALUES (?)";
    final String UPDATE="UPDATE transaction_type SET transaction=? WHERE id_transaction_type=?";
    final String DELETE="DELETE FROM transaction_type WHERE id_transaction_type=?";
    final String GETALL="SELECT * FROM transaction_type";
    final String GETONE="SELECT * FROM transaction_type WHERE id_transaction_type=?";
    public TransactionTypeDao(Connection connection) {
    }
    public TransactionType turnToTransactionType(ResultSet rs) throws SQLException {
        String transaction= rs.getString("transaction");
        TransactionType transactionType=new TransactionType(transaction);
        transactionType.setId_transactionType(rs.getInt("id_transaction_type"));
        return transactionType;
    }
    @Override
    public TransactionType getOne(Integer id) {
        TransactionType transactionType=null;
        try {
            connectToDB();
            statement=connection.prepareStatement(GETONE);
            statement.setInt(1,id);
            result= statement.executeQuery();
            if (result.next()){
                transactionType=turnToTransactionType(result);
            }
            connection.commit();
            System.out.println("GetOne succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return transactionType;
    }

    @Override
    public List<TransactionType> getAll() {
        List <TransactionType> transactionTypeList=new ArrayList<>();
        try {
            connectToDB();
            statement=connection.prepareStatement(GETALL);
            result= statement.executeQuery();
            while (result.next()){
                transactionTypeList.add(turnToTransactionType(result));
            }
            connection.commit();
            System.out.println("GetAll succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return transactionTypeList;
    }

    @Override
    public void insert(TransactionType transactionType) {
        try {
            connectToDB();
            statement=connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,transactionType.getTransactionName());
            statement.executeUpdate();

            connection.commit();
            System.out.println("Insert succeed");
            ResultSet result=statement.getGeneratedKeys();
            if (result.next()){
                transactionType.setId_transactionType(result.getInt(1));//set the id from result mysql into the java object, bc it is AI
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            disconnectToDB();
        }
    }

    @Override
    public void update(TransactionType transactionType, Integer id) {
        try {
            connectToDB();
            statement=connection.prepareStatement(UPDATE);
            statement.setString(1,transactionType.getTransactionName());
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
