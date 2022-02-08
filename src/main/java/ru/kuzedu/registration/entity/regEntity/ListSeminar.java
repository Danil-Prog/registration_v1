package ru.kuzedu.registration.entity.regEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "seminar")
@Data
@AllArgsConstructor
public class ListSeminar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_seminar")
    private String nameSeminar;

    public ListSeminar() {

    }
}
