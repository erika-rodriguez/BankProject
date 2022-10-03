package  com.solvd.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Branch {
    @JsonProperty("id_branch")
    private Integer id_branch;
    @JsonProperty("City")
    private String city;

    public Branch() {
    }

    public Branch(String city) {
        this.city = city;
    }

    public Branch(Integer id_branch, String city) {
        this.id_branch = id_branch;
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
