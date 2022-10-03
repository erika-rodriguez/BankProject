package com.solvd.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountStatus {
    @JsonProperty("id_accountStatus")
    private Integer id_accountStatus;
    @JsonProperty("AccountStatus")
    private String status;

    public AccountStatus() {
    }

    public AccountStatus(String status) {
        this.status = status;
    }

    public Integer getId_accountStatus() {
        return id_accountStatus;
    }

    public void setId_accountStatus(Integer id_accountStatus) {
        this.id_accountStatus = id_accountStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AccountStatus{" +
                "id_accountStatus=" + id_accountStatus +
                ", status='" + status + '\'' +
                '}';
    }
}
