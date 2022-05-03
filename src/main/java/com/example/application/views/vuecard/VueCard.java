package com.example.application.views.vuecard;


import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.PageTitle;


@PageTitle("Vue Card")
@Tag("v-card")
@JsModule("../frontend/src/v-card.js")
public class VueCard extends LitTemplate {
    
    @Id("buttons")
    private Div buttonsDiv;

    public VueCard() {
        super();
    }
    public String getHeadertext() {
        return getElement().getProperty("headertext");
    }
    public String getThumbnail() {
        return getElement().getProperty("thumbnail");
    }
    public String getSubheadText() {
        return getElement().getProperty("subhead");
    }
    public String getMedia() {
        return getElement().getProperty("media");
    }
    public String getSupportText() {
        return getElement().getProperty("supporttext");
    }
    public void setThumbnail(String thumbnail) {
        getElement().setProperty("thumbnail", thumbnail);
    }
    public void setHeadertext(String headertext) {
        getElement().setProperty("headertext", headertext);
    }
    public void setSubhead(String subhead) {
        getElement().setProperty("subhead", subhead);
    }
    public void setMedia(String media) {
        getElement().setProperty("media", media);
    }
    public void setSupporttext(String supporttext) {
        getElement().setProperty("supporttext", supporttext);
    }     
    public void addButton(Button btnName) {
        this.buttonsDiv.add(btnName);
    }
 }