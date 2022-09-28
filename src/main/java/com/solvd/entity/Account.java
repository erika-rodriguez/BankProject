package com.solvd.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class Account {
    @JsonProperty("id_account")
    private Integer id_account;
    @JsonProperty("customerId")
    private Integer customerId;
    @JsonProperty("branchId")
    private Integer branchId;
    @JsonProperty("accountStatusId")
    private Integer accountStatusId;
    @JsonProperty("OpeningDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "DD/MM/YYYY")
    private Date openingDate;
    @JsonProperty("Balance")
    private int balance;

    public Account() {
    }

    public Account(Integer customerId, Integer branchId, Integer accountStatusId, Date openingDate, int balance) {
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
