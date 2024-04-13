package org.ogms.frontend.View;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.ogms.frontend.Model.Product;
import org.ogms.frontend.Service.CartService;

public class ProductCardView extends ListItem {
    private final CartService cartService;
    public ProductCardView(Product product, CartService cartService) {
        this.cartService = cartService;
        addClassNames(LumoUtility.Background.CONTRAST_5,
                LumoUtility.Display.FLEX,
                LumoUtility.FlexDirection.COLUMN,
                LumoUtility.AlignItems.START,
                LumoUtility.Padding.MEDIUM,
                LumoUtility.BorderRadius.LARGE);

        Div div = new Div();
        div.addClassNames(LumoUtility.Background.CONTRAST, LumoUtility.Display.FLEX, LumoUtility.AlignItems.CENTER, LumoUtility.JustifyContent.CENTER,
                LumoUtility.Margin.Bottom.MEDIUM, LumoUtility.Overflow.HIDDEN, LumoUtility.BorderRadius.MEDIUM, LumoUtility.Width.FULL);
        div.setHeight("128px");

        Image image = new Image();
        image.setWidth("100%");
        image.setSrc(product.getImageUrl());
        image.setAlt(product.getName());

        div.add(image);

        Span header = new Span();
        header.addClassNames(LumoUtility.FontSize.XLARGE, LumoUtility.FontWeight.SEMIBOLD);
        header.setText(product.getName());

        Paragraph description = new Paragraph(product.getDescription());
        description.addClassName(LumoUtility.Margin.Vertical.MEDIUM);

        Button addToCartButton = new Button("Add to Cart", VaadinIcon.CART.create());
        addToCartButton.addClickListener(clickEvent -> {
            cartService.addProduct(product);
        });

        add(div, header, description, addToCartButton);
    }
}
