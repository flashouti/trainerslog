package ru.npcric.asparagus.trainerslog.service.factory.common;

import ru.npcric.asparagus.trainerslog.domain.context.BaseContext;

//Паттерн AbstractFactory
public interface BaseFactory <T> {
    BaseContext createContext(T dto);
}
