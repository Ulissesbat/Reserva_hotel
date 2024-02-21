package db;

public class DbIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	//classe para evitar uma integridade refencial.
		//expelo quando desejo deletar um departamento para qual existem vendedores, pode dar um erro de integridade
	public DbIntegrityException (String msg) {
		super (msg);
	}

}
