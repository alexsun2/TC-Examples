// TC_TYPE: adapter

package Adapter;

// The Target defines the domain-specific interface used by the client code.
public interface Target {
  // The interface expected by the client
  String request();
}
