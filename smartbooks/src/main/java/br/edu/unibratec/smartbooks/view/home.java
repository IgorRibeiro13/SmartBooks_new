package br.edu.unibratec.smartbooks.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class home {

	private JFrame frame;
	private JTextField txtUser;
	private JTextField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 592, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(182, 192, 180, 19);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(182, 239, 180, 19);
		frame.getContentPane().add(txtPass);
		
		JButton btnErease = new JButton("Limpar"); // aqui fica a ação do botão Limpar
		btnErease.addActionListener(new ActionListener() {// aqui eu instancio a ação
			public void actionPerformed(ActionEvent e) {
				//aqui eu inicio os métodos que o professor tanto fala, o encapsulamento...
				ereaseFields();
				
			}
		});
		btnErease.setBounds(277, 282, 85, 21);
		frame.getContentPane().add(btnErease);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtUser.getText().equals("oi") || txtPass.getText().equals("oi")) {
					JOptionPane.showMessageDialog(null, "Deu certo pivete...");
				} else {
					System.out.println("As credenciais não são válidas.");
					JOptionPane.showMessageDialog(null, "Não foi dessa vez fera...");
					ereaseFields();
				}
				
			}
		});
		btnLogin.setBounds(182, 282, 85, 21);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(182, 177, 46, 13);
		frame.getContentPane().add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(182, 221, 46, 13);
		frame.getContentPane().add(lblSenha);
	}
	
	public void ereaseFields() {
		System.out.println("iniciando limpeza nos campos");
		txtUser.setText(null);
		txtPass.setText(null);
		
		System.out.println("Os campos foram limpos...");
	}
}
