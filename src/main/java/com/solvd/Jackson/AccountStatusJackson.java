package com.solvd.Jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.daoImplementation.DB_Connection;
import com.solvd.entity.AccountStatus;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountStatusJackson {
    private static final Logger logger = LogManager.getLogger(AccountStatusJackson.class);
    private static final File file = new File("D:\\Documentos\\Solvd\\Task\\Bank\\src\\main\\resources\\JSON\\AccountStatus.json");
    static DB_Connection manager=new DB_Connection();
    List<AccountStatus> accountStatusList = new ArrayList<>();

    public AccountStatusJackson() {
        this.accountStatusList = manager.getAccountStatusDao().getAll();
    }

    public List<AccountStatus> getAccountStatusList() {
        return accountStatusList;
    }

    public void setAccountStatusList(List<AccountStatus> accountStatusList) {
        this.accountStatusList = accountStatusList;
    }

    static AccountStatusJackson accountStatusJackson=new AccountStatusJackson();

    public static void marshalAccountStatus()  {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file, accountStatusJackson.getAccountStatusList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void unmarshalAccountStatus() {
        ObjectMapper objectMapper = new ObjectMapper();
        //List<AccountStatus> accstList = objectMapper.readValue(file,new TypeReference< List<AccountStatus>>() {});
        List<AccountStatus> accstList = null;
        try {
            accstList = objectMapper.readValue(file,objectMapper.getTypeFactory().constructCollectionType(List.class, AccountStatus.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (AccountStatus a:accstList) {
            logger.info("ID_accountStatus: "+a.getId_accountStatus());
            logger.info("Status: "+a.getStatus());
        }
    }
}
