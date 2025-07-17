package Template;

/**
 * The AbstractClass defines a template method that contains the skeleton of
 * an algorithm, composed of calls to (usually) abstract primitive operations.
 * Concrete subclasses should implement these operations, but leave the
 * template method itself intact.
 */
abstract class AbstractClass {

    /**
     * The template method defines the skeleton of an algorithm. It calls the
     * necessary operations in the order required for the algorithm to function.
     */
    public void templateMethod() {
        baseOperation1();
        requiredOperation1();
        baseOperation2();
        hook1();
        requiredOperation2();
        baseOperation3();
        hook2();
    }

    /**
     * Base operation 1 that has a default implementation.
     */
    public void baseOperation1() {
        System.out.println("AbstractClass says: I am doing the bulk of the work");
    }

    /**
     * Base operation 2 that has a default implementation.
     */
    public void baseOperation2() {
        System.out.println("AbstractClass says: But I let subclasses override some operations");
    }

    /**
     * Base operation 3 that has a default implementation.
     */
    public void baseOperation3() {
        System.out.println("AbstractClass says: But I am doing the bulk of the work anyway");
    }

    /**
     * Abstract method that subclasses must implement to define their required
     * operation 1.
     */
    public abstract void requiredOperation1();

    /**
     * Abstract method that subclasses must implement to define their required
     * operation 2.
     */
    public abstract void requiredOperation2();

    /**
     * Hook1 is a method that provides an extension point for subclasses. It
     * can be overridden, but it has a default implementation.
     */
    public void hook1() {
    }

    /**
     * Hook2 is another extension point for subclasses. It can be overridden,
     * but it has a default implementation.
     */
    public void hook2() {
    }
}

/**
 * ConcreteClass1 implements all abstract methods and uses the base operations
 * with no changes.
 */
class ConcreteClass1 extends AbstractClass {

    /**
     * Implements requiredOperation1 for ConcreteClass1.
     */
    @Override
    public void requiredOperation1() {
        System.out.println("ConcreteClass1 says: Implemented Operation1");
    }

    /**
     * Implements requiredOperation2 for ConcreteClass1.
     */
    @Override
    public void requiredOperation2() {
        System.out.println("ConcreteClass1 says: Implemented Operation2");
    }
}

/**
 * ConcreteClass2 implements all abstract methods and overrides one of the
 * hooks.
 */
class ConcreteClass2 extends AbstractClass {

    /**
     * Implements requiredOperation1 for ConcreteClass2.
     */
    @Override
    public void requiredOperation1() {
        System.out.println("ConcreteClass2 says: Implemented Operation1");
    }

    /**
     * Implements requiredOperation2 for ConcreteClass2.
     */
    @Override
    public void requiredOperation2() {
        System.out.println("ConcreteClass2 says: Implemented Operation2");
    }

    /**
     * Overrides the hook1 method to provide custom behavior.
     */
    @Override
    public void hook1() {
        System.out.println("ConcreteClass2 says: Overridden Hook1");
    }
}

/**
 * The client code demonstrates how the Template Method pattern allows
 * different subclasses to implement specific behavior while using the same
 * template method for the overall structure of the algorithm.
 */
public class TemplateMethodPatternExample {

    /**
     * The client code calls the template method to execute the algorithm.
     * Client code does not need to know the concrete class of the object
     * it works with, as long as it works through the base class interface.
     * 
     * @param abstractClass The abstract class object that will execute the
     *                      template method.
     */
    public static void clientCode(AbstractClass abstractClass) {
        abstractClass.templateMethod();
    }

    /**
     * The main method demonstrates the Template Method pattern.
     * It works with different concrete subclasses without needing to know
     * their specific implementations.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("Same client code can work with different subclasses:");
        clientCode(new ConcreteClass1());
        System.out.println("");

        System.out.println("Same client code can work with different subclasses:");
        clientCode(new ConcreteClass2());
    }
}
