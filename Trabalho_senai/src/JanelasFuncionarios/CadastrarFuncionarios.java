package JanelasFuncionarios;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Imagem.ImagemCadastrarFncionario;
import JanelasAnimal.CadastrarAnimais;
import JanelasAnimal.VisualizarAnimais;
import JanelasComtabil.NovaCompra;
import JanelasComtabil.NovaVenda;
import JanelasComtabil.Total;
import JanelasComtabil.VisualizarCompras;
import JanelasComtabil.VisualizarVendas;
import crud.CrudFuncionarios;
import outraJanelas.NovaFazenda;
import outraJanelas.Pergunta;
import outraJanelas.Principal;
import outraJanelas.VisualizarFazendas;

public class CadastrarFuncionarios {

	private JFrame frmCadastrarFuncionarios;
	private JTextField tfNome;
	private JTextField tfData;
	private JTextField tfCPF;
	private JTextField tfRG;
	private JTextField tfFone;
	private JTextField tfCargo;
	private JTextField tfSal;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	private JEditorPane editorPane;
	private JButton btnLimpar;
	public static File img;
	public static JLabel lblImg;
	ImagemCadastrarFncionario i = new ImagemCadastrarFncionario();
	public static JPanel panel;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarFuncionarios window = new CadastrarFuncionarios();
					window.frmCadastrarFuncionarios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastrarFuncionarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastrarFuncionarios = new JFrame();
		frmCadastrarFuncionarios.setTitle("Cadastrar Funcionarios");
		frmCadastrarFuncionarios.setBounds(100, 100, 720, 450);
		frmCadastrarFuncionarios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastrarFuncionarios.setLocationRelativeTo(null);
		frmCadastrarFuncionarios.setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		frmCadastrarFuncionarios.setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		mnInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Principal.frmPrincipal.setVisible(true);
				frmCadastrarFuncionarios.dispose();
			}
		});
		menuBar.add(mnInicio);
		
		JMenu mnNewMenu = new JMenu("Animais");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCadastrarAnimais = new JMenuItem("Cadastrar Animais");
		mntmCadastrarAnimais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarAnimais.main(null);
				frmCadastrarFuncionarios.dispose();
			}
		});
		mnNewMenu.add(mntmCadastrarAnimais);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Visualizar Animais");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizarAnimais.main(null);
				frmCadastrarFuncionarios.dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnFuncionarios = new JMenu("Funcionarios");
		menuBar.add(mnFuncionarios);
		
		JMenuItem mntmCadastrarFuncionarios = new JMenuItem("Cadastrar funcionarios");
		mntmCadastrarFuncionarios.setEnabled(false);
		mntmCadastrarFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarFuncionarios.main(null);
				frmCadastrarFuncionarios.dispose();
			}
		});
		mnFuncionarios.add(mntmCadastrarFuncionarios);
		
		JMenuItem mntmVisualizarFuncionarios = new JMenuItem("Visualizar funcionarios");
		mntmVisualizarFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizarFuncionarios.main(null);
				frmCadastrarFuncionarios.dispose();
			}
		});
		mnFuncionarios.add(mntmVisualizarFuncionarios);
		
		JMenu mnNewMenu_1 = new JMenu("Compra de Insumos");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmCompra = new JMenuItem("Nova Compra");
		mntmCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovaCompra.main(null);
				frmCadastrarFuncionarios.dispose();
			}
		});
		mnNewMenu_1.add(mntmCompra);
		
		JMenuItem mntmVisualizarCompra = new JMenuItem("Visualizar Compras");
		mntmVisualizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizarCompras.main(null);
				frmCadastrarFuncionarios.dispose();
			}
		});
		mnNewMenu_1.add(mntmVisualizarCompra);
		
		JMenu mnNewMenu_2 = new JMenu("Vendas");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNovaVenda = new JMenuItem("Nova Venda");
		mntmNovaVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovaVenda.main(null);
				frmCadastrarFuncionarios.dispose();
			}
		});
		mnNewMenu_2.add(mntmNovaVenda);
		
		JMenuItem mntmVisualizarVendas = new JMenuItem("Visualizar Vendas");
		mntmVisualizarVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizarVendas.main(null);
				frmCadastrarFuncionarios.dispose();
			}
		});
		mnNewMenu_2.add(mntmVisualizarVendas);
		
		JMenu mnRelatrio = new JMenu("Relat\u00F3rio");
		menuBar.add(mnRelatrio);
		
		JMenu mnOpes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnOpes);
		
		JMenuItem mntmTotal = new JMenuItem("Total");
		mntmTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Total.main(null);
				frmCadastrarFuncionarios.dispose();
			}
		});
		mnRelatrio.add(mntmTotal);
		
		JMenuItem mntmNovaFazenda = new JMenuItem("Nova fazenda");
		mntmNovaFazenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovaFazenda.main(null);
				frmCadastrarFuncionarios.dispose();
			}
		});
		mnOpes.add(mntmNovaFazenda);
		
		JMenuItem mntmVisualizarFazenda = new JMenuItem("Visualizar Fazenda");
		mntmVisualizarFazenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizarFazendas.main(null);
				frmCadastrarFuncionarios.dispose();
			}
		});
		mnOpes.add(mntmVisualizarFazenda);
		
		JMenuItem mntmSada = new JMenuItem("Sair");
		mntmSada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnOpes.add(mntmSada);
		
		JMenuItem mntmMudarFazenda = new JMenuItem("Mudar Fazenda");
		mntmMudarFazenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pergunta.main(null);
			}
		});
		mnOpes.add(mntmMudarFazenda);
		
		frmCadastrarFuncionarios.getContentPane().setLayout(null);
		
		JLabel lblCadastroDeFuncionarios = new JLabel("Cadastro de Funcionarios");
		lblCadastroDeFuncionarios.setBounds(0, 0, 714, 19);
		lblCadastroDeFuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeFuncionarios.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmCadastrarFuncionarios.getContentPane().add(lblCadastroDeFuncionarios);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(10, 50, 46, 20);
		frmCadastrarFuncionarios.getContentPane().add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(55, 51, 211, 20);
		frmCadastrarFuncionarios.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNascimento.setBounds(10, 80, 80, 20);
		frmCadastrarFuncionarios.getContentPane().add(lblNascimento);
		
		tfData = new JTextField();
		tfData.setBounds(100, 80, 166, 20);
		frmCadastrarFuncionarios.getContentPane().add(tfData);
		tfData.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCpf.setBounds(10, 110, 46, 20);
		frmCadastrarFuncionarios.getContentPane().add(lblCpf);
		
		tfCPF = new JTextField();
		tfCPF.setColumns(10);
		tfCPF.setBounds(55, 110, 211, 20);
		frmCadastrarFuncionarios.getContentPane().add(tfCPF);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRg.setBounds(10, 140, 46, 20);
		frmCadastrarFuncionarios.getContentPane().add(lblRg);
		
		tfRG = new JTextField();
		tfRG.setColumns(10);
		tfRG.setBounds(55, 140, 211, 20);
		frmCadastrarFuncionarios.getContentPane().add(tfRG);
		
		JLabel lblFone = new JLabel("Fone:");
		lblFone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFone.setBounds(304, 50, 46, 20);
		frmCadastrarFuncionarios.getContentPane().add(lblFone);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(504, 50, 200, 136);
		frmCadastrarFuncionarios.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		lblImg = new JLabel("");
		panel.add(lblImg, "name_9445457657444");
		
		tfFone = new JTextField();
		tfFone.setColumns(10);
		tfFone.setBounds(352, 50, 142, 20);
		frmCadastrarFuncionarios.getContentPane().add(tfFone);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCargo.setBounds(304, 80, 46, 20);
		frmCadastrarFuncionarios.getContentPane().add(lblCargo);
		
		JLabel lblSalrio = new JLabel("Sal\u00E1rio:");
		lblSalrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSalrio.setBounds(304, 110, 61, 20);
		frmCadastrarFuncionarios.getContentPane().add(lblSalrio);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSexo.setBounds(10, 170, 46, 20);
		frmCadastrarFuncionarios.getContentPane().add(lblSexo);
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setSelected(true);
		rdbtnMasculino.setBounds(55, 170, 87, 20);
		frmCadastrarFuncionarios.getContentPane().add(rdbtnMasculino);
		
		rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(144, 170, 87, 20);
		frmCadastrarFuncionarios.getContentPane().add(rdbtnFeminino);
		
		tfCargo = new JTextField();
		tfCargo.setColumns(10);
		tfCargo.setBounds(352, 80, 142, 20);
		frmCadastrarFuncionarios.getContentPane().add(tfCargo);
		
		tfSal = new JTextField();
		tfSal.setColumns(10);
		tfSal.setBounds(362, 110, 132, 20);
		frmCadastrarFuncionarios.getContentPane().add(tfSal);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(504, 185, 200, 33);
		frmCadastrarFuncionarios.getContentPane().add(panel_1);
		
		JButton btnFoto = new JButton("Foto");
		panel_1.add(btnFoto);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrudFuncionarios crud = new CrudFuncionarios();
				String s=null;
				if(rdbtnFeminino.isSelected())
					s = "feminino";
				if (rdbtnMasculino.isSelected()) {
					s="masculino";
				}
				
				if(! tfNome.getText().trim().equals("")) {
					if (!tfData.getText().trim().equals("")) {
						if (!tfCPF.getText().trim().equals("")) {
							if (! editorPane.getText().trim().equals("")) {
								if (! tfRG.getText().trim().equals("")) {
									if (! tfFone.getText().trim().equals("")) {
										if (! tfCargo.getText().trim().equals("")) {
											if (! tfSal.getText().trim().equals("")) {
												crud.addFun(tfNome.getText(), tfData.getText(), tfCPF.getText(), tfRG.getText(), tfFone.getText(), textField.getText(),
														tfCargo.getText(), Double.parseDouble(tfSal.getText()), editorPane.getText(), i.getImagem(),s);
												btnLimpar.doClick();
											}else {
												JOptionPane.showMessageDialog(null, "Insira o salario!");
											}	
										}else {
											JOptionPane.showMessageDialog(null, "Insira o cargo!");
										}	
									}else {
										JOptionPane.showMessageDialog(null, "Insira o Telefone!");
									}	
								}else {
									JOptionPane.showMessageDialog(null, "Insira o RG!");
								}	
							}else {
								JOptionPane.showMessageDialog(null, "Insira as descrições!");
							}	
						}else {
							JOptionPane.showMessageDialog(null, "Insira o CPF!");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Insira uma Data de Nascimento!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Insira um nome!");
				}
				
			}
		});
		btnSalvar.setBounds(615, 366, 89, 23);
		frmCadastrarFuncionarios.getContentPane().add(btnSalvar);
		
		ButtonGroup bd = new ButtonGroup();
		bd.add(rdbtnFeminino);
		bd.add(rdbtnMasculino);
		
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNome.setText(null);
				tfData.setText(null);
				tfCargo.setText(null);
				tfCPF.setText(null);
				tfFone.setText(null);
				tfRG.setText(null);
				tfSal.setText(null);
				editorPane.setText(null);
				rdbtnMasculino.setSelected(true);
				lblImg.setIcon(null);
				textField.setText(null);
			}
		});
		btnLimpar.setBounds(516, 366, 89, 23);
		frmCadastrarFuncionarios.getContentPane().add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastrarFuncionarios.dispose();
				Principal.frmPrincipal.setVisible(true);
			}
		});
		btnCancelar.setBounds(417, 366, 89, 23);
		frmCadastrarFuncionarios.getContentPane().add(btnCancelar);
		
		editorPane = new JEditorPane();
		editorPane.setBounds(10, 262, 484, 93);
		frmCadastrarFuncionarios.getContentPane().add(editorPane);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescrio.setBounds(10, 227, 484, 33);
		frmCadastrarFuncionarios.getContentPane().add(lblDescrio);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(304, 144, 61, 20);
		frmCadastrarFuncionarios.getContentPane().add(lblEmail);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(352, 141, 142, 20);
		frmCadastrarFuncionarios.getContentPane().add(textField);
		btnFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				img = i.selecionaImg();
				i.abrirImagem(img);
			}
		});
	}
}
