package cat.itb.m09.uf3.ex01.controladors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorMVC {
    @GetMapping(value = "/hola")
    public String hola(@RequestParam("nom") String nom, @RequestParam("cognoms") String cognoms, Model model) {
        model.addAttribute("out", nom + " " + cognoms);
        return "hola";
    }

    @GetMapping("/hola/{nom}/{cognoms}")
    public String saludarPathVariable(@PathVariable("nom") String nom, @PathVariable("cognoms") String cognoms, Model m) {
        m.addAttribute("out", nom + " " + cognoms);
        return "hola";
    }
}
