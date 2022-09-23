package  com.solvd.entity;

public class Department {
    private Integer id_department;
    private String departmentName;

    public Department(String departmentName) {
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
