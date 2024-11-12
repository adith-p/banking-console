package com.banking_sys.app;

/**
 * Bank
 */
public class Bank {

    String acc_number;
    String acc_holder_name;
    private Double acc_balance;
    String acc_type;
    Boolean acc_status;

    private String[] transaction_history = new String[100];

    private int transaction_count = 0;

    public Bank(String accNumber, String accHolderName, Boolean accStatus, String accType) {

        acc_number = accNumber;
        acc_holder_name = accHolderName;
        acc_status = accStatus;
        acc_type = accType;
    }

    public void setBalance(Double value) {
        this.acc_balance = value;
    }

    public Double getBalance() {
        return this.acc_balance;
    }

    public void setTransaction(String type, Double amt) {
        if (this.transaction_count < this.transaction_history.length) {
            this.transaction_history[transaction_count] = type + ": " + amt + "on " + java.time.LocalDateTime.now();
            transaction_count += 1;
        }

    }

    public String[] getTransaction() {
        return this.transaction_history;
    }

    @Override
    public String toString() {
        return "acc_no " + acc_number + "acc_name " + acc_holder_name + " acc_type " + acc_type;
    }

}
