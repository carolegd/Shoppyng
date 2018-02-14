import fr.lacombe.cartbnp.Cart;
import fr.lacombe.cartbnp.Product;
import fr.lacombe.cartbnp.ProductNotFoundInCart;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Set;

public class ShoppingCartShouldTest {
    @Test
    public void givenNoProductAdded_EmptyCart() throws Exception {
        Cart cart = new Cart();

        Set<Product> allProducts = cart.getAllProducts();

        Assertions.assertThat(allProducts).isEmpty();
    }

    @Test
    public void givenEmptyCartProductAdded_CartWithProduct() throws Exception {
        Cart cart = new Cart();
        cart.add(new Product("chair"));

        Set<Product> allProducts = cart.getAllProducts();

        Assertions.assertThat(allProducts).hasSize(1);
    }

    @Test
    public void givenEmptyCartTwoProductsAdded_CartWithTwoProducts() throws Exception {
        Cart cart = new Cart();
        cart.add(new Product("chair"));
        cart.add(new Product("table"));


        Set<Product> allProducts = cart.getAllProducts();

        Assertions.assertThat(allProducts).hasSize(2);
    }

    @Test
    public void givenMultipleProductsProductDeleted_CartWithoutDeletedProduct() throws Exception {
        Cart cart = new Cart();
        cart.add(new Product("chair"));
        cart.add(new Product("table"));
        cart.add(new Product("vase"));

        cart.remove(new String("vase"));

        Assertions.assertThat(cart.getAllProducts()).hasSize(2);
    }

    @Test(expected = ProductNotFoundInCart.class)
    public void givenMultipleProductsDeleteNonExistentProduct_UnchangedCartAndErrorMessage() throws Exception {
        Cart cart = new Cart();
        cart.add(new Product("chair"));
        cart.add(new Product("table"));
        cart.add(new Product("vase"));

        cart.remove("shelf");

    }

    @Test
    public void givenDuplicateProductsInCart_ProductAppearOnlyOnce() throws Exception {
        Cart cart = new Cart();
        cart.add(new Product("chair"));
        cart.add(new Product("table"));
        cart.add(new Product("table"));
        cart.add(new Product("table"));

        Set<Product> allProducts = cart.getAllProducts();
        
        Assertions.assertThat(allProducts).hasSize(2);
    }
}
