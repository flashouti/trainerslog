package ru.npcric.asparagus.trainerslog.service.logger;

import java.util.logging.Logger;

//Паттерн Adapter
public class LoggerAdapter implements MyLogger {
    private final Logger logger;

    public LoggerAdapter(Class<?> clazz) {
        this.logger = Logger.getLogger(clazz.getName());

    }

    @Override
    public void logInfo(String message) {
        logger.info(message);
    }

    @Override
    public void logError(String message) {
        logger.severe(message);
    }

    @Override
    public void logWarning(String message){
        logger.warning(message);
    }
}
