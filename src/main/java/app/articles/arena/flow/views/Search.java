package app.articles.arena.flow.views;


import app.articles.arena.flow.MainLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(value = "search",layout = MainLayout.class)
public class Search extends Div {
    private static final long serialVersionUID = 3781870836622100260L;

    public Search() {
        add(new Text("Search Tab"));
    }
}