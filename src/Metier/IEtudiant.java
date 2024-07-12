package Metier;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEtudiant extends Remote {
    public void ajouter_une_epreuve(Epreuve e) throws RemoteException;
    public String afficher_liste_des_epreuves() throws RemoteException;
    public double calculer_la_moyenne() throws RemoteException;
}