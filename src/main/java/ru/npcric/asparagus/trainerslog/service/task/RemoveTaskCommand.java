package ru.npcric.asparagus.trainerslog.service.task;

public class RemoveTaskCommand implements Command {
    private TaskManager taskManager;
    private String task;

    public RemoveTaskCommand(TaskManager taskManager, String task) {
        this.taskManager = taskManager;
        this.task = task;
    }

    @Override
    public void execute() {
        taskManager.removeTask(task);
    }
}
