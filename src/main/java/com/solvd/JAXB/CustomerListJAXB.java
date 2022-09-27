package com.solvd.JAXB;

import com.solvd.daoImplementation.DB_Connection;
import com.solvd.entity.Customer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerListJAXB  {
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

}


