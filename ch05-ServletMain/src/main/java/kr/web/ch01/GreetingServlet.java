package kr.web.ch01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String num1 = request.getParameter("name");

		// HTML 출력을 위한 출력 스트림을 생성
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head><title>이름</title></head>");
		out.println("<body>");
		out.println("------------<br>");
		out.println(num1);
		out.println("</body>");
		out.println("</html>");
	}
}
