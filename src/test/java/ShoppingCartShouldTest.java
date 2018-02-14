import fr.lacombe.cartbnp.Cart;
import fr.lacombe.cartbnp.Product;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ShoppingCartShouldTest {
    @Test
    public void givenNoProductAdded_EmptyCart() throws Exception {
        Cart cart = new Cart();
        Assertions.assertThat(cart.getAllProducts()).isEmpty();
    }

    @Test
    public void givenEmptyCartProductAdded_CartWithProduct() throws Exception {
        Cart cart = new Cart();
        cart.add(new Product("chair"));
        Assertions.assertThat(cart.getAllProducts()).hasSize(1);
    }

    @Test
    public void givenEmptyCartTwoProductsAdded_CartWithTwoProducts() throws Exception {
        Cart cart = new Cart();
        cart.add(new Product("chair"));
        cart.add(new Product("table"));
        Assertions.assertThat(cart.getAllProducts()).hasSize(2);
    }

    @Test
    public void givenMultipleProductsProductDeleted_CartWithoutDeletedProduct() throws Exception {
        Cart cart = new Cart();
        cart.add(new Product("chair"));
        cart.add(new Product("table"));
        cart.add(new Product("vase"));
        cart.remove("vase");
        Assertions.assertThat(cart.getAllProducts()).hasSize(2);
    }


}
