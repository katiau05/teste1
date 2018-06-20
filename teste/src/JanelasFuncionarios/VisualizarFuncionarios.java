package JanelasFuncionarios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import DAO.Animal;
import DAO.Funcionario;
import JanelasAnimal.CadastrarAnimais;
import JanelasAnimal.EditarRemoverAnimal;
import JanelasAnimal.VisualizarAnimais;
import JanelasComtabil.NovaCompra;
import JanelasComtabil.NovaVenda;
import JanelasComtabil.Total;
import JanelasComtabil.VisualizarCompras;
import JanelasComtabil.VisualizarVendas;
import banco.Conexao;
import crud.CrudFuncionarios;
import outraJanelas.NovaFazenda;
import outraJanelas.Pergunta;
import outraJanelas.Principal;
import outraJanelas.VisualizarFazendas;

public class VisualizarFuncionarios {

	private JFrame frame;
	 JTextField tfProucurar;
	private JTable table;
	static JButton btnProcurar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarFuncionarios window = new VisualizarFuncionarios();
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
	public VisualizarFuncionarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 450);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		tfProucurar = new JTextField();
		tfProucurar.setBounds(10, 11, 595, 20);
		frame.getContentPane().add(tfProucurar);
		tfProucurar.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Principal.frmPrincipal.setVisible(true);
			}
		});
		btnCancelar.setBounds(615, 367, 89, 23);
		frame.getContentPane().add(btnCancelar);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfProucurar.getText().trim().equals(""))
					coloca();
				else
					like();
			}
		});
		btnProcurar.setBounds(615, 10, 89, 23);
		frame.getContentPane().add(btnProcurar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 694, 314);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				passa();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Nascimento", "CPF", "RG", "Sexo", "Telefone", "Email", "Cargo", "Salario", "Descri\u00E7\u00E3o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(90);
		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		table.getColumnModel().getColumn(9).setPreferredWidth(85);
		table.getColumnModel().getColumn(10).setPreferredWidth(121);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		mnInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Principal.frmPrincipal.setVisible(true);
				frame.dispose();
			}
		});
		menuBar.add(mnInicio);
		
		JMenu mnNewMenu = new JMenu("Animais");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCadastrarAnimais = new JMenuItem("Cadastrar Animais");
		mntmCadastrarAnimais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarAnimais.main(null);
				frame.dispose();
			}
		});
		mnNewMenu.add(mntmCadastrarAnimais);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Visualizar Animais");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizarAnimais.main(null);
				frame.dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnFuncionarios = new JMenu("Funcionarios");
		menuBar.add(mnFuncionarios);
		
		JMenuItem mntmCadastrarFuncionarios = new JMenuItem("Cadastrar funcionarios");
		mntmCadastrarFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarFuncionarios.main(null);
				frame.dispose();
			}
		});
		mnFuncionarios.add(mntmCadastrarFuncionarios);
		
		JMenuItem mntmVisualizarFuncionarios = new JMenuItem("Visualizar funcionarios");
		mntmVisualizarFuncionarios.setEnabled(false);
		mntmVisualizarFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizarFuncionarios.main(null);
				frame.dispose();
			}
		});
		mnFuncionarios.add(mntmVisualizarFuncionarios);
		
		JMenu mnNewMenu_1 = new JMenu("Compra de Insumos");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmCompra = new JMenuItem("Nova Compra");
		mntmCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovaCompra.main(null);
				frame.dispose();
			}
		});
		mnNewMenu_1.add(mntmCompra);
		
		JMenuItem mntmVisualizarCompra = new JMenuItem("Visualizar Compras");
		mntmVisualizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizarCompras.main(null);
				frame.dispose();
			}
		});
		mnNewMenu_1.add(mntmVisualizarCompra);
		
		JMenu mnNewMenu_2 = new JMenu("Vendas");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNovaVenda = new JMenuItem("Nova Venda");
		mntmNovaVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovaVenda.main(null);
				frame.dispose();
			}
		});
		mnNewMenu_2.add(mntmNovaVenda);
		
		JMenuItem mntmVisualizarVendas = new JMenuItem("Visualizar Vendas");
		mntmVisualizarVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizarVendas.main(null);
				frame.dispose();
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
				frame.dispose();
			}
		});
		mnRelatrio.add(mntmTotal);
		
		JMenuItem mntmNovaFazenda = new JMenuItem("Nova fazenda");
		mntmNovaFazenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovaFazenda.main(null);
				frame.dispose();
			}
		});
		mnOpes.add(mntmNovaFazenda);
		
		JMenuItem mntmVisualizarFazenda = new JMenuItem("Visualizar Fazenda");
		mntmVisualizarFazenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizarFazendas.main(null);
				frame.dispose();
			}
		});
		mnOpes.add(mntmVisualizarFazenda);
		
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
		coloca();
	}
	
	void coloca() {
		ResultSet rs = new CrudFuncionarios().seFu();
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		
		try {
			while (rs.next()) {
				modelo.addRow(new Object[] {rs.getInt("idfuncionarios"),rs.getString("nome_fun"),rs.getString("data_nasc"),rs.getString("cpf_fun"),
						rs.getString("rg_fun"),rs.getString("sexo"),rs.getString("fone_fun"),rs.getString("email_fun"),rs.getString("cargo"),rs.getString("salario"),rs.getString("descrica")});
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void like() {
		ResultSet rs = new CrudFuncionarios().proucfun(tfProucurar.getText());
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		
		try {
			while (rs.next()) {
				modelo.addRow(new Object[] {rs.getInt("idfuncionarios"),rs.getString("nome_fun"),rs.getString("data_nasc"),rs.getString("cpf_fun"),
						rs.getString("rg_fun"),rs.getString("sexo"),rs.getString("fone_fun"),rs.getString("email_fun"),rs.getString("cargo"),rs.getString("salario"),rs.getString("descrica")});
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void passa() {
		int linha = table.getSelectedRow();
		Funcionario edit = new Funcionario();
		
		edit.setId(Integer.parseInt(table.getValueAt(linha, 0).toString()));
		edit.setNome(table.getValueAt(linha, 1).toString());
		edit.setData(table.getValueAt(linha, 2).toString());
		edit.setCpf(table.getValueAt(linha, 3).toString());
		edit.setRg(table.getValueAt(linha, 4).toString());
		edit.setSexo(table.getValueAt(linha, 5).toString());
		edit.setFone(table.getValueAt(linha, 6).toString());
		//edit.setEmail(table.getValueAt(linha, 7).toString());
		edit.setCargo(table.getValueAt(linha, 8).toString());
		edit.setSal(Double.parseDouble(table.getValueAt(linha, 9).toString()));
		edit.setDes(table.getValueAt(linha, 10).toString());
		
		ResultSet dados1 = null;
		String sql = "SELECT (img) FROM funcionarios WHERE idfuncionarios=?";
		
			try {
				PreparedStatement stmt = new Conexao().getConexao().prepareStatement(sql);
				stmt.setInt(1, Integer.parseInt(table.getValueAt(linha, 0).toString()));
				dados1 = stmt.executeQuery();
				stmt.execute();
				stmt.close();
				
				if(dados1.next()) {
					edit.setImg(dados1.getBytes("img"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			EditarRemoverFuncionarios.funcionario = edit;
			EditarRemoverFuncionarios.main(null);
	}
}
