package Services;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import Metier.Epreuve;
import Metier.Promotion;

public class PromotionImpl extends UnicastRemoteObject implements Promotion {

    private List<Etudiant> etudiants;

    public PromotionImpl() throws RemoteException {
        etudiants = new ArrayList<>();
    }

    public Etudiant ajouter_un_etudiant(Etudiant etudiant) throws RemoteException {
        boolean existe = false;
        for (Etudiant e : etudiants) {
            if (e.getNumeroEtudiant().equals(etudiant.getNumeroEtudiant())) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            etudiants.add(etudiant);
           return etudiant;
        } else {
           return null;
        }
    }

    public Etudiant rechercher_un_etudiant(String numero) throws RemoteException {
        Etudiant e = null;
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getNumeroEtudiant().equals(numero)) {
                e = etudiant;
            }
        }
        return e;
    }

    public double calculer_moyenne_de_la_promotion() throws RemoteException {
        double sommeCoefficients = 0;
        double sommeNotesPonderees = 0;
        for (Etudiant etudiant : etudiants) {
            for (Epreuve epreuve : etudiant.getEpreuves()) {
                sommeCoefficients += epreuve.getCoefficient();
                sommeNotesPonderees += epreuve.getNote() * epreuve.getCoefficient();
            }
        }
        return sommeNotesPonderees / sommeCoefficients;
    }

    public List<Etudiant> lister_etudiants() throws RemoteException {
        return etudiants;
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException {
		PromotionImpl promotion = new PromotionImpl();
		LocateRegistry.createRegistry(8080);
		String adresse = "rmi://localhost:8080/PromotionImpl";
		Naming.rebind(adresse, promotion);
		System.out.println("Serveur demarre...");
	}
}