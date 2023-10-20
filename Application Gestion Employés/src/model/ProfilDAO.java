package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfilDAO {
    private Connection connection;

    public ProfilDAO() {
    }

    public ProfilDAO(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<String> selectProfiles() {
        ArrayList<String> profiles = new ArrayList<>();
        String sqlQuery = "SELECT libelle FROM profil";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String profile = resultSet.getString("libelle");
                profiles.add(profile);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return profiles;
    }
    public ArrayList<Profil> selectProfiless() {
        ArrayList<Profil> profiles = new ArrayList<Profil>();
        String sqlQuery = "SELECT * FROM profil";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String profile = resultSet.getString("libelle");
                int idprofil = resultSet.getInt("idprofil");
                
                profiles.add(new Profil(idprofil,profile));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return profiles;
    }


    public int insertProfil(Profil profil) {
        try {
        	String insertSql = "INSERT INTO PROFIL (idprofil, libelle) VALUES (?, ?)";;
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setLong(1,profil.getIdprofil());
            preparedStatement.setString(2,profil.getLibelle());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

        return 1;
    }

    public ArrayList<Employe> selectEmployeesByProfile(String libelle) {
        ArrayList<Employe> employees = new ArrayList<>();

        try {
            String sqlQuery = "SELECT employe.* " +
                             "FROM employe " +
                             "JOIN profil " +
                             "ON employe.idprofil = profil.idprofil " +
                             "WHERE profil.libelle = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, libelle);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String cin = resultSet.getString("cin");
                int idProfil = resultSet.getInt("idprofil");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String datnais = resultSet.getString("datnais");
                String genre = resultSet.getString("genre");
                String email = resultSet.getString("email");

                Employe employe = new Employe(cin, idProfil, nom, prenom, datnais, genre, email);

                employees.add(employe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }



    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
	public boolean checkLibelle(String libelle) {
	    try {
	        String sqlQuery = "SELECT COUNT(*) FROM profil WHERE libelle = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
	        preparedStatement.setString(1, libelle);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            return count > 0;
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return false; }
}
