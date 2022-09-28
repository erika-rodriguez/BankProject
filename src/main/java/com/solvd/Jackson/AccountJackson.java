package com.solvd.Jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.daoImplementation.DB_Connection;
import com.solvd.entity.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountJackson {
    private static final Logger logger = LogManager.getLogger(BranchJackson.class);
    private static final File file = new File("D:\\Documentos\\Solvd\\Task\\Bank\\src\\main\\resources\\JSON\\Account.json");
    static DB_Connection manager=new DB_Connection();
    List<Account> accountList = new ArrayList<>();

    public AccountJackson() {
        this.accountList = manager.getAccountDao().getAll();
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
    static AccountJackson accountJackson= new AccountJackson();

            public static void marshalAccount()  {
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    objectMapper.writeValue(file, accountJackson.getAccountList());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public static void unmarshalAccount() {
                ObjectMapper objectMapper = new ObjectMapper();
                //List<Account> accList = objectMapper.readValue(file,new TypeReference< List<Account>>() {});
                List<Account> accList = null;
                try {
                    accList = objectMapper.readValue(file,objectMapper.getTypeFactory().constructCollectionType(List.class, Account.class));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                for (Account a:accList) {
                    logger.info("ID_Account: "+a.getId_account());
                    logger.info("CustomerId: "+a.getCustomerId());
                    logger.info("BranchId: "+a.getBranchId());
                    logger.info("AccountStatusId: "+a.getAccountStatusId());
                    logger.info("OpeningDate: "+a.getOpeningDate());
                    logger.info("Balance: "+a.getBalance());
                }
            }

}
