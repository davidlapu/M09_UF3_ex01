package cat.itb.m09.uf3.ex01.controladors;

import cat.itb.m09.uf3.ex01.models.Usuari;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorRest {

    @GetMapping("/usuari/{nom}")
    public Usuari e3Rest(@PathVariable("nom") String nom) {
        return new Usuari(nom);
    }
}