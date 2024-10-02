package ru.npcric.asparagus.trainerslog.domain;

import java.time.LocalDate;

//Реализация паттерна Builder
public class TicketBuilder {
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isExpired;
    private Integer paidAmount;

    public TicketBuilder(){}

    public TicketBuilder startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public TicketBuilder endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public TicketBuilder isExpired(Boolean isExpired) {
        this.isExpired = isExpired;
        return this;
    }

    public TicketBuilder paidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
        return this;
    }

    public  TicketEntity build() {
        return new TicketEntity(startDate, endDate, isExpired, paidAmount);
    }
}
