package dao;

import models.Etudiant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtudiantService {
    public void ajouterEtudiant(Etudiant etudiant) {
        DB conn = new DB();
        Connection connection = conn.getConnection();
        String query = "INSERT INTO etudiant (apogee, filliere_id, id, email, nom, prenom) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, etudiant.getApogee());
            statement.setLong(2, etudiant.getFilliere().getId());
            statement.setLong(3, etudiant.getId());
            statement.setString(4, etudiant.getEmail());
            statement.setString(5, etudiant.getNom());
            statement.setString(6, etudiant.getPrenom());
            statement.executeUpdate();
            System.out.println("bien inserer un neauveau enregistrement d'une etudiant dans la table");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
    }
    public Etudiant getEtudiantById(long etudiantId) {
        Etudiant etudiant = null;
        DB conn = new DB();
        Connection connection = conn.getConnection();
        try {
            String query = "SELECT apogee, filliere_id, id, email, nom, prenom FROM etudiant WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, etudiantId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                etudiant = new Etudiant();
                etudiant.setId(resultSet.getLong("id"));
                etudiant.setApogee(resultSet.getInt("apogee"));
                etudiant.setNom(resultSet.getString("nom"));
                etudiant.setPrenom(resultSet.getString("prenom"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return etudiant;
    }
    public List<Etudiant> getAllEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();
        DB conn = new DB();
        Connection connection = conn.getConnection();
        try {
            String query = "SELECT apogee, filliere_id, id, email, nom, prenom FROM etudiant";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Etudiant etudiant = new Etudiant();
                etudiant.setId(resultSet.getLong("id"));
                etudiant.setApogee(resultSet.getInt("apogee"));
                etudiant.setNom(resultSet.getString("nom"));
                etudiant.setPrenom(resultSet.getString("prenom"));
                etudiant.setEmail(resultSet.getString("email"));

                etudiants.add(etudiant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return etudiants;
    }
    public void modifierEtudiant(Etudiant etudiant) {
        DB conn = new DB();
        Connection connection = conn.getConnection();
        try {
            String query = "UPDATE etudiant SET apogee = ?, filliere_id = ?, email = ?, nom = ?, prenom = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, etudiant.getApogee());
            statement.setLong(2, etudiant.getFilliere().getId());
            statement.setString(3, etudiant.getEmail());
            statement.setString(4, etudiant.getNom());
            statement.setString(5, etudiant.getPrenom());
            statement.setLong(6, etudiant.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
    }
    public void supprimerEtudiant(long etudiantId) {
        DB conn = new DB();
        Connection connection = conn.getConnection();
        try {
            String query = "DELETE FROM etudiant WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, etudiantId);
            statement.executeUpdate();
            System.out.println("supprission etudiant de l'id : "+etudiantId+" bien traite");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           conn.disconnect();
        }
    }



}
