package controllers;

import dao.DepartementService;
import dao.EnseignantService;
import dao.FilliereService;
import dao.ModuleService;
import models.Departement;
import models.Enseignant;
import models.Filliere;
import models.Module;
import util.ConsoleClavier;

import java.util.List;

public class ModuleController {
    public static void showMenu(){
        System.out.println("-------------------------[ Fillieres ]---------------------------");


        System.out.println("1: Pour ajouter un Module");
        System.out.println("2: Pour afficher les modules");
        System.out.println("3: Pour modifier un Module");
        System.out.println("4: Pour supprimer un Module");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = ConsoleClavier.lireEntier("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createModule();
                break;
            case 2:
                showModules();
                break;
            case 3:
                editModule();
                break;
            case 4:
                destroyModule();
                break;
            default:
                ConsoleClavier.showPrincipalMenu();
        }
    }

    public static void createModule() {
        Long idModule =(long) ConsoleClavier.lireEntier("veuillez entrez l'id du Module : ");
        String nom = ConsoleClavier.lireString("Entrez  nom de module :");


        FilliereController.showFillieres();
        Long idFilliere = (long) ConsoleClavier.lireEntier("Entrez  id de filliere que vous avez rechercher:");
        FilliereService filliereService = new FilliereService();
        Filliere filliereById = filliereService.getFilliereById(idFilliere);

        EnseignantsController.showEnseignants();
        Long idEnseignent = (long)  ConsoleClavier.lireEntier("Entrez l'id  de enseignant que vous avez rechercher:");
        EnseignantService enseignantService = new EnseignantService();
        Enseignant enseignantById = enseignantService.getEnseignantById(idEnseignent);


        Module module = new Module();
        module.setId(idModule);
        module.setNom(nom);
        module.setProfesseur(enseignantById);
        module.setModuleFiliere(filliereById);

        ModuleService moduleService = new ModuleService();
        moduleService.ajouterModule(module);
    }
    public static void showModules() {
        ModuleService service = new ModuleService();
        List<Module> allModules = service.getAllModules();
        for (Module module:allModules){
            System.out.println(module.getId() +" | "+module.getNom());
        }
    }
    public static void editModule() {

        showModules();
        Long idModule =(long) ConsoleClavier.lireEntier("veuillez entrez l'id du Module que vous recherchez : ");
        String nom = ConsoleClavier.lireString("Entrez  nom de module :");


        FilliereController.showFillieres();
        Long idFilliere = (long) ConsoleClavier.lireEntier("Entrez  id de filliere existe deja :");
        FilliereService filliereService = new FilliereService();
        Filliere filliereById = filliereService.getFilliereById(idFilliere);

        EnseignantsController.showEnseignants();
        Long idEnseignent = (long)  ConsoleClavier.lireEntier("Entrez l'id  de enseignant existe deja:");
        EnseignantService enseignantService = new EnseignantService();
        Enseignant enseignantById = enseignantService.getEnseignantById(idEnseignent);

        ModuleService moduleService = new ModuleService();
        Module moduleById = moduleService.getModuleById(idModule);
        moduleById.setNom(nom);
        moduleById.setProfesseur(enseignantById);
        moduleById.setModuleFiliere(filliereById);

        moduleService.modifierModule(moduleById);



    }

    private static void destroyModule() {
        showModules();
        Long id =(long) ConsoleClavier.lireEntier("veuillez entrez l'id de Module que vous shouhaitez supprimer : ");
        ModuleService service = new ModuleService();
        service.supprimerModule(id);

    }






}
