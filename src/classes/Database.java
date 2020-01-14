package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.*;
import java.text.SimpleDateFormat;

import interfaces.DataHandler;

/**
 * The class for the MYSQL database
 * 
 * @author gabrieleromanato
 *
 */

public class Database implements DataHandler {
	
	private Connection conn;
	
	public Database() {
        try {

            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/pedaggioautostradale?user=pedaggio&password=1234&useSSL=false&serverTimezone=Europe/Rome");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
	
	/**
	 *   Gets database results from an SQL query.
	 *   Normalizes the results in an associative structure.
	 *   Normalizes data types as strings.
	 *   
	 *   
	 *   @param query String The SQL query
	 *   @return ArrayList
	 * 
	 */
	
	
	public ArrayList<HashMap<String, String>> readData( String query ) {
		 	Statement stmt = null;
	        ResultSet rs = null;
	        ArrayList<HashMap<String,String>> data = new ArrayList<HashMap<String,String>>();

	        try {
	            stmt = this.conn.createStatement();
	            rs = stmt.executeQuery(query);
	            ArrayList<String> info = new ArrayList<String>();
	            
	            ResultSetMetaData metadata = rs.getMetaData();
	            
	            int columnCount = metadata.getColumnCount();
	            
	            for (int i = 1; i <= columnCount; i++ ) {
	            	 
	            	String columnName = metadata.getColumnName(i);
	            	String columnType = metadata.getColumnTypeName(i);
	            	
	            	info.add(columnName + ":" + columnType);
	            	
	            	 
	            }
	           
	            if (stmt.execute(query)) {
	                rs = stmt.getResultSet();

	                while(rs.next()) {
	                	
	                	HashMap<String, String> datum = new HashMap<String, String>();
	                	
	                	for(String part: info) {
	                		String[] parts = part.split(":");
	                		String name = parts[0];
	                		String type = parts[1];
	                		
	                		switch(type.toLowerCase()) {
	                		case "int":
	                			datum.put(name, Integer.toString(rs.getInt(name)));
	                			break;
	                		case "varchar":
	                			datum.put(name, rs.getString(name));
	                			break;
	                		case "decimal":
	                			datum.put(name, Double.toString(rs.getDouble(name)));
	                			break;
	                		case "datetime":
	                			Timestamp timestamp = rs.getTimestamp(name);
	                			String pattern = "yyyy-MM-dd HH:mm:ss";
	                			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	                			datum.put(name, simpleDateFormat.format(timestamp.getTime()));
	                			break;
	                			default:
	                				break;
	                		}
	                	}
	                	
	                	data.add(datum);
	                	
	                }
	                
	                rs.close();
	                

	                return data;

	            }
	            

	        } catch(SQLException ex) {
	            System.out.println("SQLException: " + ex.getMessage());
	            System.out.println("SQLState: " + ex.getSQLState());
	            System.out.println("VendorError: " + ex.getErrorCode());
	        } finally {
	            if (rs != null) {
	                try {
	                    rs.close();
	                } catch (SQLException sqlEx) { }
	            }

	            if (stmt != null) {
	                try {
	                    stmt.close();
	                } catch (SQLException sqlEx) { }
	            }
	        }
	        return data;
	}
	
	/**
	 *   Performs INSERT, UPDATE and DELETE SQL queries.
	 *  
	 *   
	 *   
	 *   @param query String The SQL query
	 *   @return Boolean
	 * 
	 */
	
	public boolean writeData(String query) {
		
		 try {
	            Statement st = this.conn.createStatement();
	            st.executeUpdate(query);
	            this.conn.close();
	            return true;
	        } catch(SQLException ex) {
	            try {
	                this.conn.close();
	            } catch(SQLException e) {
	                System.out.println(e.getErrorCode());
	            }
	            return false;
	        }
		
	}

}
