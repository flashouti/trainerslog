package ru.npcric.asparagus.trainerslog.service;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.npcric.asparagus.trainerslog.adapter.repository.UserRepository;
import ru.npcric.asparagus.trainerslog.adapter.web.dto.request.RegistrationRequest;
import ru.npcric.asparagus.trainerslog.domain.user.UserEntity;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class RegistrationService {
    PasswordEncoder passwordEncoder;
    UserRepository userRepository;

    public void register(RegistrationRequest registrationRequest) {
        UserEntity.Context userEntity = new UserEntity.Context(
            registrationRequest.login(),
                passwordEncoder.encode(registrationRequest.password())
        );

        UserEntity user = UserEntity.from(userEntity);
        userRepository.save(user);
    }
}