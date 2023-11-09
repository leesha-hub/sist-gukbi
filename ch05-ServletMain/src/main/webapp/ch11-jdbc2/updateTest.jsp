<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ include file="dbInfo.jspf" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 수정</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<%
	//전송된 데이터에 대한 인코딩 처리
	request.setCharacterEncoding("utf-8");

	//전송된 데이터 반환
	int num = Integer.parseInt(request.getParameter("num"));
	String name = request.getParameter("name");
	int price = Integer.parseInt(request.getParameter("price"));
	int stock = Integer.parseInt(request.getParameter("stock"));
	String origin = request.getParameter("origin");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	try{
		//JDBC 수행1단계 : 드라이버 로드
		Class.forName(driverName);
		//JDBC 수행2단계 : Connection 객체 생성(인증)
		conn = DriverManager.getConnection(jdbcUrl,dbId,dbPass);
	
		//SQL문
		sql = "update product set name=?,price=?,stock=?,origin=? where num=?";
		
		//JDBC 수행3단계 : PreparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setInt(2, price);
		pstmt.setInt(3, stock);
		pstmt.setString(4,origin);
		pstmt.setInt(5, num);
		
		//JDBC 수행4단계 : SQL문 실행
		pstmt.executeUpdate();
%>
		<div class="result-display">
			<div class="align-center">
			상품 정보 수정 완료!<br>
			<input type="button" value="목록보기"
			   onclick="location.href='selectTest.jsp'">
			</div>
		</div>
<%		
	}catch(Exception e){
%>
		<div class="result-display">
			<div class="align-center">
			오류 발생! 상품 정보 수정 실패!<br>
			<input type="button" value="상품수정폼"
			    onclick="location.href='updateTestForm.jsp?num=<%=num%>'">
			</div>
		</div>
<%		
		e.printStackTrace();
	}finally{
		//자원정리
		if(pstmt!=null)try{pstmt.close();}catch(SQLException e){}
		if(conn!=null)try{conn.close();}catch(SQLException e){}
	}
%>
</body>
</html>







