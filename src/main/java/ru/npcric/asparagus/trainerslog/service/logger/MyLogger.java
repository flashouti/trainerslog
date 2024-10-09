package ru.npcric.asparagus.trainerslog.service.logger;

public interface MyLogger {
    void logInfo(String message);
    void logError(String message);
    void logWarning(String message);
}
