package entity;

public class Branch {
    private Integer id_branch;
    private String city;

    public Branch(String city) {
        this.city = city;
    }

    public Integer getId_branch() {
        return id_branch;
    }

    public void setId_branch(Integer id_branch) {
        this.id_branch = id_branch;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id_branch=" + id_branch +
                ", city='" + city + '\'' +
                '}';
    }
}
