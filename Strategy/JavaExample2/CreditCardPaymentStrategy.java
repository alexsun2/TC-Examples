// TC_TYPE: strategy

package Strategy.JavaExample2;

// Concrete Strategy Classes: These are the different algorithms that implement the strategy interface.
public class CreditCardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCardPaymentStrategy(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " paid with credit/debit card.");
    }
}