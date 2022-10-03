package com.solvd.serviceMyBatis;

import com.solvd.myBatisMapper.connection.ConnectionFactory;
import com.solvd.myBatisMapper.mapper.IAccountMapper;
import org.apache.ibatis.session.SqlSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class AccountServiceMyBatis {
    private static final Logger logger = LogManager.getLogger(AccountServiceMyBatis.class);
    //SqlSession session= new ConnectionFactory().buildConnection();


    public void getAccountById(){
        logger.info("Insert the account number:");
        Scanner sc=new Scanner(System.in);
        int search=sc.nextInt();
        Class myClass=IAccountMapper.class;
        try (SqlSession session= new ConnectionFactory().buildConnection(myClass)){
            logger.info(session.getMapper(IAccountMapper.class).getOne(search));
        }
    }

}
