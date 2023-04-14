package kb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLifeCycle extends HttpServlet {
	
	public ServletLifeCycle() {
		System.out.println("ServletLifeCycle 생성자");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//browser Hangul encoding + document type
		resp.setContentType("text/html;charset=UTF-8");
		
		System.out.println("ServletLifeCycle doGet");
		
		//브라우저에 출력
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head><title>Servlet Practice</title></head>");
		out.print("<body>");
		out.println("<h1 style='color : red;'> Servlet First 강의</h1>");
		out.print("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ServletLifeCycle doPost");
	}
	
	//doGet doPost 방식 차이없이 사용할때 service 사용
	//요청 방식을 나누고 싶을때는 service 안쓰고 doGet doPost 사용
	/*
	 * @Override protected void service(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * System.out.println("SServletLifeCycle service"); }
	 */

	@Override
	public void destroy() {
		System.out.println("ServletLifeCycle destroy");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("ServletLifeCycle init");
	}

}
