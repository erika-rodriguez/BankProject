package com.solvd.Jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.daoImplementation.DB_Connection;
import com.solvd.entities.Department;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentJackson {
    private static final Logger logger = LogManager.getLogger(DepartmentJackson.class);
    static DB_Connection manager=new DB_Connection();
    private static final File file = new File("D:\\Documentos\\Solvd\\Task\\Bank\\src\\main\\resources\\JSON\\Department.json");
    static List<Department> departmentList = new ArrayList<>();

    public DepartmentJackson() {
        this.departmentList = manager.getDepartmentDao().getAll();
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
    static DepartmentJackson deptJackson=new DepartmentJackson();

    public static void marshalDepartments()  {
        //deptJackson.setDepartmentList(manager.getDepartmentDao().getAll());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file, deptJackson.getDepartmentList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void unmarshalDepartments() throws IOException {
        //deptJackson.setDepartmentList(manager.getDepartmentDao().getAll());

        ObjectMapper objectMapper = new ObjectMapper();
        //List<Department> deptList = objectMapper.readValue(file,new TypeReference<List<Department>>() {});
        List<Department> deptList = objectMapper.readValue(file,objectMapper.getTypeFactory().constructCollectionType(List.class, Department.class));

        for (Department d:deptList) {
            logger.info("ID_Department: "+d.getId_department());
            logger.info("DepartmentName: "+d.getDepartmentName());
        }
    }

}
