package ru.npcric.asparagus.trainerslog.adapter.web.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.npcric.asparagus.trainerslog.adapter.web.dto.request.filial.FilialDTO;
import ru.npcric.asparagus.trainerslog.adapter.web.dto.response.filial.FilialSmallResponse;
import ru.npcric.asparagus.trainerslog.service.FilialService;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("/trainerslog/api/v1/filial")
//@RolesAllowed("DEFAULT")
public class FilialController {
    FilialService filialService;

    @PostMapping("/create")
    public FilialSmallResponse createFilial(@Valid @RequestBody FilialDTO filialDTO) {
        return filialService.create(filialDTO);
    }


    @GetMapping("/getAll")
    public List<FilialSmallResponse> getAllFilial(){
        return filialService.getAll();
    }

    //настроить каскадирование
    @DeleteMapping("/deleteByAddress")
    public void deleteFilialByAddress(@RequestParam("address") String address){
        filialService.deleteFilialByAddress(address);
    }
}