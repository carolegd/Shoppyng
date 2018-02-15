package fr.lacombe.cartbnp.webservice;

import fr.lacombe.cartbnp.domain.Cart;
import fr.lacombe.cartbnp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
