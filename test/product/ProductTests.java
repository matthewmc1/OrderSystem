import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import product.Category;
import product.Product;
import product.Product.ProductBuilder;

public class ProductTests {

    static List<Product> allProducts = new ArrayList<>();

    static Product pr1 = new ProductBuilder("Inactive Beauty Product", "des", BigDecimal.valueOf(10.50)).setCategories(List.of(Category.BEAUTY, Category.TOP))
            .isProductActive(false).create();

    static Product pr2 = new ProductBuilder("Active Clothing Product", "des", BigDecimal.valueOf(18.50)).setCategories(List.of(Category.CLOTHING, Category.TOP))
            .isProductActive(true).create();

    static Product pr3 = new ProductBuilder("Active Outwear Product", "des", BigDecimal.valueOf(100.50)).setCategories(List.of(Category.OUTERWEAR, Category.TOP))
            .isProductActive(true).create();


    public static List<Product> getAllInActiveProducts() {
        List<Product> allActiveProducts = allProducts; 
        return allActiveProducts.stream().filter(product -> !product.isActiveProduct()).collect(Collectors.toList());
    }

    public static List<Product> getAllActiveProducts() {
        List<Product> allActiveProducts = allProducts; 
        return allActiveProducts.stream().filter(Product::isActiveProduct).collect(Collectors.toList());
    }

    public static List<Product> getAllActiveProductsByCatoregory(Category category) {
        return getAllActiveProducts().stream().filter(product -> product.getCategory().contains(category))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        allProducts.add(pr1);
        allProducts.add(pr2);
        allProducts.add(pr3);

        List<Product> allActiveProducts = getAllActiveProducts();
        allActiveProducts.forEach(product -> System.out.println(product.getTitle()));

        List<Product> allInactiveProducts = getAllInActiveProducts();
        allInactiveProducts.forEach(product -> System.out.println(product.getTitle()));

        List<Product> productsByCategory = getAllActiveProductsByCatoregory(Category.CLOTHING);
        productsByCategory.forEach(product -> System.out.println(product.getTitle()));
    }
}
