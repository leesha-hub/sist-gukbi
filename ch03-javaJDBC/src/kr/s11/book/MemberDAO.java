package kr.s11.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

/*
1.관리자 도서 등록(registerBook)
2.관리자 도서 목록(allBookList)
3.사용자 회원 가입(joinMember)
4.관리자 회원 목록(allMemberList)
5.사용자 도서 대출(loanBook)
    ㄴ 도서번호(bk_num)로 검색해서 re_status의 값이 0이면 대출 가능, 
    1이면 대출 불가능
6.관리자 대출 목록(loanList * admin)
    ㄴ 대출 및 반납 - 모든 데이터 표시
7.사용자 MY대출 목록(loanList * user)
    ㄴ 현재 대출한 목록만 표시
8.사용자 대출 도서 반납(givebackBook)
    ㄴ 대출번호(re_num)과 회원id(me_id)를 함께 조회, 
    re_status가 1인 것은 반납 가능, re_status가 0이면 반납 불가능)
*/
public class MemberDAO {
	// 회원 가입
	public boolean joinMember(String me_id, String me_passwd, String me_name, String me_phone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int count = 0;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "INSERT INTO member (me_id, me_passwd, me_name," + "me_phone, me_regdate) VALUES ("
					+ "?,?,?,?,SYSDATE)";

			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터 바인딩
			pstmt.setString(1, me_id);
			pstmt.setString(2, me_passwd);
			pstmt.setString(3, me_name);
			pstmt.setString(4, me_phone);

			// JDBC 수행 4단계
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
		
		if(count > 0) {
			System.out.println(count + "개의 행을 삽입했습니다.");
			return true;
		} else {
			return false;
		}
	}
	
	// 회원 가입 - 사용자 아이디 중복 체크
	public int checkId(String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT me_id FROM member WHERE me_id=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, me_id);
			//JDBc 수행 4단계
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return count;
	}
	
	// 회원 가입 - 사용자 로그인 체크
	public boolean loginCheck(String me_id,String me_passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT me_id FROM member WHERE me_id=? AND me_passwd=?";
			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터 바인딩
			pstmt.setString(1, me_id);
			pstmt.setString(2, me_passwd);
			// JDBC 수행 4단계
			rs = pstmt.executeQuery();

			if (rs.next()) {
				flag = true;// 로그인 성공
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return flag;
	}
	
	// 회원 가입 - 관리자 체크
	public boolean adminCheck(String me_id) { 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT me_admin FROM member WHERE me_id=?";
			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터 바인딩
			pstmt.setString(1, me_id);
			// JDBC 수행 4단계
			rs = pstmt.executeQuery();

			if (rs.next() && rs.getInt("me_admin") == 1) {
				flag = true;// 관리자 로그인
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return flag;
	}
	
	public void allMemberList() { 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "SELECT * FROM member ORDER BY me_regdate DESC";
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			System.out.println("---------------------");
			//JDBC 수행 4단계 : SQL문을 실행해서 결과행들을 ResultSet에 담음
			rs = pstmt.executeQuery();
			if(rs.next()) {
				// 아이디	이름		전화번호			가입일
				System.out.println("아이디\t이름\t전화번호\t가입일");
				do{
					System.out.print(rs.getString("me_id") + "\t");
					System.out.print(rs.getString("me_name") + "\t");
					System.out.print(rs.getString("me_phone") + "\t");
					System.out.println(rs.getDate("me_regdate"));
				}while(rs.next());
			}else {
				System.out.println("등록된 데이터가 없습니다.");
			}
			System.out.println("---------------------");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}	
}