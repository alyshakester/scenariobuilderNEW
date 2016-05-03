package org.theradoc.scenariobuilder;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Database {
	
	static Connection conn = null;
	static Statement stmt = null;
	private static String serverName;
	
	public static void connectToDB() throws SQLException, ClassNotFoundException, UnknownHostException
	{
		serverName = InetAddress.getLocalHost().getHostName();
		System.out.println(serverName);
		String user = "tdrun";
		String password = "smrt600";
		String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
//		String dbURL = "jdbc:oracle:thin:@//c3cipurging470:1521/tdoc";
		String dbURL = "jdbc:oracle:thin:@//" + serverName + ":1521/tdoc";
		Class.forName(jdbcDriver);
		conn = DriverManager.getConnection(dbURL, user, password);
	//	System.out.println("Connected to database");
	}
	
	public static void insertADTRecord(String message) throws SQLException {
		String messageId = null;
		stmt = conn.createStatement();
		String query = "select TD_TRAN_ID_SEQ.NEXTVAL from dual";
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			messageId = rs.getString("NEXTVAL");
		}
		System.out.println(messageId);
		stmt = conn.createStatement();
//		String query = "insert into td_if_queue(td_message_id, time_received, time_parsed, time_in_db, msg_type, event_type, message, pat_id, if_data_type, if_data_source)" + 
//				"values((select max(td_message_id) + 1 from td_if_queue), sysdate, sysdate, sysdate, 'ADT', 'A01', '" + message + "', '" + patId + "', 'ADT', 'ADT')";
		String query1 = "insert into td_if_queue(td_message_id, time_received, time_in_db, msg_type, message, if_data_type, if_data_source)" + 
				"values(" + messageId + ", sysdate, sysdate, 'ADT', '" + message + "', 'ADT', 'ADT')";
		System.out.println(query1);
		rs = stmt.executeQuery(query1);
		parseADT(messageId);
		rs.close();
		stmt.close();
		conn.close();
//		System.out.println("Connection Closed");
	}
	
	public static void parseADT(String message) throws SQLException {
		String query = "begin td_msg_pkg.Parse(" + message + "); end;";
		CallableStatement callStmt = conn.prepareCall(query);
//		System.out.println(query);
		callStmt.executeQuery(query);
	}
	
	public static boolean checkDBForPatient(String patientId) throws SQLException {
		boolean patExists = false;
		stmt = conn.createStatement();
		String query = "select * from td_patient where pat_id = '" + patientId + "'";
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		if(!rs.next()) 
		{
			JOptionPane.showMessageDialog(null, "Patient does not exist in database. Submit an ADT.");
		} else
			patExists = true;
		rs.close();
		stmt.close();
		conn.close(); 
		System.out.println("Connection Closed");
		return patExists;
	}
}

//insert into td_if_queue(td_message_id, time_recieved, time_parsed, time_in_db, msg_type, event_type, message, pat_id, if_data_type, if_data_source) 
//values(max(td_message_id) + 1, sysdate, sysdate, sysdate, 'ADT', 'A01', message, patId, 'ADT', 'ADT');