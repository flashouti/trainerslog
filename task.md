Задание 2. Singleton

В этом разделе описан класс Logger, который реализует паттерн проектирования Singleton

Причины выбора Singleton для класса Logger
1. Единая точка доступа:
Singleton гарантирует, что в приложении будет только один экземпляр Logger. Это упрощает управление доступом к логированию и предотвращает создание нескольких логгеров, которые могли бы конфликтовать друг с другом. 

2. Экономия ресурсов:
Создание множества экземпляров логгера может привести к избыточному потреблению ресурсов, особенно если логгер управляет подключениями к файловой системе или сетевым ресурсам. Singleton помогает избежать этого.

3. Удобство:
Реализация Logger с помощью Singleton гарантирует, что все логи будут записываться в одно место


Признаки реализации Singleton в классе Logger
1. Приватный конструктор

2. Статическое поле для хранения экземпляра
  
3. Статический метод для доступа к экземпляру

Реализация класса Logger

```
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Реализация паттерна Singleton
public class Logger {
    private static Logger instance;
    private static final String LOG_FILE_PATH = "application.log"; // Путь к файлу лога


    private Logger() {
    }

    // Метод для получения единственного экземпляра
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Метод для записи сообщений в лог
    public void log(String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logMessage = String.format("%s: %s%n", timestamp, message);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
            writer.write(logMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
