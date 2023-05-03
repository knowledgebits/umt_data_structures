import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TaskProcessing {
    private LinkedList<Task> taskList;
    private Queue<Task> completedTasks;
    private Stack<TaskOperation> operationStack;

    public TaskProcessing() {
        taskList = new LinkedList<>();
        completedTasks = new LinkedList<>();
        operationStack = new Stack<>();
    }

    public void addTask(String title, String description, int priority, LocalDate dueDate) {
        Task task = new Task(title, description, priority, dueDate);
        taskList.add(task);
        operationStack.push(new TaskOperation(TaskOperationType.ADD, task));
    }

    public void deleteTask(int index) {
        Task task = taskList.get(index);
        taskList.remove(index);
        operationStack.push(new TaskOperation(TaskOperationType.DELETE, task));
    }

    public void editTask(int index, String newTitle, String newDescription, int newPriority, LocalDate newDueDate) {
        Task task = taskList.get(index);
        Task oldTask = new Task(task.getTitle(), task.getDescription(), task.getPriority(), task.getDueDate());
        task.setTitle(newTitle);
        task.setDescription(newDescription);
        task.setPriority(newPriority);
        task.setDueDate(newDueDate);
        operationStack.push(new TaskOperation(TaskOperationType.EDIT, oldTask, task));
    }

    public void markAsComplete(int index) {
        Task task = taskList.get(index);
        task.setCompleted(true);
        completedTasks.offer(task);
        operationStack.push(new TaskOperation(TaskOperationType.COMPLETE, task));
    }

    public void viewCompletedTasks() {
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks.");
        } else {
            System.out.println("Completed tasks:");
            for (Task task : completedTasks) {
                System.out.println(task.getTitle() + " (" + task.getDueDate() + ")");
            }
        }
    }

    public void undoLastAction() {
        if (operationStack.isEmpty()) {
            System.out.println("No actions to undo.");
        } else {
            TaskOperation lastOperation = operationStack.pop();
            switch (lastOperation.getType()) {
                case ADD:
                    taskList.remove(lastOperation.getTask());
                    break;
                case DELETE:
                    taskList.add(lastOperation.getTask());
                    break;
                case EDIT:
                    Task oldTask = lastOperation.getOldTask();
                    Task newTask = lastOperation.getTask();
                    int index = taskList.indexOf(newTask);
                    taskList.set(index, oldTask);
                    break;
                case COMPLETE:
                    Task task = lastOperation.getTask();
                    task.setCompleted(false);
                    completedTasks.remove(task);
                    break;
            }
        }
    }
}
