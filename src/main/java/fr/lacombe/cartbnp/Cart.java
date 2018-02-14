package fr.lacombe.cartbnp;

import java.util.*;

public class Cart {

    private final ArrayList<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public Set<Product> getAllProducts() {
        return new HashSet<>(products);
    }

    public void add(Product product) {
        products.add(product);
    }

    public void remove(String name) {
        Optional<Product> result = products.stream().filter(p -> Objects.equals(p.getName(), name)).findFirst();
        result.ifPresent(products::remove);
        result.orElseThrow(ProductNotFoundInCart::new);

    }

    public double totalPrice() {
        return products.stream()
                .map(Product::getPrice)
                .reduce(0.0, (a,b)->(a+b));
    }
}
