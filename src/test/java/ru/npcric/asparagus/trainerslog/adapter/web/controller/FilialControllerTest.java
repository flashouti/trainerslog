package ru.npcric.asparagus.trainerslog.adapter.web.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.npcric.asparagus.trainerslog.adapter.web.dto.request.filial.FilialDTO;
import ru.npcric.asparagus.trainerslog.adapter.web.dto.response.filial.FilialSmallResponse;
import ru.npcric.asparagus.trainerslog.service.filial.FilialService;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FilialControllerTest {
    @Mock
    FilialService filialService;
    @InjectMocks
    FilialController filialController;

    @Test
    @DisplayName("POST /trainerslog/api/v1/filial/create проверяет создание филиала")
    void createFilial_ReturnsValidResponseEntity() {
        //given
        var filialRequest = new FilialDTO("Юго Западный филиал", "Фурманова 125");
        var filialResponse = new FilialSmallResponse(1L, "Юго Западный филиал", "Фурманова 125");
        Mockito.doReturn(filialResponse).when(this.filialService).create(filialRequest);
        //when
        var responseEntity = this.filialController.createFilial(filialRequest);
        //then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(filialResponse, responseEntity.getBody());
    }

    @Test
    @DisplayName("GET /trainerslog/api/v1/filial/getAll проверяет наличие всех филиалов")
    void getAllFilial_ValidatingList_ReturnsValidResponseEntity() {
        //given
        List<FilialSmallResponse> expectedResponse = List.of(new FilialSmallResponse(1L, "Юго Западный филиал", "Фурманова 125"),
                new FilialSmallResponse(2L, "Академический филиал", "Павла Шаманова 6"));
        Mockito.doReturn(expectedResponse).when(this.filialService).getAll();
        //when
        var responseEntity = this.filialController.getAllFilial();
        //then

        List<FilialSmallResponse> actualResponse = responseEntity.getBody();

        assertThat(actualResponse).hasSameSizeAs(expectedResponse).containsExactlyInAnyOrderElementsOf(expectedResponse);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());
    }

    @Test
    @DisplayName("DELETE /trainerslog/api/v1/filial/deleteByAddress проверяет удаление филиала по адресу")
    void deleteFilialByAddress_ChecksValidDeleting_ReturnsOkStatusCode() {
        //given
        String address = "Павла Шаманова 6";

        ResponseEntity<?> responseEntity = filialController.deleteFilialByAddress(address);
        Mockito.verify(filialService).deleteFilialByAddress(address);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
