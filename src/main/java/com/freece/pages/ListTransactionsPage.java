package com.freece.pages;

import com.freece.model.Category;
import com.freece.model.Transaction;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.List;

public class ListTransactionsPage extends AbstractBasePage {

    private static final long serialVersionUID = 1L;
    private int counter = 1;

    public ListTransactionsPage(final PageParameters parameters) {
        super(parameters);

        final IModel<List<Transaction>> model = new LoadableDetachableModel<List<Transaction>>() {
            @Override
            protected List<Transaction> load() {
                return getServices().getTransactions();
            }
        };

        final ListView listview = new ListView("listView", model) {
            protected void populateItem(ListItem item) {
                final Transaction transaction = (Transaction) item.getModelObject();
                item.add(new Label("tDate", transaction.getFormattedDate()));
                item.add(new Label("tDesc", transaction.getDescription()));
                item.add(new Label("tAmount", transaction.getAmount()));

                final int index = item.getIndex();
                item.add(new AttributeModifier("class", true, new
                        AbstractReadOnlyModel<String>() {
                            @Override
                            public String getObject() {
                                return index % 2 == 0
                                        ? "listtrans_list_even"
                                        : "listtrans_list_odd";
                            }
                        }));

                IModel<List<Category>> model = new LoadableDetachableModel<List<Category>>() {
                    @Override
                    protected List<Category> load() {
                        return getServices().getCategories(transaction);
                    }
                };
                final ListView tCategories = new ListView("tCategories", model) {
                    protected void populateItem(ListItem item) {
                        final Category category = (Category) item.getModelObject();
                        item.add(new Label("tCategory", category.getName()));
                    }
                };
                item.add(tCategories);
            }
        };
        final WebMarkupContainer listContainer = new WebMarkupContainer("listContainer");
        listContainer.setOutputMarkupId(true);
        listContainer.add(listview);
        add(listContainer);



        AjaxLink<Void> addButton = new AjaxLink<Void>("addButton") {
            @Override
            public void onClick(AjaxRequestTarget ajaxRequestTarget) {
                counter++;
                ajaxRequestTarget.add(listContainer);
            }
        };
        add(addButton);
    }
}
