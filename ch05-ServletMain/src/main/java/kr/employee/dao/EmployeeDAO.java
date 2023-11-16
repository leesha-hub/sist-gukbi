package kr.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.employee.vo.EmployeeVO;
import kr.util.DBUtil;

public class EmployeeDAO {
	//싱글턴 패턴
	private static EmployeeDAO instance = new EmployeeDAO();
	
	public static EmployeeDAO getInstance() {
		return instance;
	}
	
	private EmployeeDAO() {}
	
	public void insertEmployee(EmployeeVO vo)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try{
			//커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();

			//SQL문
			sql = "INSERT INTO semployee (snum,id,name,passwd,salary"
					+ ",job) VALUES "
					+ "(semployee_seq.nextval,?,?,?,?,?)";

			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPasswd());
			pstmt.setInt(4, vo.getSalary());
			pstmt.setString(5, vo.getJob());

			//SQL문 반영
			pstmt.executeUpdate();

		}catch(Exception e){
			throw new Exception(e);
		}finally{
			DBUtil.executeClose(null, pstmt, conn);
		}

	}
	//사원상세정보
	public EmployeeVO getEmployee(int snum)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVO vo = null;
		String sql = null;

		try{
			//커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();

			//SQL문
			sql = "SELECT * FROM semployee WHERE snum=?";

			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, snum);

			//SQL문 반영하고 결과행을 ResultSet에 담음
			rs = pstmt.executeQuery();

			if(rs.next()){
				vo = new EmployeeVO(); //자바빈 객체 생성
				vo.setSnum(rs.getInt("snum"));
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setSalary(rs.getInt("salary"));
				vo.setJob(rs.getString("job"));
				vo.setReg_date(rs.getDate("reg_date"));
			}
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return vo;
	}
	//아이디 중복 체크, 로그인 체크
	public EmployeeVO checkEmployee(String id)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVO vo = null;
		String sql = null;

		try{
			//커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();

			//SQL문
			sql = "SELECT * FROM semployee WHERE id=?";

			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			//SQL문 반영하고 결과행을 ResultSet에 담음
			rs = pstmt.executeQuery();

			if(rs.next()){
				vo = new EmployeeVO(); //자바빈 객체 생성
				vo.setId(rs.getString("id"));
				vo.setSnum(rs.getInt("snum"));
				vo.setPasswd(rs.getString("passwd"));
			}
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return vo;
	}
	//사원정보수정
	public void updateEmployee(EmployeeVO vo)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try{
			//커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();
			//SQL문 
			sql = "UPDATE semployee SET name=?,passwd=?,"
					+ "salary=?,job=? "
					+ "WHERE snum=?";
			//PreparedStatement 객체를 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setInt(3, vo.getSalary());
			pstmt.setString(4, vo.getJob());
			pstmt.setInt(5, vo.getSnum());
			//SQL문 반영
			pstmt.executeUpdate();

		}catch(Exception e){
			throw new Exception(e);
		}finally{
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//사원정보삭제
	public void deleteEmployee(int snum)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try{
			//커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();
			//SQL문
			sql = "DELETE FROM semployee WHERE snum=?";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, snum);
			//SQL문 반영
			pstmt.executeUpdate();

		}catch(Exception e){
			throw new Exception(e);
		}finally{
			DBUtil.executeClose(null, pstmt, conn);
		}

	}
	
}




