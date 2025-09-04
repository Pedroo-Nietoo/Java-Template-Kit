package com.pedronieto.java_template_kit.adapter.input;

import com.pedronieto.java_template_kit.adapter.input.terms_of_service.TermsHtmlController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TermsHtmlControllerTest {

    private final TermsHtmlController controller = new TermsHtmlController();

    @Test
    void serveIndexPage_shouldRedirectToIndexHtml() {
        String result = controller.serveIndexPage();

        assertEquals("redirect:/index.html", result);
    }
}
