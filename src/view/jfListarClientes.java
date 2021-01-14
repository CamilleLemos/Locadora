package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

import javax.swing.AbstractButton;
import javax.swing.JButton;

public class jfListarClientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfListarClientes frame = new jfListarClientes();
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
	public jfListarClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 146, 30);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 52, 522, 275);
		contentPane.add(scrollPane);
		
		tableClientes = new JTable();
		tableClientes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Idade", "Email", "Nome", "IdCliente"
			}
		));
		scrollPane.setViewportView(tableClientes);
		
		JButton btnCadastrarC = new JButton("Cadastrar Cliente");
		btnCadastrarC.setBounds(23, 362, 131, 23);
		contentPane.add(btnCadastrarC);
		
		JButton btnAlterarC = new JButton("Alterar Cliente\r\n");
		btnAlterarC.setBounds(197, 362, 136, 23);
		contentPane.add(btnAlterarC);
		
		
		JButton btnExcluirC = new JButton("Excluir Cliente");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(jtClientes.getSelectedColumn() != -1) {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o cliente selecionado?","Exclusão", JOptionPane.YES_NO_OPTION);

					if(opcao == 0) {
						ClienteDAO dao = new ClienteDAO();
						Cliente c = new Cliente();
						c.setIdCliente((int) jtClientes.getValueAt(jtClientes.getSelectedRow(), 0));
						dao.delete(c);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente!");					
				}
				readJTable();	
			}
		});
		
		btnExcluirC.setBounds(370, 362, 131, 23);
		contentPane.add(btnExcluirC);
		
		readTableClientes();
	
}
	
	public void readTableClientes() {
		DefaultTableModel modelo = (DefaultTableModel)tableClientes.getModel();
		modelo.setNumRows(0);
		ClienteDAO cdao = new ClienteDAO();
		for(Cliente c: cdao.read()) {
			modelo.addRow(new Object[] {
					c.getIdCliente(),
					c.getNome(),
					c.getIdade(),
					c.getEmail()
			});

		}
	}
}