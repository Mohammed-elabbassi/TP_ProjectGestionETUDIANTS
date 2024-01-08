package dao;

import models.Departement;
import models.Filliere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilliereService {
    public void ajouterFilliere(Filliere filliere) {
        DB conn = new DB();
        Connection connection = conn.getConnection();
        String query = "INSERT INTO filliere (id, departement_id, enseignant_id, intitule) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, filliere.getId());
            statement.setLong(2, filliere.getDepartement().getId());
            statement.setLong(3, filliere.getEnseignant().getId());
            statement.setString(4, filliere.getIntitule());
            statement.executeUpdate();
            System.out.println("bien inserer un neauveau enregistrement d'une filliere dans la table");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
    }
    public Filliere getFilliereById(long filliereId) {
        Filliere filliere = null;
        DB conn = new DB();
        Connection connection = conn.getConnection();
        String query = "SELECT id, departement_id, enseignant_id, intitule FROM filliere WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, filliereId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                filliere = new Filliere();
                filliere.setId(resultSet.getLong("id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return filliere;
    }
    public List<Filliere> getAllFillieres() {
        List<Filliere> filieres = new ArrayList<>();
        DB conn = new DB();
        Connection connection = conn.getConnection();
        String query = "SELECT id, departement_id, enseignant_id, intitule FROM filliere";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Filliere filliere = new Filliere();
                filliere.setId(resultSet.getLong("id"));
                filliere.setIntitule(resultSet.getString("intitule"));

                filieres.add(filliere);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return filieres;
    }

    public void modifierFilliere(Filliere filliere) {
        DB conn = new DB();
        Connection connection = conn.getConnection();
        String query = "UPDATE filliere SET departement_id = ?, enseignant_id = ?, intitule = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, filliere.getDepartement().getId());
            statement.setLong(2, filliere.getEnseignant().getId());
            statement.setString(3, filliere.getIntitule());
            statement.setLong(4, filliere.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
    }
    public void supprimerFilliere(long filliereId) {
        DB conn = new DB();
        Connection connection = conn.getConnection();
        String query = "DELETE FROM filliere WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, filliereId);
            statement.executeUpdate();
            System.out.println("supprission de filliere de l'id : "+filliereId+" bien traite");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
    }



}
