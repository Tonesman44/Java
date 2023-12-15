// Antonio Fabrizio
// November 15th 2023
// Lab 9: to-do list
// This program implements a class Task, which is used to represent a job that should be done.

package task;

public class HoneyDoList {
    private Task[] tasks;
    private int numTasks;
    private static final int INITIAL_CAPACITY = 10;

    // Constructor
    public HoneyDoList() {
        tasks = new Task[INITIAL_CAPACITY];
        numTasks = 0;
    }

    // String representation of the HoneyDoList
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numTasks; i++) {
            result.append(tasks[i]).append("\n");
        }
        return result.toString();
    }

    // Find the index of the first occurrence of a Task with the specified name (case-insensitive)
    public int find(String name) {
        for (int i = 0; i < numTasks; i++) {
            if (tasks[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    // Add a new Task to the list
    public void addTask(Task task) {
        if (numTasks == tasks.length) {
            // Array is full, create a new array with double the capacity
            Task[] newTasks = new Task[tasks.length * 2];
            System.arraycopy(tasks, 0, newTasks, 0, tasks.length);
            tasks = newTasks;
        }
        tasks[numTasks] = task;
        numTasks++;
    }

    // Calculate the total time required to complete all tasks
    public int totalTime() {
        int total = 0;
        for (int i = 0; i < numTasks; i++) {
            total += tasks[i].getEstMinsToComplete();
        }
        return total;
    }

    // Find the index of the task that should take the least amount of time to finish
    public int shortestTime() {
        if (numTasks == 0) {
            return -1;
        }

        int shortestIndex = 0;
        int shortestTime = tasks[0].getEstMinsToComplete();

        for (int i = 1; i < numTasks; i++) {
            int currentTaskTime = tasks[i].getEstMinsToComplete();
            if (currentTaskTime < shortestTime) {
                shortestTime = currentTaskTime;
                shortestIndex = i;
            }
        }

        return shortestIndex;
    }

    // Remove and return the Task at the specified index
    public Task completeTask(int index) {
        if (index < 0 || index >= numTasks) {
            return null;
        }

        Task completedTask = tasks[index];

        // Shift all subsequent tasks to the left
        for (int i = index; i < numTasks - 1; i++) {
            tasks[i] = tasks[i + 1];
        }

        // Set the last element to null and decrement numTasks
        tasks[numTasks - 1] = null;
        numTasks--;

        return completedTask;
    }

    // Get a reference to the Task at the specified index
    public Task getTask(int index) {
        if (index < 0 || index >= numTasks) {
            return null;
        }
        return tasks[index];
    }

    // Driver program to test the HoneyDoList class
    public static void main(String[] args) {
        HoneyDoList honeydo = new HoneyDoList();
        System.out.println("Initial List:");
        System.out.println(honeydo);

        Task task1 = new Task("Take aspirin", 1, 120);
        honeydo.addTask(task1);
        System.out.println("After Adding Task 1:");
        System.out.println(honeydo);

        Task task2 = new Task("Finish coding assignment", 3, 90);
        honeydo.addTask(task2);
        System.out.println("After Adding Task 2:");
        System.out.println(honeydo);

        int shortestTaskIndex = honeydo.shortestTime();
        System.out.println("Shortest Task Index: " + shortestTaskIndex);
        System.out.println("Shortest Task: " + honeydo.getTask(shortestTaskIndex));

        Task completedTask = honeydo.completeTask(0);
        System.out.println("Completed Task: " + completedTask);
        System.out.println("List after completing Task 1:");
        System.out.println(honeydo);
    }
}

