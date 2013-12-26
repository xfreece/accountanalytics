package com.freece.service;

import com.freece.model.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockServiceFacade implements ServiceFacade {
    @Override
    public List<Transaction> getTransactions() {
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        list.add(new Transaction(new Date(), "SevenElevent", 54));
        list.add(new Transaction(new Date(), "Teknikmagasinet", 199));
        for (int i = 0; i < 3; i++) {
            list.add(new Transaction(new Date(), "Statoil", 756));
        }
        return list;

    }
}
