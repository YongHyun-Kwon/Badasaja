package kr.co.sist.badasaja.user.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import kr.co.sist.badasaja.dbConnection.DbConnection;
import kr.co.sist.badasaja.vo.CuVO;




public class MemberDAO {
	
 public boolean selectMember(CuVO cuVO) throws SQLException, NamingException{
	 	boolean flag= false;
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		CuVO loginVo =null; 
		DbConnection dc= DbConnection.getInstance();
		try {
		//1. 드라이버 로딩
		//2. 커넥션 얻기
			con=dc.getConn();

			StringBuilder login = new StringBuilder();  
			
			login.append("select c_id,c_pass from customer where c_id= ? and c_pass= ?");
			pstmt=con.prepareStatement(login.toString());
			 
			pstmt.setString(1, cuVO.getcID());
			pstmt.setString(2, cuVO.getcPass());
			
			rs=pstmt.executeQuery(); 
			
			if(rs.next()) {
				flag=true;
			}
		}finally {
		//6. 연결 끊기
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
		//1. 드라이버 로딩
		//2. 커넥션 얻기
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
		//6. 연결 끊기
		dc.close(rs, pstmt, con);
		}
		return id;
	}
 
 public boolean selectNick(CuVO cuVO) throws SQLException, NamingException{
	 	boolean nick=false;
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		
		DbConnection dc= DbConnection.getInstance();
		try {
		//1. 드라이버 로딩
		//2. 커넥션 얻기
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
		//6. 연결 끊기
		dc.close(rs, pstmt, con);
		}
		return nick;
	}
 
 public void insertMember(CuVO cuVO) throws SQLException, NamingException{
		Connection con =null;
		PreparedStatement pstmt=null;

		DbConnection dc= DbConnection.getInstance();
		try {
			
			con=dc.getConn();
		//4. 쿼리문 생성객체 얻기
			StringBuilder insertUser = new StringBuilder();
			insertUser.append("insert into customer(C_ID, C_PASS, NICKNAME, GENDER, TEL, BIRTH , GU_CODE,EMAIL, PROFILE,IPADDRESS)")
			.append("values(?,?,?,?,?,?,?,?,'C:\\Users\\user\\Desktop\\citi_1.png',?)");
			pstmt=con.prepareStatement(insertUser.toString());
			//5. 바인드 변수 값 설정
			pstmt.setString(1, cuVO.getcID());
			pstmt.setString(2, cuVO.getcPass());
			pstmt.setString(3, cuVO.getNickName());
			pstmt.setString(4, cuVO.getGender());
			pstmt.setString(5, cuVO.getTel());
			pstmt.setString(6, cuVO.getBirth());
			pstmt.setInt(7, cuVO.getGuCode());
			pstmt.setString(8, cuVO.getEmail());
			pstmt.setString(9, cuVO.getIpAddress());
			//6. 쿼리 수행 후 결과 얻기
			pstmt.executeUpdate();
		}
		finally {
			//7. 연결 끊기
			dc.close(null, pstmt, con);
		}
		
	}
}

