package ru.npcric.asparagus.trainerslog.service.scheduler;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.npcric.asparagus.trainerslog.adapter.repository.GroupRepository;
import ru.npcric.asparagus.trainerslog.adapter.repository.StudentRepository;
import ru.npcric.asparagus.trainerslog.adapter.repository.TicketRepository;
import ru.npcric.asparagus.trainerslog.domain.StudentEntity;
import ru.npcric.asparagus.trainerslog.domain.TicketEntity;
import ru.npcric.asparagus.trainerslog.service.TicketService;

import java.time.LocalDate;
import java.util.List;

@EnableAsync
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class TicketScheduler {
    StudentRepository studentRepository;
    TicketService ticketService;
    TicketRepository ticketRepository;



    @SchedulerLock(name = "UpdateAllTicketsStatus")
    //Каждые 10 минут
    @Scheduled(cron = "0 */1 * * * *")
    @SneakyThrows
    @Transactional
    public void autoUpdateAllTicketsStatus() {
        log.info("Scheduler updateAllTicketsStatus start");
        List<StudentEntity> students = studentRepository.findStudentsWithExpiredTickets(LocalDate.now());
        for (StudentEntity student : students) {
            int studentBalance = student.getBalance();
            student.setBalance(student.getBalance() - ticketService.INITIAL_COST);
            TicketEntity ticket = student.getTicket();
            TicketEntity newTicket = ticketService.getDefaultTicket();
            student.setTicket(newTicket);
            studentRepository.save(student);
            ticketRepository.delete(ticket);
        }

        log.info("Scheduler updateAllTicketsStatus end");
    }
}
