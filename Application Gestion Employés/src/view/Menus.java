package view;
import javax.swing.*;
import java.awt.*;

public class Menus extends JMenuBar {
    private JMenu gestion;
    private JMenu rechercher;
    private JMenu couleurs;
    private JMenuItem profil;
    private JMenuItem employe;
    private JMenuItem employePro;
    private JMenuItem quitter;
    private JMenuItem cinEmp;
    private JMenuItem nomEmp;
    private JMenuItem rouge;
    private JMenuItem bleu;
    private JMenuItem magneta;

    public Menus() {
        gestion = new JMenu("Gestion");
        add(gestion);
        rechercher = new JMenu("Rechercher");
        add(rechercher);
        couleurs = new JMenu("Couleurs");
        add(couleurs);

        // Menu Items
        profil = new JMenuItem("Gestion profils");
        employe = new JMenuItem("Gestion employés");
        employePro = new JMenuItem("Employés/Profil");
        quitter = new JMenuItem("Quitter");
        cinEmp = new JMenuItem("Cin Employé");
        nomEmp = new JMenuItem("Nom Employé");
        rouge = new JMenuItem("Rouge");
        bleu = new JMenuItem("Bleu");
        magneta = new JMenuItem("Magneta");

        // Adding Items to Menus
        gestion.add(profil);
        gestion.add(new JSeparator()); 
        gestion.add(employe);
        gestion.add(new JSeparator()); 
        gestion.add(employePro);
        gestion.add(new JSeparator()); 
        gestion.add(quitter);
        rechercher.add(cinEmp);
        rechercher.add(new JSeparator()); 
        rechercher.add(nomEmp);
        couleurs.add(rouge);
        couleurs.add(bleu);
        couleurs.add(magneta);
        // Adding to Menu
        add(gestion);
        add(rechercher);
        add(couleurs);}

	public JMenu getGestion() {
		return gestion;
	}

	public void setGestion(JMenu gestion) {
		this.gestion = gestion;
	}

	public JMenu getRechercher() {
		return rechercher;
	}

	public void setRechercher(JMenu rechercher) {
		this.rechercher = rechercher;
	}

	public JMenu getCouleurs() {
		return couleurs;
	}

	public void setCouleurs(JMenu couleurs) {
		this.couleurs = couleurs;
	}

	public JMenuItem getProfil() {
		return profil;
	}

	public void setProfil(JMenuItem profil) {
		this.profil = profil;
	}

	public JMenuItem getEmploye() {
		return employe;
	}

	public void setEmploye(JMenuItem employe) {
		this.employe = employe;
	}

	public JMenuItem getEmployePro() {
		return employePro;
	}

	public void setEmployePro(JMenuItem employePro) {
		this.employePro = employePro;
	}

	public JMenuItem getQuitter() {
		return quitter;
	}

	public void setQuitter(JMenuItem quitter) {
		this.quitter = quitter;
	}

	public JMenuItem getCinEmp() {
		return cinEmp;
	}

	public void setCinEmp(JMenuItem cinEmp) {
		this.cinEmp = cinEmp;
	}

	public JMenuItem getNomEmp() {
		return nomEmp;
	}

	public void setNomEmp(JMenuItem nomEmp) {
		this.nomEmp = nomEmp;
	}

	public JMenuItem getRouge() {
		return rouge;
	}

	public void setRouge(JMenuItem rouge) {
		this.rouge = rouge;
	}

	public JMenuItem getBleu() {
		return bleu;
	}
	
	public JMenuItem getMagneta() {
		return magneta;
	}
	public void setMagneta(JMenuItem rouge) {
		this.magneta = magneta;
	}
}
