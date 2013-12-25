package com.freece.pages;

import com.freece.model.Transaction;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListTransactionsPage extends WebPage {

    private static final long serialVersionUID = 1L;
    private int counter = 1;

    public ListTransactionsPage(final PageParameters parameters) {
        super(parameters);

        IModel<List<Transaction>> model = new LoadableDetachableModel<List<Transaction>>() {
            @Override
            protected List<Transaction> load() {
                ArrayList<Transaction> list = new ArrayList<Transaction>();
                list.add(new Transaction(new Date(), "SevenElevent", 54));
                list.add(new Transaction(new Date(), "Teknikmagasinet", 199));
                for (int i = 0; i < counter; i++) {
                    list.add(new Transaction(new Date(), "Statoil", 756));
                }
                System.out.println("load()");
                return list;
            }
        };

        final ListView listview = new ListView("listView", model) {
            protected void populateItem(ListItem item) {
                System.out.println("populateItem");
                Transaction transaction = (Transaction) item.getModelObject();
                item.add(new Label("tDate", transaction.getFormattedDate()));
                item.add(new Label("tDesc", transaction.getDescription()));
                item.add(new Label("tAmount", transaction.getAmount()));
            }
        };
        final WebMarkupContainer listContainer = new WebMarkupContainer("listContainer");
        listContainer.setOutputMarkupId(true);
        listContainer.add(listview);
        add(listContainer);

        AjaxLink<Void> addButton = new AjaxLink<Void>("addButton") {
            @Override
            public void onClick(AjaxRequestTarget ajaxRequestTarget) {
                System.out.println("CLICK!");
                counter++;
                ajaxRequestTarget.add(listContainer);
            }
        };
        add(addButton);
    }
}
