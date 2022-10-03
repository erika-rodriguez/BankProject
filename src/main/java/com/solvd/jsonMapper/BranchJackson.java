package com.solvd.jsonMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.daoImplementation.DB_Connection;
import com.solvd.entities.Branch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BranchJackson {
    private static final Logger logger = LogManager.getLogger(BranchJackson.class);
    private static final File file = new File("D:\\Documentos\\Solvd\\Task\\Bank\\src\\main\\resources\\JSON\\Branch.json");
    static DB_Connection manager=new DB_Connection();
    List<Branch> branchList = new ArrayList<>();

    public BranchJackson() {
        this.branchList = manager.getBranchDao().getAll();
    }

    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }

    static BranchJackson branchJackson= new BranchJackson();

            public static void marshalBranch()  {
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    objectMapper.writeValue(file, branchJackson.getBranchList());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public static void unmarshalBranch() {
                ObjectMapper objectMapper = new ObjectMapper();
                //List<Branch> brList = objectMapper.readValue(file,new TypeReference< List<Branch>>() {});
                List<Branch> brList = null;
                try {
                    brList = objectMapper.readValue(file,objectMapper.getTypeFactory().constructCollectionType(List.class, Branch.class));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                for (Branch b:brList) {
                    logger.info("ID_Branch: "+b.getId_branch());
                    logger.info("City: "+b.getCity());
                }
            }
}
