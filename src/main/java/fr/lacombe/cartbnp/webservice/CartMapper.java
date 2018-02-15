package fr.lacombe.cartbnp.webservice;

import fr.lacombe.cartbnp.domain.Cart;

import java.util.stream.Collectors;

public class CartMapper {
    public static CartDto map(Cart cart){
        CartDto cartDto = new CartDto();
        cartDto.setProducts(cart.getAllProducts().stream().map(ProductDto::new).collect(Collectors.toSet()));
        cartDto.setTotalPrice(cart.totalPrice());
        return cartDto;
    }
}
