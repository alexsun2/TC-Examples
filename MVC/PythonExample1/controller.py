from model import TaskModel
from MVC.PythonExample1.view import TaskView

class TaskController:
    def __init__(self):
        self.model = TaskModel()
        self.view = TaskView()

    def run(self):
        while True:
            user_input = self.view.get_user_input()
            if user_input == "quit":
                break
            self.model.add_task(user_input)
            self.view.show_tasks(self.model.get_tasks())