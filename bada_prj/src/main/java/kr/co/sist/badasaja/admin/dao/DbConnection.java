package kr.co.sist.badasaja.admin.dao;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbConnection {

	private static DbConnection dc;
	/**
	 * Ŭ���� �ܺο��� ��üȭ �ϴ°��� ���´�.
	 */
	private DbConnection() {
		
	}
	/**
	 * Dbconnection ��ü�� ��ȯ�ϴ���
	 * @return
	 */
	public static DbConnection getInstance() {
		if(dc==null) {
			
			dc=new DbConnection();
		}
		return dc;
	}
	public Connection getConn() throws SQLException, NamingException {
		Connection con =null;
		
		//1. JDNI ��밴ü ����
		Context ctx = new InitialContext();
		//2. JDNI ��ü�� ����Ͽ� DBCP�� ã��
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/dbcp");
		//3. Connection ���
		 con = ds.getConnection();
		
		
		return con; 
	}//getConn.
	
	
	public Statement getStatment() throws SQLException, NamingException {
		Statement stmt= null;
		stmt=getConn().createStatement();
		return stmt;
	}
	
	
	/**
	 * DBMS ��������
	 * @param re
	 * @param stmt
	 * @param con
	 * @throws SQLException
	 */
	public void close(ResultSet rs,Statement stmt , Connection con)throws SQLException{
		if(rs!=null) {rs.close();}
		if(stmt!=null) {stmt.close();}
		if(con!=null) {con.close();}
	}

	
}
