package com.freece.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class AbstractBasePage extends WebPage {
    final protected PageParameters pageParameters;

    public AbstractBasePage(final PageParameters parameters) {
        super(parameters);
        pageParameters = parameters;
    }
}

