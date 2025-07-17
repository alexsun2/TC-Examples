// TC_TYPE: model_view_controller

package MVC;

/**
 * Controller class that connects the model and view
 */
public class TaskController {
    private TaskModel model;
    private TaskView view;

    public TaskController() {
        model = new TaskModel();
        view = new TaskView();
    }

    public void run() {
        while (true) {
            String userInput = view.getUserInput();
            if ("quit".equalsIgnoreCase(userInput)) {
                break;
            }
            model.addTask(userInput);
            view.showTasks(model.getTasks());
        }
    }
}
