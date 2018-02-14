import fr.lacombe.cartbnp.Cart;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ShoppingCartShouldTest {
    @Test
    public void givenNoProductAdded_EmptyCart() throws Exception {
        Cart cart = new Cart();
        Assertions.assertThat(cart.getAllProducts()).isEmpty();
    }
}
