package com.example.application.views.vuecard;

import java.util.LinkedList;
import java.util.List;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Vue Card")
@Route(value = "card-list", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)

public class VueCardView extends HorizontalLayout {

    List<VueCard> cards = new LinkedList<>();

    public List<VueCard> getCards() {
        return cards;
    }
    public VueCard saveCard(VueCard card) {
        cards.add(card);
        return card;
    }
    public VueCardView() {
       
        VueCard vc = new VueCard();
        vc.setMedia("https://www.planetware.com/wpimages/2020/02/france-in-pictures-beautiful-places-to-photograph-eiffel-tower.jpg");

        Button action1 = new Button("Action 1");
        action1.addClickListener(ClickEvent -> {
            vc.setMedia("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRUnHF-H-QVm1OVR7VhLpyTdUjBROeCVYVHBg&usqp=CAU");
        });
        vc.addButton(action1);

        Button action2 = new Button("Action 2");
        action2.addClickListener(ClickEvent -> {
            vc.setMedia("https://i.pinimg.com/originals/42/63/2f/42632f4d48030c4b04bdeb2bbe00e313.jpg");
        });
        vc.addButton(action2);

        add(vc);

        this.setPadding(true);

    }
}
