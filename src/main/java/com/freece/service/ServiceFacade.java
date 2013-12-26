package com.freece.service;

import com.freece.model.Category;
import com.freece.model.Transaction;

import java.util.List;

public interface ServiceFacade {

    List<Transaction> getTransactions();

    List<Category> getCategories(Transaction transaction);
}
