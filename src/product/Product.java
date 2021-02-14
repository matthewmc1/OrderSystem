package product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Product {
    
    long id;
    final String title;
    String description;
    final BigDecimal price;
    Optional<BigDecimal> discountPrice;
    List<Category> category;
    //iamge should only contain link to location of CDN image = we want to avoid storing this in the database, 
    //we want to offload one of the most expensive parts.
    String cdnImagerRef;
    LocalDateTime lastOrderedTime;
    LocalDate productAdded;
    long quantity;
    boolean activeProduct;
    public static class ProductBuilder {
        final String title;
        String description;
        final BigDecimal price;
        List<Category> category;
        String cdnImagerRef;
        long quantity;
        boolean activeProduct;

        public ProductBuilder(String title, String description, BigDecimal price) {
            this.title = title;
            this.description = description;
            this.price = price;
        }

        public ProductBuilder setCategories(List<Category> categories) {
            this.category = categories;
            return this;
        }

        public ProductBuilder setQuantity(long quantity) {
            this.quantity = quantity;
            return this;
        }

        public ProductBuilder setCDNImageRef(String imageRef) {
            this.cdnImagerRef = imageRef;
            return this;
        }

        public ProductBuilder isProductActive(boolean active) {
            this.activeProduct = active;
            return this;
        }

        public Product create() {
            return new Product(this);
        }
 
    }

    private Product(ProductBuilder builder) {
        title = builder.title;
        description = builder.description;
        price = builder.price;
        category = builder.category;
        quantity = builder.quantity;
        cdnImagerRef = builder.cdnImagerRef;
        activeProduct = builder.activeProduct;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Optional<BigDecimal> getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Optional<BigDecimal> discountPrice) {
        this.discountPrice = discountPrice;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public String getCdnImagerRef() {
        return cdnImagerRef;
    }

    public void setCdnImagerRef(String cdnImagerRef) {
        this.cdnImagerRef = cdnImagerRef;
    }

    public LocalDateTime getLastOrderedTime() {
        return lastOrderedTime;
    }

    public void setLastOrderedTime(LocalDateTime lastOrderedTime) {
        this.lastOrderedTime = lastOrderedTime;
    }

    public LocalDate getProductAdded() {
        return productAdded;
    }

    public void setProductAdded(LocalDate productAdded) {
        this.productAdded = productAdded;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public boolean isActiveProduct() {
        return activeProduct;
    }

    public void setActiveProduct(boolean activeProduct) {
        this.activeProduct = activeProduct;
    }
}
