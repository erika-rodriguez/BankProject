package com.solvd;


import com.solvd.daoImplementation.DB_Connection;
import com.solvd.myBatis.connection.ConnectionFactory;
import com.solvd.myBatis.mapper.IAccountMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;

import java.io.IOException;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws JAXBException, IOException {
        DB_Connection manager=new DB_Connection();

        //MyBatis
        SqlSession session= new ConnectionFactory().buildConnection();
        System.out.println(session.getMapper(IAccountMapper.class).getAccountById(50001));

        //Marshal/Unmarshal Departments JACKSON
        //marshalDepartments();
        //unmarshalDepartments();

        //Marshal/Unmarshal Account JACKSON
        //marshalAccount();
        //unmarshalAccount();

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