package ru.npcric.asparagus.trainerslog.domain.context;

import ru.npcric.asparagus.trainerslog.domain.FilialEntity;
import ru.npcric.asparagus.trainerslog.domain.user.UserEntity;

import java.time.LocalDate;

public record CoachContext (String name, String eemail, String phoneNumber,
                            String sex, LocalDate birthDate,
                            FilialEntity filial, UserEntity user) implements BaseContext{
}
