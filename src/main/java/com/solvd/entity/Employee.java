package  com.solvd.entity;

import java.sql.Date;

public class Employee {
    private Integer id_employee;
    private Integer departmentId;
    private String fullName;
    private Date birth_date;
    private Date hire_date;

    public Employee(Integer departmentId, String fullName, Date birth_date, Date hire_date) {
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

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id_employee=" + id_employee +
                ", departmentId=" + departmentId +
                ", fullName='" + fullName + '\'' +
                ", birth_date=" + birth_date +
                ", hire_date=" + hire_date +
                '}';
    }
}
