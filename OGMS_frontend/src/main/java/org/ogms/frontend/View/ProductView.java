package org.ogms.frontend.View;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.OrderedList;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.ogms.frontend.Model.Product;
import org.ogms.frontend.Service.CartService;
import org.ogms.frontend.Service.ProductService;

import java.util.List;

@PageTitle("Products")
@Route(value = "/products", layout = MainLayout.class)
public class ProductView extends VerticalLayout {
    private OrderedList productContainer;
    private final ProductService productService;
    private final CartService cartService;
    ProductView(ProductService productService, CartService cartService){
        this.productService = productService;
        this.cartService = cartService;
        constructUI();
        populate();
    }

    private void constructUI() {
        addClassNames("products-view");
        addClassNames(LumoUtility.MaxWidth.SCREEN_LARGE, LumoUtility.Margin.Horizontal.AUTO, LumoUtility.Padding.Bottom.LARGE, LumoUtility.Padding.Horizontal.LARGE);

        productContainer = new OrderedList();
        productContainer.addClassNames(LumoUtility.Gap.MEDIUM, LumoUtility.Display.GRID, LumoUtility.ListStyleType.NONE, LumoUtility.Margin.NONE, LumoUtility.Padding.NONE);

        add(productContainer);
    }

    private void populate(){
        List<Product> products = productService.getProducts();
        products.forEach(e -> productContainer.add(new ProductCardView(e, this.cartService)));
    }
}
