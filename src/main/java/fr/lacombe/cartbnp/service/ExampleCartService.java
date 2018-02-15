package fr.lacombe.cartbnp.service;

import fr.lacombe.cartbnp.Domain.Cart;
import fr.lacombe.cartbnp.Domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ExampleCartService implements CartService {

    @Override
    public Cart getCurrentCart() {
            Cart cart = new Cart();
            cart.add(new Product("My Book", 33.));
            cart.add(new Product("Apple IPAD", 933.));
            cart.add(new Product("Pencil", 3.));
            cart.add(new Product("Paper Booklet", 7.8));
            return cart;
    }
}
