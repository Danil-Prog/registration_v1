package ru.kuzedu.registration.entity.regEntity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "seminar")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ListSeminar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_seminar")
    private String nameSeminar;

    @Builder
    public ListSeminar(Long id, String nameSeminar){
        this.id = id;
        this.nameSeminar = nameSeminar;
    }
}
