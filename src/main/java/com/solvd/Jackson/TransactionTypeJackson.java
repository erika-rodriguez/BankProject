package com.solvd.Jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.daoImplementation.DB_Connection;
import com.solvd.entities.TransactionType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionTypeJackson {
    private static final Logger logger = LogManager.getLogger(TransactionTypeJackson.class);
    private static final File file = new File("D:\\Documentos\\Solvd\\Task\\Bank\\src\\main\\resources\\JSON\\TransactionType.json");
    static DB_Connection manager=new DB_Connection();
    List<TransactionType> transactionTypeList = new ArrayList<>();

    public TransactionTypeJackson(){
        this.transactionTypeList = manager.getTransactionTypeDao().getAll();
    }

    public List<TransactionType> getTransactionTypeList() {
        return transactionTypeList;
    }

    public void setTransactionTypeList(List<TransactionType> transactionTypeList) {
        this.transactionTypeList = transactionTypeList;
    }

    static TransactionTypeJackson transactionTypeJackson=new TransactionTypeJackson();

        public static void marshalTransactionType()  {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                objectMapper.writeValue(file, transactionTypeJackson.getTransactionTypeList());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static void unmarshalTransactionType() {
            ObjectMapper objectMapper = new ObjectMapper();
            //List<TransactionType> ttypeList = objectMapper.readValue(file,new TypeReference< List<TransactionType>>() {});
            List<TransactionType> ttypeList = null;
            try {
                ttypeList = objectMapper.readValue(file,objectMapper.getTypeFactory().constructCollectionType(List.class, TransactionType.class));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            for (TransactionType t:ttypeList) {
                logger.info("ID_transactionType: "+t.getId_transactionType());
                logger.info("Transaction: "+t.getTransactionName());
            }
        }
}
