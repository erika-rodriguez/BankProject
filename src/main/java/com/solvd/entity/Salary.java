package  com.solvd.entity;

public class Salary {
    private Integer id_employee;
    private int amount;

    public Salary(Integer id_employee, int amount) {
        this.id_employee = id_employee;
        this.amount = amount;
    }

    public Integer getId_employee() {
        return id_employee;
    }

    public void setId_employee(Integer id_employee) {
        this.id_employee = id_employee;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id_employee=" + id_employee +
                ", amount=" + amount +
                '}';
    }
}
