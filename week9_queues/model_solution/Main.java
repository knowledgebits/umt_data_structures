import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TaskProcessing taskProcessing = new TaskProcessing();

        taskProcessing.addTask("Task 1", "Do task 1", 1, LocalDate.of(2023, 5, 15));
        taskProcessing.addTask("Task 2", "Do task 2", 2, LocalDate.of(2023, 5, 17));
        taskProcessing.addTask("Task 3", "Do task 3", 3, LocalDate.of(2023, 5, 20));
        taskProcessing.viewCompletedTasks();
        taskProcessing.deleteTask(1);
        taskProcessing.viewCompletedTasks();
        taskProcessing.markAsComplete(0);
        taskProcessing.viewCompletedTasks();
        taskProcessing.undoLastAction();
        taskProcessing.viewCompletedTasks();
    }
}
