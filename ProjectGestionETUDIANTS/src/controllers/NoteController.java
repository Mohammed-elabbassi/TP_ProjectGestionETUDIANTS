package controllers;

import dao.*;
import models.*;
import models.Module;
import util.ConsoleClavier;

import java.util.List;

public class NoteController {
    public static void showMenu(){
        System.out.println("-------------------------[ Notes ]---------------------------");


        System.out.println("1: Pour ajouter un Note");
        System.out.println("2: Pour afficher les Notes");
        System.out.println("3: Pour modifier un Note");
        System.out.println("4: Pour supprimer un Note");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = ConsoleClavier.lireEntier("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createNote();
                break;
            case 2:
                showNotes();
                break;
            case 3:
                editNote();
                break;
            case 4:
                destroyNote();
                break;
            default:
                ConsoleClavier.showPrincipalMenu();
        }
    }
    public static void createNote() {
        Long idNote = (long) ConsoleClavier.lireEntier("Entrez  id de note :");
        double noteEtudiant =   ConsoleClavier.lireEntier("Entrez la note de etudiant :");


        ModuleController.showModules();
        long idModule = ConsoleClavier.lireEntier("Entrez  un  id module deja exist :"); ;
        ModuleService moduleService = new ModuleService();
        Module moduleById = moduleService.getModuleById(idModule);


        EtudiantController.showEtudiants();
        long idEtudiant = ConsoleClavier.lireEntier("Entrez  un  id etudinat deja exist :"); ;
        EtudiantService filliereService = new EtudiantService();
        Etudiant etudiantById = filliereService.getEtudiantById(idEtudiant);


        Note note = new Note();
        note.setId(idNote);
        note.setNote(noteEtudiant);
        note.setModule(moduleById);
        note.setEtudiant(etudiantById);

        NoteService noteService = new NoteService();
        noteService.ajouterNote(note);

    }
    public static void showNotes() {
        NoteService service = new NoteService();
        List<Note> allNotes = service.getAllNotes();
        for (Note note:allNotes){
            System.out.println(note.getId() + "|" + note.getNote());
        }
    }
    public static void editNote() {
        showNotes();
        Long idNote = (long) ConsoleClavier.lireEntier("Entrez  id de note que vous  recherchez:");
        double noteEtudiant =   ConsoleClavier.lireEntier("Entrez la note de etudiant :");


        ModuleController.showModules();
        long idModule = ConsoleClavier.lireEntier("Entrez  un  id module deja exist :"); ;
        ModuleService moduleService = new ModuleService();
        Module moduleById = moduleService.getModuleById(idModule);


        EtudiantController.showEtudiants();
        long idEtudiant = ConsoleClavier.lireEntier("Entrez  un  id etudinat deja exist :"); ;
        EtudiantService filliereService = new EtudiantService();
        Etudiant etudiantById = filliereService.getEtudiantById(idEtudiant);


        NoteService noteService = new NoteService();
        Note noteById = noteService.getNoteById(idNote);

        noteById.setNote(noteEtudiant);
        noteById.setModule(moduleById);
        noteById.setEtudiant(etudiantById);

        noteService.modifierNote(noteById);


    }
    public static void destroyNote() {
        showNotes();
        Long id =(long) ConsoleClavier.lireEntier("veuillez entrez l'id de Note que vous shouhaitez supprimer : ");

        NoteService service = new NoteService();
        service.supprimerNote(id);

    }
}
