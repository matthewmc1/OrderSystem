package product;

import java.math.BigDecimal;
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

    public Product(String title, String description, BigDecimal price, Optional<BigDecimal> discountPrice, List<Category> categories, String cdnImageRef) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.discountPrice = discountPrice;
        this.category = categories;
        this.cdnImagerRef = cdnImageRef;
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

}
