package app.articles.arena.flow.views;

import app.articles.arena.flow.MainLayout;
import app.articles.arena.flow.components.ViewFrame;
import app.articles.arena.flow.utilities.VaadinUtilities;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.RoutePrefix;
import com.vaadin.flow.router.RouterLayout;

@RoutePrefix(value = "home",absolute = true)
@ParentLayout(value = MainLayout.class)
public class Home extends ViewFrame implements RouterLayout{
    private static final long serialVersionUID = -4486935496158391L;

    Tabs tabs = new Tabs();
    HorizontalLayout header = new HorizontalLayout(tabs);

    public Home() {
        init();
        createHeaders();
    }

    private void init() {
        setSizeFull();
        setFlexDirection(FlexDirection.COLUMN);
        setAlignItems(Alignment.STRETCH);

        setHeader(header);
    }

    private void createHeaders() {
        header.setJustifyContentMode(JustifyContentMode.CENTER);
        header.addClassName("tabs-in-headers");

        tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
        tabs.add(getTabs());
    }

    private Tab[] getTabs() {
        Tab feed = VaadinUtilities.tabWithIconOnTop(VaadinIcon.DASHBOARD, "Feed", Feed.class);
        Tab notifications = VaadinUtilities.tabWithIconOnTop(VaadinIcon.BELL, "Notifications", Feed.class);
        Tab profile = VaadinUtilities.tabWithIconOnTop(VaadinIcon.EDIT, "Editor", CKEditor.class);
        Tab card = VaadinUtilities.tabWithIconOnTop(VaadinIcon.CREDIT_CARD, "card", MyCard.class);

        return new Tab[]{feed,notifications,profile,card};
    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
        getContent().getElement().appendChild(content.getElement());
    }
}