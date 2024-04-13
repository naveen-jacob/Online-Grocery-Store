package org.ogms.frontend.View;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.WebStorage;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.ogms.frontend.DTO.CredentialsDTO;
import org.ogms.frontend.Model.Credentials;

@PageTitle("Login")
@Route(value = "/login", layout = MainLayout.class)
public class LoginView extends VerticalLayout {
    private final Credentials credentials;
    LoginView(Credentials credentials){
        this.credentials = credentials;

        Button signUpButton = new Button("Sign Up");
        signUpButton.addClickListener(click -> {
            UI.getCurrent().navigate(SignUpView.class);
        });

        LoginForm loginForm = new LoginForm();
        loginForm.addLoginListener(loginEvent ->{
            String username = loginEvent.getUsername();
            String password = loginEvent.getPassword();
            CredentialsDTO credentialsCheck = new CredentialsDTO(username, password);
            if (credentialsCheck.isValid()) {
                credentials.setUsername(username);
                credentials.setPassword(password);
                UI.getCurrent().navigate(AccountView.class);
            }
            else {
                loginForm.setError(true);
            }
        });
        add(signUpButton, loginForm);
    }
}
