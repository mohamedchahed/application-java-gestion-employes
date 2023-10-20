package view;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import model.Profil;


public class ListeProEmp extends JPanel {
	Object[][] data = new Object[4][10];
    String[] title = {"cin", "nom", "prenom", "email"};
    MonModel tableModel ;
    private NordPane nordPane;
    private SudPane sudPane;
    public SudPane getSudPane() {
		return sudPane;
	}


	public void setSudPane(SudPane sudPane) {
		this.sudPane = sudPane;
	}

	JComboBox<String> comboBoxProfil;
   
    public MonModel getTableModel() {
		return tableModel;
	}


	public void setTableModel(MonModel tableModel) {
		this.tableModel = tableModel;
	}


	public JComboBox<String> getComboBoxProfil() {
		return comboBoxProfil;
	}

	public void setComboboxProfil(ArrayList<Profil> profiles) {
			comboBoxProfil.removeAllItems();
		
		for(Profil profile:profiles) {
			comboBoxProfil.addItem(profile.getLibelle());
			
		}
	}
	public void setComboBoxProfil(JComboBox<String> comboBoxProfil) {
		this.comboBoxProfil = comboBoxProfil;
	}


	public ListeProEmp() {
        setLayout(new BorderLayout());
        nordPane = new NordPane();
        sudPane = new SudPane();
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, nordPane, sudPane);
        add(splitPane, BorderLayout.CENTER);
    }

    public class NordPane extends JPanel {
        public NordPane() {
            setLayout(new FlowLayout());
            setBackground(Color.BLUE);
            JLabel labelProfil = new JLabel("Profil:");
            labelProfil.setForeground(Color.WHITE);
            
            comboBoxProfil = new JComboBox<>();
            add(labelProfil);
            add(comboBoxProfil);
        }
    }
    

    public Object[][] getData() {
		return data;
	}


	public void setData(Object[][] data) {
		this.data = data;
	}


	public String[] getTitle() {
		return title;
	}


	public void setTitle(String[] title) {
		this.title = title;
	}


	public NordPane getNordPane() {
		return nordPane;
	}


	public void setNordPane(NordPane nordPane) {
		this.nordPane = nordPane;
	}

	class SudPane extends JPanel {
        public SudPane() {
        }
    }
}


