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
		public Cliente read(int idCliente) {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Cliente c = new Cliente();
			
			try {
				stmt = con.prepareStatement("SELECT * FROM cliente WHERE idCliente=? LIMIT 1;");
				stmt.setInt(1, idCliente);
				rs = stmt.executeQuery();
				if(rs != null && rs.next()) {
					c.setIdCliente(rs.getInt("idFilme"));
					c.setNome(rs.getString("nome"));
					c.setEmail(rs.getString("email"));
					c.setIdade(rs.getInt("int"));
					
		}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				ConnectionFactory.closeConnection(con, stmt, rs);
			}
				return c;
		}
			
		public void update(Cliente c) {
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt =  null;
	
	try {
		stmt = con.prepareStatement("UPDATE filme SET nome=?, email=?, tempo?, idade=?, WHERE idClientes=?");
		stmt.setString(1, c.getNome());
		stmt.setString(2, c.getEmail());
		stmt.setInt(3, c.getIdade());
		stmt.setInt(7, c.getIdCliente());
		stmt.executeUpdate();
		JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
		
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e);
	} finally {
		ConnectionFactory.closeConnection(con, stmt);
	}
}
		public void delete(Cliente c) {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;

			try {
				stmt = con.prepareStatement("DELETE FROM cliente WHERE idCliente=?");
				stmt.setInt(1, c.getIdCliente());
				stmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ e);

			} finally {
				ConnectionFactory.closeConnection(con, stmt);
			}

		}
	}
			
