package  com.solvd.daoImplementation;

import  com.solvd.daoInterfaces.ILoanDAO;
import  com.solvd.entity.Loan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoanDao extends DB_Connection implements ILoanDAO {
    final String INSERT="INSERT INTO loan (customer_id, branch_id, amount) VALUES (?,?,?)";
    final String UPDATE="UPDATE loan SET customer_id=?,branch_id=?,amount=? WHERE id_loan=?";
    final String DELETE="DELETE FROM loan WHERE id_loan=?";
    final String GETALL="SELECT * FROM loan";
    final String GETONE="SELECT * FROM loan WHERE id_loan=?";
    public LoanDao(Connection connection) {
    }
    public Loan turnToLoan(ResultSet rs) throws SQLException {
        Integer customerId= rs.getInt("customer_id");
        Integer branchId= rs.getInt("branch_id");
        Integer amount= rs.getInt("amount");
        Loan loan=new Loan(customerId,branchId,amount);
        loan.setId_loan(rs.getInt("id_loan"));
        return loan;
    }
    @Override
    public Loan getOne(Integer id) {
        Loan loan=null;
        try {
            connectToDB();
            statement=connection.prepareStatement(GETONE);
            statement.setInt(1,id);
            result= statement.executeQuery();
            if (result.next()){
                loan=turnToLoan(result);
            }
            connection.commit();
            System.out.println("GetOne succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return loan;
    }

    @Override
    public List<Loan> getAll() {
        List <Loan> loanList=new ArrayList<>();
        try {
            connectToDB();
            statement=connection.prepareStatement(GETALL);
            result= statement.executeQuery();
            while (result.next()){
                loanList.add(turnToLoan(result));
            }
            connection.commit();
            System.out.println("GetAll succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return loanList;
    }

    @Override
    public void insert(Loan loan) {
        try {
            connectToDB();
            statement=connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,loan.getCustomerId());
            statement.setInt(2,loan.getBranchId());
            statement.setInt(3,loan.getAmount());
            statement.executeUpdate();

            connection.commit();
            System.out.println("Insert succeed");
            ResultSet result=statement.getGeneratedKeys();
            if (result.next()){
                loan.setId_loan(result.getInt(1));//set the id from result mysql into the java object, bc it is AI
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            disconnectToDB();
        }
    }

    @Override
    public void update(Loan loan, Integer id) {
        try {
            connectToDB();
            statement=connection.prepareStatement(UPDATE);
            statement.setInt(1,loan.getCustomerId());
            statement.setInt(2,loan.getBranchId());
            statement.setInt(3,loan.getAmount());
            statement.setInt(4, id);

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
