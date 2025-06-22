package tms;

public class Main {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task("T001", "Prepare report", "Pending"));
        taskList.addTask(new Task("T002", "Call client", "Completed"));
        taskList.addTask(new Task("T003", "Update website", "In Progress"));

        System.out.println("All Tasks:");
        taskList.displayTasks();

        System.out.println("\nSearching for task T002:");
        Task task = taskList.searchTask("T002");
        if (task != null) {
            System.out.println("Found: " + task);
        }

        System.out.println("\nDeleting task T001...");
        taskList.deleteTask("T001");

        System.out.println("\nTasks after deletion:");
        taskList.displayTasks();
    }
}
