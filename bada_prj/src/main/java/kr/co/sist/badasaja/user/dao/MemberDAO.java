package kr.co.sist.badasaja.user.dao;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.naming.NamingException;

import kr.co.sist.badasaja.dbConnection.DbConnection;
import kr.co.sist.badasaja.vo.CuVO;
import kr.co.sist.util.cipher.DataEncrypt;



/**
 * @author user
 *info="����"
 */
public class MemberDAO {
	
 public boolean selectMember(CuVO cuVO) throws SQLException, NamingException, UnsupportedEncodingException, NoSuchAlgorithmException, GeneralSecurityException{
	 	boolean flag= false;
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		CuVO loginVo =null; 
		DbConnection dc= DbConnection.getInstance();
		try {
		//1. ����̹� �ε�
		//2. Ŀ�ؼ� ���
			con=dc.getConn();

			StringBuilder login = new StringBuilder();  
			
			login.append("select c_id,c_pass from customer where c_id= ? and c_pass= ? and C_STATUS= 'no' ");
			pstmt=con.prepareStatement(login.toString());
			 
			DataEncrypt de = new DataEncrypt("abcefghijklmn1234");//Ű�� �ȸ¾Ƽ� ���� �����
	
			
			pstmt.setString(1, cuVO.getcID());
			pstmt.setString(2, de.encryption(cuVO.getcPass()));
			
			rs=pstmt.executeQuery(); 
			
			if(rs.next()) {
				flag=true;
			}
		}finally {
		//6. ���� ����
		dc.close(rs, pstmt, con);
		}
		return flag;
	}
 
 public boolean selectid(CuVO cuVO) throws SQLException, NamingException{
	 	boolean id=false;
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		
		DbConnection dc= DbConnection.getInstance();
		try {
		//1. ����̹� �ε�
		//2. Ŀ�ؼ� ���
			con=dc.getConn();

			StringBuilder login = new StringBuilder();  
			
			login.append("select c_id from customer where c_id= ?");
			pstmt=con.prepareStatement(login.toString());
			 
			pstmt.setString(1, cuVO.getcID());
			
			rs=pstmt.executeQuery(); 
			
			if(rs.next()) {
				id=true;
			}
		}finally {
		//6. ���� ����
		dc.close(rs, pstmt, con);
		}
		return id;
	}
 
 public String selectEmail(String email) throws SQLException, NamingException{
	 	String flag="none";
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		
		DbConnection dc= DbConnection.getInstance();
		try {
		//1. ����̹� �ε�
		//2. Ŀ�ؼ� ���
			con=dc.getConn();

			StringBuilder login = new StringBuilder();  
			
			login.append("select c_id from customer where email= ?");
			pstmt=con.prepareStatement(login.toString());
			 
			pstmt.setString(1, email);
			
			rs=pstmt.executeQuery(); 
			
			if(rs.next()) {
				flag=rs.getString("c_id");
			}
		}finally {
		//6. ���� ����
		dc.close(rs, pstmt, con);
		}
		return flag;
	}
 
 public boolean selectPass(String id,String email) throws SQLException, NamingException{
	 	boolean flag=false;
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		
		DbConnection dc= DbConnection.getInstance();
		try {
		//1. ����̹� �ε�
		//2. Ŀ�ؼ� ���
			con=dc.getConn();

			StringBuilder login = new StringBuilder();  
			
			login.append(" select C_PASS from customer where c_id= ? and email= ? ");
			pstmt=con.prepareStatement(login.toString());
			 
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			
			rs=pstmt.executeQuery(); 
			
			if(rs.next()) {
				flag=true;
			}
		}finally {
		//6. ���� ����
		dc.close(rs, pstmt, con);
		}
		return flag;
	}
 
 
 
 public boolean selectNick(CuVO cuVO) throws SQLException, NamingException{
	 	boolean nick=false;
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		
		DbConnection dc= DbConnection.getInstance();
		try {
		//1. ����̹� �ε�
		//2. Ŀ�ؼ� ���
			con=dc.getConn();

			StringBuilder login = new StringBuilder();  
			
			login.append("select NICKNAME from customer where NICKNAME= ?");
			pstmt=con.prepareStatement(login.toString());
			 
			pstmt.setString(1, cuVO.getNickName());
			
			rs=pstmt.executeQuery(); 
			
			if(rs.next()) {
				nick=true;
			}
		}finally {
		//6. ���� ����
		dc.close(rs, pstmt, con);
		}
		return nick;
	}
 
 public void insertMember(CuVO cuVO) throws SQLException, NamingException{
		Connection con =null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;

		DbConnection dc= DbConnection.getInstance();
		try {
			
			con=dc.getConn();
		//4. ������ ������ü ���
			StringBuilder insertUser = new StringBuilder();
			insertUser.append("insert into customer(C_ID, C_PASS, NICKNAME, GENDER, TEL, BIRTH , GU_CODE,EMAIL, PROFILE,IPADDRESS)")
			.append("values(?,?,?,?,?,?,?,?,'C:/Users/user/Desktop/citi_1.png',?)");
			pstmt=con.prepareStatement(insertUser.toString());
			//5. ���ε� ���� �� ����
			pstmt.setString(1, cuVO.getcID());
			pstmt.setString(2, cuVO.getcPass());
			pstmt.setString(3, cuVO.getNickName());
			pstmt.setString(4, cuVO.getGender());
			pstmt.setString(5, cuVO.getTel());
			pstmt.setString(6, cuVO.getBirth());
			pstmt.setInt(7, cuVO.getGuCode());
			pstmt.setString(8, cuVO.getEmail());
			pstmt.setString(9, cuVO.getIpAddress());
		
			pstmt.executeUpdate();
			StringBuilder insertScore = new StringBuilder();
			insertScore.append("insert into C_SCORE ( C_ID ) values( ? ) ");
			
			pstmt2=con.prepareStatement(insertScore.toString());
			pstmt2.setString(1, cuVO.getcID());
			pstmt2.executeUpdate();
			
		}
		finally {
			//7. ���� ����
			dc.close(null, pstmt, con);
		}
		
	}
 public void updatePass(String id,String email,String pass) throws SQLException, NamingException, UnsupportedEncodingException, NoSuchAlgorithmException, GeneralSecurityException{
		Connection con =null;
		PreparedStatement pstmt=null;
		
		DbConnection dc= DbConnection.getInstance();
		try {
		//1. ����̹� �ε�
		//2. Ŀ�ؼ� ���
			con=dc.getConn();

			StringBuilder update = new StringBuilder();  
			
			update.append(" update customer set C_PASS= ? where c_id= ? and email= ? ");
			pstmt=con.prepareStatement(update.toString());
			
			DataEncrypt de = new DataEncrypt("abcefghijklmn1234");//Ű�� �ȸ¾Ƽ� ���� �����
			
			pstmt.setString(1, de.encryption(pass));
			pstmt.setString(2, id);
			pstmt.setString(3, email);
			//��ȯ���� int��
			pstmt.executeUpdate();

		}finally {
		//6. ���� ����
		dc.close(null, pstmt, con);
		}
	}
 

}

