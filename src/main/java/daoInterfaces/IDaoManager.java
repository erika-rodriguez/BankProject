package daoInterfaces;

public interface IDaoManager {
    IAccountDAO getAccountDao();
    IAccountStatusDAO getAccountStatusDao();
    IBranchDAO getBranchDao();
    ICustomerDAO getCustomerDao();
    IDepartmentDAO getDepartmentDao();
    IEmployeeDAO getEmployeeDao();
    ILoanDAO getLoanDao();
    ISalaryDAO getSalaryDao();
    ITransactionDAO getTransactionDao();
    ITransactionTypeDAO getTransactionTypeDao();
    IUserDAO getUserDao();
}
