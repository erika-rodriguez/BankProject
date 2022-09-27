package com.solvd;


import com.solvd.daoImplementation.DB_Connection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;

import static com.solvd.JAXB.CustomerListJAXB.marshallCustomers;
import static com.solvd.JAXB.EmployeeListJAXB.marshallEmployees;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws JAXBException {
        DB_Connection manager=new DB_Connection();

//        //Marshal list of Customers
//        marshallCustomers();
//        //Marshal list of Employees
//        marshallEmployees();


//        List <Employee> employeeList=manager.getEmployeeDao().getAll();
//        List <Customer> customerList=manager.getCustomerDao().getAll();
//        logger.info(customerList);
    }

}