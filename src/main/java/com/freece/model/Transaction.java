package com.freece.model;

public class Transaction {
    final private String note;
    final private int amount;

    public Transaction(String note, int amount) {
        this.note = note;
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public int getAmount() {
        return amount;
    }
}
