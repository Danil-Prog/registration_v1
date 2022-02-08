package ru.kuzedu.registration.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kuzedu.registration.entity.regEntity.ListSeminar;


@Repository
public interface ListSeminarRepository extends JpaRepository<ListSeminar, Long> {

    @Query("SELECT s FROM ListSeminar s WHERE s.nameSeminar LIKE %?1%")
    Page<ListSeminar> listAll(String keyword, Pageable pageable);
}
