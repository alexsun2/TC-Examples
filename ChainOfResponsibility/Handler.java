// TC_TYPE: chain_of_responsibility

package ChainOfResponsibility;

/**
 * The Handler interface declares a method for building the chain of handlers.
 * It also declares a method for executing a request.
 */
public interface Handler {
    Handler setNext(Handler handler);
    String handle(String request);
}
