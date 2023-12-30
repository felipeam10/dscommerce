package com.felipe.dscommerce.tests;

import com.felipe.dscommerce.entities.Category;
import com.felipe.dscommerce.entities.Product;

public class ProductFactory {

    public static Product createProduct() {
        Category category = CategoryFactory.createCategory();
        Product product = new Product(1L, "Phone", "Good phone", 800.0, "https://img.com/img.png");
        product.getCategories().add(category);
        return product;
    }

    public static Product createProduct(String name) {
        Product product = createProduct();
        product.setName(name);
        return product;
    }

}
