package ru.kuzedu.registration.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kuzedu.registration.entity.regEntity.ListConference;


@Repository
public interface ListConferenceRepository extends JpaRepository<ListConference, Long> {

    @Query("SELECT s FROM ListConference s WHERE s.nameConference LIKE %?1%")
    Page<ListConference> listAll(String keyword, Pageable pageable);

}
