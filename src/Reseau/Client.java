package Reseau;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import Metier.Epreuve;
import Metier.Promotion;
import Services.Etudiant;

public class Client {

        public static void main(String[] args) throws MalformedURLException, RemoteException, Exception {

                Promotion promotion = (Promotion) Naming.lookup("rmi://localhost:8080/PromotionImpl");

                Etudiant etudiant1 = new Etudiant("Mbodj", "Ndeye Selbé", "NSB7895");
                Etudiant etudiant2 = new Etudiant("Niang", "Ndeye Lobé", "NLN1412");
                Etudiant etudiant3 = new Etudiant("Diamanka", "Mouhamadou", "MD14589");

                etudiant1.ajouter_une_epreuve(new Epreuve(3, "Math", 15));
                etudiant1.ajouter_une_epreuve(new Epreuve(2, "Anglais", 18));
                etudiant2.ajouter_une_epreuve(new Epreuve(2.5, "Math", 18));
                etudiant2.ajouter_une_epreuve(new Epreuve(1.5, "Anglais", 19));
                etudiant3.ajouter_une_epreuve(new Epreuve(2.5, "Math", 13));
                etudiant3.ajouter_une_epreuve(new Epreuve(1.5, "Anglais", 16));
                etudiant3.ajouter_une_epreuve(new Epreuve(1.5, "Anglais", 16));

           
                System.out.println(etudiant1.afficher_liste_des_epreuves());
                System.out.println(etudiant2.afficher_liste_des_epreuves());
                System.out.println(etudiant3.afficher_liste_des_epreuves());

                System.out.println("\t\t\tMoyenne des étudiants");
                System.out.println("-------------------------------------------------------");

                System.out.println("| Prenom\t| Nom\t\t| Moyenne\t");
                System.out.println("-------------------------------------------------------");

                System.out.printf("| %7s\t| %7s\t| %7.2f\t\n", etudiant1.getPrenom(), etudiant1.getNom(),
                                etudiant1.calculer_la_moyenne());
                System.out.printf("| %7s\t| %7s\t| %7.2f\t\n", etudiant2.getPrenom(), etudiant2.getNom(),
                                etudiant2.calculer_la_moyenne());
                System.out.printf("| %7s\t| %7s\t| %7.2f\t\n", etudiant3.getPrenom(), etudiant3.getNom(),
                                etudiant3.calculer_la_moyenne());

                System.out.println("-------------------------------------------------------");

                promotion.ajouter_un_etudiant(etudiant1);
                promotion.ajouter_un_etudiant(etudiant2);
                promotion.ajouter_un_etudiant(etudiant3);

                System.out.println("\nMoyenne de la promotion: " + promotion.calculer_moyenne_de_la_promotion());
                System.out.println("\n\t\t\tLa liste des etudiants...");

                List<Etudiant> listeEtudiants = promotion.lister_etudiants();

                System.out.println("-------------------------------------------------------");
                System.out.println("| Numero\t| Prenom\t\t| Nom\t");
                System.out.println("-------------------------------------------------------");

                listeEtudiants.forEach(etudiant -> {
                        System.out.printf("| %7s\t| %7s\t\t| %7s\t\n", etudiant.getNumeroEtudiant(),
                                        etudiant.getPrenom(), etudiant.getNom());
                });

                System.out.println("-------------------------------------------------------\n");

                Etudiant etudiantTrouve = promotion.rechercher_un_etudiant("NLN1412");
                if (etudiantTrouve != null) {
                        System.out.println("\t\t\tEtudiant trouvé");
                        System.out.println(etudiantTrouve.afficher_liste_des_epreuves());

                        System.out.println("\nMoyenne de l'étudiant : " + etudiantTrouve.calculer_la_moyenne());
                } else {
                        System.out.println("\nEtudiant non trouvé");
                }
        }
}
