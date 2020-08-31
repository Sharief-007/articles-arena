package app.articles.arena.flow.views;

import app.articles.arena.flow.MainLayout;
import com.vaadin.componentfactory.Chat;
import com.vaadin.componentfactory.model.Message;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

//@Route(value = "chat", layout = MainLayout.class)
public class ChatView extends VerticalLayout {
    private static final long serialVersionUID = 1L;

    public ChatView() {
        Chat chat = new Chat();
        chat.setMessages(loadMessages());
        chat.setDebouncePeriod(200);
        chat.setLazyLoadTriggerOffset(2500);
        chat.scrollToBottom();

        chat.addChatNewMessageListener(event -> {
            event.getSource()
                    .addNewMessage(new Message(event.getMessage(),
                            "https://mir-s3-cdn-cf.behance.net/project_modules/disp/ce54bf11889067.562541ef7cde4.png",
                            "Ben Smith", true));
            event.getSource().clearInput();
            event.getSource().scrollToBottom();
        });

        chat.addLazyLoadTriggerEvent(e -> {
            List<Message> list = loadMessages();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            chat.setLoading(false);
            chat.addMessagesToTop(list);
        });

        addAndExpand(chat);
        setWidthFull();
    }

    private List<Message> loadMessages() {
        return null;
    }
}