package com.fcamara.desafio.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CompanyController {
    @RequestMapping("/company/add")
    @ResponseBody
    public String teste() {
        return "teste";
    }
}
