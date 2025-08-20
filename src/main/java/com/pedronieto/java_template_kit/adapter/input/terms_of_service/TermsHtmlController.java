package com.pedronieto.java_template_kit.adapter.input.terms_of_service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TermsHtmlController {
    @GetMapping("/terms-of-service")
    public String serveIndexPage() {
        return "redirect:/index.html";
    }
}
