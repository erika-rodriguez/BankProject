package com.solvd.myBatisMapper.serviceMyBatis;

import com.solvd.entities.AccountStatus;
import com.solvd.myBatisMapper.connection.ConnectionFactory;
import com.solvd.myBatisMapper.mapper.IAccountMapper;
import com.solvd.myBatisMapper.mapper.IAccountStatusMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class AccountStatusServiceMyBatis {
    private static final Logger logger = LogManager.getLogger(AccountStatusServiceMyBatis.class);
    private final Class myClass= IAccountStatusMapper.class;

    public void getOneAccountStatus() throws IOException {
        logger.info("Insert the accountStatus id:");
        Scanner sc=new Scanner(System.in);
        int search=sc.nextInt();
        try (SqlSession session= new ConnectionFactory().buildSqlSessionFactory(myClass)){
            logger.info(session.getMapper(IAccountStatusMapper.class).getOne(search));
        }
    }

    public void getAllAccountStatus() throws IOException {//works
        try (SqlSession session= new ConnectionFactory().buildSqlSessionFactory(myClass)){
            logger.info(session.getMapper(IAccountStatusMapper.class).getAll());
        }
    }

    public void insertAccountStatus(AccountStatus as) throws IOException {//works
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //session.getConfiguration().addMapper(IAccountStatusMapper.class);
            IAccountStatusMapper mapper = session.getMapper(IAccountStatusMapper.class);
            mapper.insert(as);
            session.commit();
        }
    }

    public void updateAccountStatus (Integer id,String newStatus) throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //session.getConfiguration().addMapper(IAccountStatusMapper.class);
            IAccountStatusMapper mapper = session.getMapper(IAccountStatusMapper.class);
            AccountStatus modifiedAccountStatus=mapper.getOne(id);
            System.out.println(modifiedAccountStatus.toString());
            modifiedAccountStatus.setStatus(newStatus);
            mapper.update(modifiedAccountStatus);
            session.commit();
        }
    }

    public void deleteAccountStatus(Integer id) throws IOException {//works
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //session.getConfiguration().addMapper(IAccountStatusMapper.class);
            IAccountStatusMapper mapper = session.getMapper(IAccountStatusMapper.class);
            mapper.delete(id);
            session.commit();
        }
    }

}
