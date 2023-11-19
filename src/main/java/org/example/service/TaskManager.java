package org.example.service;

import org.example.model.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private static final String FILE_NAME = "tasks.txt";

    public TaskManager() {
        this.tasks = new ArrayList<>();
        loadTasks();
    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        tasks.add(newTask);
        saveTasks();
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsCompleted();
            saveTasks();
        }
    }
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println(i + 1 + ". " + task.getDescription() + " - Completed: " + task.isCompleted());
            }
        }
    }

    private void saveTasks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tasks.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTasks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            tasks = (List<Task>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // File doesn't exist or couldn't be read, no problem, start with an empty list
            tasks = new ArrayList<>();
        }
    }
}
