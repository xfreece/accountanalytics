package com.freece.pages;

import com.freece.service.MockServiceFacade;
import com.freece.service.ServiceFacade;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class AbstractBasePage extends WebPage {
    final protected PageParameters pageParameters;

    public AbstractBasePage(final PageParameters parameters) {
        super(parameters);
        pageParameters = parameters;
    }

    protected ServiceFacade getServices() {
        return new MockServiceFacade();
    }
}

