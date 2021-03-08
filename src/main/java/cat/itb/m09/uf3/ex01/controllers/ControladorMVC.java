package cat.itb.m09.uf3.ex01.controllers;

import cat.itb.m09.uf3.ex01.models.entities.Empleat;
import cat.itb.m09.uf3.ex01.models.services.EmpleatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorMVC {
    @Autowired
    private EmpleatService empleatService;

    @PostMapping("/empleats/edit/submit")
    public String edit(@ModelAttribute("empleatForm") Empleat emp) {
        empleatService.substituir(emp);
        return "redirect:/empleats/list";
    }


    @GetMapping("/empleats/list")
    public String llistar(Model m){
        m.addAttribute("llistaEmpleats", empleatService.llistat());
        return "llistat";
    }

    @GetMapping("/empleats/new")
    public String afegirEmpleat(Model m){
        m.addAttribute("empleatForm",new Empleat());
        return "afegir";
    }

    @PostMapping("empleats/new/submit")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String afegirSubmit(@ModelAttribute("empleatForm") Empleat emp){
        empleatService.afegir(emp);
        return "redirect:/empleats/list";
    }

    @GetMapping("empleats/eliminar")
    public String eliminarEmpList(@RequestParam("id") int id) {
        empleatService.eliminarPerId(id);
        return "redirect:/empleats/list";
    }

    @GetMapping("empleats/edit/{id}")
    public String editarEmpList(@PathVariable("id") int id, @ModelAttribute("empleatForm") Empleat emp, Model m) {
        m.addAttribute("empleatForm", empleatService.consultaPerId(id));
        return "afegir";
    }

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
