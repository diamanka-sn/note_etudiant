package Metier;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import Services.Etudiant;

public interface Promotion extends Remote {

    public Etudiant ajouter_un_etudiant(Etudiant etudiant) throws RemoteException;
    public Etudiant rechercher_un_etudiant(String numero) throws RemoteException;
    public double calculer_moyenne_de_la_promotion() throws RemoteException;
    public List<Etudiant> lister_etudiants() throws RemoteException;
}
