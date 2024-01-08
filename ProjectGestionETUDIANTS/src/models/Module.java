package models;


import java.util.List;

public class Module {

    private  Long id;
    private String nom;
    private Filliere moduleFiliere;
    private Enseignant professeur;
    private List<Note> notes;
    public Module(){
    }

    public Module(Long id,String nom, Filliere moduleFiliere, Enseignant professeur, List<Note> notes) {
        this.id=id;
        this.nom = nom;
        this.moduleFiliere = moduleFiliere;
        this.professeur = professeur;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Filliere getModuleFiliere() {
        return moduleFiliere;
    }

    public void setModuleFiliere(Filliere moduleFiliere) {
        this.moduleFiliere = moduleFiliere;
    }

    public Enseignant getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Enseignant professeur) {
        this.professeur = professeur;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
