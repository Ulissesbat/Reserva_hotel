package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import entities.Hospede;
import entities.enums.SituacaoReserva;
import model.dao.HospedeDao;

public class HospedeDaoJDBC implements HospedeDao {
	
	private Connection conn;
	
	public HospedeDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Hospede obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO hospede "
					+ "(Name, dataEntrada, dataSaida, SituacaoReserva, Email, Documento, TipoAp, NumeroAp, ValorDiaria, ValorTotal) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
		
			st.setString(1, obj.getNome());
			st.setDate(2, java.sql.Date.valueOf(obj.getEntrada()));
			st.setDate(3, java.sql.Date.valueOf(obj.getSaida()));
			st.setString(4, obj.getSituacaoReserva().toString());
			st.setString(5, obj.getEmail());
			st.setString(6, obj.getDocumento());
			st.setString(7, obj.getTipo());
			st.setInt(8, obj.getNumero());
			st.setDouble(9, obj.getValorDiaria());
			st.setDouble(10, obj.getValorTotal());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Hospede obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE hospede "
					+ "SET Name = ?, DataEntrada = ?, DataSaida = ?, SituacaoReserva = ?, "
					+ "Email = ?, Documento = ?, TipoAp = ?, NumeroAp = ?, ValorDiaria = ?, ValorTotal = ? "
					+ "WHERE Id = ?",
					Statement.RETURN_GENERATED_KEYS);
		
			st.setString(1, obj.getNome());
			st.setDate(2, java.sql.Date.valueOf(obj.getEntrada()));
			st.setDate(3, java.sql.Date.valueOf(obj.getSaida()));
			st.setString(4, obj.getSituacaoReserva().toString());
			st.setString(5, obj.getEmail());
			st.setString(6, obj.getDocumento());
			st.setString(7, obj.getTipo());
			st.setInt(8, obj.getNumero());
			st.setDouble(9, obj.getValorDiaria());
			st.setDouble(10, obj.getValorTotal());
			
			st.executeUpdate();
		
	}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deletById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM hospede WHERE id = ? ");
			
			st.setInt(1, id);
			
			st.executeUpdate();
		}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		finally {
			DB.closeStatement(st);
		}
	
	}

	@Override
	public Hospede findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM hospede WHERE Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				
				Hospede obj = instantiateHospede(rs, new Hospede());
		
				return obj;
			}
			return null;
		}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		finally{
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		}

	private Hospede instantiateHospede(ResultSet rs, Hospede hosp) throws SQLException {
		
		Hospede obj = new Hospede();
		
		obj.setNome(rs.getString("Name"));
		obj.setEntrada(rs.getDate("entrada").toLocalDate());
		obj.setSaida(rs.getDate("saida").toLocalDate());
	    obj.setSituacaoReserva(SituacaoReserva.valueOf(rs.getString("SituacaoReserva")));
		obj.setEmail(rs.getString("email"));
		obj.setDocumento(rs.getString("documento"));
		obj.setTipo(rs.getString("tipoAp"));
		obj.setNumero(rs.getInt("NumeroAp"));
		obj.setValorDiaria(rs.getDouble("ValorDiaria"));
		obj.setValorTotal(rs.getDouble("ValorTotal"));
		
		return obj;
	
	}

	@Override
	public List<Hospede> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT hospede.*, hospede.Name as DepName " +
							"FROM hospede " +
							"ORDER BY hospede.Name");

			rs = st.executeQuery();
			
			List<Hospede> list = new ArrayList<>();
			Map<Integer, Hospede> map = new HashMap<>();
			
			while (rs.next()) {
				
				Hospede hosp = map.get(rs.getInt("Id"));
				
				if (hosp == null) {
					hosp = instantiateHospede(rs, hosp);
					map.put(rs.getInt("hospede"), hosp);
				}
				
				Hospede obj = instantiateHospede(rs, hosp);
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
}
