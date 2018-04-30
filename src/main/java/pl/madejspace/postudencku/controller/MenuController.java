package pl.madejspace.postudencku.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.madejspace.postudencku.MenuEntry;
import pl.madejspace.postudencku.dao.MenuEntryDAO;

@Controller
public class MenuController {

    private ConfigurableApplicationContext context;

    @GetMapping("/menu")
    public String menu(Model model) {
        // SELECT d.id, d.name, d.price, d.image_url, c.name FROM dishes AS d JOIN categories AS c ON d.category_id=c.id;
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenuEntryDAO menuEntryDAO = (MenuEntryDAO) context.getBean("menuEntryDAO");
        MenuEntry entry = menuEntryDAO.findById(1);
        model.addAttribute("entry",entry);
        return "menu";
    }
}
