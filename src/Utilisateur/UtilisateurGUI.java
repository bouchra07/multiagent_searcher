package Utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import jade.gui.GuiEvent;

import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class UtilisateurGUI extends JFrame {

	private JPanel contentPane;
	private JTextField marque;
	private UtilisateurAgent utilisateurAgent;

	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_2;
	private JLabel lblDriver;

	private final ButtonGroup type = new ButtonGroup();
	private JPanel panel;
	
	public UtilisateurAgent getUtilisateurAgent() {
		return utilisateurAgent;
	}

	public void setUtilisateurAgent(UtilisateurAgent utilisateurAgent) {
		this.utilisateurAgent = utilisateurAgent;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UtilisateurGUI frame = new UtilisateurGUI();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *
	 */
	public UtilisateurGUI() {
		
		
		
		
		
		setTitle("Recherche du chauffeurs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 511);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new LineBorder(SystemColor.inactiveCaption, 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 
	       
		panel = new JPanel();
		panel.setForeground(SystemColor.desktop);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Car Marque", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(37, 25, 384, 82);
		contentPane.add(panel);
		
		
		JLabel lbltype = new JLabel("Type :");
		lbltype.setBounds(28, 52, 51, 20);
		lbltype.setHorizontalAlignment(SwingConstants.LEFT);
		lbltype.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		
		JLabel lblNewLabel = new JLabel("Marque de voiture :");
		lblNewLabel.setBounds(28, 21, 151, 20);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		marque = new JTextField();
		marque.setBounds(189, 18, 174, 26);
		marque.setFont(new Font("Tahoma", Font.BOLD, 16));
		marque.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("automatic");
		rdbtnNewRadioButton.setBounds(189, 51, 99, 23);
		rdbtnNewRadioButton.setBackground(SystemColor.inactiveCaption);
		rdbtnNewRadioButton.setSelected(true);
		type.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JRadioButton rdbtnS = new JRadioButton("manual");
		rdbtnS.setBounds(284, 51, 79, 23);
		rdbtnS.setBackground(SystemColor.inactiveCaption);
		type.add(rdbtnS);
		rdbtnS.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.setLayout(null);
		panel.add(lbltype);
		panel.add(lblNewLabel);
		panel.add(marque);
		panel.add(rdbtnNewRadioButton);
		panel.add(rdbtnS);
		 
		JButton btnEnvoyer = new JButton("Rechercher");
		btnEnvoyer.setContentAreaFilled(false);
		btnEnvoyer.setBackground(SystemColor.inactiveCaption);
		btnEnvoyer.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		
		btnEnvoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String marquee = marque.getText();
				String typee = getSelectedButtonText(type);
				GuiEvent ev = new GuiEvent(this,1);
				ev.addParameter(marquee);
				ev.addParameter(typee);
				utilisateurAgent.onGuiEvent(ev);
			}
		});
		btnEnvoyer.setForeground(SystemColor.desktop);
		btnEnvoyer.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEnvoyer.setBounds(454, 45, 128, 32);
		contentPane.add(btnEnvoyer);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 166, 605, 143);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setTabSize(2);
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setEditable(false);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblNewLabel_2 = new JLabel("Recherche les chauffeurs");
		lblNewLabel_2.setForeground(SystemColor.desktop);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNewLabel_2.setBounds(119, 427, 394, 36);
		contentPane.add(lblNewLabel_2);
		
		lblDriver = new JLabel("Liste du chauffeurs ");
		lblDriver.setForeground(SystemColor.desktop);
		lblDriver.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDriver.setBounds(10, 128, 150, 27);
		contentPane.add(lblDriver);
		
		JButton btnViderLaListe = new JButton("Vider la liste");
		btnViderLaListe.setContentAreaFilled(false);
		btnViderLaListe.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		btnViderLaListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
			}
		});
		btnViderLaListe.setForeground(SystemColor.desktop);
		btnViderLaListe.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnViderLaListe.setBounds(454, 123, 128, 32);
		contentPane.add(btnViderLaListe);
		
		JPanel panel_1 = new AfficheImage("C:\\Users\\bouch\\eclipse-workspace\\Projet 7\\src\\Utilisateur\\car.png");
		
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(37, 309, 545, 118);
		contentPane.add(panel_1);
		
	    
	    
	    
		this.setVisible(true);
		
		
	}
	
	public void showMessage(String msg) {
		
			textArea.append(msg+"\n");
		
	}
	String getSelectedButtonText(ButtonGroup buttonGroup) {
	    for (Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
	        AbstractButton button = (AbstractButton) buttons.nextElement();

	        if (button.isSelected()) {
	            return button.getText();
	        }
	    }

	    return null;
	}
	
	

	public void showNotFound() {
		JOptionPane jop1 = new JOptionPane();
         jop1.showMessageDialog(null, "Aucun resultat n'est trouve", "Information", JOptionPane.INFORMATION_MESSAGE);
         
	}
}
class AfficheImage extends JPanel
{
Image eau;

AfficheImage(String s)
{
eau = getToolkit().getImage(s);
}

public void paintComponent(Graphics g)
{
super.paintComponent(g);
g.drawImage(eau, 0, 0, getWidth(), getHeight(), this);
}
}


