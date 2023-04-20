package web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(urlPatterns = {"/encodingResult.jsp", "/ETS"})
public class EncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodingFilter() {
    	System.out.println("EncodingFilter contructor");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("EncodingFilter destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("사전처리");
		
		request.setCharacterEncoding("UTF-8");

		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("사후처리");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("EncodingFilter init");
	}

}
