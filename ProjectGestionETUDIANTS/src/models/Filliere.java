package models;

import java.util.List;

public class Filliere {
    private  Long id;
    private String intitule;
    private Departement departement;
    private Enseignant enseignant;
    List<Etudiant> etudiants;
    List<Module> modules;
    public Filliere(){
    }

    public Filliere(Long id,String intitule, Departement departement, Enseignant enseignant, List<Etudiant> etudiants, List<Module> modules) {
        this.id=id;
        this.intitule = intitule;
        this.departement = departement;
        this.enseignant = enseignant;
        this.etudiants = etudiants;
        this.modules = modules;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
