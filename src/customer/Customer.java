package customer;

import java.math.BigDecimal;

import card.Card;

public class Customer {
    
    //id
    long id;
    String forename;
    String surname;
    String address;
    String postcode;
    CustomerTypes type;
    Card card;
    BigDecimal spendLimitPerMonth;
    
    public static class CustomerBuilder {
        String forename;
        String surname;
        String address;
        String postcode;
        CustomerTypes type;
        Card card;
        BigDecimal spendLimitPerMonth;

        public CustomerBuilder(String forname, String surname) {
            this.forename = forname;
            this.surname = surname;
        }

        public CustomerBuilder setCustomerAddress(String address, String postcode) {
            this.address = address;
            this.postcode = postcode;
            return this;
        }

        public CustomerBuilder setCustomerType(CustomerTypes type) {
            this.type = type;
            return this;
        }

        public CustomerBuilder setCard(Card card) {
            this.card = card;
            return this;
        }

        public CustomerBuilder setCustomersSpendLimit(BigDecimal spendLimit) {
            this.spendLimitPerMonth = spendLimit;
            return this;
        }

        public Customer createCustomer() {
            return new Customer(this);
        }
        
    }

    public Customer(CustomerBuilder builder) {
        forename = builder.forename;
        surname = builder.surname;
        address = builder.address;
        postcode = builder.postcode;
        type = builder.type;
        card = builder.card;
        spendLimitPerMonth = builder.spendLimitPerMonth;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public CustomerTypes getType() {
        return type;
    }

    public void setType(CustomerTypes type) {
        this.type = type;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public BigDecimal getSpendLimitPerMonth() {
        return spendLimitPerMonth;
    }

    public void setSpendLimitPerMonth(BigDecimal spendLimitPerMonth) {
        this.spendLimitPerMonth = spendLimitPerMonth;
    }

}
