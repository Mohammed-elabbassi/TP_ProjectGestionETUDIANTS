package dao;


import models.Departement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DepartementService {

    public void ajouterDepartement(Departement departement) {
        DB conn = new DB();
        Connection connection = conn.getConnection();
        String query = "INSERT INTO departement (id, responsable_id, intitule) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, departement.getId());
            statement.setLong(2, departement.getChef().getId());
            statement.setString(3, departement.getIntitule());
            statement.executeUpdate();
            System.out.println("bien inserer un neauveau enregistrement d'une departement dans la table ");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.disconnect();
        }
    }
    public Departement getDepartementById(long departementId) {
        Departement departement = null;

        DB conn = new DB();
        Connection connection = conn.getConnection();
        String query = "SELECT id, responsable_id, intitule FROM departement WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, departementId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                departement = new Departement();
                departement.setId(resultSet.getLong("id"));
                // Remplir les détails du département depuis le ResultSet
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            conn.disconnect();
        }
        return departement;
    }

    public List<Departement> getAllDepartements() {
        List<Departement> departements = new ArrayList<>();
        DB conn = new DB();
        Connection connection = conn.getConnection();
        String query = "SELECT id, responsable_id, intitule FROM departement";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Departement departement = new Departement();
                departement.setId(resultSet.getLong("id"));
                departement.setIntitule(resultSet.getString("intitule"));
                departements.add(departement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return departements;
    }

    public void modifierDepartement(Departement departement) {
        DB conn = new DB();
        Connection connection = conn.getConnection();
        String query = "UPDATE departement SET responsable_id = ?, intitule = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, departement.getChef().getId());
            statement.setString(2, departement.getIntitule());
            statement.setLong(3, departement.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
    }

    public void supprimerDepartement(long departementId) {
        DB conn = new DB();
        Connection connection = conn.getConnection();
        String query = "DELETE FROM departement WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, departementId);
            statement.executeUpdate();
            System.out.println("la departement :"+departementId+" bien supprime");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
    }


}
