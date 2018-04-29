package pl.madejspace.postudencku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ErrorController {

    @GetMapping("/error")
    public String error(@RequestParam Map<String,String> params, Model model) {
        params.forEach((id,elem) -> {
            System.out.println(id + " " + elem);
        });
        model.addAttribute("status", 404);
        model.addAttribute("type","Not Found");
        return "error";
    }
}
