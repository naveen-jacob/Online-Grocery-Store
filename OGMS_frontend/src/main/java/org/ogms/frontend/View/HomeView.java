package org.ogms.frontend.View;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Home")
@Route(value = "", layout = MainLayout.class)
public class HomeView extends VerticalLayout {
    HomeView(){
        H1 greeting = new H1("Online Grocery Store");

        Paragraph paragraph = new Paragraph("This e-commerce store leverages Vaadin's " +
                "rich web UI for the frontend and Spring Boot's efficiency for the " +
                "backend. It is built on MVC architecture with microservices.");

        add(greeting, paragraph);
    }
}
