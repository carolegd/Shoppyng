package fr.lacombe.cartbnp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
        Optional<Product> result = products.stream().filter(p -> p.getName() == name).findFirst();
        result.ifPresent(product -> products.remove(product));
        result.orElseThrow(() -> new ProductNotFoundInCart());

    }

    public double totalPrice() {
        if (products.isEmpty()) return 0.0;
        return products.stream()
                .map(Product::getPrice)
                .reduce(0.0, (a,b)->(a+b));
    }
}
