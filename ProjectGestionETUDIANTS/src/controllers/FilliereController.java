package controllers;

import dao.DepartementService;
import dao.EnseignantService;
import dao.FilliereService;
import models.Departement;
import models.Enseignant;
import models.Filliere;
import util.ConsoleClavier;

import java.util.List;

public class FilliereController {
    public static void showMenu(){
        System.out.println("-------------------------[ Fillieres ]---------------------------");


        System.out.println("1: Pour ajouter un Filliere");
        System.out.println("2: Pour afficher les Fillieres");
        System.out.println("3: Pour modifier un Filliere");
        System.out.println("4: Pour supprimer un Filliere");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = ConsoleClavier.lireEntier("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createFilliere();
                break;
            case 2:
                showFillieres();
                break;
            case 3:
                editFilliere();
                break;
            case 4:
                destroyFilliere();
                break;
            default:
                ConsoleClavier.showPrincipalMenu();
        }
    }
    public static void createFilliere() {
        Long id = (long) ConsoleClavier.lireEntier("Entrez  id de filliere :");
        String intitule = ConsoleClavier.lireString("Entrez  intitule de filliere :");

        DepartementController.showDepartements();
        Long idDepartement =(long) ConsoleClavier.lireEntier("veuillez entrez l'id de departement existe deja: ");

        DepartementService departementService = new DepartementService();
        Departement departementById = departementService.getDepartementById(idDepartement);

        EnseignantsController.showEnseignants();
        Long idEnseignent = (long)  ConsoleClavier.lireEntier("Entrez l'id  de enseignant existe deja:");
        EnseignantService enseignantService = new EnseignantService();
        Enseignant enseignantById = enseignantService.getEnseignantById(idEnseignent);


        Filliere filliere = new Filliere();
        filliere.setId(id);
        filliere.setIntitule(intitule);
        filliere.setDepartement(departementById);
        filliere.setEnseignant(enseignantById);

        FilliereService filliereService = new FilliereService();
        filliereService.ajouterFilliere(filliere);
    }
    public static void showFillieres() {
        FilliereService service = new FilliereService();
        List<Filliere> allFillieres = service.getAllFillieres();
        for (Filliere filliere:allFillieres){
            System.out.println(filliere.getId() + "|" + filliere.getIntitule());
        }
    }
    public static void editFilliere() {
        showFillieres();

        Long id = (long) ConsoleClavier.lireEntier("Entrez  id de filliere que vous avez rechercher:");

        String intitule = ConsoleClavier.lireString("Entrez  intitule de filliere :");

        DepartementController.showDepartements();
        Long idDepartement =(long) ConsoleClavier.lireEntier("veuillez entrez l'id de departement existe deja: ");

        DepartementService departementService = new DepartementService();
        Departement departementById = departementService.getDepartementById(idDepartement);

        EnseignantsController.showEnseignants();
        Long idEnseignent = (long)  ConsoleClavier.lireEntier("Entrez l'id  de enseignant existe deja:");
        EnseignantService enseignantService = new EnseignantService();
        Enseignant enseignantById = enseignantService.getEnseignantById(idEnseignent);


        FilliereService filliereService = new FilliereService();
        Filliere filliereById = filliereService.getFilliereById(id);

        filliereById.setIntitule(intitule);
        filliereById.setDepartement(departementById);
        filliereById.setEnseignant(enseignantById);

        filliereService.modifierFilliere(filliereById);

    }
    private static void destroyFilliere() {
        showFillieres();
        Long id =(long) ConsoleClavier.lireEntier("veuillez entrez l'id de Filliere que vous shouhaitez supprimer : ");

        FilliereService service = new FilliereService();
        service.supprimerFilliere(id);

    }
}
