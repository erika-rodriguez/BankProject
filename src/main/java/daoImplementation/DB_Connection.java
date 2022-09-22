package daoImplementation;

import daoInterfaces.*;

import java.sql.*;

public class DB_Connection implements IDaoManager {
    protected Connection connection=null;
    protected ResultSet result=null;
    protected PreparedStatement statement=null;

    private final String USER="root";
    private final String PASSWORD="root";
    private final String DATABASE="bank";
    private final String DRIVER="com.mysql.jdbc.Driver";

    public void connectToDB(){
        try {
            String urlDB = "jdbc:mysql://localhost:3306/"+DATABASE;

            connection = DriverManager.getConnection(urlDB, USER, PASSWORD);
            connection.setAutoCommit(false);
            System.out.println("I'm in");

        } catch (SQLException ex) {
            connection = null;
            ex.printStackTrace();
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }
    }
    public void disconnectToDB(){
        try{
            if (connection!=null){
                connection.close();
            }
            if (result!=null){
                result.close();
            }
            if (statement!=null){
                statement.close();
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private IAccountDAO iaDao=null;
    private IAccountStatusDAO iasDao=null;
    private IBranchDAO ibDao=null;
    private ICustomerDAO icDao=null;
    private IDepartmentDAO idDao=null;
    private IEmployeeDAO ieDao=null;
    private ILoanDAO ilDao=null;
    private ISalaryDAO isDao=null;
    private ITransactionDAO itDao=null;
    private ITransactionTypeDAO ittDao=null;
    private IUserDAO iuDao=null;
    @Override
    public IAccountDAO getAccountDao() {
        if (iaDao==null){
            iaDao=new AccountDao(connection);
        }
        return iaDao;
    }

    @Override
    public IAccountStatusDAO getAccountStatusDao() {
        if (iasDao==null){
            iasDao=new AccountStatusDao(connection);
        }
        return iasDao;
    }

    @Override
    public IBranchDAO getBranchDao() {
        if (ibDao==null){
            ibDao=new BranchDao(connection);
        }
        return ibDao;
    }

    @Override
    public ICustomerDAO getCustomerDao() {
        if (icDao==null){
            icDao=new CustomerDao(connection);
        }
        return icDao;
    }

    @Override
    public IDepartmentDAO getDepartmentDao() {
        if (idDao==null){
            idDao=new DepartmentDao(connection);
        }
        return idDao;
    }

    @Override
    public IEmployeeDAO getEmployeeDao() {
        if (ieDao==null){
            ieDao=new EmployeeDao(connection);
        }
        return ieDao;
    }

    @Override
    public ILoanDAO getLoanDao() {
        if (ilDao==null){
            ilDao=new LoanDao(connection);
        }
        return ilDao;
    }

    @Override
    public ISalaryDAO getSalaryDao() {
        if (isDao==null){
            isDao=new SalaryDao(connection);
        }
        return isDao;
    }

    @Override
    public ITransactionDAO getTransactionDao() {
        if (itDao==null){
            itDao=new TransactionDao(connection);
        }
        return itDao;
    }

    @Override
    public ITransactionTypeDAO getTransactionTypeDao() {
        if (ittDao==null){
            ittDao=new TransactionTypeDao(connection);
        }
        return ittDao;
    }

    @Override
    public IUserDAO getUserDao() {
        if (iuDao==null){
            iuDao=new UserDao(connection);
        }
        return iuDao;
    }
}
