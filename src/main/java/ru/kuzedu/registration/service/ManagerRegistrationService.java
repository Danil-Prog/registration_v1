package ru.kuzedu.registration.service;

import org.springframework.data.domain.Page;

import java.util.List;

public interface ManagerRegistrationService<T> {

    Page<T> listAll(int pageNum, String sortField, String sortDir, String keyword);
    T getById(Long id);
    T updateRecord(T t);
    void deleteById(Long id);
    T save(T t);
}
