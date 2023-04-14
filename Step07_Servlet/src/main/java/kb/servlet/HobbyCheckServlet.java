package kb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HobbyCheckServlet extends HttpServlet {
	public HobbyCheckServlet() {
		System.out.println("HobbyCheckServlet constructor");
	}
	
	/*
	 * @Override protected void doGet(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * System.out.println("doGet calllllllllllll");
	 * 
	 * }
	 * 
	 * @Override protected void doPost(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * System.out.println("doPost calllllllllllll"); }
	 */
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("service calllllllllllll");
		resp.setContentType("text/html;charset=UTF-8");
		// >>> Get 방식만 인코딩 변환됨
		
		//post방식으로 전송되는 한글 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		//전송된 데이터 받기
		String name = req.getParameter("name");
		String age = req.getParameter("age");
//		String hobby = req.getParameter("hobby");
		
		//하나의 이름으로 값이 여러개 전송될 때
		String[] hobby = req.getParameterValues("hobby");
		
		//브라우저로 출력
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head><title>Servlet Practice</title></head>");
		out.println("<body>");
		
		out.println("<h3>이름 : " + name + "</h3>");
		out.println("<h3>나이 : " + age + "</h3>");
//		out.println("<h3>취미 : " + hobby + "</h3>");
		out.println("<h3>취미 : ");
		for(String h:hobby) {
			out.println(h + ", ");
		}
		out.println("</h3>");
		out.println("</body>");
		out.print("</html>");
	}
}
