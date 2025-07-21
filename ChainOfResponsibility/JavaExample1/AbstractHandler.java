// TC_TYPE: chain_of_responsibility

package ChainOfResponsibility.JavaExample1;

/**
 * The default chaining behavior can be implemented inside a base handler
 * class.
 */
public abstract class AbstractHandler implements Handler {

    protected Handler nextHandler;

    @Override
    public Handler setNext(Handler handler) {
        this.nextHandler = handler;
        // Returning a handler from here will let us link handlers in a
        // convenient way like this:
        // monkey.setNext(squirrel).setNext(dog)
        return handler;
    }

    @Override
    public String handle(String request) {
        if (nextHandler != null) {
            return nextHandler.handle(request);
        }

        return null;
    }
}