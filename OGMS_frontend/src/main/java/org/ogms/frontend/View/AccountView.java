package org.ogms.frontend.View;

import com.sun.jna.platform.win32.Advapi32Util;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.WebStorage;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.apache.coyote.http11.Http11InputBuffer;
import org.ogms.frontend.Model.Credentials;

@PageTitle("Account")
@Route(value = "/account", layout = MainLayout.class)
public class AccountView extends VerticalLayout {
    private final Credentials credentials;
    AccountView(Credentials credentials){
        this.credentials = credentials;
        add(new H1("My Account"));
        add(new H2("Username: " + credentials.getUsername()));
    }
}
