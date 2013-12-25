package com.freece.pages;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Created with IntelliJ IDEA.
 * User: stefan.hermelin
 * Date: 12/23/13
 * Time: 10:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainPage extends AbstractBasePage {
    public MainPage(PageParameters parameters) {
        super(parameters);

        BookmarkablePageLink aboutLink = new BookmarkablePageLink("link1", ListTransactionsPage.class);
        BookmarkablePageLink categoryLink = new BookmarkablePageLink("link2", ListCategoryPage.class);
        aboutLink.add(new Label("link1text", "Go to About page"));
        categoryLink.add(new Label("link2text", "See Categorys Bitch!"));
        add(categoryLink);
        add(aboutLink);

    }
}
