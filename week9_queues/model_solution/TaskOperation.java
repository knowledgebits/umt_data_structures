enum TaskOperationType {
    ADD,
    DELETE,
    COMPLETE,
    EDIT
}

public class TaskOperation {
    private final TaskOperationType type;
    private final Task task;
    private final Task oldTask;

    public TaskOperation(TaskOperationType type, Task task) {
        this.type = type;
        this.task = task;
        this.oldTask = null;
    }

    public TaskOperation(TaskOperationType type, Task oldTask, Task newTask) {
        this.type = type;
        this.task = newTask;
        this.oldTask = oldTask;
    }

    public TaskOperationType getType() {
        return type;
    }

    public Task getTask() {
        return task;
    }

    public Task getOldTask() {
        return oldTask;
    }
}
