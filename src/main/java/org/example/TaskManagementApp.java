package org.example;

import org.example.service.TaskManager;

import java.util.Scanner;

public class TaskManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println();
            System.out.println("Task Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Display Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            System.out.println();

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskManager.addTask(description);
                    break;
                case 2:
                    System.out.print("Enter task index to mark as completed: ");
                    int index = scanner.nextInt();
                    taskManager.markTaskAsCompleted(index - 1);
                    break;
                case 3:
                    taskManager.displayTasks();
                    break;
                case 4:
                    System.out.println("Exiting Task Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}