package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeDAO {
	private Connection connection;
	public EmployeDAO() {
		
	}
	public EmployeDAO(Connection connection) {
		this.connection = connection;
	}
	public int insertEmploye(Employe employe) {
		try {
			String insertSql = "INSERT INTO employe (cin,idprofil,nom,prenom,datnais,genre,email) values (?,?,?,?,?,?,?)";
			 PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
			 preparedStatement.setString(1, employe.getCin());
			 preparedStatement.setInt(2, employe.getIdProfil());
			 preparedStatement.setString(3, employe.getNom());
			 preparedStatement.setString(4, employe.getPrenom());
			 preparedStatement.setString(5, employe.getDatnais());
			 preparedStatement.setString(6, employe.getGenre());
			 preparedStatement.setString(7, employe.getEmail());
			 preparedStatement.execute();
			 preparedStatement.close();
			
			
		}
		catch(Exception e) {
			System.out.println(e);
			return 0;
		}
		return 1;
	}
	
	public int updateEmploye(Employe employe) {
		try {
			String updateSql = "update employe set idprofil = ? ,nom = ?,prenom = ?,datnais = ?,genre = ?,email = ? where cin = ?";
			 PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
			 preparedStatement.setString(7, employe.getCin());
			 preparedStatement.setInt(1, employe.getIdProfil());
			 preparedStatement.setString(2, employe.getNom());
			 preparedStatement.setString(3, employe.getPrenom());
			 preparedStatement.setString(4, employe.getDatnais());
			 preparedStatement.setString(5, employe.getGenre());
			 preparedStatement.setString(6, employe.getEmail());
			 preparedStatement.execute();
			 preparedStatement.close();
			
			
		}
		catch(Exception e) {
			System.out.println(e);
			return 0;
		}
		return 1;
	}
	public int deleteEmploye(Employe employe) {
		try {
			String updateSql = "DELETE FROM employe WHERE cin = ?";
			 PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
			 preparedStatement.setString(1, employe.getCin());
			 preparedStatement.execute();
			 preparedStatement.close();
			
			
		}
		catch(Exception e) {
			System.out.println(e);
			return 0;
		}
		return 1;
	}
	public ArrayList<Employe> selectEmployes() {
		ArrayList<Employe> employes =new ArrayList<Employe>();
		try {
			String sqlQuery = "SELECT * FROM employe";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()) {
			    // Retrieve data from columns
			    String cin = resultSet.getString("cin");
			    int idprofil = resultSet.getInt("idprofil");
			    String nom = resultSet.getString("nom");
			    String prenom = resultSet.getString("prenom");
			    String datnais = resultSet.getString("datnais");
			    String genre = resultSet.getString("genre");
			    String email = resultSet.getString("email");
			    
			    
			    employes.add(new Employe(cin,idprofil,nom,prenom,datnais,genre,email));

			
			}
		}
		
		catch(Exception e) {
			
		}
		
		return employes;
	}
	
	public ArrayList<Employe> selectEmployeesByLibelle(ArrayList<Employe> employes, ArrayList<String> profiles, String libelle) {
	    ArrayList<Employe> selectedEmployees = new ArrayList<>();

	    for (Employe employee : employes) {
	        int idprofil = employee.getIdProfil();
	        if (idprofil >= 0 && idprofil < profiles.size() && profiles.get(idprofil).equals(libelle)) {
	            selectedEmployees.add(employee);
	        }
	    }

	    return selectedEmployees;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public boolean checkCin(String cin) {
	    try {
	        String sqlQuery = "SELECT COUNT(*) FROM employe WHERE cin = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
	        preparedStatement.setString(1, cin);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            return count > 0;
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    
	    return false; 
	}
	public boolean checkNom(String nom) {
	    try {
	        String sqlQuery = "SELECT COUNT(*) FROM employe WHERE nom = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
	        preparedStatement.setString(1, nom);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            return count > 0;
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    
	    return false; 
	}
}