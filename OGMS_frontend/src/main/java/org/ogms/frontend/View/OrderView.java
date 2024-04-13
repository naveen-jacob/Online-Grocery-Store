package org.ogms.frontend.View;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Orders")
@Route(value = "/orders", layout = MainLayout.class)
public class OrderView extends HorizontalLayout {
    OrderView(){
        VerticalLayout left = new VerticalLayout();
        VerticalLayout right = new VerticalLayout();
    }
}
