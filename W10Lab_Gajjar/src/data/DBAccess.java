package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccess {
private Connection conn = null;
public DBAccess() {
	this.connect();
}
public Connection connect() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url ="jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK";
		String username = "N01349164";
		String password = "oracle";
		conn = DriverManager.getConnection(url,username,password);
	}
	catch(SQLException e) {
		e.printStackTrace();		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return conn;
}
	public ResultSet getPrograms() {
		ResultSet rs = null;
		try {
			String query = "Select * From Programs";
			Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = stm.executeQuery(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}