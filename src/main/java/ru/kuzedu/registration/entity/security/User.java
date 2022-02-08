package ru.kuzedu.registration.entity.security;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    public User(String username, String lastname, String email) {
        super();
        this.username = username;
        this.lastname = lastname;
        this.email = email;
    }

    public User() {

    }
}
