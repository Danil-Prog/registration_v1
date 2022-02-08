package ru.kuzedu.registration.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.kuzedu.registration.entity.regEntity.ListConference;
import ru.kuzedu.registration.repository.ListConferenceRepository;
import ru.kuzedu.registration.service.ManagerRegistrationService;

import java.util.List;

@Service
public class ListConferenceService implements ManagerRegistrationService<ListConference> {

    @Autowired
    private final ListConferenceRepository listConferenceRepository;

    public ListConferenceService(ListConferenceRepository listConferenceRepository) {
        this.listConferenceRepository = listConferenceRepository;
    }


    @Override
    public Page<ListConference> listAll(int pageNum, String sortField, String sortDir, String keyword) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        int pageSize = 12;

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        if (keyword != null){
            return listConferenceRepository.listAll(keyword, pageable);
        }

        return listConferenceRepository.findAll(pageable);
    }

    @Override
    public ListConference getById(Long id) {
        return listConferenceRepository.findById(id).get();
    }

    @Override
    public ListConference updateRecord(ListConference listConference) {
        return listConferenceRepository.save(listConference);
    }

    @Override
    public void deleteById(Long id) {
        listConferenceRepository.deleteById(id);
    }

    @Override
    public ListConference save(ListConference listConference) {
        return listConferenceRepository.save(listConference);
    }

}
