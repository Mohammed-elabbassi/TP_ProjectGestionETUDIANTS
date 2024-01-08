package dao;

import models.Departement;
import models.Module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModuleService {
    public void ajouterModule(Module module) {
        DB conn = new DB();
        Connection connection = conn.getConnection();
        String query = "INSERT INTO module (id, filiere_id, professeur_id, nom) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, module.getId());
            statement.setLong(2, module.getModuleFiliere().getId());
            statement.setLong(3, module.getProfesseur().getId());
            statement.setString(4, module.getNom());
            statement.executeUpdate();
            System.out.println("bien inserer un neauveau enregistrement d'une module dans la table ");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.disconnect();
        }
    }
    public Module getModuleById(long moduleId) {
        Module module = null;
        DB conn = new DB();
        Connection connection = conn.getConnection();
        try {
            String query = "SELECT filiere_id, id, professeur_id, nom FROM module WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, moduleId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                module = new Module();
                module.setId(resultSet.getLong("id"));
                // Récupérer d'autres attributs du module depuis le ResultSet
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return module;
    }
    public List<Module> getAllModules() {
        List<Module> modules = new ArrayList<>();
        DB conn = new DB();
        Connection connection = conn.getConnection();
        try {
            String query = "SELECT filiere_id, id, professeur_id, nom FROM module";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Module module = new Module();
                module.setId(resultSet.getLong("id"));
                module.setNom(resultSet.getString("nom"));
                // Récupérer d'autres attributs du module depuis le ResultSet
                modules.add(module);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return modules;
    }

    public void modifierModule(Module module) {
        DB conn = new DB();
        Connection connection = conn.getConnection();
        try {
            String query = "UPDATE module SET filiere_id = ?, professeur_id = ?, nom = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, module.getModuleFiliere().getId());
            statement.setLong(2, module.getProfesseur().getId());
            statement.setString(3, module.getNom());
            statement.setLong(4, module.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
    }
    public void supprimerModule(long moduleId) {
        DB conn = new DB();
        Connection connection = conn.getConnection();
        try {
            String query = "DELETE FROM module WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, moduleId);
            statement.executeUpdate();
            System.out.println("supprission de module de l'id : "+moduleId+" bien traite");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
    }




}
