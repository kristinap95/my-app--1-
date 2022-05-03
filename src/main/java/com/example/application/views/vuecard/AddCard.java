package com.example.application.views.vuecard;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.FileBuffer;
import com.vaadin.flow.component.upload.receivers.FileData;
import com.vaadin.flow.router.PageTitle;


@PageTitle("Vue Card")
@Tag("v-card-form")
@JsModule("../frontend/src/addNew.js")
public class AddCard extends LitTemplate {
    
    @Id("thumbnail")
    private Avatar thumbnail;

    @Id("header")
    private TextField headerText;
    
    @Id("subhead")
    private TextField subheadText;

    @Id("media")
    private Upload mediaImg;

    @Id("support")
    private TextArea supportText;

    @Id("btn1")
    private Button btn1;

    @Id("btn2")
    private Button btn2;

    @Id("cancelBtn")
    private Button cancel;

    @Id("saveBtn")
    private Button save;

    public void setEmpty() {
        if(this.btn1.hasThemeName("primary")) 
                this.btn1.removeThemeName("primary");
        if(this.btn2.hasThemeName("primary")) 
                this.btn2.removeThemeName("primary");
        this.headerText.setValue("");
        this.supportText.setValue("");
        this.subheadText.setValue("");
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
    public void getMediaURL() {
        FileBuffer fileBuffer = new FileBuffer();
        mediaImg = new Upload(fileBuffer);

        mediaImg.addSucceededListener(event -> {
            // Get information about the file that was written to the file system
            FileData savedFileData = fileBuffer.getFileData();
            String absolutePath = savedFileData.getFile().getAbsolutePath();

            System.out.printf("File saved to: %s%n", absolutePath);
        });
    }
    public void editButtons() {
        this.btn1.addClickListener(ClickEvent -> {
            if(this.btn1.hasThemeName("primary")) 
                this.btn1.removeThemeName("primary");
            else 
                this.btn1.addThemeName("primary");
        });
        this.btn2.addClickListener(ClickEvent -> {
            if(this.btn2.hasThemeName("primary")) 
                this.btn2.removeThemeName("primary");
            else
                this.btn2.addThemeName("primary");
        });
    }
    public AddCard() {
        super();
        this.supportText.setWidthFull();
        this.supportText.setHeight("7rem");
        this.supportText.getStyle().set("overflow","hidden");
        this.subheadText.setWidthFull();
        this.headerText.setWidthFull();
        this.editButtons();
    }
}
