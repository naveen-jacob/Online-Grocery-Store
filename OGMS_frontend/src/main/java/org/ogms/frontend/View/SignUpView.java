package org.ogms.frontend.View;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.ogms.frontend.DTO.CredentialsDTO;

@PageTitle("SignUp")
@Route(value = "/signup", layout = MainLayout.class)
public class SignUpView extends VerticalLayout {
    private final TextField usernameField;
    private final PasswordField passwordField;
    private final Button signupButton;

    public SignUpView() {
        this.usernameField = new TextField("Username");
        this.passwordField = new PasswordField("Password");
        this.signupButton = new Button("Sign Up");

        add(usernameField, passwordField, signupButton);

        signupButton.addClickListener(click -> onSignupClicked());
    }

    private void onSignupClicked() {
        String username = usernameField.getValue();
        String password = passwordField.getValue();

        CredentialsDTO signupDTO = new CredentialsDTO(username, password);
        boolean signupSuccess = signupDTO.signUp();
        if (signupSuccess) {
            Notification.show("Sign up successful");
        } else {
            // Show error notification to user
            Notification.show("Sign up failed");
        }
    }
}
