package ru.kuzedu.registration.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.kuzedu.registration.entity.regEntity.ListSeminar;
import ru.kuzedu.registration.repository.ListSeminarRepository;
import ru.kuzedu.registration.service.ManagerRegistrationService;

@Service
public class ListSeminarService implements ManagerRegistrationService<ListSeminar> {

    private final ListSeminarRepository listSeminarRepository;

    public ListSeminarService(ListSeminarRepository listSeminarRepository) {
        this.listSeminarRepository = listSeminarRepository;
    }

    @Override
    public Page<ListSeminar> findAllResponse(Pageable pageable) {
        int page = pageable.getPageNumber() == 0 ? 0 : pageable.getPageNumber() - 1;
        pageable = PageRequest.of(page, 7);
        return listSeminarRepository.findAll(pageable);
    }

    @Override
    public ListSeminar getById(Long id) {
        return listSeminarRepository.findById(id).get();
    }

    public ListSeminar saveRecord(ListSeminar dto) {
        return listSeminarRepository.save(dto);
    }

    @Override
    public void deleteById(Long id) {
        listSeminarRepository.deleteById(id);
    }

    @Override
    public ListSeminar save(ListSeminar listSeminar) {
        return listSeminarRepository.save(listSeminar);
    }
}
