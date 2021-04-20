package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSQL {
	
	public Connection cadena_conexion() {
		Connection cn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn = DriverManager.getConnection("jdbc:sqlserver://ERIDANO\\PRUEBAS;databaseName=DbMultiFondosEducacionSuperior","FondoEducacionP","1234");
		} 
		catch (Exception e) {
			
		}
		return cn ;
	}
}
