import fr.lacombe.cartbnp.Cart;
import fr.lacombe.cartbnp.Product;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ShoppingCartGetPriceTest {
    @Test
    public void givenEmptyCart_PriceIsZero() throws Exception {
        Cart cart = new Cart();
        Assertions.assertThat(cart.totalPrice()).isEqualTo(0.0);
    }

    @Test
    public void givenOneProductCart_CartPriceIsProductPrice() throws Exception {
        Cart cart = new Cart();
        cart.add(new Product("book", 14.35 ));
        Assertions.assertThat(cart.totalPrice()).isEqualTo(14.35);
    }

    @Test
    public void givenSeveralProductsInCart_CartPriceIsSumOfProductPrices() throws Exception {
        Cart cart = new Cart();
        cart.add(new Product("book", 14.35));
        cart.add(new Product("vase", 80.0));
        cart.add(new Product("shelf", 30.40));
        cart.add(new Product("chair", 100.55));
        Assertions.assertThat(cart.totalPrice()).isEqualTo(14.35+80.0+30.40+100.55);
    }

    @Test
    public void givenDuplicateProductsInCart_CartPriceIsSumOfProductPrices() throws Exception {
        Cart cart = new Cart();
        cart.add(new Product("book", 14.35));
        cart.add(new Product("book", 14.35));
        cart.add(new Product("book", 14.35));
        cart.add(new Product("book", 14.35));
        Assertions.assertThat(cart.totalPrice()).isEqualTo(14.35*4);
    }


}
