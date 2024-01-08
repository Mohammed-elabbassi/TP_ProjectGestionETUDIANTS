package models;


import java.util.List;

public class Enseignant {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String grade;

    private Departement departement;
    private List<Filliere> fillieres;
    private List<Module> modules;

    public Enseignant() {
    }

    public Enseignant(Long id, String nom, String prenom, String email, String grade, Departement departement, List<Filliere> fillieres, List<Module> modules) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.grade = grade;
        this.departement = departement;
        this.fillieres = fillieres;
        this.modules = modules;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public List<Filliere> getFillieres() {
        return fillieres;
    }

    public void setFillieres(List<Filliere> fillieres) {
        this.fillieres = fillieres;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
