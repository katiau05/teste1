package JanelasAnimal;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import JanelasComtabil.NovaCompra;
import JanelasComtabil.NovaVenda;
import JanelasComtabil.Total;
import JanelasComtabil.VisualizarCompras;
import JanelasComtabil.VisualizarVendas;
import JanelasFuncionarios.CadastrarFuncionarios;
import JanelasFuncionarios.VisualizarFuncionarios;
import crud.CrudAnimal;
import crud.CrudFuncionarios;
import outraJanelas.NovaFazenda;
import outraJanelas.Pergunta;
import outraJanelas.Principal;
import outraJanelas.VisualizarFazendas;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.CardLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Caret;
import javax.swing.text.MaskFormatter;

import DAO.Animal;
import DAO.Fazenda;
import Imagem.MetodosImagem;

import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import java.awt.SystemColor;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;

public class CadastrarAnimais {

	private JFrame frmCadastroDeAnimais;
	private JTextField tfNomeLote;
	private JTable tabela;
	private JTextField tfDestino;
	private JTextField tfProcurar;
	protected static JComboBox cbEspecie;
	protected static JComboBox cbRaca;
	private JFormattedTextField ftfDataNascimento;
	private JFormattedTextField ftfDataCompra;
	private JSpinner spinnerQuantidade;
	private JButton btnProcurar;
	private JRadioButton rdbtnMacho;
	private JRadioButton rdbtnFemea;
	private JPanel panel;
	private File img;
	private MaskFormatter mask;
	private int contador=0;//contar quantos cliques
	private MetodosImagem mI = new MetodosImagem();
	private JLabel lblImagem;
	private Animal animal = new Animal();
	/**
	 *
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarAnimais window = new CadastrarAnimais();
					window.frmCadastroDeAnimais.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastrarAnimais() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {//inicio formatação mascara
			mask = new MaskFormatter("####/##/##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fim formatação mascara
		
		frmCadastroDeAnimais = new JFrame();
		frmCadastroDeAnimais.setTitle("Cadastro de Animais");
		frmCadastroDeAnimais.setBounds(100, 100, 1080, 720);
		frmCadastroDeAnimais.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDeAnimais.setLocationRelativeTo(null);
		frmCadastroDeAnimais.setResizable(false);
		frmCadastroDeAnimais.getContentPane().setLayout(null);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataDeNascimento.setBounds(10, 100, 126, 20);
		frmCadastroDeAnimais.getContentPane().add(lblDataDeNascimento);
		
		ftfDataNascimento = new JFormattedTextField(mask);
		ftfDataNascimento.setToolTipText("As datas devem ser colocadas em padr\u00E3o Americano (ANO/M\u00CAS/DIA).");
		ftfDataNascimento.setBounds(140, 100, 164, 20);
		frmCadastroDeAnimais.getContentPane().add(ftfDataNascimento);
		
		JLabel lblEspecie = new JLabel("Destino:");
		lblEspecie.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEspecie.setBounds(420, 170, 80, 20);
		frmCadastroDeAnimais.getContentPane().add(lblEspecie);
		
		JLabel lblDataDaCompra = new JLabel("Data da Compra:");
		lblDataDaCompra.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataDaCompra.setBounds(10, 135, 120, 20);
		frmCadastroDeAnimais.getContentPane().add(lblDataDaCompra);
		
		ftfDataCompra = new JFormattedTextField(mask);
		ftfDataCompra.setToolTipText("As datas devem ser colocadas em padr\u00E3o Americano (ANO/M\u00CAS/DIA).");
		ftfDataCompra.setBounds(140, 135, 164, 20);
		frmCadastroDeAnimais.getContentPane().add(ftfDataCompra);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuantidade.setBounds(420, 65, 80, 20);
		frmCadastroDeAnimais.getContentPane().add(lblQuantidade);
		
		spinnerQuantidade = new JSpinner();
		spinnerQuantidade.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerQuantidade.setBounds(506, 65, 164, 20);
		frmCadastroDeAnimais.getContentPane().add(spinnerQuantidade);
		
		JLabel label = new JLabel("Especie:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(420, 100, 80, 20);
		frmCadastroDeAnimais.getContentPane().add(label);
		
		cbEspecie = new JComboBox();
		cbEspecie.setModel(new DefaultComboBoxModel(new String[] {""}));
		cbEspecie.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbRaca.removeAllItems();
				ComboBox.comboBoxRaca(ComboBox.pegaIdEspecie(cbEspecie.getSelectedItem().toString()));
			}
		});
		cbEspecie.setBackground(SystemColor.controlHighlight);
		cbEspecie.setBounds(506, 100, 164, 20);
		frmCadastroDeAnimais.getContentPane().add(cbEspecie);
		
		JLabel lblNomeDoLote = new JLabel("Nome do Lote:");
		lblNomeDoLote.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeDoLote.setBounds(10, 65, 120, 20);
		frmCadastroDeAnimais.getContentPane().add(lblNomeDoLote);
		
		tfNomeLote = new JTextField();
		tfNomeLote.setBounds(140, 65, 164, 20);
		frmCadastroDeAnimais.getContentPane().add(tfNomeLote);
		tfNomeLote.setColumns(10);
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(774, 25, 290, 217);
		frmCadastroDeAnimais.getContentPane().add(panel);
		
		lblImagem = new JLabel("SELECIONAR IMAGEM");
		lblImagem.setToolTipText("Clique 2 vezes");
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				contador++;
				new Thread(thread).start();	
				if(contador == 2) {
					lblImagem.setText(null);
					lblImagem.setHorizontalAlignment(SwingConstants.LEADING);
					img = mI.selecionaImg();
					mI.abrirImagem(img, img, panel, lblImagem);
					contador=0;
				}else {
					return;
				}
			}
		});
		panel.setLayout(new CardLayout(0, 0));
		panel.add(lblImagem, "name_6315985644698");
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSexo.setBounds(10, 170, 46, 20);
		frmCadastroDeAnimais.getContentPane().add(lblSexo);
		
		rdbtnMacho = new JRadioButton("Macho");
		rdbtnMacho.setOpaque(false);
		rdbtnMacho.setSelected(true);
		rdbtnMacho.setBounds(62, 170, 68, 23);
		frmCadastroDeAnimais.getContentPane().add(rdbtnMacho);
		
		rdbtnFemea = new JRadioButton("Femea");
		rdbtnFemea.setOpaque(false);
		rdbtnFemea.setBounds(140, 170, 80, 23);
		frmCadastroDeAnimais.getContentPane().add(rdbtnFemea);
		
		JLabel lblRaa = new JLabel("Ra\u00E7a:");
		lblRaa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRaa.setBounds(420, 135, 80, 20);
		frmCadastroDeAnimais.getContentPane().add(lblRaa);
		
		cbRaca = new JComboBox();
		cbRaca.setBackground(SystemColor.controlHighlight);
		cbRaca.setBounds(506, 135, 164, 20);
		frmCadastroDeAnimais.getContentPane().add(cbRaca);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVisible(true);
		scrollPane.setOpaque(false);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 253, 1054, 373);
		frmCadastroDeAnimais.getContentPane().add(scrollPane);
		
		tabela = new JTable();
		tabela.setFocusTraversalKeysEnabled(false);
		tabela.setOpaque(false);
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Nome", "Nascimento", "Especie", "Ra\u00E7a", "Sexo", "Destino", "Quantidade", "Data Obten\u00E7\u00E3o", "Fazenda"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(2).setResizable(false);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(3).setResizable(false);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(4).setResizable(false);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(5).setResizable(false);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(78);
		tabela.getColumnModel().getColumn(6).setResizable(false);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(7).setResizable(false);
		tabela.getColumnModel().getColumn(7).setPreferredWidth(90);
		tabela.getColumnModel().getColumn(8).setResizable(false);
		tabela.getColumnModel().getColumn(8).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(9).setResizable(false);
		tabela.getColumnModel().getColumn(9).setPreferredWidth(125);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(tabela);
		
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfNomeLote.getText().trim().equals("")) {//inicio do tratamento de informação para salvar novo animal
					JOptionPane.showMessageDialog(null, "insira um nome", "ALERTA!",JOptionPane.WARNING_MESSAGE);
					tfNomeLote.requestFocus();
					return;
				}
				if(ftfDataNascimento.getText().contains(" ")){
					JOptionPane.showMessageDialog(null, "insira uma Data de Nascimento", "ALERTA!",JOptionPane.WARNING_MESSAGE);
					ftfDataNascimento.requestFocus();
					return;
				}
				if(ftfDataCompra.getText().contains(" ")){
					JOptionPane.showMessageDialog(null, "insira a Data da \"Compra\"", "ALERTA!",JOptionPane.WARNING_MESSAGE);
					ftfDataCompra.requestFocus();
					return;
				}
				if(cbEspecie.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "insira uma Especie valida", "ALERTA!",JOptionPane.WARNING_MESSAGE);
					cbEspecie.requestFocus();
					return;
				}
				if(tfDestino.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "insira o Destino", "ALERTA!",JOptionPane.WARNING_MESSAGE);
					tfDestino.requestFocus();
					return;
				}// fim do tratamento de informação para salvar novo animal
				
				preencherDAOAnimalParaSalvarNovo();
				new CrudAnimal().addAnimal(animal);
			}
		});
		btnSalvar.setBackground(SystemColor.controlHighlight);
		btnSalvar.setBounds(975, 637, 89, 23);
		frmCadastroDeAnimais.getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(SystemColor.controlHighlight);
		btnCancelar.setBounds(777, 637, 89, 23);
		frmCadastroDeAnimais.getContentPane().add(btnCancelar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {/**ação do botão limpar*/
				lblImagem.setText("SELECIONAR IMAGEM");
				tfNomeLote.setText(null);
				spinnerQuantidade.setValue(0);
				cbEspecie.setSelectedIndex(0);
				tfDestino.setText(null);
				rdbtnMacho.setSelected(true);
				lblImagem.setIcon(null);
				lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
			}
		});
		btnLimpar.setBackground(SystemColor.controlHighlight);
		btnLimpar.setBounds(678, 637, 89, 23);
		frmCadastroDeAnimais.getContentPane().add(btnLimpar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setEnabled(false);
		btnDeletar.setBackground(SystemColor.controlHighlight);
		btnDeletar.setBounds(876, 637, 89, 23);
		frmCadastroDeAnimais.getContentPane().add(btnDeletar);
		
		JLabel lblAnimais = new JLabel("Animais");
		lblAnimais.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAnimais.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnimais.setBounds(10, 11, 1054, 25);
		frmCadastroDeAnimais.getContentPane().add(lblAnimais);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnFemea);
		bg.add(rdbtnMacho);
		
		tfDestino = new JTextField();
		tfDestino.setBounds(506, 170, 164, 20);
		frmCadastroDeAnimais.getContentPane().add(tfDestino);
		tfDestino.setColumns(10);
		
		tfProcurar = new JTextField();
		tfProcurar.setBounds(10, 222, 331, 20);
		frmCadastroDeAnimais.getContentPane().add(tfProcurar);
		tfProcurar.setColumns(10);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.setBackground(SystemColor.controlHighlight);
		btnProcurar.setBounds(351, 222, 89, 20);
		frmCadastroDeAnimais.getContentPane().add(btnProcurar);
		ImageIcon img = new ImageIcon("D:\\campo-39-full.jpg");
		img.getImage().getScaledInstance(1074, 671, 100);
		
		menu();
		ComboBox.comboBoxEspecie();
		colocaDadosNaTabela();
		
	}
	
	void preencherDAOAnimalParaSalvarNovo() {
		animal.setNomeLote(tfNomeLote.getText());
		animal.setDataDeNascimento(ftfDataNascimento.getText());
		animal.setDataCompra(ftfDataCompra.getText());
		animal.setQuantidade((int) spinnerQuantidade.getValue());
		animal.setRaca(ComboBox.pegaIdRaca(cbRaca.getSelectedItem().toString()));
		animal.setIdFazenda(Principal.fazenda.getIdFazenda());
		animal.setDestino(tfDestino.getText());
		animal.setImagem(mI.getImagem(img, panel));
		if(rdbtnMacho.isSelected())
			animal.setSexo("M");
		else
			animal.setSexo("F");
	}
	
	void colocaDadosNaTabela() {
		animal.setIdFazenda(Principal.fazenda.getIdFazenda());
		ResultSet rs = new CrudAnimal().selecionaAnimais(animal);
		String sexo;
		
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		modelo.setNumRows(0);
		
		try {
			while (rs.next()) {
				if( rs.getString("sexo").equalsIgnoreCase("m"))
					sexo = "Masculino";
				else
					sexo="Feminino";
				modelo.addRow(new Object[] {rs.getInt("idanimal"),rs.getString("nomelote"),rs.getString("datadenascimento"),
						/*rs.getString(especie),rs.getString(raca),*/sexo,rs.getString("destino"),rs.getString("quantidade"),
						rs.getString("datacompra"),rs.getInt("idfazenda")});
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	Runnable thread = new Runnable() {	
		@Override
		public void run() {
			try {
				while(true) {
					Thread.sleep(1500);
					contador=0;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};


	
	void menu() {
		JMenuBar menuBar = new JMenuBar();
		frmCadastroDeAnimais.setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		mnInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Principal.frmPrincipal.setVisible(true);
				frmCadastroDeAnimais.dispose();
			}
		});
		menuBar.add(mnInicio);
		
		JMenu mnNewMenu = new JMenu("Animais");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCadastrarAnimais = new JMenuItem("Cadastrar Animais");
		mntmCadastrarAnimais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarAnimais.main(null);
				frmCadastroDeAnimais.dispose();
			}
		});
		mntmCadastrarAnimais.setEnabled(false);
		mnNewMenu.add(mntmCadastrarAnimais);
		
		JMenu mnFuncionarios = new JMenu("Funcionarios");
		menuBar.add(mnFuncionarios);
		
		JMenuItem mntmCadastrarFuncionarios = new JMenuItem("Cadastrar funcionarios");
		mntmCadastrarFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarFuncionarios.main(null);
				frmCadastroDeAnimais.dispose();
			}
		});
		mnFuncionarios.add(mntmCadastrarFuncionarios);
		
		JMenu mnNewMenu_1 = new JMenu("Compra de Insumos");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmCompra = new JMenuItem("Nova Compra");
		mntmCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovaCompra.main(null);
				frmCadastroDeAnimais.dispose();
			}
		});
		mnNewMenu_1.add(mntmCompra);
		
		JMenu mnNewMenu_2 = new JMenu("Vendas");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNovaVenda = new JMenuItem("Nova Venda");
		mntmNovaVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovaVenda.main(null);
				frmCadastroDeAnimais.dispose();
			}
		});
		mnNewMenu_2.add(mntmNovaVenda);
		
		JMenu mnRelatrio = new JMenu("Relat\u00F3rio");
		menuBar.add(mnRelatrio);
		
		JMenuItem mntmTotal = new JMenuItem("Total");
		mntmTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Total.main(null);
				frmCadastroDeAnimais.dispose();
			}
		});
		mnRelatrio.add(mntmTotal);
		
		JMenu mnOpes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnOpes);
		
		JMenuItem mntmNovaFazenda = new JMenuItem("Nova fazenda");
		mntmNovaFazenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovaFazenda.main(null);
				frmCadastroDeAnimais.dispose();
			}
		});
		mnOpes.add(mntmNovaFazenda);
		
		JMenuItem mntmSada = new JMenuItem("Sair");
		mntmSada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmMudarFazenda = new JMenuItem("Mudar Fazenda");
		mntmMudarFazenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pergunta.main(null);
			}
		});
		mnOpes.add(mntmMudarFazenda);
		mnOpes.add(mntmSada);
	}
}
