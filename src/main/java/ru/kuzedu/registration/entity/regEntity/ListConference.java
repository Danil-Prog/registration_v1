package ru.kuzedu.registration.entity.regEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "conference")
@Data
@AllArgsConstructor
public class ListConference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_conference")
    private String nameConference;

    public ListConference() {
    }
}
