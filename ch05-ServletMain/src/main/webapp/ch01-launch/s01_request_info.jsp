<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
클라이언트IP = <%= request.getParameterMap() %>
클라이언트IP = <%= request.getLocalAddr() %>
<% Enumeration params = request.getParameterNames();
out.println("----------------------------");
while (params.hasMoreElements()){
	out.println("???");
    String name = (String)params.nextElement();
    out.println(name + " : " +request.getParameter(name));
}
out.println("----------------------------");
%>
</body>
</html>