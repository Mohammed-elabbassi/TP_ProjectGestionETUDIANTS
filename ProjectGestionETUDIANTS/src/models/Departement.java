package models;
import java.util.ArrayList;
import java.util.List;


public class Departement {
    private Long id;

    private String intitule;

    private Enseignant chef;
    List<Filliere> fillieres = new ArrayList<>();

    public Departement() {
    }


    public Departement(Long id, String intitule, Enseignant chef, List<Filliere> fillieres) {
        this.id = id;
        this.intitule = intitule;
        this.chef = chef;
        this.fillieres = fillieres;
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

    public Enseignant getChef() {
        return chef;
    }

    public void setChef(Enseignant chef) {
        this.chef = chef;
    }

    public List<Filliere> getFillieres() {
        return fillieres;
    }

    public void setFillieres(List<Filliere> fillieres) {
        this.fillieres = fillieres;
    }
}
