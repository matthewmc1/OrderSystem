package card;

import java.time.LocalDate;
import java.util.Random;

public class Card {
    
    //autogen
    long id;
    String nameOnCard;
    final long cardNumber;
    final LocalDate expires;
    final String issueNumber;
    final CardTypes cardTypes;

    public static class CardBuilder {

        final String nameOnCard;
        final long cardNumber;
        final LocalDate expires;
        String issueNumber;
        final CardTypes cardTypes;

        public CardBuilder(String nameOnCard, long cardNumber, LocalDate expires, CardTypes cardTypes) {
            this.nameOnCard = nameOnCard;
            this.cardNumber = cardNumber;
            this.expires = expires;
            this.cardTypes = cardTypes;
        }


        public CardBuilder setCardIssueNumber(String issueNumber) {
            this.issueNumber = issueNumber;
            return this;
        }

        public Card createCard() {
            return new Card(this);
        }
    }


    private Card(CardBuilder builder) {
        id = new Random(1).nextInt(20000);
        nameOnCard = builder.nameOnCard;
        cardNumber = builder.cardNumber;
        expires = builder.expires;
        issueNumber = builder.issueNumber;
        cardTypes = builder.cardTypes;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public LocalDate getExpires() {
        return expires;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public CardTypes getCardTypes() {
        return cardTypes;
    }

}
