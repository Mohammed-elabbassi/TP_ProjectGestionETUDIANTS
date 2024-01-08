package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private  String url = "jdbc:mysql://localhost:3306/gestionetudiants";
    private  String username = "root";
    private  String password = "";
    private  Connection connection;

    public DB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Creation connexion");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Connection getConnection() {
        return connection;
    }
    public void disconnect(){
        try{
            connection.close();
            System.out.println("la connexion ferme a la base de donnees ");

        }catch(Exception e){
            System.out.println("un probleme de fermeture de base de donnee ");
        }
    }

}
