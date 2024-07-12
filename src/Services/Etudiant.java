package Services;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Metier.Epreuve;
import Metier.IEtudiant;

public class Etudiant implements IEtudiant, Serializable {
    private String nom;
    private String prenom;
    private String numeroEtudiant;
    private ArrayList<Epreuve> epreuves;

        public Etudiant(String nom, String prenom, String numeroEtudiant) throws RemoteException {
            this.nom = nom;
            this.prenom = prenom;
            this.numeroEtudiant = numeroEtudiant;
            this.epreuves = new ArrayList<Epreuve>();
        }

        public void ajouter_une_epreuve(Epreuve epreuve) throws RemoteException {
            epreuves.add(epreuve);
        }

        public String afficher_liste_des_epreuves() throws RemoteException {
            String listeEpreuves = "----------------------" + prenom + " "+ nom +"----------------\n";
            listeEpreuves += "| Epreuve\t| Note\t\t| Coefficient\t\n";
            listeEpreuves += "-------------------------------------------------------\n";
            
            for (Epreuve epreuve : epreuves) {
                listeEpreuves += String.format("| %8s\t| %4.2f\t\t| %11.2f\t\n", epreuve.getNom(), epreuve.getNote(), epreuve.getCoefficient());
            }
            
            listeEpreuves += "-------------------------------------------------------\n";
            return listeEpreuves;
            
        }

        public double calculer_la_moyenne() throws RemoteException {
            double sommeNotes = 0;
            double sommeCoefficients = 0;
            for (Epreuve epreuve : epreuves) {
                sommeNotes += epreuve.getNote() * epreuve.getCoefficient();
                sommeCoefficients += epreuve.getCoefficient();
            }
            return sommeNotes / sommeCoefficients;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public String getNumeroEtudiant() {
            return numeroEtudiant;
        }

        public void setNumeroEtudiant(String numeroEtudiant) {
            this.numeroEtudiant = numeroEtudiant;
        }

        public ArrayList<Epreuve> getEpreuves() {
            return epreuves;
        }

        public void setEpreuves(ArrayList<Epreuve> epreuves) {
            this.epreuves = epreuves;
        }
    }
