package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connexion {
		String url = "jdbc:mysql://localhost:3306/gestionemploye?serverTimezone=UTC";
		private static String utilisateur = "root";
		private static String motDePasse = "";
		private static Connection connexion = null;
		Connexion() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
        System.out.println("Connexion à la base de données établie avec succès !");

		} catch ( Exception e ) {
		e.printStackTrace();}
		}
		public static Connection getConnection() {
			if (connexion == null) {
			new Connexion();}
			return connexion; }

			public static void stop() {
			if (connexion != null) {
			try {
			connexion.close();
			} catch (SQLException e) {
			e.printStackTrace();}
			}
			}
			}
	
