package ru.kuzedu.registration.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuzedu.registration.repository.ListConferenceRepository;

@Service
public class ListConferenceService {

    @Autowired
    private final ListConferenceRepository listConferenceRepository;

    public ListConferenceService(ListConferenceRepository listConferenceRepository) {
        this.listConferenceRepository = listConferenceRepository;
    }

}
