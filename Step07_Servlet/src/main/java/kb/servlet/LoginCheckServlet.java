package kb.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet(urlPatterns = { "/login", "/logout" }, loadOnStartup = 1,
initParams = {
		@WebInitParam (name="id", value="park"),
		@WebInitParam (name="pwd", value="0420")
})
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String dbId, dbPwd;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		dbId = config.getInitParameter("id");
		dbPwd = config.getInitParameter("pwd");
		System.out.println(dbId + " " + dbPwd);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("login part");
		
		//전송되는 데이터 받기
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		
		if(dbId.equals(userId)&&dbPwd.equals(userPwd)) {
			//성공시 정보 저장하고 이동 - ok.jsp
			Customer customer = new Customer(userName, 29, "Misa", "1234-1234");
			
			request.setAttribute("cu", customer); //re 유지되는 동안 사용 가능
			//customer 가지고 이동
			request.getRequestDispatcher("loginOK.jsp").forward(request, response);
		} else {
			//실패시 오류 메세지 출력, form으로 이동
			response.sendRedirect("LoginForm.html");
		}
		
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("logout part");
		
	}

	

}
