class TaskView:
    def show_tasks(self, tasks):
        print("Current Tasks:")
        for i, task in enumerate(tasks, 1):
            print(f"{i}. {task}")

    def get_user_input(self):
        return input("Enter a new task (or 'quit' to exit): ")