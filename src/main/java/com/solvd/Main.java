package com.solvd;


import com.solvd.daoImplementation.DB_Connection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;

import java.io.IOException;

import static com.solvd.JAXB.CustomerListJAXB.marshallCustomers;
import static com.solvd.JAXB.CustomerListJAXB.unmarshalCustomers;
import static com.solvd.JAXB.EmployeeListJAXB.marshallEmployees;
import static com.solvd.JAXB.EmployeeListJAXB.unmarshalEmployees;
import static com.solvd.Jackson.AccountJackson.marshalAccount;
import static com.solvd.Jackson.AccountJackson.unmarshalAccount;
import static com.solvd.Jackson.AccountStatusJackson.marshalAccountStatus;
import static com.solvd.Jackson.AccountStatusJackson.unmarshalAccountStatus;
import static com.solvd.Jackson.BranchJackson.marshalBranch;
import static com.solvd.Jackson.BranchJackson.unmarshalBranch;
import static com.solvd.Jackson.DepartmentJackson.marshalDepartments;
import static com.solvd.Jackson.DepartmentJackson.unmarshalDepartments;
import static com.solvd.Jackson.TransactionTypeJackson.marshalTransactionType;
import static com.solvd.Jackson.TransactionTypeJackson.unmarshalTransactionType;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws JAXBException, IOException {
        DB_Connection manager=new DB_Connection();

        //Marshal/Unmarshal Departments JACKSON
        //marshalDepartments();
        //unmarshalDepartments();

        //Marshal/Unmarshal Account JACKSON
        //marshalAccount();
        unmarshalAccount();

        //Marshal/Unmarshal AccountStatus JACKSON
        //marshalAccountStatus();
        //unmarshalAccountStatus();

        //Marshal/Unmarshal TransactionType JACKSON
        //marshalTransactionType();
        //unmarshalTransactionType();

        //Marshal/Unmarshal Branch JACKSON
        //marshalBranch();
        //unmarshalBranch();


//        //Marshal/Unmarshal list of Customers JAXB
//        marshallCustomers();
//        unmarshalCustomers();
//        //Marshal/Unmarshal list of Employees JAXB
//        marshallEmployees();
//        unmarshalEmployees();


//        List <Employee> employeeList=manager.getEmployeeDao().getAll();
//        List <Customer> customerList=manager.getCustomerDao().getAll();
//        logger.info(customerList);
    }

}