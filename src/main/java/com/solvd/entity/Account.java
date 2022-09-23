package com.solvd.entity;

import java.sql.Date;

public class Account {
    private Integer id_account;
    private Integer customerId;
    private Integer branchId;
    private Integer accountStatusId;
    private Date openingDate;
    private int balance;

    public Account( Integer customerId, Integer branchId, Integer accountStatusId, Date openingDate, int balance) {
        this.customerId = customerId;
        this.branchId = branchId;
        this.accountStatusId = accountStatusId;
        this.openingDate = openingDate;
        this.balance = balance;
    }

    public Integer getId_account() {
        return id_account;
    }

    public void setId_account(Integer id_account) {
        this.id_account = id_account;
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

    public Integer getAccountStatusId() {
        return accountStatusId;
    }

    public void setAccountStatusId(Integer accountStatusId) {
        this.accountStatusId = accountStatusId;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id_account=" + id_account +
                ", customerId=" + customerId +
                ", branchId=" + branchId +
                ", accountStatusId=" + accountStatusId +
                ", openingDate=" + openingDate +
                ", balance=" + balance +
                '}';
    }
}
