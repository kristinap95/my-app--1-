package com.example.application.views.vuecard;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarVariant;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.FileBuffer;
import com.vaadin.flow.component.upload.receivers.FileData;
import com.vaadin.flow.router.PageTitle;


@PageTitle("Vue Card")
public class AddCard extends VerticalLayout {

    protected Avatar thumbnailImg;
    protected TextField headerText, subheaderText;
    protected TextArea supportText;
    protected Button btn1, btn2, cancel, save;
    protected Upload media;

    public AddCard() {
        super();
        setId("card-form");
        thumbnailImg = new Avatar();
        thumbnailImg.addThemeVariants(AvatarVariant.LUMO_XLARGE);
        headerText = new TextField();
        headerText.setPlaceholder("Title text here");
        headerText.setWidthFull();
        subheaderText = new TextField();
        subheaderText.setPlaceholder("Subtitle text");
        subheaderText.setWidthFull();
        
        HorizontalLayout headerCard = new HorizontalLayout();
        headerCard.add(thumbnailImg);
        Div headerFields = new Div();
        headerFields.add(headerText, subheaderText);
        headerCard.setAlignItems(Alignment.CENTER);
        headerCard.add(headerFields);
        add(headerCard);
        media = new Upload();
        add(media);
        supportText = new TextArea();
        supportText.setPlaceholder("Supporting text");
        supportText.addClassName("support-text");
        add(supportText);
        btn1 = new Button("Action1");
        btn2 = new Button("Action2");
        HorizontalLayout actions = new HorizontalLayout();
        actions.add(btn1, btn2);
        cancel = new Button("Cancel");
        save = new Button("Save");
        save.setThemeName("primary");
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setJustifyContentMode(JustifyContentMode.END);
        buttons.add(cancel, save);
        add(actions,buttons);
        
        editButtons();
        uploadMedia();
    }
    public String getThumbnailURL() {
        return this.thumbnailImg.getImage();
    }
    public String getHeaderText() {
        return this.headerText.getValue();
    }
    public String getSubheaderText() {
        return this.subheaderText.getValue();
    }
    public String getSupportText() {
        return this.supportText.getValue();
    }
    public Button getBtn1() {
            return this.btn1;
    }
    public Button getBtn2() {
            return this.btn2;
    }
    public Button getCancelButton() {
        return this.cancel;
    }
    public Button getSaveButton() {
        return this.save;
    }
    public void uploadMedia() {
        FileBuffer fileBuffer = new FileBuffer();
        media = new Upload(fileBuffer);

        media.addSucceededListener(event -> {
            FileData savedFileData = fileBuffer.getFileData();
            String absolutePath = savedFileData.getFile().getAbsolutePath();
            System.out.printf("File saved to: %s%n", absolutePath);
        });
    }
    public void editButtons() {
        this.btn1.addClickListener(ClickEvent -> {
            if (this.btn1.hasThemeName("primary"))
                this.btn1.removeThemeName("primary");
            else
                this.btn1.addThemeName("primary");
        });
        this.btn2.addClickListener(ClickEvent -> {
            if (this.btn2.hasThemeName("primary"))
                this.btn2.removeThemeName("primary");
            else
                this.btn2.addThemeName("primary");
        });
    }
}
