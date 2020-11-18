package model.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	import javax.swing.JOptionPane;

	import connection.ConnectionFactory;
import model.bean.Cliente;
	
	public class ClienteDAO {

		public void create(Cliente f) {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			
			try {
				stmt = con.prepareStatement("INSERT INTO CLIENTE (nome, email, idade) VALUES"
						+ "(?,?,?)");
				stmt.setString(1, f.getNome());
				stmt.setString(2, f.getEmail());
				stmt.setLong(3, f.getIdade());
				
				stmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Cliente Salvo com sucesso!");
			} catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ e);
			}finally{
				ConnectionFactory.closeConnection(con, stmt);
			}
		}

}
