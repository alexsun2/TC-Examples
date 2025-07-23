// TC_TYPE: strategy

package Strategy.JavaExample2;

// Concrete Strategy Classes: These are the different algorithms that implement the strategy interface.
public class PayPalPaymentStrategy implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPaymentStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " paid using PayPal.");
    }
}