package JavaExample1;
import java.util.List;

/**
 * The Component interface declares an `accept` method that should take the
 * base visitor interface as an argument.
 */
interface Component {
    /**
     * Accepts a visitor to allow the visitor to perform operations on this
     * component.
     * 
     * @param visitor The visitor to accept.
     */
    void accept(Visitor visitor);
}

/**
 * ConcreteComponentA implements the Component interface and defines its own
 * specific behavior.
 */
class ConcreteComponentA implements Component {
    /**
     * Accepts a visitor and delegates the call to the visitor's corresponding
     * method.
     * 
     * @param visitor The visitor to accept.
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteComponentA(this);
    }

    /**
     * This is a special method unique to ConcreteComponentA.
     * 
     * @return A string indicating the method belongs to ConcreteComponentA.
     */
    public String exclusiveMethodOfConcreteComponentA() {
        return "A";
    }
}

/**
 * ConcreteComponentB implements the Component interface and defines its own
 * specific behavior.
 */
class ConcreteComponentB implements Component {
    /**
     * Accepts a visitor and delegates the call to the visitor's corresponding
     * method.
     * 
     * @param visitor The visitor to accept.
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteComponentB(this);
    }

    /**
     * This is a special method unique to ConcreteComponentB.
     * 
     * @return A string indicating the method belongs to ConcreteComponentB.
     */
    public String specialMethodOfConcreteComponentB() {
        return "B";
    }
}

/**
 * The Visitor interface declares a set of visiting methods that correspond to
 * component classes. These methods allow the visitor to perform operations on
 * specific component classes.
 */
interface Visitor {
    /**
     * Visit method for ConcreteComponentA.
     * 
     * @param element The ConcreteComponentA to visit.
     */
    void visitConcreteComponentA(ConcreteComponentA element);

    /**
     * Visit method for ConcreteComponentB.
     * 
     * @param element The ConcreteComponentB to visit.
     */
    void visitConcreteComponentB(ConcreteComponentB element);
}

/**
 * ConcreteVisitor1 implements the Visitor interface and defines the operations
 * to be performed on ConcreteComponentA and ConcreteComponentB.
 */
class ConcreteVisitor1 implements Visitor {
    /**
     * Performs an operation on ConcreteComponentA.
     * 
     * @param element The ConcreteComponentA to visit.
     */
    @Override
    public void visitConcreteComponentA(ConcreteComponentA element) {
        System.out.println(element.exclusiveMethodOfConcreteComponentA() + " + ConcreteVisitor1");
    }

    /**
     * Performs an operation on ConcreteComponentB.
     * 
     * @param element The ConcreteComponentB to visit.
     */
    @Override
    public void visitConcreteComponentB(ConcreteComponentB element) {
        System.out.println(element.specialMethodOfConcreteComponentB() + " + ConcreteVisitor1");
    }
}

/**
 * ConcreteVisitor2 implements the Visitor interface and defines different
 * operations to be performed on ConcreteComponentA and ConcreteComponentB.
 */
class ConcreteVisitor2 implements Visitor {
    /**
     * Performs a different operation on ConcreteComponentA.
     * 
     * @param element The ConcreteComponentA to visit.
     */
    @Override
    public void visitConcreteComponentA(ConcreteComponentA element) {
        System.out.println(element.exclusiveMethodOfConcreteComponentA() + " + ConcreteVisitor2");
    }

    /**
     * Performs a different operation on ConcreteComponentB.
     * 
     * @param element The ConcreteComponentB to visit.
     */
    @Override
    public void visitConcreteComponentB(ConcreteComponentB element) {
        System.out.println(element.specialMethodOfConcreteComponentB() + " + ConcreteVisitor2");
    }
}

/**
 * The client code demonstrates how the Visitor pattern allows visitors to
 * operate on various component classes without needing to know their concrete
 * types.
 */
public class VisitorPatternExample {

    /**
     * The client code can execute visitor operations on a list of components.
     * It delegates the operation to the components via the accept method.
     * 
     * @param components The list of components to visit.
     * @param visitor    The visitor to apply to the components.
     */
    public static void clientCode(List<Component> components, Visitor visitor) {
        for (Component component : components) {
            component.accept(visitor);
        }
    }

    /**
     * The main method to demonstrate the Visitor pattern.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a list of components
        List<Component> components = List.of(new ConcreteComponentA(), new ConcreteComponentB());

        // Demonstrate the use of different visitors
        System.out.println("The client code works with all visitors via the base Visitor interface:");
        Visitor visitor1 = new ConcreteVisitor1();
        clientCode(components, visitor1);

        System.out.println("It allows the same client code to work with different types of visitors:");
        Visitor visitor2 = new ConcreteVisitor2();
        clientCode(components, visitor2);
    }
}
