package ru.kuzedu.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuzedu.registration.entity.security.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
