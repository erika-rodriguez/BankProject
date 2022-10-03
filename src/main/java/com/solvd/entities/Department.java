package  com.solvd.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Department {
    @JsonProperty("id_department")
    private Integer id_department;
    @JsonProperty("DepartmentName")
    private String departmentName;

    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(Integer id_department, String departmentName) {
        this.id_department = id_department;
        this.departmentName = departmentName;
    }

    public Integer getId_department() {
        return id_department;
    }

    public void setId_department(Integer id_department) {
        this.id_department = id_department;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id_department=" + id_department +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
