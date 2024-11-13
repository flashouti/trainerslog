package ru.npcric.asparagus.trainerslog.service.task;

public class Usage {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Invoker invoker = new Invoker();

        Command addTask1 = new AddTaskCommand(taskManager, "Learn Java");
        Command addTask2 = new AddTaskCommand(taskManager, "Implement Command Pattern");
        Command removeTask1 = new RemoveTaskCommand(taskManager, "Learn Java");

        invoker.executeCommand(addTask1);
        invoker.executeCommand(addTask2);
        invoker.executeCommand(removeTask1);

        System.out.println("Current tasks: " + taskManager.getTasks());
    }
}
