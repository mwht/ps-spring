package pl.madejspace.postudencku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    @GetMapping("/menu")
    public String menu(Model model) {
        @Autowired
        JdbcTemplate jdbc = new JdbcTemplate();
        jdbc.query("SELECT id, name, price, image_url FROM dishes AS d JOIN categories AS c ON d.category_id=c.id", null,
                (rs, rowID) -> {

                });
        return "menu";
    }
}
