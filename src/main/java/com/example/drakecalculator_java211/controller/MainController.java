package com.example.drakecalculator_java211.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("drake")
    public String drakeForm(Model model) {
        model.addAttribute("R",1);
        model.addAttribute("fp",50);
        model.addAttribute("ne_",2);
        model.addAttribute("fl",1);
        model.addAttribute("fi",1);
        model.addAttribute("fc",1);
        model.addAttribute("L",10000);
        return "form-calc";
    }

    @PostMapping("form-calc")
    public String drake(@RequestParam Integer R,
                        @RequestParam Integer fp,
                        @RequestParam Integer ne,
                        @RequestParam Integer fl,
                        @RequestParam Integer fi,
                        @RequestParam Integer fc,
                        @RequestParam Integer L, Model model) {
        model.addAttribute("R",R);
        model.addAttribute("fp",fp);
        model.addAttribute("ne_",ne);
        model.addAttribute("fl",fl);
        model.addAttribute("fi",fi);
        model.addAttribute("fc",fc);
        model.addAttribute("L",L);

        Double N = R * fp * ne * fl * fi * fc * L / Math.pow(100, 4);
        model.addAttribute("N",N);
        return "form-calc";
    }
}

