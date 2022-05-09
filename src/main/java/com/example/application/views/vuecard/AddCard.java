package com.example.application.views.vuecard;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.router.PageTitle;


@PageTitle("Vue Card")
public class AddCard extends Div {

    protected Avatar thumbnailImg;
    protected TextField headerText, subheadText;
    protected TextArea supportText;
    protected Button btn1, btn2, cancel, save;
    protected Upload media;

    public AddCard() {
        super();
        setWidth("100%");
        thumbnailImg = new Avatar();
        headerText = new TextField();
        headerText.setPlaceholder("Title text here");
        subheadText = new TextField();
        subheadText.setPlaceholder("Subtitle text");
        HorizontalLayout headerCard = new HorizontalLayout();
        headerCard.add(thumbnailImg);
        VerticalLayout headerFileds = new VerticalLayout();
        headerFileds.add(headerText, subheadText);
        headerCard.setAlignItems(Alignment.CENTER);
        headerCard.add(headerFileds);
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
    }
    public String getThumbnailURL() {
        return this.thumbnailImg.getImage(); // return null ????
    }
    public String getHeaderText() {
        return this.headerText.getValue();
    }
    public String getSubheadText() {
        return this.subheadText.getValue();
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
