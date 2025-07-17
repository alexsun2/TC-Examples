// TC_TYPE: adapter

package Adapter;

/*
 * The Adaptee contains some useful behavior, but its interface is incompatible
 * with the existing client code. The Adaptee needs some adaptation before the
 * client code can use it.
 */
public class Adaptee {
  // Incompatible interface (e.g., legacy or external class)
  public String specificRequest() {
    return ".eetpadA eht fo roivaheb laicepS";
  }
}