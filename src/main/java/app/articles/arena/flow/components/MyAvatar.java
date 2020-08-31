package app.articles.arena.flow.components;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.incubator.Avatar;
import com.vaadin.flow.component.incubator.TooltipAlignment;
import com.vaadin.flow.component.incubator.TooltipPosition;
import com.vaadin.flow.shared.Registration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@Tag("vcf-avatar-item")
@JsModule("@vaadin-component-factory/vcf-avatar-item/src/vcf-avatar-item.js")
public class MyAvatar extends Component implements HasStyle {
    private static final long serialVersionUID = 5097439595600784993L;

    private final String NAME_PROPERTY;
    private final String IMAGE_PROPERTY;
    private final String ABBR_PROPERTY;
    private final String TOOLTIP_POSITION_PROPERTY;
    private final String TOOLTIP_ALIGN_PROPERTY;
    private final String NO_TOOLTIP_PROPERTY;
    private final String WITH_IMAGE;

    public MyAvatar() {
        this.NAME_PROPERTY = "name";
        this.IMAGE_PROPERTY = "image";
        this.ABBR_PROPERTY = "abbr";
        this.TOOLTIP_POSITION_PROPERTY = "tooltipPosition";
        this.TOOLTIP_ALIGN_PROPERTY = "tooltipAlign";
        this.NO_TOOLTIP_PROPERTY = "noTooltip";
        this.WITH_IMAGE = "withImage";
        this.setToolTipEnabled(true);
    }

    public MyAvatar(String name) {
        this();
        this.setName(name);
    }

    public MyAvatar(String name, TooltipPosition tooltipPosition) {
        this(name);
        this.setTooltipPosition(tooltipPosition);
    }

    public MyAvatar(String name, TooltipPosition tooltipPosition, TooltipAlignment tooltipAlignment) {
        this(name, tooltipPosition);
        this.setTooltipAlignment(tooltipAlignment);
    }

    public void setName(String name) {
        this.getElement().setProperty("name", name);
    }

    public String getName() {
        return this.getElement().getProperty("name", "");
    }

    public void setImage(String imageUrl) {
        this.getElement().setProperty("image", imageUrl);
    }

    public void setImage(String imagePath, String contentType) {
        try {
            this.setImage(this.getBytesFromFile(imagePath), contentType);
        } catch (IOException var4) {
            throw new RuntimeException("It was not possible to set the image from the path: " + imagePath);
        }
    }

    public void setImage(byte[] bytes, String contentType) {
        String encodedImg = Base64.getEncoder().encodeToString(bytes);
        this.setImage("data:" + contentType + ";base64," + encodedImg);
    }

    public String getImage() {
        return this.getElement().getProperty("image", "");
    }

    public void setAbbreviation(String abbr) {
        this.getElement().setProperty("abbr", abbr);
    }

    public String getAbbreviation() {
        return this.getElement().getProperty("abbr");
    }

    public boolean isToolTipEnabled() {
        return !this.getElement().getProperty("noTooltip", false);
    }

    public void setToolTipEnabled(boolean enabled) {
        this.getElement().setProperty("noTooltip", !enabled);
    }

    public boolean hasImage() {
        return this.getElement().getProperty("withImage", false);
    }

    public void setTooltipPosition(TooltipPosition position) {
        this.setTooltipPosition(position.getPositionText());
    }

    public TooltipPosition getTooltipPosition() {
        return TooltipPosition.getPosition(this.getTooltipPositionText());
    }

    public void setTooltipAlignment(TooltipAlignment alignment) {
        this.setTooltipAlignment(alignment.getAlignmentText());
    }

    public TooltipAlignment getTooltipAlignment() {
        return TooltipAlignment.getAlignment(this.getTooltipAlignmentText());
    }

    public Registration addClickListener(ComponentEventListener<Avatar.ClickEvent> listener) {
        return this.addListener(Avatar.ClickEvent.class, listener);
    }

    private void setTooltipPosition(String position) {
        this.getElement().setProperty("tooltipPosition", position);
    }

    private String getTooltipPositionText() {
        return this.getElement().getProperty("tooltipPosition");
    }

    private void setTooltipAlignment(String alignment) {
        this.getElement().setProperty("tooltipAlign", alignment);
    }

    private String getTooltipAlignmentText() {
        return this.getElement().getProperty("tooltipAlign");
    }

    private byte[] getBytesFromFile(String imagePath) throws IOException {
        File file = new File(imagePath);
        return Files.readAllBytes(file.toPath());
    }

    @DomEvent("click")
    public static class ClickEvent extends ComponentEvent<Avatar> {
        public ClickEvent(Avatar source, boolean fromClient) {
            super(source, fromClient);
        }
    }
}

