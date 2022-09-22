package entity;

public class Loan {
    private Integer id_loan;
    private Integer customerId;
    private Integer branchId;
    private int amount;

    public Loan(Integer customerId, Integer branchId, int amount) {
        this.customerId = customerId;
        this.branchId = branchId;
        this.amount = amount;
    }

    public Integer getId_loan() {
        return id_loan;
    }

    public void setId_loan(Integer id_loan) {
        this.id_loan = id_loan;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Loan{" +
                "id_loan=" + id_loan +
                ", customerId=" + customerId +
                ", branchId=" + branchId +
                ", amount=" + amount +
                '}';
    }
}
