package ru.npcric.asparagus.trainerslog.service.filial;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.npcric.asparagus.trainerslog.adapter.repository.FilialRepository;
import ru.npcric.asparagus.trainerslog.adapter.web.dto.request.filial.FilialDTO;
import ru.npcric.asparagus.trainerslog.adapter.web.dto.response.filial.FilialSmallResponse;
import ru.npcric.asparagus.trainerslog.domain.FilialEntity;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class FilialServiceProxy implements FilialServiceInterface{

    FilialService filialService;
    FilialRepository filialRepository;

    @Override
    public FilialSmallResponse create(FilialDTO filialDTO) {
        return filialService.create(filialDTO);
    }

    @Override
    public List<FilialSmallResponse> getAll() {
        List<FilialEntity> filialEntityList = filialRepository.findAll();
        System.out.println("FilialServiceProxy.getAll");
        return filialEntityList.stream()
                .map(f -> new FilialSmallResponse(f.getId(),f.getFilialName(),f.getAddress())).toList();
    }

    @Override
    public void deleteFilialByAddress(String address) {
        filialService.deleteFilialByAddress(address);
    }
}
