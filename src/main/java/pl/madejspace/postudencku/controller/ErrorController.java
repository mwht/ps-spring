package pl.madejspace.postudencku.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.madejspace.postudencku.Bootstrap;

import java.util.Map;

@Controller
public class ErrorController {

    @GetMapping("/error")
    public String error(@RequestParam Map<String,String> params, Model model) {
        return "error";
    }
}
