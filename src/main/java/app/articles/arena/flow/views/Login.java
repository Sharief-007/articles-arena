package app.articles.arena.flow.views;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.Route;

@Route("login")
public class Login extends FlexLayout{
    
    private static final long serialVersionUID = 1L;

    public Login() {
        setFlexDirection(FlexDirection.COLUMN);
        setHeightFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);

        H1 header = new H1("Welcome To Vaadin !");
        LoginForm loginForm = new LoginForm();
        loginForm.addLoginListener(e->{
            Notification.show(e.getUsername()+" : "+e.getPassword());
        });
        Anchor signup = new Anchor();
        signup.add("signup");
        add(header);
        add(loginForm);
        add(signup);
    }
}