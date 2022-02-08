package ru.kuzedu.registration.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kuzedu.registration.entity.regEntity.ListSeminar;
import ru.kuzedu.registration.service.impl.ListConferenceService;
import ru.kuzedu.registration.service.impl.ListSeminarService;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private final ListConferenceService listConferenceService;

    @Autowired
    private final ListSeminarService listSeminarService;


    public AdminController(ListConferenceService listConferenceService, ListSeminarService listSeminarService) {
        this.listConferenceService = listConferenceService;
        this.listSeminarService = listSeminarService;
    }

    @GetMapping("/api/get/seminar")
    public String defaultGetListConference(Model model){
        String keyword = null;
        return getListConference(model, 1, "id", "asc", keyword);
    }

    //get all conference
    @GetMapping("/api/get/seminar/{pageNum}")
    public String getListConference(Model model,
                                    @PathVariable(name = "pageNum") int pageNum,
                                    @RequestParam("sortField") String sortField,
                                    @RequestParam("sortDir") String sortDir,
                                    @Param("keyword") String keyword) {

        Page<ListSeminar> page = listSeminarService.listAll(pageNum, sortField, sortDir, keyword);

        List<ListSeminar> listSeminars = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listProducts", listSeminars);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("keyword", keyword);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        return "manager/seminar";
    }

}
