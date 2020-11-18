package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.dao.ClienteDAO;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
		lblNewLabel.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 310, 25);
		contentPane.add(lblNewLabel);
		
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
				
		
		JButton buttonCadastrar = new JButton("Cadastrar");
		buttonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				c.setNome(textNome.getText());
				c.setEmail(textEmail.getText());
		        c.setIdade(Integer.parseInt(buttonIdade.getValue().toString()));
				dao.create(c);
			}
		});
		buttonCadastrar.setBounds(10, 248, 89, 23);
		contentPane.add(buttonCadastrar);
		
		JButton buttonLimpar = new JButton("Limpar");
		buttonLimpar.setBounds(139, 248, 89, 23);
		contentPane.add(buttonLimpar);
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(265, 248, 89, 23);
		contentPane.add(buttonCancelar);
	}
}
