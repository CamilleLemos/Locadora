package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroFilme extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textoTitulo;
	private JTextField textoCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFilme frame = new TelaCadastroFilme();
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
	public TelaCadastroFilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Filmes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 229, 14);
		contentPane.add(lblNewLabel);
		
		JLabel Título = new JLabel("T\u00EDtulo");
		Título.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Título.setBounds(10, 36, 69, 14);
		contentPane.add(Título);
		
		JLabel lblNewLabel_2 = new JLabel("Sinopse");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 92, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textoTitulo = new JTextField();
		textoTitulo.setBounds(10, 61, 395, 20);
		contentPane.add(textoTitulo);
		textoTitulo.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 395, 77);
		contentPane.add(scrollPane);
		
		JTextArea textoSinopse = new JTextArea();
		scrollPane.setViewportView(textoSinopse);
		
		JLabel lblNewLabel_1 = new JLabel("Categoria");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 206, 99, 20);
		contentPane.add(lblNewLabel_1);
		
		textoCategoria = new JTextField();
		textoCategoria.setBounds(10, 228, 395, 20);
		contentPane.add(textoCategoria);
		textoCategoria.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tempo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 259, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JSpinner buttonTempo = new JSpinner();
		buttonTempo.setBounds(10, 284, 51, 43);
		contentPane.add(buttonTempo);
		
		JLabel lblNewLabel_4 = new JLabel("Imagem");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(135, 260, 69, 14);
		contentPane.add(lblNewLabel_4);
		
		JRadioButton button2D = new JRadioButton("2D");
		button2D.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button2D.setBounds(110, 293, 46, 23);
		contentPane.add(button2D);
		
		JRadioButton button3D = new JRadioButton("3D");
		button3D.setBounds(158, 294, 46, 23);
		contentPane.add(button3D);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(button2D);
		imagem.add(button3D);
		
		
		JLabel lblNewLabel_5 = new JLabel("\u00C1udio");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(287, 259, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JRadioButton buttonDublado = new JRadioButton("Dublado");
		buttonDublado.setBounds(252, 294, 69, 23);
		contentPane.add(buttonDublado);
		
		JRadioButton buttonLegendado = new JRadioButton("Legendado");
		buttonLegendado.setBounds(326, 294, 79, 23);
		contentPane.add(buttonLegendado);
		
		ButtonGroup audio = new ButtonGroup();
		audio.add(buttonDublado);
		audio.add(buttonLegendado);
		
		
		JButton buttonCadastrar = new JButton("Cadastrar");
		buttonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filme f = new Filme();
				FilmeDAO dao = new FilmeDAO();
				f.setTitulo(textoTitulo.getText());
				f.setSinopse(textoSinopse.getText());
				f.setCategoria(textoCategoria.getText());
				f.setTempo(Integer.parseInt(buttonTempo.getValue().toString()));
				if(button2D.isSelected()) {
					f.setImagem3d(false);
				}else if (button3D.isSelected()) {
					f.setImagem3d(true);
				}
				if(buttonDublado.isSelected()) {
					f.setDublado(true);
				}else if (buttonLegendado.isSelected()) {
					f.setDublado(false);
				}
				dao.create(f);
				dispose();
			}
		});
		buttonCadastrar.setBounds(10, 352, 89, 23);
		contentPane.add(buttonCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textoTitulo.setText(null);
				textoSinopse.setText(null);
				textoCategoria.setText(null);
				buttonTempo.setValue(0);
				imagem.clearSelection();
				audio.clearSelection();
			}
		});
		
		btnLimpar.setBounds(150, 352, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		buttonCancelar.setBounds(299, 352, 89, 23);
		contentPane.add(buttonCancelar);
	}

}
