package view;
import javax.swing.*;

import model.Profil;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class GestionEmploye extends JPanel {
    private JTextField cinFieldNord, prenomFieldNord, nomFieldNord, dateFieldNord, emailFieldNord;
    private NordPane nordPane;
    private CentrePane centrePane;
    private SudPane sudPane;
    private JButton ajouterButton, annulerButton, nextButton, previousButton, moddifierButton, suprimerButton;
    private JComboBox<String> genre, profile;
    private SimpleDateFormat dateFormat;

    private JTextField cinFieldCenter; 
    private JTextField nomCenter;
    private JTextField mailCenter;
    private JComboBox<String> genreCenter;
    private JTextField prenomCenter;
    private JComboBox<String> profileCenter;
    private JFormattedTextField dateFieldCenter;
    private JTextField mail;
    
    
    public GestionEmploye() {
        setLayout(new BorderLayout());
        nordPane = new NordPane();
        centrePane = new CentrePane();
        sudPane = new SudPane();

        add(nordPane, BorderLayout.NORTH);
        add(centrePane, BorderLayout.CENTER);
        add(sudPane, BorderLayout.SOUTH);
    }

    public class NordPane extends JPanel {
        public NordPane() {
            setLayout(new GridBagLayout());
            setBackground(Color.BLUE);
            GridBagConstraints rule = new GridBagConstraints();
            rule.insets = new Insets(10, 10, 10, 10);

            cinFieldNord = new JTextField();
            cinFieldNord.setPreferredSize(new Dimension(200, 20));
            rule.gridx = 0;
            rule.gridy = 0;
            add(cinFieldNord, rule);

            profile = new JComboBox<>(new String[]{"1", "2"});
            rule.gridx = 1;
            rule.gridy = 0;
            add(profile, rule);

            prenomFieldNord = new JTextField();
            prenomFieldNord.setPreferredSize(new Dimension(200, 20));
            rule.gridx = 2;
            rule.gridy = 0;
            add(prenomFieldNord, rule);

            nomFieldNord = new JTextField();
            nomFieldNord.setPreferredSize(new Dimension(200, 20));
            rule.gridx = 3;
            rule.gridy = 0;
            add(nomFieldNord, rule);

            dateFieldNord = new JTextField();
            dateFieldNord.setPreferredSize(new Dimension(200, 20));
            rule.gridx = 4;
            rule.gridy = 0;
            add(dateFieldNord, rule);

            genre = new JComboBox<>(new String[]{"Masculin", "Feminin"});
            rule.gridx = 5;
            rule.gridy = 0;
            add(genre, rule);

            emailFieldNord = new JTextField();
            emailFieldNord.setPreferredSize(new Dimension(200, 20));
            rule.gridx = 6;
            rule.gridy = 0;
            add(emailFieldNord, rule);

            previousButton = new JButton("<");
            rule.gridx = 1;
            rule.gridy = 1;
            add(previousButton, rule);

            nextButton = new JButton(">");
            rule.gridx = 2;
            rule.gridy = 1;
            add(nextButton, rule);

            moddifierButton = new JButton("Modifier");
            rule.gridx = 4;
            rule.gridy = 1;
            add(moddifierButton, rule);

            suprimerButton = new JButton("Supprimer");
            rule.gridx = 5;
            rule.gridy = 1;
            add(suprimerButton, rule);
        }
    }

    public class CentrePane extends JPanel {
    	public CentrePane() {
            setLayout(new GridBagLayout());
            setBackground(Color.GRAY);
            GridBagConstraints rule = new GridBagConstraints();
            rule.insets = new Insets(10, 10, 10, 10);

            JLabel cinLabelCenter = new JLabel("CIN");
            rule.gridx = 0;
            rule.gridy = 0;
            add(cinLabelCenter, rule);

            cinFieldCenter = new JTextField();
            cinFieldCenter.setPreferredSize(new Dimension(200, 20));
            rule.gridx = 1;
            rule.gridy = 0;
            add(cinFieldCenter, rule);

            JLabel nomLabel = new JLabel("Nom");
            rule.gridx = 0;
            rule.gridy = 1;
            add(nomLabel, rule);

            nomCenter = new JTextField();
            nomCenter.setPreferredSize(new Dimension(200, 20));
            rule.gridx = 1;
            rule.gridy = 1;
            add(nomCenter, rule);

            JLabel genreLabel = new JLabel("Genre");
            rule.gridx = 2;
            rule.gridy = 0;
            add(genreLabel, rule);

            genreCenter = new JComboBox<>(new String[]{"Masculin", "Feminin"});
            rule.gridx = 3;
            rule.gridy = 0;
            add(genreCenter, rule);

            JLabel prenomLabel = new JLabel("Prenom");
            rule.gridx = 2;
            rule.gridy = 1;
            add(prenomLabel, rule);

            prenomCenter = new JTextField();
            prenomCenter.setPreferredSize(new Dimension(200, 20));
            rule.gridx = 3;
            rule.gridy = 1;
            add(prenomCenter, rule);
            JLabel profileLabel = new JLabel("Profil");
            rule.gridx = 0;
            rule.gridy = 2;
            add(profileLabel, rule);

            profileCenter = new JComboBox<>();
            rule.gridx = 1;
            rule.gridy = 2;
            add(profileCenter, rule);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFieldCenter = new JFormattedTextField(dateFormat.format(new java.util.Date()));
            rule.gridx = 3;
            rule.gridy = 2;
            add(dateFieldCenter, rule);

            JLabel dateLabel = new JLabel("Date");
            rule.gridx = 2;
            rule.gridy = 2;
            add(dateLabel, rule);

            mailCenter = new JTextField();
            mailCenter.setPreferredSize(new Dimension(200, 20));
            rule.gridx = 1;
            rule.gridy = 3;
            add(mailCenter, rule);

            JLabel mailLabel = new JLabel("Mail");
            rule.gridx = 0;
            rule.gridy = 3;
            add(mailLabel, rule);
        }
    
    }

    public class SudPane extends JPanel {
        public SudPane() {
            setLayout(new FlowLayout());
            setBackground(Color.BLUE);

            ajouterButton = new JButton("Ajouter");
            add(ajouterButton);

            annulerButton = new JButton("Annuler");
            add(annulerButton);
        }
}
    

	public JTextField getCinFieldNord() {
		return cinFieldNord;
	}

	public void setCinFieldNord(JTextField cinFieldNord) {
		this.cinFieldNord = cinFieldNord;
	}

	public JTextField getPrenomFieldNord() {
		return prenomFieldNord;
	}

	public void setPrenomFieldNord(JTextField prenomFieldNord) {
		this.prenomFieldNord = prenomFieldNord;
	}

	public JTextField getNomFieldNord() {
		return nomFieldNord;
	}

	public void setNomFieldNord(JTextField nomFieldNord) {
		this.nomFieldNord = nomFieldNord;
	}

	public JTextField getDateFieldNord() {
		return dateFieldNord;
	}

	public void setDateFieldNord(JTextField dateFieldNord) {
		this.dateFieldNord = dateFieldNord;
	}

	public JTextField getEmailFieldNord() {
		return emailFieldNord;
	}

	public void setEmailFieldNord(JTextField emailFieldNord) {
		this.emailFieldNord = emailFieldNord;
	}

	public NordPane getNordPane() {
		return nordPane;
	}

	public void setNordPane(NordPane nordPane) {
		this.nordPane = nordPane;
	}

	public CentrePane getCentrePane() {
		return centrePane;
	}

	public void setCentrePane(CentrePane centrePane) {
		this.centrePane = centrePane;
	}

	public SudPane getSudPane() {
		return sudPane;
	}

	public void setSudPane(SudPane sudPane) {
		this.sudPane = sudPane;
	}

	public JButton getAjouterButton() {
		return ajouterButton;
	}

	public void setAjouterButton(JButton ajouterButton) {
		this.ajouterButton = ajouterButton;
	}

	public JButton getAnnulerButton() {
		return annulerButton;
	}

	public void setAnnulerButton(JButton annulerButton) {
		this.annulerButton = annulerButton;
	}

	public JButton getNextButton() {
		return nextButton;
	}

	public void setNextButton(JButton nextButton) {
		this.nextButton = nextButton;
	}

	public JButton getPreviousButton() {
		return previousButton;
	}

	public void setPreviousButton(JButton previousButton) {
		this.previousButton = previousButton;
	}

	public JButton getModdifierButton() {
		return moddifierButton;
	}

	public void setModdifierButton(JButton moddifierButton) {
		this.moddifierButton = moddifierButton;
	}

	
	public JButton getSuprimerButton() {
		return suprimerButton;
	}

	public void setSuprimerButton(JButton suprimerButton) {
		this.suprimerButton = suprimerButton;
	}

	public JComboBox<String> getGenre() {
		return genre;
	}

	public void setGenre(JComboBox<String> genre) {
		this.genre = genre;
	}
	public void setComboBoxProfil(ArrayList<Profil> profiles) {
		profileCenter.removeAllItems();
		profile.removeAllItems();
		
		for(Profil prof:profiles) {
			profileCenter.addItem(Integer.toString(prof.getIdprofil()));
			profile.addItem(Integer.toString(prof.getIdprofil()));
			
		}
	}
	public JComboBox<String> getProfile() {
		return profile;
	}

	public void setProfile(JComboBox<String> profile) {
		this.profile = profile;
	}

	public JTextField getCinFieldCenter() {
		return cinFieldCenter;
	}

	public void setCinFieldCenter(JTextField cinFieldCenter) {
		this.cinFieldCenter = cinFieldCenter;
	}

	public JTextField getNomCenter() {
		return nomCenter;
	}

	public void setNomCenter(JTextField nomCenter) {
		this.nomCenter = nomCenter;
	}

	public JTextField getMailCenter() {
		return mailCenter;
	}

	public void setMailCenter(JTextField mailCenter) {
		this.mailCenter = mailCenter;
	}

	public JComboBox<String> getGenreCenter() {
		return genreCenter;
	}

	public void setGenreCenter(JComboBox<String> genreCenter) {
		this.genreCenter = genreCenter;
	}

	public JTextField getPrenomCenter() {
		return prenomCenter;
	}

	public void setPrenomCenter(JTextField prenomCenter) {
		this.prenomCenter = prenomCenter;
	}

	public JComboBox<String> getProfileCenter() {
		return profileCenter;
	}

	public void setProfileCenter(JComboBox<String> profileCenter) {
		this.profileCenter = profileCenter;
	}

	public JFormattedTextField getDateFieldCenter() {
		return dateFieldCenter;
	}

	public void setDateFieldCenter(JFormattedTextField dateFieldCenter) {
		this.dateFieldCenter = dateFieldCenter;
	}

	public JTextField getMail() {
		return mail;
	}

	public void setMail(JTextField mail) {
		this.mail = mail;
	}

	
	



    
}
