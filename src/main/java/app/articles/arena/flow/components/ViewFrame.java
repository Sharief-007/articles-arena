package app.articles.arena.flow.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

public class ViewFrame extends FlexLayout{
    private static final long serialVersionUID = 1L;
    
    Div header = new Div(), content = new Div(), footer = new Div();
    public ViewFrame() {
        setFlexDirection(FlexDirection.COLUMN);
        setSizeFull();
        setAlignItems(Alignment.STRETCH);
        add(header,content,footer);
        expand(content);
        content.getStyle().set("overflow-y", "auto");
    }
    
    public void setHeader(Component component){
        header.add(component);
    }

    public void setContent(Component component){
        content.add(component);
    }
    public void setFooter(Component component){
        content.add(component);
    }

    public Div getContent(){
        return this.content;
    }
}