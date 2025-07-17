// TC_TYPE: adapter

package Adapter;

/*
 * The Adapter makes the Adaptee's interface compatible with the Target's
 * interface via multiple inheritance.
 */
public class Adapter implements Target {
  private final Adaptee adaptee;

  public Adapter(Adaptee adaptee) {
    this.adaptee = adaptee;
  }

  @Override
  public String request() {
    // Reverse the string to simulate "translation"
    return "Adapter: (TRANSLATED) " + new StringBuilder(adaptee.specificRequest()).reverse();
  }
}
