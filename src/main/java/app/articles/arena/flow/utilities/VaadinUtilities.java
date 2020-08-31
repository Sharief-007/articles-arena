package app.articles.arena.flow.utilities;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.router.RouterLink;

public class VaadinUtilities {
    private VaadinUtilities(){}

    public static Tab createTabWithRouterLink(VaadinIcon icon, String text, Class<? extends Component> target){
        RouterLink link = new RouterLink(text,target);
        Tab tab = new Tab(new Icon(icon),link);
        return tab;
    }

    public static Tab tabWithIconOnTop(VaadinIcon icon, String text, Class<? extends Component> target){
        RouterLink link = new RouterLink(text,target);
        Tab tab = new Tab(new Icon(icon),link);
        tab.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
        return tab;
    }

    
}