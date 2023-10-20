package view;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


class InterfaceGestion extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar barreMenus ;
	private Fenetres Fenetres;
	private Menus Menus;
	private Connection connection ;
	private EmployeDAO employeDAO;
	private ProfilDAO profilDAO;
	private ArrayList<Employe> employes;
	private ArrayList<String> profiles;
	private int index;
	Image icon;
	int id;
	public InterfaceGestion() {
		super("Application de Gestion Des Employes");
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\\\Users\\\\chahe\\\\Desktop\\\\icon.jpg");
		setIconImage(icon);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1600,1400);
		setVisible(true);
		initComponents();
		initConnection();
		initListeEmp();
		
		
		profiles = profilDAO.selectProfiles();
    	Fenetres.getListe().setComboboxProfil(profilDAO.selectProfiless());
		Fenetres.getGestion().setComboBoxProfil(profilDAO.selectProfiless());
		id = profiles.size();
		refreshProfiles();
		System.out.println(profiles);
		
		
		employes = employeDAO.selectEmployes();
		if (employes.isEmpty()) {
			setDefaultEmployes();
		}
		else {
			initEmployes();
		}
		
		
		
        Fenetres.getListe().getComboBoxProfil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	initConnection();
            	Fenetres.getListe().getSudPane().removeAll();
            	initListeEmp();
        	    Fenetres.getListe().getSudPane().revalidate();
        	    Fenetres.getListe().getSudPane().repaint();
            }
        });

        Fenetres.getGestionP().getAjouterButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String libelle = Fenetres.getGestionP().getTextField().getText();

                if (libelle.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Le champ 'Libellé' ne peut pas être vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!profilDAO.checkLibelle(libelle)) {
                    id++;
                    Profil profil = new Profil(id, libelle);
                    profilDAO.insertProfil(profil);
                    refreshProfiles();
                	Fenetres.getListe().setComboboxProfil(profilDAO.selectProfiless());
            		Fenetres.getGestion().setComboBoxProfil(profilDAO.selectProfiless());
                    // Set the text field to an empty string after processing
                    Fenetres.getGestionP().getTextField().setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Ce libellé existe déjà", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

		Fenetres.getGestionP().getAnnulerButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			Fenetres.getGestionP().getTextField().setText("");	
			}});
		
		
		Menus.getRouge().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Fenetres.getGestion().getNordPane().setBackground(Color.red);
				Fenetres.getGestion().getSudPane().setBackground(Color.red);
				Fenetres.getGestionP().getLeftPanel().setBackground(Color.red);
				Fenetres.getListe().getNordPane().setBackground(Color.red);
				
				
			}
		});
		Menus.getBleu().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Fenetres.getGestion().getNordPane().setBackground(Color.blue);
				Fenetres.getGestion().getSudPane().setBackground(Color.blue);
				Fenetres.getGestionP().getLeftPanel().setBackground(Color.blue);
				Fenetres.getListe().getNordPane().setBackground(Color.blue);
				
				
			}
		});
		
		Menus.getMagneta().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Fenetres.getGestion().getNordPane().setBackground(Color.magenta);
				Fenetres.getGestion().getSudPane().setBackground(Color.magenta);
				Fenetres.getGestionP().getLeftPanel().setBackground(Color.magenta);
				Fenetres.getListe().getNordPane().setBackground(Color.magenta);
				
				
			}
		});
		
		
		Menus.getCinEmp().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String cin = null;
		        do {
		            cin = JOptionPane.showInputDialog(null, "Saisissez CIN SVP (ou annulez pour quitter)", "Recherche CIN", JOptionPane.INFORMATION_MESSAGE);
		            if (cin == null) {
		                // The user clicked cancel
		                break;
		            }
		            if (cin.isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Veuillez saisir un CIN valide ou cliquez sur Annuler pour quitter.", "Erreur", JOptionPane.ERROR_MESSAGE);
		            }
			        if(employeDAO.checkCin(cin)) {
			        	JOptionPane.showMessageDialog(null, "L'employé existe.", "Erreur", JOptionPane.ERROR_MESSAGE);}
			        else {
			        	JOptionPane.showMessageDialog(null, "L'employé n'existe pas.", "Erreur", JOptionPane.ERROR_MESSAGE)
			        ;}
		        } while (cin.isEmpty());

		        	
		    }
		});

		Menus.getNomEmp().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String nomEmploye = null;
		        do {
		            nomEmploye = JOptionPane.showInputDialog(null, "Saisissez le Nom de l'Employé SVP (ou annulez pour quitter)", "Recherche Nom Employé", JOptionPane.INFORMATION_MESSAGE);
		            if (nomEmploye == null) {
		                break;
		            }
		            if (nomEmploye.isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Veuillez saisir un nom d'employé valide ou cliquez sur Annuler pour quitter.", "Erreur", JOptionPane.ERROR_MESSAGE);
		            }
			        if(employeDAO.checkNom(nomEmploye)) {
			        	JOptionPane.showMessageDialog(null, "l'employé existe.", "Erreur", JOptionPane.ERROR_MESSAGE);}
			        else {
			        	JOptionPane.showMessageDialog(null, "L'employé n'existe pas.", "Erreur", JOptionPane.ERROR_MESSAGE)
			        	
			        ;}
		        } while (nomEmploye.isEmpty());

		        
		    }
		});

		Menus.getQuitter().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int o  = JOptionPane.showConfirmDialog(
	                    null,
	                    "Voulez vous Quitter?",
	                    "Confirmez",
	                    JOptionPane.YES_NO_OPTION
	            );
				if (o == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		Menus.getEmploye().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Fenetres.setSelectedComponent(Fenetres.getGestion());
				Fenetres.setEnabledAt(1, false);
				Fenetres.setEnabledAt(2,true);
				Fenetres.setEnabledAt(3,false);
			}
		});
		Menus.getProfil().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Fenetres.setSelectedComponent(Fenetres.getGestionP());
				Fenetres.setEnabledAt(1, true);
				Fenetres.setEnabledAt(2,false);
				Fenetres.setEnabledAt(3,false);
			}
		});
		Menus.getEmployePro().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			
				Fenetres.setSelectedComponent(Fenetres.getListe());
				Fenetres.setEnabledAt(1, false);
				Fenetres.setEnabledAt(2,false);
				Fenetres.setEnabledAt(3,true);
			}
		});
		Fenetres.getGestion().getAnnulerButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        GestionEmploye.CentrePane centrePane = Fenetres.getGestion().getCentrePane();
		        reset();
		    }
		});
		Fenetres.getGestion().getAjouterButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String cin = Fenetres.getGestion().getCinFieldCenter().getText();
		        String nom = Fenetres.getGestion().getNomCenter().getText();
		        String prenom = Fenetres.getGestion().getPrenomCenter().getText();
		        String email = Fenetres.getGestion().getMailCenter().getText();
		        String datnais = Fenetres.getGestion().getDateFieldCenter().getText();
		        String genre = Fenetres.getGestion().getGenreCenter().getSelectedItem().toString();
		        int idprofil = Fenetres.getGestion().getProfileCenter().getSelectedIndex();
		        if (!cin.matches("\\d{8}")) {
		            JOptionPane.showMessageDialog(null, "Le cin doit contenir 8 chiffres.", "Erreur", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
		            JOptionPane.showMessageDialog(null, "Format d'email invalide.", "Erreur", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        if (cin.isEmpty() || nom.isEmpty() || prenom.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Le cin, le nom et le prénom sont des champs obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        if (employeDAO.checkCin(cin)) {
		            JOptionPane.showMessageDialog(null, "Le cin existe déjà.", "Erreur", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        Employe employe = new Employe(cin, idprofil, nom, prenom, datnais, genre, email);
		        int result = employeDAO.insertEmploye(employe);

		        if (result == 1) {
		            reset();
		        } else {
		            // Échec de l'insertion
		            JOptionPane.showMessageDialog(null, "Échec.", "Erreur", JOptionPane.ERROR_MESSAGE);
		        }
		        initEmployes();
		    }
		});

		Fenetres.getGestion().getNextButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index >= employes.size()-1) {
					index = 0;
				}
				else {
					index++;
					System.out.println(index);
				}
				initEmployes();
			}
		});

		Fenetres.getGestion().getPreviousButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index == 0) {
					index = employes.size()-1;
				}
				else {
					index--;
					System.out.println(index);
				}
				
				initEmployes();
			}
		});
		Fenetres.getGestion().getSuprimerButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
				String cin = Fenetres.getGestion().getCinFieldNord().getText();
				System.out.println(cin);
				String nom =Fenetres.getGestion().getNomFieldNord().getText();
				String prenom =Fenetres.getGestion().getPrenomFieldNord().getText();
				String email = Fenetres.getGestion().getEmailFieldNord().getText();
				String datnais = Fenetres.getGestion().getDateFieldNord().getText();
				String genre = Fenetres.getGestion().getGenre().getSelectedItem().toString();
				int idprofil = Fenetres.getGestion().getProfile().getSelectedIndex();	
				Employe employe = new Employe(cin, idprofil, nom, prenom, datnais, genre, email);
				employeDAO.deleteEmploye(employe);
				
		    }});
		Fenetres.getGestion().getModdifierButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
			    String cin = Fenetres.getGestion().getCinFieldNord().getText();
			    String nom = Fenetres.getGestion().getNomFieldNord().getText();
			    String prenom = Fenetres.getGestion().getPrenomFieldNord().getText();
			    String email = Fenetres.getGestion().getEmailFieldNord().getText();
			    String date = Fenetres.getGestion().getDateFieldNord().getText();
			    int idprofil = Fenetres.getGestion().getProfile().getSelectedIndex();
			    String genre = Fenetres.getGestion().getGenre().getSelectedItem().toString();
			    Employe employe = new Employe(cin, idprofil, nom, prenom, date, genre, email);
			    employeDAO.updateEmploye(employe);
			    
		    }});	
		}
	
	
	
	
	
	public void initComponents() {
		barreMenus = new JMenuBar();
		Fenetres = new Fenetres();
	    Menus = new Menus();
		setJMenuBar(barreMenus);	
		barreMenus.add(Menus);
		add(Fenetres);
		Fenetres.setSelectedComponent(Fenetres.getBienvenue());
		Fenetres.setEnabledAt(1, false);
		Fenetres.setEnabledAt(2,false);
		Fenetres.setEnabledAt(3,false);
		
	}
	public void initConnection() {
		Connexion conn = new Connexion();
		connection = conn.getConnection();
		employeDAO = new EmployeDAO(connection);
		profilDAO = new ProfilDAO(connection);
	}
	public void initEmployes() {
		employes = employeDAO.selectEmployes();
		Employe employe = employes.get(index);
		Fenetres.getGestion().getCinFieldNord().setText(employe.getCin());
		Fenetres.getGestion().getNomFieldNord().setText(employe.getNom());
		Fenetres.getGestion().getPrenomFieldNord().setText(employe.getPrenom());
		Fenetres.getGestion().getEmailFieldNord().setText(employe.getEmail());
		Fenetres.getGestion().getDateFieldNord().setText(employe.getDatnais());
		Fenetres.getGestion().getGenre().setSelectedItem(employe.getGenre());
		Fenetres.getGestion().getProfile().setSelectedIndex(employe.getIdProfil());
		Fenetres.getGestion().getCinFieldNord().setEnabled(false);
		
;
	}
	public void reset() {
        Fenetres.getGestion().getCinFieldCenter().setText("");
        Fenetres.getGestion().getNomCenter().setText("");
        Fenetres.getGestion().getPrenomCenter().setText("");
        Fenetres.getGestion().getMailCenter().setText("");
        Fenetres.getGestion().getGenreCenter().setSelectedIndex(0);
        Fenetres.getGestion().getProfileCenter().setSelectedIndex(0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Fenetres.getGestion().getDateFieldCenter().setText(dateFormat.format(new java.util.Date()));
	}
	public void setDefaultEmployes(){
		Fenetres.getGestion().getCinFieldNord().setText("");
		Fenetres.getGestion().getNomFieldNord().setText("");
		Fenetres.getGestion().getPrenomFieldNord().setText("");
		Fenetres.getGestion().getEmailFieldNord().setText("");
		Fenetres.getGestion().getDateFieldNord().setText("");
		
		Fenetres.getGestion().getCinFieldNord().setEnabled(false);
	}
	public void refreshProfiles() {
		initConnection();
	    profiles = profilDAO.selectProfiles();
	    int rowCount = profiles.size();
	    int colCount = 2;
	    Object[][] data = new Object[rowCount][colCount];
	    for (int i = 0; i < rowCount; i++) {
	        data[i][0] = i+1 ;
	        data[i][1] = profiles.get(i);
	    }
	    Fenetres.getGestionP().getRightPanel().removeAll();
	    Fenetres.getGestionP().getRightPanel().setLayout(new BorderLayout());
	    MonModel tableModel = new MonModel(data, Fenetres.getGestionP().getTitle());
	    JTable table = new JTable(tableModel);
	    Fenetres.getGestionP().getRightPanel().add(new JScrollPane(table), BorderLayout.CENTER);
	    Fenetres.getGestionP().getRightPanel().revalidate();
	    Fenetres.getGestionP().getRightPanel().repaint();
	}
	
	public void initListeEmp() {
    	profiles = profilDAO.selectProfiles();
    	employes = employeDAO.selectEmployes();
    	String selectedLibelle = (String) Fenetres.getListe().getComboBoxProfil().getSelectedItem();
    	ArrayList<Employe> selectedEmployees = employeDAO.selectEmployeesByLibelle(employes,profiles,selectedLibelle);
	    int rowCount = selectedEmployees.size();
	    int colCount = 4;
	    Object[][] data = new Object[rowCount][colCount];
	    for (Employe employee : selectedEmployees) {
	        for (int i = 0; i < rowCount; i++) {
	            data[i][0] = employee.getCin();
	            data[i][1] = employee.getNom();
	            data[i][2] = employee.getPrenom();
	            data[i][3]= employee.getEmail();
	    }}

	    Fenetres.getListe().getSudPane().setLayout(new BorderLayout());
	    MonModel tableModel = new MonModel(data, Fenetres.getListe().getTitle());
	    JTable table = new JTable(tableModel);
	    Fenetres.getListe().getSudPane().add(new JScrollPane(table), BorderLayout.CENTER);	
	}	
}