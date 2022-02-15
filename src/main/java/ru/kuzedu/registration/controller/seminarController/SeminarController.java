package ru.kuzedu.registration.controller.seminarController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.kuzedu.registration.dto.seminar.ListSeminarSaveRequestDto;
import ru.kuzedu.registration.entity.regEntity.ListSeminar;
import ru.kuzedu.registration.service.impl.ListConferenceService;
import ru.kuzedu.registration.service.impl.ListSeminarService;

@Controller
public class SeminarController {

    @Autowired
    private final ListConferenceService listConferenceService;

    @Autowired
    private final ListSeminarService listSeminarService;


    public SeminarController(ListConferenceService listConferenceService, ListSeminarService listSeminarService) {
        this.listConferenceService = listConferenceService;
        this.listSeminarService = listSeminarService;
    }


    //get all seminar
    @GetMapping("/api/v1/seminars")
    public String main(Model model, @PageableDefault(size = 5, sort = "id") Pageable pageable) {
        Page<ListSeminar> pages = listSeminarService.findAllResponse(pageable);
        model.addAttribute("pages", pages);

        int start = Math.max(1, pages.getNumber() - 2);
        int last = Math.min(start + 6, pages.getTotalPages());

        model.addAttribute("start", start);
        model.addAttribute("last", last);

        return "manager/seminar";
    }

}
