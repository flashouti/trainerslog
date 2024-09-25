package ru.npcric.asparagus.trainerslog.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.npcric.asparagus.trainerslog.domain.common.BaseEntity;

import java.util.List;


//Паттерн Static Fabric method
@Getter
@Setter
@NoArgsConstructor
@Table(name = "filial")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilialEntity extends BaseEntity {
    String filialName;
    String address;
    @OneToMany(mappedBy = "filial")
    List<CoachEntity> coachesInFilial;

    private FilialEntity(String name, String address, List<CoachEntity> coachesInFilial){
        this.filialName = name;
        this.address = address;
        this.coachesInFilial = coachesInFilial;
    }

    public static FilialEntity getFilialWithDefaultName(FilialContext context){
        return new FilialEntity("Школа Айкидо", context.address(), null);
    }

    public record FilialContext(String name, String address) {
    }
}
