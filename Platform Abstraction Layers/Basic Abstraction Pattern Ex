# TC_TYPE: abstraction_layer

# Define the abstraction
class Operation:
    def execute(self):
        pass

# Concrete implementation
class RealOperation(Operation):
    def execute(self):
        # actual logic hidden behind the abstraction
        ...

# Core logic depending only on abstraction
class TaskRunner:
    def __init__(self, operation: Operation):
        self.operation = operation

    def run(self):
        self.operation.execute()
