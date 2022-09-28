package  com.solvd.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionType {
    @JsonProperty("id_transactionType")
    private Integer id_transactionType;
    @JsonProperty("Transaction")
    private String transactionName;

    public TransactionType() {
    }

    public TransactionType(String transactionName) {
        this.transactionName = transactionName;
    }

    public Integer getId_transactionType() {
        return id_transactionType;
    }

    public void setId_transactionType(Integer id_transactionType) {
        this.id_transactionType = id_transactionType;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    @Override
    public String toString() {
        return "TransactionType{" +
                "id_transactionType=" + id_transactionType +
                ", transactionName='" + transactionName + '\'' +
                '}';
    }
}
