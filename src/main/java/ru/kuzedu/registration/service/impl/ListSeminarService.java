package ru.kuzedu.registration.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.kuzedu.registration.entity.regEntity.ListSeminar;
import ru.kuzedu.registration.repository.ListSeminarRepository;
import ru.kuzedu.registration.service.ManagerRegistrationService;

import java.util.List;

@Service
public class ListSeminarService implements ManagerRegistrationService<ListSeminar> {

    private final ListSeminarRepository listSeminarRepository;

    public ListSeminarService(ListSeminarRepository listSeminarRepository) {
        this.listSeminarRepository = listSeminarRepository;
    }

    @Override
    public Page<ListSeminar> listAll(int pageNum, String sortField, String sortDir, String keyword) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        int pageSize = 12;

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        if (keyword != null){
            return listSeminarRepository.listAll(keyword, pageable);
        }

        return listSeminarRepository.findAll(pageable);
    }

    @Override
    public ListSeminar getById(Long id) {
        return listSeminarRepository.findById(id).get();
    }

    @Override
    public ListSeminar updateRecord(ListSeminar listSeminar) {
        return listSeminarRepository.save(listSeminar);
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
