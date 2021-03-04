package cat.itb.m09.uf3.ex01.models.services;

import cat.itb.m09.uf3.ex01.models.entities.Empleat;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class EmpleatService {
    private final List<Empleat> empleatList = new ArrayList<>();

    public void afegir(Empleat e) {
        empleatList.add(e);
    }
    public List<Empleat> llistat() {
        return empleatList;
    }

    public List<Empleat> llistatOrdenatPerNom() {
        final List<Empleat> sortedLlist = new ArrayList<>(empleatList);
        sortedLlist.sort(Comparator.comparing(Empleat::getNom));

        return sortedLlist;
    }

    public Empleat consultaPerId(int id) {
        for (Empleat e : empleatList) {
            if (e.getId() == id) {
                return e;
            }
        }

        return null;
    }

    public void eliminarPerId(int id) {
        empleatList.removeIf(e -> e.getId() == id);
    }

    public void substituir(Empleat e) {
        for (int i = 0; i < empleatList.size(); i++) {
            if (empleatList.get(i).getId() == e.getId()) {
                empleatList.set(i, e);
            }
        }
    }

    @PostConstruct
    public void init() {
        empleatList.addAll(
                Arrays.asList(
                        new Empleat(1, "Montse Madridejos", "montse@itb.cat", "677123456", true),
                        new Empleat(2, "Alberto Vila", "alberto@itb.cat", "699876543", false),
                        new Empleat(3, "Robert López", "robert@bbc.com", "123456789", false)
                )
        );
    }
}
