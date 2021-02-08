package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bean.Filme;
import model.dao.FilmeDAO;

public class JFatualizarFilme extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textoTitulo;
	private JTextField textoCategoria;
	
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFatualizarFilme frame = new JFatualizarFilme(id);
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
	public JFatualizarFilme(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alterar Filme");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 229, 14);
		contentPane.add(lblNewLabel);
		
		FilmeDAO fdao = new FilmeDAO();
		Filme f = fdao.read(id);
		
		JLabel lblNewLabel_6 = new JLabel("ID do Filme:");
		lblNewLabel_6.setBounds(145, 36, 59, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(218, 37, 46, 14);
		contentPane.add(lblId);
		
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
		
		
		if(f.isImagem3d() == true) {
			button3D.setSelected(true);
		} else if(f.isImagem3d() == false) {
			button2D.setSelected(true);
		}
		
		if(f.isDublado() == true) {
			buttonDublado.setSelected(true);
		} else if(f.isDublado() == false) {
			buttonLegendado.setSelected(true);
		}
		
		lblId.setText(String.valueOf(f.getIdFilme()));
		textoTitulo.setText(f.getTitulo());
		textoSinopse.setText(f.getSinopse());
		textoCategoria.setText(f.getCategoria());
		buttonTempo.setValue(f.getTempo());
		
		
		JButton buttonAlterar = new JButton("Alterar");
		buttonAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filme f = new Filme();
				FilmeDAO dao = new FilmeDAO();
				f.setIdFilme(Integer.parseInt(lblId.getText()));
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
				dao.update(f);
				dispose();
				
			}
		});
		buttonAlterar.setBounds(10, 352, 89, 23);
		contentPane.add(buttonAlterar);
		
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
		
		JButton buttonLimpar = new JButton("Limpar");
		buttonLimpar.setBounds(150, 352, 89, 23);
		contentPane.add(buttonLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(299, 352, 89, 23);
		contentPane.add(buttonCancelar);
		
		
	}
}
