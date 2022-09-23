package  com.solvd.entity;

public class TransactionType {
    private Integer id_transactionType;
    private String transactionName;

    public TransactionType( String transactionName) {
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
