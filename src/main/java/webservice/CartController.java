package webservice;

import fr.lacombe.cartbnp.Cart;
import fr.lacombe.cartbnp.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class CartController {
    @RequestMapping("/cart")
    public CartDto getCart() {

        Cart cart = getCurrentCart();
        CartDto cartDto = CartDto.mapper(cart);
        return  cartDto;
    }

    private Cart getCurrentCart() {
        Cart cart = new Cart();
        cart.add(new Product("My Book", 33.));
        cart.add(new Product("Apple IPAD", 933.));
        cart.add(new Product("Pencil", 3.));
        cart.add(new Product("Paper Booklet", 7.8 ));
        return cart;
    }
}
