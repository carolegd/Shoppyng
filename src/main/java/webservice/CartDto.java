package webservice;

import fr.lacombe.cartbnp.Cart;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class CartDto {
    private Set<ProductDto> products;
    private double totalPrice;
    private CartDto(){
    }
    public static CartDto mapper(Cart cart){
        CartDto cartDto = new CartDto();
        cartDto.products= cart.getAllProducts().stream().map(ProductDto::new).collect(Collectors.toSet());
        cartDto.totalPrice=cart.totalPrice();
        return cartDto;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Set<ProductDto> getProducts() {
        return Collections.unmodifiableSet(products);
    }
}
