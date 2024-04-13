package org.ogms.frontend.View;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.ogms.frontend.Model.Credentials;

public class MainLayout extends AppLayout {
    String username;
    private final Credentials credentials;

    public MainLayout(Credentials credentials) {
        this.credentials = credentials;
        createHeader();
    }

    private void createHeader() {

        MenuBar menu = new MenuBar();

        menu.addItem("Home", item -> UI.getCurrent().navigate(HomeView.class));
        menu.addItem("Products", item -> UI.getCurrent().navigate(ProductView.class));
        menu.addItem("Orders", item -> {
            if (credentials.getUsername() != null) {
                UI.getCurrent().navigate(OrderView.class);
            }
            else {
                Notification notification = Notification.show("Not logged in");
            }
        });
        menu.addItem("Cart", item -> UI.getCurrent().navigate(CartView.class));
        menu.addItem("My Account", item ->
                {
                    if (credentials.getUsername() == null){
                        UI.getCurrent().navigate(LoginView.class);
                    }
                    else {
                        UI.getCurrent().navigate(AccountView.class);
                    }
                });
        menu.addItem("Logout", item ->
        {
            if (credentials.getUsername() != null){
                credentials.reset();
            }
        });
        addToNavbar(new VerticalLayout(menu));

    }
}