package  com.solvd.entities;

import com.solvd.JAXB.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)

public class Customer {
    @XmlAttribute
    private Integer id_customer;
    private Integer user_id;
    @XmlElement(name = "Name")
    private String fullName;
    @XmlElement(name = "City")
    private String city;
    @XmlElement(name = "DOB")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private LocalDate dateOfBirth;
    @XmlElement(name = "Mail")
    private String mail;

    public Customer() {
    }

    public Customer(String fullName, String city, LocalDate dateOfBirth, String mail) {
        this.fullName = fullName;
        this.city = city;
        this.dateOfBirth = dateOfBirth;
        this.mail = mail;
    }

    public Integer getId_customer() {
        return id_customer;
    }

    public void setId_customer(Integer id_customer) {
        this.id_customer = id_customer;
    }
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id_customer=" + id_customer +
                ", user_id=" + user_id +
                ", fullName='" + fullName + '\'' +
                ", city='" + city + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", mail='" + mail + '\'' +
                '}';
    }
}
