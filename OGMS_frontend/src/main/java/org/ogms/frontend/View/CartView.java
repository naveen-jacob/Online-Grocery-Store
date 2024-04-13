package org.ogms.frontend.View;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.ogms.frontend.DTO.ItemDTO;
import org.ogms.frontend.Model.Cart;
import org.ogms.frontend.Model.Credentials;
import org.ogms.frontend.Model.Product;
import org.ogms.frontend.Service.CartService;
import org.ogms.frontend.Service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@PageTitle("Cart")
@Route(value = "/cart", layout = MainLayout.class)
public class CartView extends VerticalLayout {
    private final CartService cartService;
    private final ProductService productService;
    private final Cart cart;
    private final Credentials credentials;
    List<ItemDTO> itemDTOList = new ArrayList<>();
    Grid<ItemDTO> grid = new Grid<>(ItemDTO.class, false);

    CartView(CartService cartService, ProductService productService, Cart cart, Credentials credentials){
        this.cartService = cartService;
        this.productService = productService;
        this.cart = cart;
        this.credentials = credentials;

        grid.addColumn(ItemDTO::getProductName).setHeader("Item");
        grid.addColumn(ItemDTO::getValue).setHeader("Quantity");

        grid.addComponentColumn(item -> {
            Button removeButton = new Button("Remove");
            removeButton.addClickListener(click -> {
                cartService.removeProduct(item.getKey());
                itemDTOList.clear();
                populateGrid();
            });
            return removeButton;
        });

        add(grid);
        populateGrid();
    }
    private void populateGrid(){
        if (this.credentials.isAuthenticated()){
            cartService.getCart();
        }
        Map<String, Integer> items = cart.getItems();
        items.forEach((key, value) -> {
            Product product = productService.getProduct(key);
            String productName = product.getName();
            itemDTOList.add(
                    new ItemDTO(
                            key, value, productName
                    )
            );
        });
        grid.setItems(itemDTOList);
    }
}
