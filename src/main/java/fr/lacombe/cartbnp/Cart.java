package fr.lacombe.cartbnp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {

    private final ArrayList<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public void add(Product product) {
        products.add(product);
    }

    public void remove(String name) {
        Optional<Product> result = products.stream().filter(p -> p.getName() == name).findFirst();
        result.ifPresent(product -> products.remove(product));
        result.orElseThrow(() -> new ProductNotFoundInCart());

    }
}
