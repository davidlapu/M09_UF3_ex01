package cat.itb.m09.uf3.ex01.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleat {
    private int id;
    private String nom;
    private String email;
    private String telefon;
    private boolean esDirectiu;
}