package controllers;

import dao.EtudiantService;
import dao.FilliereService;
import models.Etudiant;
import models.Filliere;
import util.ConsoleClavier;

import java.util.List;

public class EtudiantController {
    public static void showMenu(){
        System.out.println("-------------------------[ Etudiants ]---------------------------");


        System.out.println("1: Pour ajouter un Etudiant");
        System.out.println("2: Pour afficher les Etudiants");
        System.out.println("3: Pour modifier un Etudiant");
        System.out.println("4: Pour supprimer un Etudiant");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = ConsoleClavier.lireEntier("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEtudiant();
                break;
            case 2:
                showEtudiants();
                break;
            case 3:
                editEtudiant();
                break;
            case 4:
                destroyEtudiant();
                break;
            default:
                ConsoleClavier.showPrincipalMenu();
        }
    }
    public static void createEtudiant() {
        Long id = (long) ConsoleClavier.lireEntier("Entrez  id de etudiant :");
        int apogee = ConsoleClavier.lireEntier("Entrez apogee de etudiant :");

        String nom = ConsoleClavier.lireString("Entrez  nom de etudiant :");
        String prenom = ConsoleClavier.lireString("Entrez prenom de etudiant :");
        String email = ConsoleClavier.lireString("Entrez email de etudiant :");
        FilliereController.showFillieres();

        Long idFilliere = (long) ConsoleClavier.lireEntier("Entrez  id de filliere que vous avez rechercher:");
        FilliereService filliereService = new FilliereService();
        Filliere filliereById = filliereService.getFilliereById(idFilliere);

        Etudiant etudiant = new Etudiant();
        etudiant.setId(id);
        etudiant.setApogee(apogee);
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setEmail(email);
        etudiant.setFilliere(filliereById);

        EtudiantService service = new EtudiantService();
        service.ajouterEtudiant(etudiant);

    }
    public static void showEtudiants() {
        EtudiantService service = new EtudiantService();
        List<Etudiant> allEtudiants = service.getAllEtudiants();
        for (Etudiant etudiant:allEtudiants){
            System.out.println(etudiant.getId() + "|" + etudiant.getApogee() + "|" + etudiant.getPrenom() + "|" + etudiant.getNom() + "|" + etudiant.getEmail());
        }
    }
    public static void editEtudiant() {
        showEtudiants();
        Long id = (long) ConsoleClavier.lireEntier("Entrez  id de etudiant que vous cherchez:");
        int apogee = ConsoleClavier.lireEntier("Entrez apogee de etudiant :");

        String nom = ConsoleClavier.lireString("Entrez  nom de etudiant :");
        String prenom = ConsoleClavier.lireString("Entrez prenom de etudiant :");
        String email = ConsoleClavier.lireString("Entrez email de etudiant :");
        FilliereController.showFillieres();

        Long idFilliere = (long) ConsoleClavier.lireEntier("Entrez  id de filliere deja existe:");
        FilliereService filliereService = new FilliereService();
        Filliere filliereById = filliereService.getFilliereById(idFilliere);


        EtudiantService service = new EtudiantService();
        Etudiant etudiantById = service.getEtudiantById(id);
        etudiantById.setApogee(apogee);
        etudiantById.setNom(nom);
        etudiantById.setPrenom(prenom);
        etudiantById.setEmail(email);
        etudiantById.setFilliere(filliereById);

        service.modifierEtudiant(etudiantById);


    }
    public static void destroyEtudiant() {
        showEtudiants();
        EtudiantService service = new EtudiantService();
        Long id =(long) ConsoleClavier.lireEntier("veuillez entrez l'id de etudiant que vous shouhaitez  supprimer : ");
        service.supprimerEtudiant(id);

    }
}
