// TC_TYPE: chain_of_responsibility

package ChainOfResponsibility;

public class Main {

    /**
     * The client code is usually suited to work with a single handler. In most
     * cases, it is not even aware that the handler is part of a chain.
     */
    public static void clientCode(Handler handler) {
        String[] foods = {"Nut", "Banana", "Cup of coffee"};

        for (String food : foods) {
            System.out.println("\nClient: Who wants a " + food + "?");
            String result = handler.handle(food);

            if (result != null) {
                System.out.print("  " + result);
            } else {
                System.out.print("  " + food + " was left untouched.");
            }
        }
    }

    public static void main(String[] args) {
        Handler monkey = new MonkeyHandler();
        Handler squirrel = new SquirrelHandler();
        Handler dog = new DogHandler();

        monkey.setNext(squirrel).setNext(dog);

        // The client should be able to send a request to any handler, not just the
        // first one in the chain.
        System.out.println("Chain: Monkey > Squirrel > Dog");
        clientCode(monkey);
        System.out.println("\n");

        System.out.println("Subchain: Squirrel > Dog");
        clientCode(squirrel);
    }
}
