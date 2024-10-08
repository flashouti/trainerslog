package ru.npcric.asparagus.trainerslog.service.factory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import ru.npcric.asparagus.trainerslog.adapter.web.dto.request.filial.FilialDTO;
import ru.npcric.asparagus.trainerslog.domain.FilialEntity;
import ru.npcric.asparagus.trainerslog.domain.context.FilialContext;
import ru.npcric.asparagus.trainerslog.service.factory.common.BaseFactory;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FilialFactory implements BaseFactory<FilialDTO> {

    @Override
    public FilialContext createContext(FilialDTO filialDTO) {
        FilialContext filialContext = new FilialContext(filialDTO.name(), filialDTO.address());
        return filialContext;
    }
}
