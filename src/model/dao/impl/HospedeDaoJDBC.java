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
					+ "(Nome, dataReserva, dataEntrada, dataSaida, SituacaoReserva, Email, Documento, TipoAp, NumeroAp, ValorDiaria, ValorTotal) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
		
			st.setString(1, obj.getNome());
			st.setDate(2, new java.sql.Date(obj.getDataReserva().getTime()));
			st.setDate(3, new java.sql.Date(obj.getEntrada().getTime()));
			st.setDate(4, new java.sql.Date(obj.getSaida().getTime()));
			st.setString(5, obj.getSituacaoReserva().toString());
			st.setString(6, obj.getEmail());
			st.setString(7, obj.getDocumento());
			st.setString(8, obj.getTipo());
			st.setInt(9, obj.getNumero());
			st.setDouble(10, obj.getValorDiaria());
			st.setDouble(11, obj.getValorTotal());
			
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hospede findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HospedeDao> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hospede> findByHospede(Hospede Hospede) {
		// TODO Auto-generated method stub
		return null;
	}

}
