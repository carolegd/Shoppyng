package webservice;

import fr.lacombe.cartbnp.Product;

public class ProductDto {
    private final String name;
    private final double price;

    ProductDto(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
