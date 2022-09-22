package entity;

import java.sql.Date;

public class Transaction {
    private Integer id_transaction;
    private Integer accountId;
    private Integer transactionTypeId;
    private Date transactionDate;
    private int amount;

    public Transaction(Integer accountId, Integer transactionTypeId, Date transactionDate, int amount) {
        this.accountId = accountId;
        this.transactionTypeId = transactionTypeId;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    public Integer getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(Integer id_transaction) {
        this.id_transaction = id_transaction;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Integer transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id_transaction=" + id_transaction +
                ", accountId=" + accountId +
                ", transactionTypeId=" + transactionTypeId +
                ", transactionDate=" + transactionDate +
                ", amount=" + amount +
                '}';
    }
}
