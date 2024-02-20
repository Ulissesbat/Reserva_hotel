package model.dao;

import db.DB;
import model.dao.impl.HospedeDaoJDBC;

public class DaoFactory {
	
	public static HospedeDaoJDBC createHospedeDao() {
		return new HospedeDaoJDBC (DB.getConnection());
	}
}
