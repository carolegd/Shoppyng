import fr.lacombe.cartbnp.Cart;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ShoppingCartGetPriceTest {
    @Test
    public void givenEmptyCart_PriceIsZero() throws Exception {
        Cart cart = new Cart();
        Assertions.assertThat(cart.totalPrice()).isEqualTo(0.0);
    }
}
