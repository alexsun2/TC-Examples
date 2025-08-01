// TC_TYPE: proxy

package Proxy.JavaExample1;

/**
 * The Subject interface declares common operations for both RealSubject and
 * the Proxy. As long as the client works with RealSubject using this
 * interface, you'll be able to pass it a proxy instead of a real subject.
 */
public interface Subject {
    void request();
}