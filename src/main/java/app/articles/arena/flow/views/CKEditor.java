package app.articles.arena.flow.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.wontlost.ckeditor.*;

@Route(value = "editor",layout = Home.class)
public class CKEditor extends VerticalLayout {
    public CKEditor() {
        setSizeFull();
        setAlignItems(Alignment.STRETCH);
        /**Classic Editor*/
        VaadinCKEditor classicEditor = new VaadinCKEditorBuilder().with(builder -> {
            builder.editorData = "<p>This is a classic editor sample.</p>";
            builder.editorType = EditorType.CLASSIC;
            builder.uiLanguage = Language.en_gb; //language defaulted to 'en'
            builder.theme = ThemeType.LIGHT;
            builder.toolbar = new Toolbar[]{Toolbar.fontFamily,
                    Toolbar.fontSize, Toolbar.fontColor,
            Toolbar.code, Toolbar.mediaEmbed, Toolbar.imageUpload};
        }).createVaadinCKEditor();

        addAndExpand(classicEditor);
    }
}
