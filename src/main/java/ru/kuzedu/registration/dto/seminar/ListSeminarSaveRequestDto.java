package ru.kuzedu.registration.dto.seminar;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kuzedu.registration.entity.regEntity.ListSeminar;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ListSeminarSaveRequestDto {

    private String nameSeminar;

    public ListSeminar toEntity(){
        return ListSeminar.builder()
                .nameSeminar(nameSeminar)
                .build();
    }
}
