package ru.npcric.asparagus.trainerslog.service.filial;

import ru.npcric.asparagus.trainerslog.adapter.web.dto.request.filial.FilialDTO;
import ru.npcric.asparagus.trainerslog.adapter.web.dto.response.filial.FilialSmallResponse;

import java.util.List;

public interface FilialServiceInterface {
    FilialSmallResponse create(FilialDTO filialDTO);
    List<FilialSmallResponse> getAll();
    void deleteFilialByAddress(String address);
}
