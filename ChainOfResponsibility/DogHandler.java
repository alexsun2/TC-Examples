// TC_TYPE: chain_of_responsibility

package ChainOfResponsibility;

public class DogHandler extends AbstractHandler {
    @Override
    public String handle(String request) {
        if ("MeatBall".equals(request)) {
            return "Dog: I'll eat the " + request;
        } else {
            return super.handle(request);
        }
    }
}