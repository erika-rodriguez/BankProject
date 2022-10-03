package com.solvd.xmlMapper;

import com.solvd.Main;
import com.solvd.daoImplementation.DB_Connection;
import com.solvd.entities.Customer;

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

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerListJAXB  {
    private static final Logger logger = LogManager.getLogger(Main.class);
    static DB_Connection manager=new DB_Connection();
    @XmlElement(name = "customer")
    private List<Customer> customerList = null;

    //setter
    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    //getter
    public List<Customer> getCustomerList() {
        return customerList;
    }

    static CustomerListJAXB customers = new CustomerListJAXB();
    static {
        customers.setCustomerList(manager.getCustomerDao().getAll());
    }
    public static void marshallCustomers() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CustomerListJAXB.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(customers, new File("D:\\Documentos\\Solvd\\Task\\Bank\\src\\main\\resources\\XML/customersList.xml"));
    }

    public static void unmarshalCustomers() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CustomerListJAXB.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        CustomerListJAXB cust = (CustomerListJAXB) jaxbUnmarshaller.unmarshal( new File("D:\\Documentos\\Solvd\\Task\\Bank\\src\\main\\resources\\XML/customersList.xml"));
        for (Customer c:cust.getCustomerList()) {
            logger.info("ID_Customer: "+c.getId_customer());
            logger.info("Name: "+c.getFullName());
            logger.info("City: "+c.getCity());
            logger.info("DOB: "+c.getDateOfBirth());
            logger.info("Mail: "+c.getMail());
        }
    }

}


