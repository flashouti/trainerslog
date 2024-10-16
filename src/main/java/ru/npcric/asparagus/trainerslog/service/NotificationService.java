package ru.npcric.asparagus.trainerslog.service;

import org.springframework.stereotype.Service;
import ru.npcric.asparagus.trainerslog.service.notification.*;

@Service
public class NotificationService {

    void sendEmailHighPriorityNotification(String message) {
        EmailSender emailSender = new EmailSender();
        HighPriorityNotification notification = new HighPriorityNotification(emailSender);
        notification.send(message);
    }

    void sendEmailLowPriorityNotification(String message) {
        EmailSender emailSender = new EmailSender();
        LowPriorityNotification notification = new LowPriorityNotification(emailSender);
        notification.send(message);
    }

    void sendSmsHighPriorityNotification(String message) {
        SmsSender smsSender = new SmsSender();
        HighPriorityNotification notification = new HighPriorityNotification(smsSender);
        notification.send(message);
    }

    void sendSmsLowPriorityNotification(String message) {
        SmsSender smsSender = new SmsSender();
        LowPriorityNotification notification = new LowPriorityNotification(smsSender);
        notification.send(message);
    }
}
