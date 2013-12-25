package com.freece.pages;

import com.freece.model.Transaction;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ListTransactionsPage extends WebPage {

    private static final long serialVersionUID = 1L;
    private IModel<Transaction> model;

    public ListTransactionsPage(final PageParameters parameters) {
        super(parameters);

        List list = Arrays.asList(
                new Transaction[] {
                        new Transaction(new Date(), "SevenElevent", 54),
                        new Transaction(new Date(), "Teknikmagasinet", 199),
                        new Transaction(new Date(), "Statoil", 756)
                }
        );
        ListView listview = new ListView("listView", list) {
            protected void populateItem(ListItem item) {
                Transaction transaction = (Transaction) item.getModelObject();
                item.add(new Label("tDate", transaction.getFormattedDate()));
                item.add(new Label("tDesc", transaction.getDescription()));
                item.add(new Label("tAmount", transaction.getAmount()));
            }
        };
        add(listview);


    }
}
