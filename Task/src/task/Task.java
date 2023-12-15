// Antonio Fabrizio
// November 15th 2023
// Lab 9: to-do list
// This program implements a class Task, which is used to represent a job that should be done.
package task;

import java.time.LocalDateTime;

public class Task {
    private String name;
    private int priority;
    private int estMinsToComplete;
    private LocalDateTime whenDue;

    // Constructors
    public Task(String name, int priority, int estMinsToComplete) {
        this.name = name;
        this.priority = priority;
        this.estMinsToComplete = estMinsToComplete;
    }

    public Task(String name, int priority, LocalDateTime whenDue, int estMinsToComplete) {
        this(name, priority, estMinsToComplete);
        this.whenDue = whenDue;
    }

    // Accessor methods
    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int getEstMinsToComplete() {
        return estMinsToComplete;
    }

    public LocalDateTime getWhenDue() {
        return whenDue;
    }

    // Mutator methods
    public void setName(String name) {
        this.name = name;
    }

    public void setEstMinsToComplete(int estMinsToComplete) {
        this.estMinsToComplete = estMinsToComplete;
    }

    // Increase priority, ignoring negative values
    public void increasePriority(int amount) {
        if (amount > 0) {
            this.priority += amount;
        }
    }

    // Decrease priority, ensuring it doesn't go below 0
    public void decreasePriority(int amount) {
        this.priority = Math.max(0, this.priority - amount);
    }

    // Check if the task is overdue
    public boolean overdue() {
        if (whenDue == null) {
            return false; // Not applicable if no due date is set
        }
        return LocalDateTime.now().isAfter(whenDue);
    }

    // String representation of the Task
    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                ", estMinsToComplete=" + estMinsToComplete +
                ", whenDue=" + whenDue +
                '}';
    }

    // Driver program to test the Task class
    public static void main(String[] args) {
        Task doMyHW = new Task("Finish 1068 homework", 3, 120);
        System.out.println(doMyHW);

        Task postHW = new Task("Post 1068 homework", 1, LocalDateTime.of(2023, 3, 23, 13, 0), 180);
        System.out.println(postHW);

        // Testing mutator methods
        doMyHW.setName("Complete coding assignment");
        doMyHW.setEstMinsToComplete(90);
        doMyHW.increasePriority(2);
        doMyHW.decreasePriority(1);

        System.out.println(doMyHW);

        // Testing overdue method
        System.out.println("Is postHW overdue? " + postHW.overdue());
    }
}