// TC_TYPE: proxy

package Proxy.JavaExample1;

/**
 * The client code is supposed to work with all objects (both subjects and
 * proxies) via the Subject interface in order to support both real subjects
 * and proxies. In real life, however, clients mostly work with their real
 * subjects directly. In this case, to implement the pattern more easily, you
 * can extend your proxy from the real subject's class.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Client: Executing the client code with a real subject:");
        Subject realSubject = new RealSubject();
        clientCode(realSubject);

        System.out.println();

        System.out.println("Client: Executing the same client code with a proxy:");
        Subject proxy = new Proxy((RealSubject) realSubject);
        clientCode(proxy);
    }

    // ...
    public static void clientCode(Subject subject) {
        // ...
        subject.request();
        // ...
    }
}
