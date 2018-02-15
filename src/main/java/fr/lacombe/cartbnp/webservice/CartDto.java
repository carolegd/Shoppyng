package fr.lacombe.cartbnp.webservice;

import java.util.Collections;
import java.util.Set;

public class CartDto {
    private Set<ProductDto> products;
    private double totalPrice;
    public CartDto(){
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public Set<ProductDto> getProducts() {
        return Collections.unmodifiableSet(products);
    }

    public void setProducts(Set<ProductDto> products) {
        this.products = products;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
