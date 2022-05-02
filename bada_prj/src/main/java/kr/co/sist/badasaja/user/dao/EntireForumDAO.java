package kr.co.sist.badasaja.user.dao;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.naming.NamingException;

import kr.co.sist.badasaja.dbConnection.DbConnection;
import kr.co.sist.badasaja.vo.BannerVO;
import kr.co.sist.badasaja.vo.CuVO;
import kr.co.sist.badasaja.vo.EntireForumVO;
import kr.co.sist.badasaja.vo.HashTagVO;
import kr.co.sist.badasaja.vo.NoticeVO;
import kr.co.sist.badasaja.vo.ProductVO;
import kr.co.sist.badasaja.vo.WishListVO;
import kr.co.sist.util.cipher.DataDecrypt;


/**
 * ������ȯ �Խ��� ��ȸ
 */
public class EntireForumDAO {
	
	/**
	 * ȸ���� ���̵� �޾� �ش� ȸ���� ���� ��ȯ
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws NamingException
	 */
	public String selectCLocal(String id) throws SQLException, NamingException{
		String local = null;
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		
		DbConnection dc= DbConnection.getInstance();
		try {
		//1. ����̹� �ε�
		//2. Ŀ�ؼ� ���
		con=dc.getConn();

		StringBuilder selectlocal = new StringBuilder();  
			
		selectlocal.append("select GU_CODE from CUSTOMER where C_ID= ?");
		pstmt=con.prepareStatement(selectlocal.toString());
		pstmt.setString(1, id);
			
		rs=pstmt.executeQuery(); 
		if(rs.next()) {
			local = rs.getString("gu_code");	
			}
		}finally {
		//6. ���� ����
		dc.close(rs, pstmt, con);
		}
		return local;
	}//password �κ�
	
	/**
	 * ȸ�� ���̵�� ��ǰī�װ� �ڵ带 �޾� 
	 * ȸ�� ������ ��ǰī�װ��� �ش��ϴ� �Խñ� ��ȯ
	 * @param cId
	 * @return
	 * @throws SQLException
	 * @throws NamingException
	 * @throws GeneralSecurityException 
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 */
	public List<EntireForumVO> selectEntireForum(String cId, String product) throws SQLException, NamingException, UnsupportedEncodingException, NoSuchAlgorithmException, GeneralSecurityException{
		String local = selectCLocal(cId);
		
		List<EntireForumVO> eVOList = new ArrayList<EntireForumVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;

		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		
		DbConnection dc= DbConnection.getInstance();
		
		try{
			con = dc.getConn();
			
			
			StringBuilder entireQuery = new StringBuilder();
			entireQuery.append(" select cf_num, cf_topic, main_img ")
					.append(" from forum, product ")
					.append(" where forum.p_code = product.p_code ")
					.append(" and gu_code= ? ")
					.append(" and product = ? ")
					.append(" order by write_date desc ");
			// 1, 2, 3, 4, ... 
			pstmt=con.prepareStatement(entireQuery.toString());
			pstmt.setString(1, local);
			pstmt.setString(2, product);
			rs = pstmt.executeQuery();
			//System.out.println(local+"/"+product);
			
			
			StringBuilder hashQuery = new StringBuilder();
			hashQuery.append("SELECT C.CF_NUM, H.HASH FROM C_FORUM C, HASHTAG H WHERE C.CF_NUM = H.CF_NUM AND H.CF_NUM = ? ");

			while(rs.next()) {
				
				EntireForumVO efVO = new EntireForumVO();
				List<HashTagVO> hashList = new ArrayList<HashTagVO>();
				
				efVO.setTitle(rs.getString("cf_topic"));
				efVO.setCfNum(rs.getString("cf_num"));
				efVO.setImg(rs.getString("main_img"));
				
				pstmt2=con.prepareStatement(hashQuery.toString());
				pstmt2.setString(1, efVO.getCfNum());
				rs2 = pstmt2.executeQuery();
				
				while(rs2.next()) {
					HashTagVO hsVO = new HashTagVO();
					hsVO.setCfNum(rs2.getString("cf_num"));
					hsVO.setHash(rs2.getString("hash"));
					hashList.add(hsVO);
				}
				
				efVO.setList(hashList);
				
				StringBuilder hashQuery2 = new StringBuilder();
				hashQuery2.append("SELECT CF_NUM FROM WISH_LIST WHERE CF_NUM = ? AND C_ID = ?");
				pstmt3 = con.prepareStatement(hashQuery2.toString());
				pstmt3.setString(1, efVO.getCfNum());
				pstmt3.setString(2, cId);
				rs3 = pstmt3.executeQuery();
				if(rs3.next()) {
					efVO.setIsWish(true);
				}
				else {
					efVO.setIsWish(false);
				}
				eVOList.add(efVO);
			}
			
		}finally {
			dc.close(rs, pstmt, con);
			dc.close(rs2, pstmt2, con);
			dc.close(rs3, pstmt3, con);

		}//end finally
		return eVOList ;
		
	}//selectEntireForum
	
	/**
	 * ���� �߰��ϱ� 
	 */
	public void insertWishList(WishListVO wlVO) throws SQLException, NamingException {
		System.out.println(wlVO.getCfNum());
		System.out.println(wlVO.getcID());
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		
		DbConnection dc= DbConnection.getInstance();
		
		try {
			con =dc.getConn();
			
		String WishQuery = "INSERT INTO WISH_LIST VALUES(?,?,SYSDATE)";
		pstmt=con.prepareStatement(WishQuery);
		
		pstmt.setString(1,wlVO.getCfNum());
		pstmt.setString(2,wlVO.getcID());
		
		rs=pstmt.executeQuery();
		}finally {
			dc.close(rs, pstmt, con);
		}
		
	}//insertWishList
	
	/**
	 * ���� �����ϱ�
	 */
	
	public void deleteWishList(WishListVO wlVO) throws SQLException, NamingException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		
		DbConnection dc= DbConnection.getInstance();
		
		try {
			con =dc.getConn();
		
		String WishQuery = "DELETE FROM WISH_LIST WHERE CF_NUM = ? AND C_ID = ?";
		pstmt=con.prepareStatement(WishQuery);
		
		pstmt.setString(1,wlVO.getCfNum());
		pstmt.setString(2,wlVO.getcID());
		
		rs=pstmt.executeQuery();
		}finally {
			dc.close(rs, pstmt, con);
		}
		
	}//delete
	
	
	/**
	 * ��ǰ ���̺� ���� ����Ʈ�� ��ȯ
	 * @return
	 * @throws SQLException
	 * @throws NamingException
	 */
	public List<ProductVO> selectProductList() throws SQLException, NamingException {
		List<ProductVO> list = new ArrayList<ProductVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DbConnection dc = DbConnection.getInstance();

		try {
			con = dc.getConn();

			pstmt = con.prepareStatement("select p_code, product from product");

			rs = pstmt.executeQuery();
			
			ProductVO pVO = null;
			
			while(rs.next()) {
				pVO = new ProductVO(rs.getString("p_code"), rs.getString("product"));
				
				list.add(pVO);
			}

		} finally {
			dc.close(rs, pstmt, con);
		}
		return list;
	}
	
	/**
	 * ��ǰ�� ������ �ش��ϴ� ����� ���ڸ� ��ȯ
	 * @return
	 * @throws SQLException
	 * @throws NamingException
	 */
	public int selectBannerCnt(String cId, String product) throws SQLException, NamingException {
		String guCode = selectCLocal(cId);
		int bCnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DbConnection dc = DbConnection.getInstance();

		try {
			con = dc.getConn();
			
			StringBuilder bannerCnt = new StringBuilder();
			bannerCnt
			.append(" select count(*) cnt ")
			.append(" from banner b, advertiser a, product p ")
			.append(" where b.a_id=a.a_id ")
			.append(" and b.p_code = p.p_code ")
			.append(" and b.expiry_date-b.posted_date > 0 ")
			.append(" and product = ? ")
			.append(" and gu_code= ? ");
			
			pstmt = con.prepareStatement(bannerCnt.toString());
			
		//4 ���ε� ���� �� �Ҵ�
			pstmt.setString(1, product );
			pstmt.setString(2, guCode );
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bCnt = rs.getInt("cnt");
			}//end-if
			

		} finally {
			dc.close(rs, pstmt, con);
		}
		return bCnt;
	}//selectBannerCnt
	
	/**
	 * �Ű������� fomatData ������ �޾�
	 * ���糯�� ����޿� ������ ȸ�� ���� ��ȯ���ִ� �޼���
	 * @param fomatDate
	 * @return
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	public BannerVO selectBanner(String cId, String product) throws SQLException, NamingException {
		String guCode = selectCLocal(cId);
		BannerVO bVO = new BannerVO();
		int bCnt = selectBannerCnt(cId, product);
		if(bCnt==0) {
			bVO.setBFlag(false);
			return bVO;
		}//end if
		
		
		int randomBanner = new Random().nextInt(bCnt) + 1; 
		
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try{
		//1 ����̹� �ε�
		//2 Ŀ�ؼ� ���
			con=DbConnection.getInstance().getConn();
		//3 ������ ���� ��ü ���
			StringBuilder selectSignCnt = new StringBuilder();
			selectSignCnt
			.append(" select url, img, rnum from( ")
			.append(" select b.a_url url, b.img img, ROW_NUMBER() OVER( ORDER BY b.a_url ) rnum ")
			.append(" from banner b, advertiser a, product p ")
			.append(" where b.a_id=a.a_id ")
			.append(" and b.p_code=p.p_code ")
			.append(" and b.expiry_date-b.posted_date > 0 ")
			.append(" and product = ? ")
			.append(" and gu_code= ? ) ")
			.append(" where rnum = ? ");
			
			pstmt = con.prepareStatement(selectSignCnt.toString());
			
		//4 ���ε� ���� �� �Ҵ�
			pstmt.setString(1, product );
			pstmt.setString(2, guCode );
			pstmt.setInt(3, randomBanner );
			
		//5 ������ ���� �� ��� ���
			rs=pstmt.executeQuery();
			if(rs.next()) {//��ȸ�� ���ڵ� ����
				bVO.setaURL(rs.getString("url"));
				bVO.setImg(rs.getString("img"));
				bVO.setBFlag(true);
			}//end if
			
			//System.out.println(rs.getString("url")+"/"+rs.getString("img"));
			
		}finally{
		//6 �������
			DbConnection.getInstance().close(rs, pstmt, con);
		}
		
		return bVO;
		
	}//selectSignCustomer
	
	


}//class
