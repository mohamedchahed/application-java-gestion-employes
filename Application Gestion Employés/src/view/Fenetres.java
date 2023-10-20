package view;
import javax.swing.*;
import java.awt.*;


public class Fenetres extends JTabbedPane {
	/**
	 * 
	 */
	private Bienvenue bienvenue;
	private GestionEmploye gestion ;
	private ListeProEmp liste;
	private GestionPro gestionP;
	public Fenetres() {
		super(JTabbedPane.TOP);
		bienvenue = new Bienvenue();
		bienvenue.setPreferredSize(new Dimension(300, 800));
		add(bienvenue,"Bienvenue");
		gestionP = new GestionPro();
		add(gestionP, "Gestion Profils");
		gestion = new GestionEmploye();
		add(gestion, "Gestion Employe");
		liste = new ListeProEmp();
		add(liste, "Liste Employés/Profils");
	}
	public Bienvenue getBienvenue() {
		return bienvenue;
	}
	public void setBienvenue(Bienvenue bienvenue) {
		this.bienvenue = bienvenue;
	}
	public GestionEmploye getGestion() {
		return gestion;
	}
	public void setGestion(GestionEmploye gestion) {
		this.gestion = gestion;
	}
	public ListeProEmp getListe() {
		return liste;
	}
	public void setListe(ListeProEmp liste) {
		this.liste = liste;
	}
	public GestionPro getGestionP() {
		return gestionP;
	}
	public void setGestionP(GestionPro gestionP) {
		this.gestionP = gestionP;
	}
	
	
}