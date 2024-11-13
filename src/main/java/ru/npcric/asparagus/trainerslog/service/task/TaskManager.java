package ru.npcric.asparagus.trainerslog.service.task;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<String> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void removeTask(String task) {
        tasks.remove(task);
        System.out.println("Task removed: " + task);
    }

    public List<String> getTasks() {
        return tasks;
    }
}

