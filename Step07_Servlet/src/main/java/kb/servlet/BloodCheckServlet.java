package kb.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BloodCheckServlet
 */
@WebServlet(urlPatterns = "/bloodCheck", loadOnStartup = 1)
public class BloodCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request방식으로 전송되는 한글 인코딩
		request.setCharacterEncoding("UTF-8"); //filter로 대체
		
		//전송된 데이터 받기
		String name = request.getParameter("name");
		String blood = request.getParameter("blood");
		
		System.out.println(name + " " + blood);
		
//		PrintWriter out = response.getWriter();
		
		//혈액형에 따라 페이지 이동하기
		//1) forward
		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("/" + blood + ".jsp");
		 * rd.forward(request, response);
		 */
		
		//2) redirect
		response.sendRedirect(blood + ".jsp?name="+URLEncoder.encode(name, "UTF-8")+"&blood="+blood);
		//새로운 request와 response를 생성해서 이동
		
	}

}
