// TC_TYPE: strategy

package Strategy.JavaExample2;

// Context Class: This class holds a reference to the selected strategy and provides a method to change it.
public class ShoppingCart {
  private PaymentStrategy paymentStrategy;

  public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
    this.paymentStrategy = paymentStrategy;
  }

  public void checkout(double amount) {
    paymentStrategy.pay(amount);
  }
}
