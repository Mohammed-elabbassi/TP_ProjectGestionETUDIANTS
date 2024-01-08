package dao;


import models.Note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoteService {
    public void ajouterNote(Note note) {
        DB conn = new DB();
        Connection connection = conn.getConnection();
        String query = "INSERT INTO note (note, etudiant_id,id, module_id) VALUES (?, ?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDouble(1, note.getNote());
            statement.setLong(2, note.getEtudiant().getId());
            statement.setLong(3, note.getId());
            statement.setLong(4, note.getModule().getId());
            statement.executeUpdate();
            System.out.println("bien inserer un neauveau enregistrement d'une NOTE dans la table ");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.disconnect();
        }
    }
    public Note getNoteById(long noteId) {
        Note note = null;
        DB conn = new DB();
        Connection connection = conn.getConnection();
        try {
            String query = "SELECT note, etudiant_id, id, module_id FROM note WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, noteId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                note = new Note();
                note.setId(resultSet.getLong("id"));
                note.setNote(resultSet.getDouble("note"));
                // Récupérer d'autres attributs de la note depuis le ResultSet
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return note;
    }
    public List<Note> getAllNotes() {
        List<Note> notes = new ArrayList<>();
        DB conn = new DB();
        Connection connection = conn.getConnection();
        try {
            String query = "SELECT note, etudiant_id, id, module_id FROM note";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Note note = new Note();
                note.setId(resultSet.getLong("id"));
                note.setNote(resultSet.getDouble("note"));
                // Récupérer d'autres attributs de la note depuis le ResultSet
                notes.add(note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return notes;
    }

    public void modifierNote(Note note) {
        DB conn = new DB();
        Connection connection = conn.getConnection();
        try {
            String query = "UPDATE note SET note = ?, etudiant_id = ?, module_id = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDouble(1, note.getNote());
            statement.setLong(2, note.getEtudiant().getId());
            statement.setLong(3, note.getModule().getId());
            statement.setLong(4, note.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
    }
    public void supprimerNote(long noteId) {
        DB conn = new DB();
        Connection connection = conn.getConnection();
        try {
            String query = "DELETE FROM note WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, noteId);
            statement.executeUpdate();
            System.out.println("supprission de la note de l'id : "+noteId+" bien traite");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
    }
}
