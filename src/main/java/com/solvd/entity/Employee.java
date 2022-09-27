package  com.solvd.entity;

import com.solvd.JAXB.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlRootElement(name = "employee")
@XmlAccessorType (XmlAccessType.FIELD)

public class Employee {
    @XmlAttribute
    private Integer id_employee;
    private Integer user_id;
    @XmlElement(name = "DepartmentID")
    private Integer departmentId;
    @XmlElement(name = "Name")
    private String fullName;
    @XmlElement(name = "DOB")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private LocalDate birth_date;
    @XmlElement(name = "HireDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private LocalDate hire_date;

    public Employee() {
    }

    public Employee(Integer departmentId, String fullName, LocalDate birth_date, LocalDate hire_date) {
        this.departmentId = departmentId;
        this.fullName = fullName;
        this.birth_date = birth_date;
        this.hire_date = hire_date;
    }

    public Integer getId_employee() {
        return id_employee;
    }

    public void setId_employee(Integer id_employee) {
        this.id_employee = id_employee;
    }
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public LocalDate getHire_date() {
        return hire_date;
    }

    public void setHire_date(LocalDate hire_date) {
        this.hire_date = hire_date;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id_employee=" + id_employee +
                ", user_id=" + user_id +
                ", departmentId=" + departmentId +
                ", fullName='" + fullName + '\'' +
                ", birth_date=" + birth_date +
                ", hire_date=" + hire_date +
                '}';
    }


}
