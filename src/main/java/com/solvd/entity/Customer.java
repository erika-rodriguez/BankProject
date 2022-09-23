package  com.solvd.entity;

import java.sql.Date;

public class Customer {
    private Integer id_customer;
    private String fullName;
    private String city;
    private Date dateOfBirth;
    private String mail;

    public Customer(String fullName, String city, Date dateOfBirth, String mail) {
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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
                ", fullName='" + fullName + '\'' +
                ", city='" + city + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", mail='" + mail + '\'' +
                '}';
    }
}
