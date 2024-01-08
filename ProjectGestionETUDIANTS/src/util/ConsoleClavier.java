package util;

import controllers.*;

import java.util.Scanner;

public class ConsoleClavier {

    private static Scanner scanner = new Scanner(System.in);

    public static int lireEntier(String s) {
        System.out.println(s);
        int entier = 0;
        boolean entierValide = false;

        while (!entierValide) {
            try {
                entier = Integer.parseInt(scanner.nextLine());
                entierValide = true;
                System.out.println(entier);
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un entier valide !");
            }
        }

        return entier;
    }
    public static String lireString(String s) {
        System.out.println(s);
        String message = "";
        boolean saisieValide = false;

        while (!saisieValide) {
            message = scanner.nextLine().trim(); // Enlever les espaces avant et après
            if (message != null && !message.isEmpty()) {
                saisieValide = true;
            } else {
                System.out.println("Veuillez entrer une chaîne non vide !");
            }
        }
        return message;
    }
    public static void showPrincipalMenu(){
        System.out.println("-------------------------[ Bienvenu ]---------------------------");


        System.out.println("1:  gérer les départements");
        System.out.println("2:  gérer les filières");
        System.out.println("3:  gérer les enseignants");
        System.out.println("4:  gérer les modules");
        System.out.println("5:  gérer les étudiants");
        System.out.println("6:  gérer les notes");
        System.out.println("0: Pour sortir");


        int option = lireEntier("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                DepartementController.showMenu();
                break;
            case 2:
                FilliereController.showMenu();
                break;
            case 3:
                EnseignantsController.showMenu();
                break;
            case 4:
                ModuleController.showMenu();
                break;
            case 5:
                EtudiantController.showMenu();
                break;
            case 6:
                NoteController.showMenu();
                break;
            default:
                // code block
        }
    }

}

