// TC_TYPE: model view controller

package MVC.JavaExample2;

public class Main {
    public static void main(String[] args) {
        // Create the model
        StudentModel model = retrieveStudentFromDatabase();

        // Create the view
        StudentView view = new StudentView();

        // Create the controller
        StudentController controller = new StudentController(model, view);

        // Display initial data
        controller.updateView();

        // Update model data
        controller.setStudentName("John");
        controller.setStudentRollNo("CS2025");

        // Re-display updated data
        controller.updateView();
    }

    private static StudentModel retrieveStudentFromDatabase() {
        StudentModel student = new StudentModel();
        student.setName("Alice");
        student.setRollNo("CS1010");
        return student;
    }
} 

