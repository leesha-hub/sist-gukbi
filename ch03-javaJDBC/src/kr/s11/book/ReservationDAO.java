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
public class ReservationDAO {
	public void loanList(boolean admin_flag, String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();

			if (admin_flag) {
				// SQL문 작성
				sql = "SELECT reservation.*, book.bk_name FROM reservation " + "LEFT JOIN book "
						+ "ON reservation.bk_num = book.bk_num " + "WHERE re_status = 1 ORDER BY re_num DESC";
			} else {
				// SQL문 작성
				sql = "SELECT reservation.*, book.bk_name FROM reservation " + "LEFT JOIN book "
						+ "ON reservation.bk_num = book.bk_num " + "WHERE re_status = 1 AND me_id = '" + me_id + "' "
						+ "ORDER BY re_num DESC";
			}

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			System.out.println("---------------------");
			// JDBC 수행 4단계 : SQL문을 실행해서 결과행들을 ResultSet에 담음
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 번호 대출여부 대출자id 대출도서명 대출일 반납일
				System.out.println("예약번호\t도서번호\t대출여부\t대출자id\t대출도서명\t대출일\t반납일");
				do {
					System.out.print(rs.getInt("re_num") + "\t");
					System.out.print(rs.getInt("bk_num") + "\t");
					if (rs.getInt("re_status") == 1) {
						System.out.print("대출중" + "\t");
					} else {
						System.out.print("대출가능" + "\t");
					}
					System.out.print(rs.getString("me_id") + "\t");
					System.out.print(rs.getString("bk_name") + "\t");
					System.out.print(rs.getDate("re_regdate") + "\t");
					System.out.println(rs.getDate("re_modifydate"));
				} while (rs.next());
			} else {
				System.out.println("등록된 데이터가 없습니다.");
			}
			System.out.println("---------------------");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

	public int checkLoan(int bk_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;

		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT re_num FROM reservation WHERE bk_num=? AND re_status=1";
			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터 바인딩
			pstmt.setInt(1, bk_num);
			// JDBc 수행 4단계
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return count;
	}

	public boolean loanBook(String me_id, int bk_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int count = 0;

		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "INSERT INTO reservation (re_num, re_status, bk_num, me_id, re_regdate, re_modifydate) VALUES "
					+ "(reservation_seq.nextval,1,?,?,SYSDATE,null)";

			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터 바인딩
			pstmt.setInt(1, bk_num);
			pstmt.setString(2, me_id);

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

	public void givebackBook(int bk_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "UPDATE reservation SET re_status=0, re_modifydate=SYSDATE WHERE bk_num=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터 바인딩
			pstmt.setInt(1, bk_num);

			// JDBC 수행 4단계 : SQL문 실행
			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 행을 수정했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}