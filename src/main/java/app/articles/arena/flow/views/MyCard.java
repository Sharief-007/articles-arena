package app.articles.arena.flow.views;

import com.github.appreciated.card.Card;
import com.github.appreciated.card.action.ActionButton;
import com.github.appreciated.card.action.Actions;
import com.github.appreciated.card.content.IconItem;
import com.github.appreciated.card.content.Item;
import com.github.appreciated.card.label.PrimaryLabel;
import com.github.appreciated.card.label.SecondaryLabel;
import com.github.appreciated.card.label.TitleLabel;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "card",layout = Home.class)
public class MyCard extends VerticalLayout {
    public MyCard(){
        setSizeFull();
        setAlignItems(Alignment.STRETCH);

        Card card = new Card(
                // if you don't want the title to wrap you can set the whitespace = nowrap
                new TitleLabel("Example Title").withWhiteSpaceNoWrap(),
                new PrimaryLabel("Some primary text"),
                new SecondaryLabel("Some secondary text"),
                new IconItem(new Icon(VaadinIcon.ADOBE_FLASH), "Icon Item title", "Icon Item description"),
                new Item("Item title", "Item description"),
                //new Image("https://images.pexels.com/photos/1759531/pexels-photo-1759531.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500", "bg.png"),
                new Actions(
                        new ActionButton("Action 1", event -> {/* Handle Action*/}),
                        new ActionButton("Action 2", event -> {/* Handle Action*/})
                )
        );

        add(card);
    }
}
