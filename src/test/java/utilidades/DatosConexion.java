package utilidades;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DatosConexion extends ConexionSQL {
	Connection cn = cadena_conexion();
	
	public Object [][] ProvarConexion(String strQuery) {
		Object obj[][] = null;
		int j = 0; 
		int numFilas = 0 ;
		try {
			PreparedStatement ps = null ;
			ResultSet rs = null ;
			ps = cn.prepareStatement(strQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			rs.last();
			ResultSetMetaData rsMd = rs.getMetaData();
			int	numCols = rsMd.getColumnCount();
			numFilas = rs.getRow(); 
			obj = new Object [numFilas][numCols];
			rs.beforeFirst();
			while (rs.next()) {
				for (int i = 0; i < numCols - 1; i++) {
					obj[j][i] = rs.getObject(i+1);
				}
				j++;
			}
		} catch (Exception e) {
			
		}
		return obj;
	}

}
