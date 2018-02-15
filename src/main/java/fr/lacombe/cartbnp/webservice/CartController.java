package fr.lacombe.cartbnp.webservice;

import fr.lacombe.cartbnp.Domain.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.lacombe.cartbnp.service.CartService;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/cart")
    public CartDto getCart() {

        Cart cart = cartService.getCurrentCart();
        return CartMapper.map(cart);
    }

}
