/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.philip.utils.h2browser.utils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class DBUtils {
    
    private static Connection dbConnection;

    public static void main(String[] args) throws SQLException {
	dbConnection = DriverManager.getConnection("jdbc:h2:./phildbtest","sa","");
	Statement stmt = dbConnection.createStatement();
	//stmt.execute("CREATE TABLE demotable (id INTEGER NOT NULL, lastname VARCHAR(128), firstname VARCHAR(128), username VARCHAR(128) )");
	//stmt.executeUpdate("INSERT INTO demotable VALUES(1, 'Hassialis', 'Philip Alexander', 'fhasial') ");
	//stmt.executeUpdate("INSERT INTO demotable VALUES(2, '', '', 'Admin') ");
	stmt.execute("delete from demotable where username='fameliarisa'");
	stmt.execute("SELECT * FROM demotable");
	
	ResultSet rs = stmt.getResultSet();
	while (rs.next()) {
	    System.out.println(rs.getString("username"));
	}
	
    }
    
    public static Statement executeQuery(String query) throws SQLException {
	Statement res = dbConnection.createStatement();
	if (res.execute(query)) {
	    return res;
	} else {
	    return null;
	}
	
    }
    
    public static void openConnection(File dbFile) throws ClassNotFoundException, SQLException, IOException {
	Class.forName("org.h2.Driver");
	String strJdbcFileSpec = dbFile.getCanonicalPath().toLowerCase();
	if (strJdbcFileSpec.endsWith(".mv.db")) {
	    strJdbcFileSpec = strJdbcFileSpec.substring(0, strJdbcFileSpec.indexOf(".mv.db"));
	}
	dbConnection = DriverManager.getConnection("jdbc:h2:"+strJdbcFileSpec, "sa",""); 
    }
    
    public static void closeConnection() throws SQLException {
	if (dbConnection!=null) {
	    dbConnection.close();
	}
    }
    
    /**
     * @return the DBConnection
     */
    public static Connection getDBConnection() {
	return dbConnection;
    }

    /**
     * @param aDBConnection the DBConnection to set
     */
    public static void setDBConnection(Connection aDBConnection) {
	dbConnection = aDBConnection;
    }
    
    
}
