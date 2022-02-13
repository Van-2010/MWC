package Modelo;

import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.sun.jdi.connect.spi.Connection;

import Controlador.Conexion;


public class AccionsDev {
	
		private Conexion miConexion;
		private Connection connection;
		private boolean estadoOperacion;
		private PreparedStatement statement;

		public AccionsDev() {
			miConexion = new Conexion();

		}

		public void addDeveloper(Developer developer) throws SQLException {
			String sql = null;

			connection = (Connection) miConexion.dameConexion();
			
			try {
				PreparedStatement miSentencia = ((java.sql.Connection) connection).prepareStatement(
						"INSERT INTO developers(id,name,email,phone,categoria) VALUES(?,?,?,?,?)");
				
				
				miSentencia.setString(1, null);
				miSentencia.setString(2, developer.getName());
				miSentencia.setString(3,developer.getEmail());
				miSentencia.setString(4, developer.getPhone());
				//miSentencia.setDate(4,new java.util.Date(developer.getDate());
				miSentencia.setString(5,developer.getCategoria());
				

				miSentencia.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		public void updateDeveloper(Developer developer) throws SQLException {
			String sql = null;

			connection = (Connection) miConexion.dameConexion();
			try {
				PreparedStatement miSentencia = ((java.sql.Connection) connection).prepareStatement(
						"UPDATE developers SET name=?,email=?, phone=?,categoria=?");

				miSentencia.setString(1, null);
				miSentencia.setString(2, developer.getName());
				miSentencia.setString(3,developer.getEmail());
				miSentencia.setString(4, developer.getPhone());
				//miSentencia.setDate(4,new java.util.Date(developer.getDate());
				miSentencia.setString(5,developer.getCategoria());
				
				System.out.println(miSentencia.toString());

				miSentencia.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		public ArrayList<Developer> listarDeveloper() throws SQLException {

			ResultSet resulset = null;
			ArrayList<Developer> developers = new ArrayList<Developer>();

			String sql = null;
			connection = (Connection) miConexion.dameConexion();
			java.sql.Statement sta = ((java.sql.Connection) connection).createStatement();
			try {
				sql = "SELECT * FROM developers";

				resulset = sta.executeQuery(sql);

				while (resulset.next()) {
					Developer d = new Developer();
					
					d.setId(resulset.getInt("id"));
					d.setName(resulset.getString("name"));
					d.setEmail(resulset.getString("email"));
					d.setPhone(resulset.getString("phone"));
					d.setCategoria(resulset.getString("categoria"));
					//miSentencia.setDate(4,new java.util.Date(developer.getDate());
					
					developers.add(d);
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

			return developers;
		}

		public void eliminarDeveloper(int id) throws SQLException {
			String sql = null;

			connection = (Connection) miConexion.dameConexion();
			try {
				PreparedStatement miSentencia = ((java.sql.Connection) connection).prepareStatement("DELETE FROM developers  WHERE id=? ");

				miSentencia.setInt(1, id);

				miSentencia.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		
}