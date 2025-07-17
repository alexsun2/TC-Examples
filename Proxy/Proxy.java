// TC_TYPE: proxy

package Proxy;

/**
 * The Proxy has an interface identical to the RealSubject.
 */
public class Proxy implements Subject {
    private RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    /**
     * The most common applications of the Proxy pattern are lazy loading,
     * caching, controlling the access, logging, etc. A Proxy can perform one
     * of these things and then, depending on the result, pass the execution to
     * the same method in a linked RealSubject object.
     */
    @Override
    public void request() {
        if (checkAccess()) {
            realSubject.request();
            logAccess();
        }
    }

    public boolean checkAccess() {
        System.out.println("Proxy: Checking access prior to firing a real request.");
        return true;
    }

    public void logAccess() {
        System.out.print("Proxy: Logging the time of request.");
    }
}