package com.solvd.myBatisMapper.serviceMyBatis;

import com.solvd.entities.Account;
import com.solvd.myBatisMapper.connection.ConnectionFactory;
import com.solvd.myBatisMapper.mapper.IAccountMapper;
import org.apache.ibatis.session.SqlSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AccountServiceMyBatis {
    private static final Logger logger = LogManager.getLogger(AccountServiceMyBatis.class);
    private final Class myClass=IAccountMapper.class;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    //SqlSession session= new ConnectionFactory().buildConnection();


    public void getAccountById() throws IOException {
        logger.info("Insert the account number:");
        Scanner sc=new Scanner(System.in);
        int search=sc.nextInt();
        try (SqlSession session= new ConnectionFactory().buildSqlSessionFactory(myClass)){
            logger.info(session.getMapper(IAccountMapper.class).getOne(search));
        }
    }

    public void getAllAccounts() throws IOException {
        try (SqlSession session= new ConnectionFactory().buildSqlSessionFactory(myClass)){
            logger.info(session.getMapper(IAccountMapper.class).getAll());
        }
    }

    public void insertAccount() throws ParseException, IOException {
//        logger.info("Insert the account_customerID:");
//        Scanner sc=new Scanner(System.in);
//        int account_customerID=sc.nextInt();
//        logger.info("Insert the BranchId:");
//        int branchID=sc.nextInt();
//        logger.info("Insert the AccountStatusId:");
//        int accStatusID=sc.nextInt();
//        logger.info("Insert the Opening Date yyyy-MM-dd:");
//        LocalDate openingDate= LocalDate.parse(sc.next(),formatter);
//        logger.info("Insert the balance:");
//        int balance=sc.nextInt();

//        Account account=new Account(account_customerID,branchID,accStatusID,openingDate,balance);
        Account account=new Account(10,2,1, LocalDate.parse("2000-05-01"), 9500);
        try (SqlSession session= new ConnectionFactory().buildSqlSessionFactory(myClass)){
//            session.insert("Account.insert",account);
//            session.commit();

            session.getMapper(IAccountMapper.class).insert(account);
        }
    }

}
