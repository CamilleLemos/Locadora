package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

public class JFatualizarCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int IdCliente = 0;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEmail;

	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFatualizarCliente frame = new JFatualizarCliente();
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
	public JFatualizarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alterar Clientes");
		lblNewLabel.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 310, 25);
		contentPane.add(lblNewLabel);
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente c = cdao.read(id);
		
		JLabel lblNewLabel_2 = new JLabel("Id do Cliente:");
		lblNewLabel_2.setBounds(187, 36, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblIdCliente = new JLabel("New label");
		lblIdCliente.setBounds(265, 36, 46, 14);
		contentPane.add(lblIdCliente);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 53, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textNome = new JTextField();
		textNome.setBounds(10, 72, 414, 30);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 103, 93, 20);
		contentPane.add(lblNewLabel_3);
		
		textEmail = new JTextField();
		textEmail.setBounds(10, 126, 414, 30);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JSpinner buttonIdade = new JSpinner();
		buttonIdade.setBounds(10, 192, 414, 30);
		contentPane.add(buttonIdade);
		
		JLabel lblNewLabel_4 = new JLabel("Idade:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 167, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		lblIdCliente.setText(String.valueOf(c.getIdCliente()));
		textNome.setText(c.getNome());
		textEmail.setText(c.getEmail());
		buttonIdade.setValue(c.getIdade());
		
		
		JButton buttonAlterar = new JButton("Alterar");
		buttonAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				c.setIdCliente(Integer.parseInt(lblIdCliente.getText()));
				c.setNome(textNome.getText());
				c.setEmail(textEmail.getText());
		        c.setIdade(Integer.parseInt(buttonIdade.getValue().toString()));
				dao.update(c);
			}
		});
		buttonAlterar.setBounds(10, 248, 89, 23);
		contentPane.add(buttonAlterar);
		
		JButton buttonLimpar = new JButton("Limpar");
		buttonLimpar.setBounds(139, 248, 89, 23);
		contentPane.add(buttonLimpar);
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(265, 248, 89, 23);
		contentPane.add(buttonCancelar);
		
		
	}

}
