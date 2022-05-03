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
        modal.setResizable(true);

        AddCard cardForm = new AddCard();
        modal.add(cardForm);
        cardForm.getCancelButton().addClickListener(e -> modal.close());
        cardForm.getSaveButton().addClickListener(e -> {
            VueCard vc = new VueCard();
            //vc.thumbnail
            vc.setHeadertext(cardForm.getHeaderText());
            vc.setSubhead(cardForm.getSubheadText());
            //vc.media
            vc.setSupporttext(cardForm.getSupportText());
            if(cardForm.getBtn1().hasThemeName("primary")) {
                Button action1 = new Button("Action 1");
                action1.addClickListener(ClickEvent -> {
                    vc.setMedia("https://media.istockphoto.com/photos/villefranche-on-sea-in-evening-picture-id1145618475?k=20&m=1145618475&s=612x612&w=0&h=_mC6OZt_eWENYUAZz3tLCBTU23uvx5beulDEZHFLsxI=");
                });
                vc.addButton(action1);
            }
            if(cardForm.getBtn2().hasThemeName("primary")) {
                Button action2 = new Button("Action 2");
                action2.addClickListener(ClickEvent -> {
                    vc.setMedia("https://www.planetware.com/wpimages/2020/02/france-in-pictures-beautiful-places-to-photograph-eiffel-tower.jpg");
                });
                vc.addButton(action2);
            }
            modal.close();
            add(vc);
            cardForm.setEmpty();
        });
    }

}
