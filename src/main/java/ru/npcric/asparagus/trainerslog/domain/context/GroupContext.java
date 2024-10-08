package ru.npcric.asparagus.trainerslog.domain.context;

import ru.npcric.asparagus.trainerslog.domain.CoachEntity;
import ru.npcric.asparagus.trainerslog.domain.StudentEntity;

import java.util.List;

public record GroupContext (String groupName, List<StudentEntity> students, CoachEntity coach) implements BaseContext{
}
