package view;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class GestionPro extends JPanel {
    private LeftPanel leftPanel;
    private RightPanel rightPanel;
    private JSplitPane sep;
    JTextField textField;
    JButton annulerButton ;
    JButton ajouterButton ;
    Object[][] data = new Object[2][10];
    String[] title = {"ID", "Libele"};
    MonModel tableModel ;
    public MonModel getTableModel() {
		return tableModel;
	}


	public void setTableModel(MonModel tableModel) {
		this.tableModel = tableModel;
	}


	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	JTable table ;
    public GestionPro() {
        setLayout(new BorderLayout());

        leftPanel = new LeftPanel();
        rightPanel = new RightPanel();

        sep = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        sep.setOneTouchExpandable(true);
        add(sep, BorderLayout.CENTER);
    }
    public class LeftPanel extends JPanel {
        public LeftPanel() {
            setBackground(Color.BLUE);

            JLabel label = new JLabel("Libelle");
            label.setForeground(Color.WHITE);
            textField = new JTextField(20);
            annulerButton = new JButton("Annuler");
            ajouterButton = new JButton("Ajouter");

            add(label);
            add(textField);
            add(annulerButton);
            add(ajouterButton);
        }
    }
	public JTextField getTextField() {
		return textField;
	}


	public void setTextField(JTextField textField) {
		this.textField = textField;
	}


	public JButton getAnnulerButton() {
		return annulerButton;
	}


	public void setAnnulerButton(JButton annulerButton) {
		this.annulerButton = annulerButton;
	}


	public JButton getAjouterButton() {
		return ajouterButton;
	}


	public void setAjouterButton(JButton ajouterButton) {
		this.ajouterButton = ajouterButton;
	}


	public Object[][] getData() {
		return data;
	}





	public String[] getTitle() {
		return title;
	}


	public void setTitle(String[] title) {
		this.title = title;
	}
	class RightPanel extends JPanel {
        public RightPanel() {
        }
    }
    
    public LeftPanel getLeftPanel() {
		return leftPanel;
	}


	public void setLeftPanel(LeftPanel leftPanel) {
		this.leftPanel = leftPanel;
	}


	public RightPanel getRightPanel() {
		return rightPanel;
	}


	public void setRightPanel(RightPanel rightPanel) {
		this.rightPanel = rightPanel;
	}


	public JSplitPane getSep() {
		return sep;
	}


	public void setSep(JSplitPane sep) {
		this.sep = sep;
	}

}

    
    
