// TC_TYPE: adapter

package Adapter;

/*
 * The client code supports all classes that follow the Target interface.
 */
public class Main {
  public static void main(String[] args) {
    System.out.println("Client: I can work just fine with the Target objects:");
    Target target = new Target() {
      @Override
      public String request() {
        return "Target: The default target's behavior.";
      }
    };
    clientCode(target);
    System.out.println("\n");

    Adaptee adaptee = new Adaptee();
    System.out.println("Client: The Adaptee class has a weird interface. "
                      + "See, I don't understand it:");
    System.out.println("Adaptee: " + adaptee.specificRequest());
    System.out.println();

    System.out.println("Client: But I can work with it via the Adapter:");
    Target adapter = new Adapter(adaptee);
    clientCode(adapter);
  }

  public static void clientCode(Target target) {
    System.out.print(target.request());
  }
}