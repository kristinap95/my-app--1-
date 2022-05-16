package com.example.application.views.vuecard;


import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Vue Card")
@Route(value = "card-list", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)

public class VueCardView extends VerticalLayout {

    public VueCardView() {
       
        Button addNew = new Button("Add new");
        addNew.setThemeName("primary");
        add(addNew);

        Dialog modal = new Dialog();
        modal.setCloseOnOutsideClick(true);
        addNew.addClickListener(ClickEvent -> {
            modal.open();
        });
        modal.setMaxWidth("500px");

        AddCard cardForm = new AddCard();
        modal.add(cardForm);
        add(modal);

        UploadImage image = new UploadImage();
        add(image);
        
    }
}
