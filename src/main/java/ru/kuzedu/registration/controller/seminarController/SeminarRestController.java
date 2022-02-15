package ru.kuzedu.registration.controller.seminarController;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kuzedu.registration.dto.seminar.ListSeminarSaveRequestDto;
import ru.kuzedu.registration.service.impl.ListSeminarService;

@RestController
@AllArgsConstructor
public class SeminarRestController {

    @Autowired
    private final ListSeminarService listSeminarService;

    @PostMapping("/api/v1/seminars")
    public Long saveRequest(@RequestBody ListSeminarSaveRequestDto listSeminar){
        return listSeminarService.saveRecord(listSeminar);
    }
}
