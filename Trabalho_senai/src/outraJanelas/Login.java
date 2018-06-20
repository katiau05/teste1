package outraJanelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import banco.Conexao;
import crud.crudUsuarios;

import javax.swing.JTextField;
import javax.swing.SpringLayout.Constraints;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.AccessibleObject;
import java.nio.channels.ShutdownChannelGroupException;

public class Login {
	Conexao c = new Conexao();
	
	
	String acesso="nao";
	
	public void logar() {
		ResultSet tabela = null;
		  
		String sql = "select*from usuario where usuario=? and senha=?";
		try {
			PreparedStatement stmt = c.getConexao().prepareStatement(sql);
			stmt.setString(1, tfUsuario.getText().toString());
			stmt.setString(2, String.valueOf(pfSenha.getPassword()));
			tabela = stmt.executeQuery();
			if(tabela.next()) {
				frmLogin.dispose();
				Principal.main(null);
			}else {

				JOptionPane.showMessageDialog(null, "Usuario e/ou Senha inv�lido(s)!");						
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	

	}


	private JFrame frmLogin;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;
	String armazenar ;
	private JButton btnEntrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 309, 243);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.setResizable(false);
		frmLogin.setLocationRelativeTo(null);
		
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 273, 34);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBounds(10, 56, 54, 20);
		frmLogin.getContentPane().add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSenha.setBounds(10, 87, 54, 20);
		frmLogin.getContentPane().add(lblSenha);
		
		tfUsuario = 
				new JTextField();
		tfUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == arg0.VK_ENTER) {
					pfSenha.requestFocus();
					
				}
			}
		});
		tfUsuario.setBounds(65, 57, 183, 20);
		frmLogin.getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_ENTER) {
					btnEntrar.doClick();
					
				}
			}
		});
		pfSenha.setBounds(65, 87, 183, 20);
		frmLogin.getContentPane().add(pfSenha);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(99, 181, 105, 23);
		frmLogin.getContentPane().add(btnEntrar);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
				

			
		});
	}	
}
