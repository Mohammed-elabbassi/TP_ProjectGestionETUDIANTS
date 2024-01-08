package controllers;

import dao.DepartementService;
import dao.EnseignantService;
import models.Departement;
import models.Enseignant;
import util.ConsoleClavier;

import java.util.List;

public class DepartementController {

    public static void showMenu(){
        System.out.println("-------------------------[ Départements ]---------------------------");


        System.out.println("1: Pour ajouter un département");
        System.out.println("2: Pour afficher les départements");
        System.out.println("3: Pour modifier un département");
        System.out.println("4: Pour supprimer un département");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = ConsoleClavier.lireEntier("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createDepartement();
                break;
            case 2:
                showDepartements();
                break;
            case 3:
                editDepartement();
                break;
            case 4:
                destroyDepartement();
                break;
            default:
                ConsoleClavier.showPrincipalMenu();
        }
    }
    public static void showDepartements(){
        DepartementService service = new DepartementService();
        List<Departement> allDepartements = service.getAllDepartements();
        for (Departement departement:allDepartements){
            System.out.println(departement.getId() +" | " +departement.getIntitule());
        }

    }
    public static void createDepartement(){
        Long id =(long) ConsoleClavier.lireEntier("veuillez entrez l'id de departement : ");
        String intitule = ConsoleClavier.lireString("Entrez  intitule de departement :");

        EnseignantsController.showEnseignants();
        Long idEnseignent = (long)  ConsoleClavier.lireEntier("Entrez l'id  de enseignant :");


        EnseignantService enseignantService = new EnseignantService();
        Enseignant enseignantById = enseignantService.getEnseignantById(idEnseignent);

        Departement departement = new Departement();
        departement.setId(id);
        departement.setIntitule(intitule);
        departement.setChef(enseignantById);


        DepartementService departementService = new DepartementService();
        departementService.ajouterDepartement(departement);

    }
    public static void editDepartement(){
        showDepartements();
        Long id =(long) ConsoleClavier.lireEntier("veuillez entrez l'id de departement : ");

        DepartementService service = new DepartementService();
        Departement departementById = service.getDepartementById(id);

        String intitule = ConsoleClavier.lireString("Entrez  intitule de departement :");
        EnseignantsController.showEnseignants();
        Long idEnseignent = (long)  ConsoleClavier.lireEntier("Entrez l'id  de enseignant existe deja:");
        EnseignantService enseignantService = new EnseignantService();
        Enseignant enseignantById = enseignantService.getEnseignantById(idEnseignent);

        departementById.setIntitule(intitule);
        departementById.setChef(enseignantById);

        DepartementService departementService = new DepartementService();
        departementService.modifierDepartement(departementById);
    }
    public static void destroyDepartement(){
        showDepartements();
        Long id =(long) ConsoleClavier.lireEntier("veuillez entrez l'id de departement que vous shouhaitez  supprimer: ");

        DepartementService departementService = new DepartementService();
        departementService.supprimerDepartement(id);

    }
}
