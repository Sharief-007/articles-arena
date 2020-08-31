package app.articles.arena.flow;

import app.articles.arena.flow.utilities.VaadinUtilities;
import app.articles.arena.flow.views.Feed;
import app.articles.arena.flow.views.Search;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@CssImport(value = "frontend://styles/Main.css")
public class MainLayout extends AppLayout implements AfterNavigationObserver {
    private static final long serialVersionUID = 534990572013194226L;
    
    Tabs navigation = new Tabs();
    FlexLayout drawer = new FlexLayout();

    public MainLayout(){
        setNavBar();
        setDrawer();
    }

	private void setNavBar() {
        addToNavbar(new DrawerToggle(),new H3("Article Arena"));
	} 

    private void setDrawer() {
        drawer.setSizeFull();
        drawer.setFlexDirection(FlexLayout.FlexDirection.COLUMN);

        setProfile();
        setNavigation();
        drawer.add(new Hr());
        drawer.add(navigation);
        addToDrawer(drawer);
    }

    private void setProfile() {
        Div profile = new Div();
        profile.addClassName("profile-div");

        Image image = new Image("https://images.pexels.com/photos/1759531/pexels-photo-1759531.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","Profile");
        image.addClassName("profile-picture");

        H3 username = new H3("Sharief Baig");
        username.addClassName("h3-username");

        profile.add(image);
        profile.add(username);

        Icon twitter = new Icon(VaadinIcon.TWITTER), facebook = new Icon(VaadinIcon.FACEBOOK_SQUARE), youtube = new Icon(VaadinIcon.YOUTUBE);

        HorizontalLayout layout = new HorizontalLayout(twitter,facebook,youtube);
        layout.setSpacing(true);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        profile.add(layout);
        
        drawer.add(profile);
    }

    private void setNavigation() {
        navigation.setOrientation(Tabs.Orientation.VERTICAL);
        navigation.add(getTabs());
    }

    private Tab[] getTabs() {
        Tab home = VaadinUtilities.createTabWithRouterLink(VaadinIcon.HOME, "Home", Feed.class);
        Tab search = VaadinUtilities.createTabWithRouterLink(VaadinIcon.SEARCH, "Search", Search.class);
        //Tab chat = VaadinUtilities.createTabWithRouterLink(VaadinIcon.CHAT, "Chat", ChatView.class);

        return new Tab[]{home,search};
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        String path = event.getLocation().getPath();
        if (path.startsWith("home")){
            navigation.setSelectedIndex(0);
        }else if (path.startsWith("search")){
            navigation.setSelectedIndex(1);
        }else if (path.startsWith("chat")){
            navigation.setSelectedIndex(2);
        }
    }
}