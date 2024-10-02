package ru.npcric.asparagus.trainerslog.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.npcric.asparagus.trainerslog.domain.common.BaseEntity;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ticket")
public class TicketEntity extends BaseEntity {
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isExpired;
    private Integer paidAmount;

    TicketEntity(LocalDate startDate, LocalDate endDate, Boolean isExpired, Integer paidAmount) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.isExpired = isExpired;
        this.paidAmount = paidAmount;
    }

    public static TicketBuilder builder(){
        return new TicketBuilder();
    }
}
