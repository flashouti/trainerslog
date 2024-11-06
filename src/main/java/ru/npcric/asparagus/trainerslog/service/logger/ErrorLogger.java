package ru.npcric.asparagus.trainerslog.service.logger;

class ErrorLogger extends Logger {
    public ErrorLogger(LogLevel level) {
        super(level);
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Logger: " + message);
    }
}
