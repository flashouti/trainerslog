package ru.npcric.asparagus.trainerslog.adapter.web.dto.request.filial;

import jakarta.validation.constraints.NotBlank;

//Паттерн Prototype
public record FilialDTO(
        @NotBlank String name,
        @NotBlank String address
) {

    public FilialDTO clone() {
        // Создаем новый экземпляр FilialDTO с теми же значениями
        return new FilialDTO(name, address);
    }
}
