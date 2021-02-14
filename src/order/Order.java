package order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import customer.Customer;
import product.Product;

public class Order {
    
    //id
    long id;
    final List<Product> productsInOrder;
    final BigDecimal totalPrice;
    Optional<BigDecimal> discountPrice;
    final Customer customer;
    OrderState orderState;

    public static class OrderBuilder {
        List<Product> productsInOrder;
        BigDecimal totalPrice;
        Optional<BigDecimal> discountPrice;
        Customer customer;
        OrderState orderState;

        public OrderBuilder(List<Product> productsInorder, BigDecimal totalPrice, Customer customer) {
            this.productsInOrder = productsInorder;
            this.totalPrice = totalPrice;
            this.customer = customer;
        }

        public OrderBuilder setDiscountPrice(BigDecimal discountPrice) {
            this.discountPrice = Optional.ofNullable(discountPrice);
            return this;
        }

        public OrderBuilder setOrderState(OrderState orderState) {
            this.orderState = orderState;
            return this;
        }

        public Order createOrder() {
            return new Order(this);
        }
    }

    private Order(OrderBuilder builder) {
        productsInOrder = builder.productsInOrder;
        totalPrice = builder.totalPrice;
        discountPrice = builder.discountPrice;
        customer = builder.customer;
        orderState = builder.orderState;
    }

    public List<Product> getProductsInOrder() {
        return productsInOrder;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Optional<BigDecimal> getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Optional<BigDecimal> discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
}
