package ru.npcric.asparagus.trainerslog.domain.context;

import ru.npcric.asparagus.trainerslog.domain.TicketEntity;
import ru.npcric.asparagus.trainerslog.domain.user.UserEntity;

import java.time.LocalDate;

public record StudentContext (TicketEntity ticket,
                             String fullName,
                             String sex,
                             LocalDate birthDate,
                             Integer q,
                             String phoneNumber,
                             String parentPhoneNumber,
                             String parentFullName,
                             String eemail,
                             UserEntity user) implements BaseContext{
}
