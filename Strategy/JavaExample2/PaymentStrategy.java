// TC_TYPE: strategy

package Strategy.JavaExample2;

// The Strategy Interface: This interface declares a method that all concrete strategy classes will implement.  
// The strategy pattern requires a specific strategy interface.
public interface PaymentStrategy {
  void pay(double amount);
}