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
public class BookDAO {
	// 글쓰기
	public boolean registerBook(String bk_name, String bk_category) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int count = 0;

		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
	
			// SQL문 작성
			sql = "INSERT INTO book (bk_num, bk_name, bk_category, bk_regdate) VALUES "
					+ "(book_seq.nextval,?,?,SYSDATE)";
	
			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터 바인딩
			pstmt.setString(1, bk_name);
			pstmt.setString(2, bk_category);
	
			// JDBC 수행 4단계
			count = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.executeClose(null, pstmt, conn);
			}
	
			if (count > 0) {
				System.out.println(count + "건의 도서 정보를 등록했습니다.");
				return true;
			} else {
				return false;
			}
	}
	

	public void allBookList() { 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "SELECT book.*, reservation.re_status FROM book "
					+ "LEFT JOIN reservation "
					+ "on book.bk_num = reservation.bk_num";
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			System.out.println("---------------------");
			//JDBC 수행 4단계 : SQL문을 실행해서 결과행들을 ResultSet에 담음
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//번호	카테고리	도서명	대출여부	등록일
				System.out.println("번호\t카테고리\t도서명\t대출여부\t등록일");
				do{
					System.out.print(rs.getInt("bk_num") + "\t");
					System.out.print(rs.getString("bk_category") + "\t");
					System.out.print(rs.getString("bk_name") + "\t");
					if(rs.getInt("re_status") == 1) { 
						System.out.print("대출중" + "\t");
					} else {
						System.out.print("대출가능" + "\t");	
					}
					System.out.println(rs.getDate("bk_regdate"));
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
