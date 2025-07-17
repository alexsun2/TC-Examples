// TC_TYPE: model_view_controller

package MVC;

import java.util.List;
import java.util.Scanner;

/**
 * View class responsible for user interaction
 */
public class TaskView {
    private Scanner scanner = new Scanner(System.in);

    public void showTasks(List<String> tasks) {
        System.out.println("Current Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public String getUserInput() {
        System.out.print("Enter a new task (or 'quit' to exit): ");
        return scanner.nextLine();
    }
}