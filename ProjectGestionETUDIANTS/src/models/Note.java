package models;


public class Note {
    private Long id;
    private double note;
    private Etudiant etudiant;
    private Module module;
    public Note(){
    }

    public Note(Long id,double note, Etudiant etudiant, Module module) {
        this.id = id;
        this.note = note;
        this.etudiant = etudiant;
        this.module = module;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
