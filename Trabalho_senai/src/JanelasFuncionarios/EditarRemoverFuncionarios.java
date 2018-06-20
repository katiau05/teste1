package JanelasFuncionarios;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import DAO.Funcionario;
import Imagem.ImagemEditarFun;
import crud.CrudFuncionarios;

public class EditarRemoverFuncionarios {

	private JFrame frame;
	private JTextField tfNome;
	private JTextField tfNacs;
	private JTextField tfCpf;
	private JTextField tfRg;
	private JTextField tfFone;
	private JTextField tfCargo;
	private JTextField tfSala;
	private JRadioButton rbMas;
	private JEditorPane descricao;
	private JRadioButton rbFem;
	private JButton button_1;
	static Funcionario funcionario = new Funcionario();
	public static File img;
	public static JLabel label_9;
	public static JPanel panel;
	ImagemEditarFun i = new ImagemEditarFun();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarRemoverFuncionarios window = new EditarRemoverFuncionarios();
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
	public EditarRemoverFuncionarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 436);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEditarremoverFuncionario = new JLabel("Editar/Remover Funcionario");
		lblEditarremoverFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarremoverFuncionario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEditarremoverFuncionario.setBounds(0, 0, 714, 19);
		frame.getContentPane().add(lblEditarremoverFuncionario);
		
		tfNome = new JTextField();
		tfNome.setEditable(false);
		tfNome.setColumns(10);
		tfNome.setBounds(55, 51, 211, 20);
		frame.getContentPane().add(tfNome);
		
		tfNacs = new JTextField();
		tfNacs.setEditable(false);
		tfNacs.setColumns(10);
		tfNacs.setBounds(100, 80, 166, 20);
		frame.getContentPane().add(tfNacs);
		
		tfCpf = new JTextField();
		tfCpf.setColumns(10);
		tfCpf.setBounds(55, 110, 211, 20);
		frame.getContentPane().add(tfCpf);
		
		tfRg = new JTextField();
		tfRg.setColumns(10);
		tfRg.setBounds(55, 140, 211, 20);
		frame.getContentPane().add(tfRg);
		
		JLabel label_1 = new JLabel("RG:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(10, 140, 46, 20);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("CPF:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(10, 110, 46, 20);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Nascimento:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(10, 80, 80, 20);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Nome:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(10, 50, 46, 20);
		frame.getContentPane().add(label_4);
		
		tfFone = new JTextField();
		tfFone.setColumns(10);
		tfFone.setBounds(324, 51, 142, 20);
		frame.getContentPane().add(tfFone);
		
		tfCargo = new JTextField();
		tfCargo.setColumns(10);
		tfCargo.setBounds(324, 81, 142, 20);
		frame.getContentPane().add(tfCargo);
		
		tfSala = new JTextField();
		tfSala.setColumns(10);
		tfSala.setBounds(334, 111, 132, 20);
		frame.getContentPane().add(tfSala);
		
		JLabel label = new JLabel("Sal\u00E1rio:");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(276, 111, 61, 20);
		frame.getContentPane().add(label);
		
		JLabel label_5 = new JLabel("Cargo:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(276, 81, 46, 20);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Fone:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setBounds(276, 51, 46, 20);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Sexo:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_7.setBounds(10, 171, 46, 20);
		frame.getContentPane().add(label_7);
		
		rbMas = new JRadioButton("Masculino");
		rbMas.setBounds(55, 171, 87, 20);
		frame.getContentPane().add(rbMas);
		
		rbFem = new JRadioButton("Feminino");
		rbFem.setBounds(144, 171, 87, 20);
		frame.getContentPane().add(rbFem);
		
		descricao = new JEditorPane();
		descricao.setBounds(10, 263, 496, 93);
		frame.getContentPane().add(descricao);
		
		JLabel label_8 = new JLabel("Descri\u00E7\u00E3o:");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_8.setBounds(10, 228, 496, 33);
		frame.getContentPane().add(label_8);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(504, 51, 200, 136);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		label_9 = new JLabel("");
		panel.add(label_9, "name_43080269153814");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(504, 186, 200, 33);
		frame.getContentPane().add(panel_1);
		
		JButton button = new JButton("Foto");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				img = i.selecionaImg();
				i.abrirImagem(img);
			}
		});
		panel_1.add(button);
		
		button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		button_1.setBounds(417, 374, 89, 23);
		frame.getContentPane().add(button_1);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrudFuncionarios remover = new CrudFuncionarios();
				int resposta = JOptionPane.showConfirmDialog(null, "voce deseja remover esse funcionario ", "alerta", 
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
						if(resposta == JOptionPane.YES_OPTION) {
							remover.removeFun(funcionario.getId());
							JOptionPane.showMessageDialog(null, "Funcionario removido com sucesso");
							frame.dispose();
							
						}else
							return;
			}
		});
		btnRemover.setBounds(516, 374, 89, 23);
		frame.getContentPane().add(btnRemover);
		
		JButton button_3 = new JButton("Salvar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrudFuncionarios crud = new CrudFuncionarios();
				String s=null;
				if(rbMas.isSelected())
					s = "feminino";
				if (rbMas.isSelected()) {
					s="masculino";
				}
				
				if(! tfNome.getText().trim().equals("")) {
					if (!tfNacs.getText().trim().equals("")) {
						if (!tfCpf.getText().trim().equals("")) {
							if (! descricao.getText().trim().equals("")) {
								if (! tfRg.getText().trim().equals("")) {
									if (! tfFone.getText().trim().equals("")) {
										if (! tfCargo.getText().trim().equals("")) {
											if (! tfSala.getText().trim().equals("")) {
												crud.updFun(tfCpf.getText(), tfRg.getText(), tfFone.getText(),null ,
														tfCargo.getText(), Double.parseDouble(tfSala.getText()), descricao.getText(),
														i.getImagem(), s, funcionario.getId());
												button_1.doClick();
												VisualizarFuncionarios.btnProcurar.doClick();
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
		button_3.setBounds(615, 374, 89, 23);
		frame.getContentPane().add(button_3);
		pega();
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbFem);
		bg.add(rbMas);
		
		pega();
	}
	
	void pega() {
		tfCargo.setText(funcionario.getCargo());
		tfCpf.setText(funcionario.getCpf());
		tfFone.setText(funcionario.getFone());
		tfNacs.setText(funcionario.getData());
		tfNome.setText(funcionario.getNome());
		tfRg.setText(funcionario.getRg());
		tfSala.setText(String.valueOf(funcionario.getSal()));
		descricao.setText(funcionario.getDes());
		abrirImagem(funcionario.getImg());
		String sexo = funcionario.getSexo();
		
		if(sexo.equalsIgnoreCase("masculino"))
			rbMas.setSelected(true);
		if(sexo.equalsIgnoreCase("feminino"))
			rbFem.setSelected(true);
	}
	
public void abrirImagem(Object source) {//abra a imagem
		
		if(source instanceof File) {
			ImageIcon icon = new ImageIcon();
			icon.setImage(icon.getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), 100));
			label_9.setIcon(icon);
		
		}else if(source instanceof byte[]) {
			ImageIcon icon = new ImageIcon(funcionario.getImg());
			icon.setImage(icon.getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), 100));
			label_9.setIcon(icon);
		}
	}
}
