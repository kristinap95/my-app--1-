package com.example.application.views.vuecard;

import com.example.application.views.MainLayout;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Vue Card")
@Route(value = "card-list", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class VueCardView extends VerticalLayout {

    public VueCardView() {
        VueCard vc = new VueCard();
        vc.setHeadertext("Ovo je header text");
        vc.setSubhead("Podnaslov");
        vc.setMedia("https://ucbank.me/wp-content/uploads/2018/05/mastercard-debit500.jpg");
        add(vc);
    }

}