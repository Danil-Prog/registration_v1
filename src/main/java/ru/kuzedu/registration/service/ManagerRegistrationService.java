package ru.kuzedu.registration.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ManagerRegistrationService<T> {

    Page<T> findAllResponse(Pageable pageable);
    T getById(Long id);
    void deleteById(Long id);
    T saveRecord(T t);
    T save(T t);
}
