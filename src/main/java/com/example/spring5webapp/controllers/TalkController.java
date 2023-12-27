package com.example.spring5webapp.controllers;

import com.example.spring5webapp.repositories.TalkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class TalkController {

    private final TalkRepository talkRepository;
    @RequestMapping(value = "/talks")
    public String getTalks(Model model) {

        model.addAttribute("talks", talkRepository.findAll());
        return "talks/list";
    }
}
