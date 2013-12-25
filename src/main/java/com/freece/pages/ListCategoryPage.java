package com.freece.pages;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.freece.model.Category;

/**
 * Created with IntelliJ IDEA.
 * User: stefan.hermelin
 * Date: 12/23/13
 * Time: 10:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class ListCategoryPage extends AbstractBasePage {

    private static final long serialVersionUID = 1L;
    

    public ListCategoryPage(final PageParameters parameters) {
        super(parameters);
        List list = Arrays.asList(
                new Category[] {
                        new Category("Pulla"),
                        new Category("Rumpa"),
                        new Category("Med Skumpa")                     
                }
        );
        ListView listview = new ListView("listView", list) {
            protected void populateItem(ListItem item) {
                Category c= (Category) item.getModelObject();
                item.add(new Label("cName", c.getName()));
               
            }
        };
        add(listview);
  

      
      
    }
}