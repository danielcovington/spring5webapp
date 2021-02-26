package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepositoriy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepositoriy authorRepositoriy;

    public AuthorController(AuthorRepositoriy authorRepositoriy) {
        this.authorRepositoriy = authorRepositoriy;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){

        model.addAttribute("authors",authorRepositoriy.findAll());
        return "authors";

    }
}
