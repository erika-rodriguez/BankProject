package com.solvd.JAXB;

import com.solvd.Main;
import com.solvd.daoImplementation.DB_Connection;
import com.solvd.entity.Employee;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeListJAXB {
    private static final Logger logger = LogManager.getLogger(Main.class);
    static DB_Connection manager=new DB_Connection();
    @XmlElement(name = "employee")
    private List<Employee> employeeList = null;

    //setter
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    //getter
    public List<Employee> getEmployeeList() {
        return employeeList;
    }



    static EmployeeListJAXB employees = new EmployeeListJAXB();
    static {
        employees.setEmployeeList(manager.getEmployeeDao().getAll());
    }
    public static void marshallEmployees() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeListJAXB.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(employees, new File("D:\\Documentos\\Solvd\\Task\\Bank\\src\\main\\resources\\XML/employeesList.xml"));
    }

    public static void unmarshalEmployees() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeListJAXB.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        EmployeeListJAXB emps = (EmployeeListJAXB) jaxbUnmarshaller.unmarshal( new File("D:\\Documentos\\Solvd\\Task\\Bank\\src\\main\\resources\\XML/employeesList.xml"));
        for (Employee e:emps.getEmployeeList()) {
            logger.info("ID_Employee: "+e.getId_employee());
            logger.info("Name: "+e.getFullName());
            logger.info("Department_ID: "+e.getDepartmentId());
            logger.info("DOB: "+e.getBirth_date());
            logger.info("HireDate: "+e.getHire_date());
        }
    }


}
