package ru.npcric.asparagus.trainerslog.service.logger;

class FileLogger extends Logger {
    public FileLogger(LogLevel level) {
        super(level);
    }

    @Override
    protected void write(String message) {
        // Здесь можно добавить логику записи в файл
        System.out.println("File Logger: " + message);
    }
}
