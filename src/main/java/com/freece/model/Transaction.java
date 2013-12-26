package com.freece.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    final private Date date;
    final private String description;
    final private int amount;

    public Transaction(Date date, String description, int amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public String getFormattedDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}
