# Задание 2. Singleton
В этом разделе описан класс Logger (ru.npcric.asparagus.trainerslog.service.logger), который реализует паттерн проектирования Singleton

## Причины выбора Singleton для класса Logger
1. Единая точка доступа:
Singleton гарантирует, что в приложении будет только один экземпляр Logger. Это упрощает управление доступом к логированию и предотвращает создание нескольких логгеров, которые могли бы конфликтовать друг с другом. 

2. Экономия ресурсов:
Создание множества экземпляров логгера может привести к избыточному потреблению ресурсов, особенно если логгер управляет подключениями к файловой системе или сетевым ресурсам. Singleton помогает избежать этого.

3. Удобство:
Реализация Logger с помощью Singleton гарантирует, что все логи будут записываться в одно место


## Признаки реализации Singleton в классе Logger
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
```


(Забыл на прошлой неделе обновить task.md файл для заданий 3 и 4, но коммиты были отправлены во время, ссылка на коммиты
https://github.com/flashouti/trainerslog/commit/15a4a13909110b04fe859cc91663f7e984fdb1df
https://github.com/flashouti/trainerslog/commit/49fd7ba4fdf761fda435c92dcc259f57199a6658)

# Задание 3. Prototype
(ru.npcric.asparagus.trainerslog.adapter.web.dto.request.filial)

## Причины выбора паттерна Prototype для класса FilialDTO
1. Упрощение создания объектов: Паттерн Prototype позволяет создавать новые объекты, копируя существующие. В нашем случае будет создавать много объектов класса FilialDTO
2. Избежание избыточного кода: Вместо повторного написания кода для инициализации новых объектов с одинаковыми значениями, мы можем просто использовать метод clone(), что делает код более чистым и понятным.
3. Изменяемость и гибкость: Если в будущем потребуется изменить структуру класса (например, добавить новые поля), достаточно будет обновить метод clone()

## Признаки реализации паттерна Singleton
1.  Метод clone(): Этот метод создает новый экземпляр FilialDTO, копируя значения полей из текущего объекта


# Задание 4. Static factory method 

## Причины выбора паттерна SFM для класса FilialEntity  
(ru.npcric.asparagus.trainerslog.domain)

1. Частое создание экзампляра с заданными полями (дефолтным именем для всех филлиалов, различаются только адреса) - удобно вынести в отдельный метод
2. Читаемость и гибкость кода

## Признаки реализации паттерна SFM
1. Приватный когнструктор класса FilialEntity
2. static метод getFilialWithDefaultName, возвращающий объект класса FilialEntity с определнными полями 


# Задание 5. Реализация паттерна Builder 
Реализовал паттерн Builder для класса TicketEntity в классе TicketBuilder в пакете ru.npcric.asparagus.trainerslog.domain

## Причины выбора паттерна Builder для класса TicketEntity
1. Есть вариация создания объектов с разными наборами полей - при реализации паттерна код становится более гибкий
2. Читаемость кода, сложная структура класса при использовании buildera воспринимается понятнее

## Признаки реализации 

1. В классе TicketBuilder дублируются все поля класса TicketEntity
2. В классе TicketBuilder методы назначают поля текущему объекту и возвращают объект
3. В классе TicketBuilder есть метод build() который возращает объект с назначенными полями
4. В классе TicketEntity есть метод builder(), который возращает новый объект класса TicketBuilder


# Задание 7. Реализация паттерна Abstract Factory
Реализовал паттерн Abstract Factory в классе BaseFactory в пакете ru.npcric.asparagus.trainerslog.service.factory.common

## Признаки реализации паттерна Abstract Factory для класса Base Factory
1. Абстрактный продукт - BaseContext
2. Конкретные продукты - CoachContext, StudentContext, FilialContext. Реализуют интерфейс BaseContext
3.  Абстрактная фабрика - BaseFactory, абстраный метод - createContext()
4.  Конкретная фабрика - CoachFactory, StudentFactory, FilialFactory. Они реализуют метод createContext()
5.  Использование - в сервисах

# Задание 8. Реализация паттерна Adapter
Реализовал паттерн Adapter в классе LoggerAdapter в пакете ru.npcric.asparagus.trainerslog.service.logger

## Причины реализации 
1. Есть удобный интерфейс MyLogger, который имеет понятные по названию методы и класс Logger из пакета java.util.logging, названия методов которые не расскрывают полностью назначение методов - в качестве удобства раелизовал класс LoggerAdapter

## Признаки 
1. LoggerAdapter реализует интерфейс MyLogger, с классом Logger используется связь композиция  - объект класса инициализируется в конструкторе
2. В методах адаптера совмещается логика двух классов


# Задание 9. Реализация паттерна Bridge
Реализовал паттерн Bridge в классе Notification в пакете package ru.npcric.asparagus.trainerslog.service.notification;

## Причины реализации
1. Количество классов наследников от классов Notification и MessageSender может быстро расти а вместе с тем и их "комбинации"

## Признаки реализации 
1. Классы родители (Notification и MessageSender) и их наследники, количество которых может быстро расти
2. В классе Notification использутеся связь композиция с классом MessageSender (разбиение иерархии на две независимых)

# Задание 10. Реализация паттерна Composite
Реализовал паттерн Composite в классе DocumentComponent в пакете ru.npcric.asparagus.trainerslog.service.document;

## Причины реализации
1. У нас есть система управления документами, где документы могут содержать как текстовые блоки, так и другие документы. 
При этом текстовые блоки не могут содержать документы иои другие текстовые блоки. Для представления этой структуры подходит древовидная структура,
которую можно реализовать используя паттерн Composite

## Признаки реализации 
1. Классы Document и TextBlock реализуют один интерфейс DocumentComponent 
2. Класс Document при этом является узлом в древовидной структуре, так как имеет поле со списком дочерних объектов DocumentComponent,
а также методы по добавлению и удалению объекта DocumentComponent из списка
3. Класс TextBlock при этом является листом в древовидной структуре, так как не имеет поля со списком объектов DocumentComponent,
а в реализации методов addComponent() и removeComponent() выбрасывается исключение 


# Задание 11. Реализация паттерна Decorator
Реализовал паттерн Decorator в классе TextDecorator в пакете ru.npcric.asparagus.trainerslog.service.document.textcontent;

## Причины реализации
1. У нас есть текст в текстовых блоках, у которого может быть определенный шрифт
используя паттерн Decorator, мы смогли динамически добавлять различные стили к тексту, не изменяя его основной структуры. Это делает систему более гибкой и позволяет легко комбинировать различные стили

## Признаки реализации
1. Класс TextDecorator одновременно реализует интерфейс Text и содержит его экземпляр в виде поля
2. Существуют конкретные декораторы, которые наследуются от класса TextDecorator - BoldTextDecorator, ItalicTextDecorator, UnderLineTextDecorator
которые расширяют функционал компонента, переопределяя метод getContent(), добавляя дополнительную логику

