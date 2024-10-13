package ru.npcric.asparagus.trainerslog.service.factory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import ru.npcric.asparagus.trainerslog.adapter.repository.UserRepository;
import ru.npcric.asparagus.trainerslog.adapter.web.dto.request.student.StudentDTO;
import ru.npcric.asparagus.trainerslog.adapter.web.errors.AlreadyExistException;
import ru.npcric.asparagus.trainerslog.adapter.web.errors.UserNotFoundException;
import ru.npcric.asparagus.trainerslog.domain.StudentEntity;
import ru.npcric.asparagus.trainerslog.domain.TicketEntity;
import ru.npcric.asparagus.trainerslog.domain.context.StudentContext;
import ru.npcric.asparagus.trainerslog.domain.user.UserEntity;
import ru.npcric.asparagus.trainerslog.domain.user.UserRole;
import ru.npcric.asparagus.trainerslog.service.TicketService;
import ru.npcric.asparagus.trainerslog.service.factory.common.BaseFactory;

import java.util.Optional;


@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StudentFactory implements BaseFactory<StudentDTO> {
    UserRepository userRepository;
    TicketService ticketService;

    @Override
    public StudentContext createContext(StudentDTO studentDTO) {
        Optional<UserEntity> user = userRepository.findByUsername(studentDTO.username());


        if (user.isEmpty()) throw new UserNotFoundException(studentDTO.username());
        else if(user.get().getAuthorities().contains(UserRole.ROLE_STUDENT)){
            throw new AlreadyExistException("Student");
        }
        TicketEntity ticketEntity = ticketService.createTicketForNewStudent();
        UserEntity userEntity = user.get();

        userEntity.getAuthorities().add(UserRole.ROLE_STUDENT);
        userEntity.getAuthorities().remove(UserRole.ROLE_DEFAULT);

        //todo - засунуть в маппер
        return new StudentContext(
                ticketEntity,
                studentDTO.fullName(),
                studentDTO.sex(),
                studentDTO.birthDate(),
                studentDTO.q(),
                studentDTO.phoneNumber(),
                studentDTO.parentPhoneNumber(),
                studentDTO.parentFullName(),
                studentDTO.email(),
                userEntity);
    }
}
