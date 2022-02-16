package ru.kuzedu.registration.controller.seminarController;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kuzedu.registration.entity.regEntity.ListSeminar;
import ru.kuzedu.registration.service.impl.ListSeminarService;

@RestController
@AllArgsConstructor
public class SeminarRestController {

    @Autowired
    private final ListSeminarService listSeminarService;

    @PostMapping("/api/v1/seminars")
    public ResponseEntity<ListSeminar> saveRequest(@RequestBody ListSeminar listSeminar){
        ListSeminar listSeminar1 = listSeminarService.saveRecord(listSeminar);
        return new ResponseEntity<>(listSeminar1, HttpStatus.CREATED);
    }
}
