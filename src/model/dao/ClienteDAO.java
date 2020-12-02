package model.dao;

	import java.awt.List;
import java.sql.Connection;
	import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

	import connection.ConnectionFactory;
import model.bean.Cliente;
import model.bean.Filme;
	
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
		public List<Cliente> read(){
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<Cliente> clientes = new ArrayList<>(); 

			try {
				stmt = con.prepareStatement("SELECT * FROM cliente;");
				rs = stmt.executeQuery();

				while(rs.next()) {
					Cliente c = new Cliente();
					c.setIdCliente(rs.getInt("idCliente"));
					c.setNome(rs.getString("nome"));
					c.setEmail(rs.getString("email"));
					c.setIdade(rs.getInt("idade"));
								
					clientes.add(c);
				}

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao buscar as informações do BD: " + e);
				e.printStackTrace();
			} finally {
				ConnectionFactory.closeConnection(con, stmt, rs);
			}

		
			return clientes;
		}

}
