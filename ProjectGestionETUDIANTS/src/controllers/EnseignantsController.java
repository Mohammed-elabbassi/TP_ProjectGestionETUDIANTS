package controllers;

import dao.EnseignantService;
import models.Enseignant;
import util.ConsoleClavier;

import java.util.List;

public class EnseignantsController {
    public static void showMenu(){
        System.out.println("-------------------------[ Enseignants ]---------------------------");


        System.out.println("1: Pour ajouter un Enseignants");
        System.out.println("2: Pour afficher les Enseignants");
        System.out.println("3: Pour modifier un Enseignants");
        System.out.println("4: Pour supprimer un Enseignants");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = ConsoleClavier.lireEntier("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEnseignat();
                break;
            case 2:
                showEnseignants();
                break;
            case 3:
                editEnseignant();
                break;
            case 4:
                destroyEnseignants();
                break;
            default:
                ConsoleClavier.showPrincipalMenu();
        }
    }
    public static void createEnseignat() {
        Long id = (long) ConsoleClavier.lireEntier("Entrez  id de enseignant :");
        String nom = ConsoleClavier.lireString("Entrez  nom de enseignant :");
        String prenom = ConsoleClavier.lireString("Entrez prenom de enseignant :");
        String email = ConsoleClavier.lireString("Entrez email de enseignant :");
        String gradle = ConsoleClavier.lireString("Entrez gradle de enseignant :");

        Enseignant enseignant = new Enseignant();
        enseignant.setId(id);
        enseignant.setNom(nom);
        enseignant.setPrenom(prenom);
        enseignant.setEmail(email);
        enseignant.setGrade(gradle);

        EnseignantService service = new EnseignantService();
        service.ajouterEnseignant(enseignant);

    }
    public static void showEnseignants() {
        EnseignantService service = new EnseignantService();
        List<Enseignant> allEnseignants = service.getAllEnseignants();
        for (Enseignant enseignant:allEnseignants){
            System.out.println(enseignant.getId() + "|" + enseignant.getPrenom() + "|" + enseignant.getNom());
        }
    }
    public static void editEnseignant() {
        showEnseignants();
        Long id =(long) ConsoleClavier.lireEntier("veuillez entrez l'id de enseignant existe deja: ");

        EnseignantService service = new EnseignantService();
        Enseignant enseignantById = service.getEnseignantById(id);

        String nom = ConsoleClavier.lireString("Entrez  nom de enseignant :");
        String prenom = ConsoleClavier.lireString("Entrez prenom de enseignant :");
        String email = ConsoleClavier.lireString("Entrez email de enseignant :");
        String gradle = ConsoleClavier.lireString("Entrez gradle de enseignant :");

        enseignantById.setNom(nom);
        enseignantById.setPrenom(prenom);
        enseignantById.setEmail(email);
        enseignantById.setGrade(gradle);

        service.modifierEnseignant(enseignantById);
    }
    public static void destroyEnseignants() {
        showEnseignants();
        EnseignantService service = new EnseignantService();
        Long id =(long) ConsoleClavier.lireEntier("veuillez entrez l'id de enseignant que vous shouhaitez  supprimer : ");
        service.supprimerEnseignant(id);

    }






}
