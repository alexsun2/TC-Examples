// TC_TYPE: model_view_controller

package MVC.JavaExample1;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class that manages the list of tasks
 */
public class TaskModel {
    private List<String> tasks;

    public TaskModel() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public List<String> getTasks() {
        return tasks;
    }
}
