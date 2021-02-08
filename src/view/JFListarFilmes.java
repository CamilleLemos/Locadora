package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFListarFilmes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jtFilme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarFilmes frame = new JFListarFilmes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFListarFilmes() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 11, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("New label");
		getContentPane().add(lblNewLabel1, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel11 = new JLabel("Listar Filmes");
		lblNewLabel11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel11.setBounds(10, 11, 153, 14);
		contentPane.add(lblNewLabel11);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 504, 254);
		contentPane.add(scrollPane);
		
		jtFilme = new JTable();
		jtFilme.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"IdFilme", "T\u00EDtulo", "Categoria", "Tempo"
			}
		));
		scrollPane.setViewportView(jtFilme);
		
		JButton btnCadastrar = new JButton("Cadastrar Filme");
		btnCadastrar.setBounds(10, 322, 122, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar Filme");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				public void actionPerformed(ActionEvent e) {
										
					if(jtFilme.getSelectedRow()!= -1) {
						JFatualizarFilme af = new JFatualizarFilme(
								(int)jtFilme.getValueAt(jtFilme.getSelectedRow(), 0));
						af.setVisible(true);						
					}else {
						JOptionPane.showMessageDialog(null, "Selecione um filme!");
					}
					readJTable();
				}
			}
		});
		
		btnAlterar.setBounds(173, 322, 136, 23);
		contentPane.add(btnAlterar);
		
		contentPane.add(btnAlterar);


		JButton btnExcluir = new JButton("Excluir Filme");			
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jtFilmes.getSelectedColumn() != -1) {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o filme selecionado?","Exclusão", JOptionPane.YES_NO_OPTION);

					if(opcao == 0) {
						FilmeDAO dao = new FilmeDAO();
						Filme f = new Filme();
						f.setIdFilme((int) jtFilmes.getValueAt(jtFilmes.getSelectedRow(), 0));
						dao.delete(f);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Selecione um filme!");					
				}
				readJTable();	
			}
		});
		
		JButton btnExcluir = new JButton("Excluir Filme");
		btnExcluir.setBounds(360, 322, 130, 23);
		contentPane.add(btnExcluir);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnNewButton.setBounds(466, 434, 111, 23);
		contentPane.add(btnNewButton);
		
		readJTable();
		
	}
		public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jtFilme.getModel();
		modelo.setNumRows(0);
		FilmeDAO fdao = new FilmeDAO();
		for(Filme f : fdao.read()) {
			modelo.addRow(new Object[] {
					f.getIdFilme(),
					f.getTitulo(),
					f.getCategoria(),
					f.getTempo()
			});
			}
			
			
		}
}

