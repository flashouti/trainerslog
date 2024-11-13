package ru.npcric.asparagus.trainerslog.service.task;

public class AddTaskCommand implements Command{
    private TaskManager taskManager;
    private String task;

    public AddTaskCommand(TaskManager taskManager, String task) {
        this.taskManager = taskManager;
        this.task = task;
    }

    @Override
    public void execute() {
        taskManager.addTask(task);
    }
}
