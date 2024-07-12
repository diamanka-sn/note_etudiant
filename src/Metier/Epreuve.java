package Metier;
import java.io.Serializable;

public class Epreuve implements Serializable {
    private String nom;
    private double note;
    private double coefficient;

    public Epreuve(double coefficient, String nom, double note) {
        this.coefficient = coefficient;
        this.nom = nom;
        this.note = note;
    }

    public String getNom() {
        return nom;
    }

    public double getNote() {
        return note;
    }

    public double getCoefficient() {
        return coefficient;
    }
}
