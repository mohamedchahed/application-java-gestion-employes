package view;
import javax.swing.*;
import java.awt.*;
public class Bienvenue extends JPanel {
	private JLabel image;
	JLabel titleLabel;
	public Bienvenue() {
		setBackground(Color.gray);
		setLayout(new GridBagLayout());
		ImageIcon pic = new ImageIcon("C:\\Users\\chahe\\Desktop\\icon.png");
		image = new JLabel(pic);
		image.setHorizontalAlignment(JLabel.CENTER);
	    image.setVerticalAlignment(JLabel.CENTER);
	    GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
		add(image,gbc);
	    titleLabel = new JLabel("Bienvenue dans l'application de gestion d'employés");
	    titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
	    GridBagConstraints titleConstraints = new GridBagConstraints();
	    titleConstraints.gridx = 0;
	    titleConstraints.gridy = 1;
	    titleConstraints.insets = new Insets(10, 0, 0, 0); 
	    add(titleLabel, titleConstraints);
		
		
	}

	
}
