/*
 * CachePersentG.java
 *
 */
import java.io.*;
import java.sql.*;

public class IRISPersentG{

    public static void main(String[] args){
 		try {

        	        String           url="jdbc:IRIS://localhost:51773/USER";
        	        String           username="_SYSTEM";  // null for default
        	        String           password="SYS";  // null for default
 		        Class.forName ("com.intersystems.jdbc.IRISDriver");
                        Connection dbconnection = DriverManager.getConnection(url, username, password);
	                CallableStatement cstmt = dbconnection.prepareCall("{call SQLUSER.TestStoredProc1_G(?)}");
                        InputStreamReader isr = new InputStreamReader(System.in);
                        BufferedReader br = new BufferedReader(isr);
                        System.out.print("Enter Global Name: ");
                        String gn = br.readLine();
                        cstmt.setString(1, gn);
 		        java.sql.ResultSet rs = cstmt.executeQuery();
 		        ResultSetMetaData rsmd = rs.getMetaData();

 			int colnum = rsmd.getColumnCount();
 			while (rs.next()) {
 				for (int i=1; i<=colnum; i++) {
                                        System.out.print(rsmd.getColumnName(i) + "   ");
 				}
 				System.out.println();

                                for (int i=1; i<=colnum; i++) {
                                        System.out.print(rs.getString(i) + "  ");
                                }
                                System.out.println();
 			}

 			dbconnection.close();
 		} catch (Exception ex) {
 			System.out.println("Caught exception: " +
                               ex.getClass().getName()
                               + ": " + ex.getMessage());
 		}
 	}

}
