package kr.co.sist.badasaja.admin.dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.sist.badasaja.admin.dao.DbConnection;
import kr.co.sist.badasaja.vo.NoticeVO;

public class DashDAO {

	/**
	 * DashDAO �⺻ ������
	 */
	public DashDAO() {
	}//DashDAO
	
	
	/**
	 * ���� �ֱٿ� �ۼ��� ��� ����(notice ���̺��� O_MAIN�÷� ��)��<br/>
	 * ��ȸ�Ͽ� String���� ��ȯ�ϴ� �޼���
	 * @return String
	 * @throws SQLException
	 * @throws NamingException
	 */
	public String selectOperNotice() throws SQLException, NamingException {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String notice=null;
		
		try {
			//1.����̹�����
			//2.Ŀ�ؼ� ���
			con=DbConnection.getInstance().getConn();
			//3.������ ������ü ���
			stmt=con.createStatement();	
			//4.������ �̿��ϱ�
			StringBuilder selectNotice=new StringBuilder();
			selectNotice
			.append(" SELECT O_MAIN ")
			.append(" FROM (SELECT O_MAIN FROM NOTICE ORDER BY POSTED_DATE DESC) ")
			.append(" WHERE ROWNUM = 1 ");
			
			rs=stmt.executeQuery(selectNotice.toString());
			
			if(rs.next()) {//�˻��� ���ڵ尡 ����
				//VO�� ���� �Ҵ�
				NoticeVO n =new NoticeVO();
				//Ŀ���� �����ϴ� ���ڵ��� �÷��� ���� �����ͼ�  
				n.setoMain(rs.getString("O_MAIN"));
				notice=n.getoMain();
			}//end-if

		}finally {
			//5.�������
			DbConnection.getInstance().close(rs, stmt, con);
		}//end-finally
		
		return notice;
		
	}//selectOperNotice
	
	
	/**
	 * ��� ���̺��� ��ü ���ڵ� ���� ��ȯ�ϴ� �޼���<br/>
	 * @return int
	 * @throws SQLException
	 * @throws NamingException
	 */
	public int selectBannerCnt() throws SQLException, NamingException {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int cnt = 0;
		
		try {
			//1.����̹�����
			//2.Ŀ�ؼ� ���
			con=DbConnection.getInstance().getConn();
			//3.������ ������ü ���
			stmt=con.createStatement();	
			//4.������ �̿��ϱ�
			String bannerCnt="SELECT count(*) FROM banner";
			
			rs=stmt.executeQuery(bannerCnt);
			
			if(rs.next()) {
				cnt=rs.getInt("count(*)");
			}//end-if
			
		}finally {
			//5.�������
			DbConnection.getInstance().close(rs, stmt, con);
		}//end-finally
		
		return cnt;
		
	}//selectOperNotice
	
	
	/**
	 * ad_forum ���̺��� ��ü ���ڵ� ���� ��ȯ�ϴ� �޼���<br/>
	 * @return int
	 * @throws SQLException
	 * @throws NamingException
	 */
	public int selectForumCnt() throws SQLException, NamingException {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int cnt = 0;
		
		try {
			//1.����̹�����
			//2.Ŀ�ؼ� ���
			con=DbConnection.getInstance().getConn();
			//3.������ ������ü ���
			stmt=con.createStatement();	
			//4.������ �̿��ϱ�
			String forumCnt="SELECT count(*) FROM ad_forum";
			
			rs=stmt.executeQuery(forumCnt);
			
			if(rs.next()) {
				cnt=rs.getInt("count(*)");
			}//end-if
			
		}finally {
			//5.�������
			DbConnection.getInstance().close(rs, stmt, con);
		}//end-finally
		
		return cnt;
		
	}//selectOperNotice
	
	
	/**
	 * �Ű������� fomatData ������ �޾�
	 * ���糯�� ����޿� ������ ȸ�� ���� ��ȯ���ִ� �޼���
	 * @param fomatDate
	 * @return
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	public int selectSignCustomer(String formatDate) throws SQLException, NamingException {
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		int cnt = 0;
		
		try{
		//1 ����̹� �ε�
		//2 Ŀ�ؼ� ���
			con=DbConnection.getInstance().getConn();
		//3 ������ ���� ��ü ���
			StringBuilder selectSignCnt = new StringBuilder();
			selectSignCnt
			.append(" select count(*) ")
			.append(" from customer ")
			.append(" where to_char(sign_date,?) = to_char(sysdate,?)");
		
			
			pstmt = con.prepareStatement(selectSignCnt.toString());
			
		//4 ���ε� ���� �� �Ҵ�
			pstmt.setString(1, formatDate);
			pstmt.setString(2, formatDate);
			
		//5 ������ ���� �� ��� ���
			rs=pstmt.executeQuery();
			if(rs.next()) {//��ȸ�� ���ڵ� ����
				cnt=rs.getInt("count(*)");
			}//end if
			
		}finally{
		//6 �������
			DbConnection.getInstance().close(rs, pstmt, con);
		}
		
		return cnt;
		
	}//selectSignCustomer
	
	
	/**
	 * �Ű������� fomatData ������ �޾�
	 * ���糯�� ����� ����⵵�� ��������� ��ȯ���ִ� �޼���
	 * @param fomatDate
	 * @return
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	public int revenue(String formatDate) throws SQLException, NamingException {
		Connection conForum = null;
		PreparedStatement pstmtForum= null;
		ResultSet rsForum = null;
		
		Connection conBanner = null;
		PreparedStatement pstmtBanner= null;
		ResultSet rsBanner = null;
		
		int forumCnt = 0;
		int bannerCnt = 0;
		int revenue = 0;
		
		try{
			// ����̹� �ε�
			// Ŀ�ؼ� ���
			conForum=DbConnection.getInstance().getConn();
			conBanner=DbConnection.getInstance().getConn();
			// ������ ���� ��ü ���
			StringBuilder selectAdFCnt = new StringBuilder();
			selectAdFCnt
			.append(" select count(*) ")
			.append(" from ad_forum ")
			.append(" where to_char(posted_date,?) = to_char(sysdate,?)");
			
			pstmtForum = conForum.prepareStatement(selectAdFCnt.toString());
			
			
			StringBuilder selectAdBCnt = new StringBuilder();
			selectAdBCnt
			.append(" select count(*) ")
			.append(" from banner ")
			.append(" where to_char(posted_date,?) = to_char(sysdate,?)");
			
			pstmtBanner = conBanner.prepareStatement(selectAdBCnt.toString());
			
			//4 ���ε� ���� �� �Ҵ�
			pstmtForum.setString(1, formatDate);
			pstmtForum.setString(2, formatDate);
			pstmtBanner.setString(1, formatDate);
			pstmtBanner.setString(2, formatDate);
			
			//5 ������ ���� �� ��� ���
			rsForum=pstmtForum.executeQuery();
			rsBanner=pstmtBanner.executeQuery();
			
			if(rsForum.next()) {//��ȸ�� ���ڵ� ����
				forumCnt=rsForum.getInt("count(*)");
			}//end if
			
			if(rsBanner.next()) {//��ȸ�� ���ڵ� ����
				bannerCnt=rsBanner.getInt("count(*)");
			}//end if
			
		}finally{
			//6 �������
			DbConnection.getInstance().close(rsForum, pstmtForum, conForum);
			DbConnection.getInstance().close(rsBanner, pstmtBanner, conBanner);
		}
		
		System.out.println(bannerCnt+","+forumCnt);
		revenue = (bannerCnt*200000)+(forumCnt*130000);
		return revenue;
		
	}//selectSignCustomer
	
	
	
	
//	public static void main(String[] args) {
//		try {
//			System.out.println(new DashDAO().selectOperNotice());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}catch(NamingException ne){
//			ne.printStackTrace();
//		}
//	}
	
}
