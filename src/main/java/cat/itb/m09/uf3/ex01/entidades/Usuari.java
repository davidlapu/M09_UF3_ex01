package cat.itb.m09.uf3.ex01.entidades;

import java.util.Random;

public class Usuari {
    private int id;
    private String nom, cognoms;

    public Usuari(String nom) {
        final Random rand = new Random();
        final String[] congoms = {"Pulido", "Lopez", "Acosta", "Reus"};

        id = rand.nextInt(10) + 1;
        cognoms = congoms[rand.nextInt(congoms.length)];
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getCognoms() {
        return cognoms;
    }
}
