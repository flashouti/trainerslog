package ru.npcric.asparagus.trainerslog.service.logger;

public class LoggerChain {
    private Logger loggerChain;

    public LoggerChain() {
        Logger consoleLogger = new ConsoleLogger(LogLevel.DEBUG);
        Logger fileLogger = new FileLogger(LogLevel.INFO);
        Logger errorLogger = new ErrorLogger(LogLevel.ERROR);

        consoleLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(errorLogger);

        this.loggerChain = consoleLogger;
    }

    public void log(LogLevel level, String message) {
        loggerChain.logMessage(level, message);
    }
}
