// TC_TYPE: chain_of_responsibility

package ChainOfResponsibility;

public class SquirrelHandler extends AbstractHandler {
    @Override
    public String handle(String request) {
        if ("Nut".equals(request)) {
            return "Squirrel: I'll eat the " + request;
        } else {
            return super.handle(request);
        }
    }
}
