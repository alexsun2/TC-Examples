// TC_TYPE: chain_of_responsibility

package ChainOfResponsibility.JavaExample1;

/**
 * All Concrete Handlers either handle a request or pass it to the next handler in
 * the chain.
 */
public class MonkeyHandler extends AbstractHandler {
    @Override
    public String handle(String request) {
        if ("Banana".equals(request)) {
            return "Monkey: I'll eat the " + request;
        } else {
            return super.handle(request);
        }
    }
}