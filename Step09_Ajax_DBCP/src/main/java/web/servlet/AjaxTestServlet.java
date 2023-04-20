package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import web.dao.MemberDAO;
import web.dao.MemberDAOImpl;
import web.dto.Member;

/**
 * Servlet implementation class AjaxTestServlet
 */
@WebServlet(urlPatterns = "/ajaxTest", loadOnStartup = 1)
public class AjaxTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		
		if("text".equals(key)) {
			text(request, response);
		} else if (key.equals("json")) {
			json(request, response);
		} else if (key.equals("dto")) {
			dto(request, response);
		} else if (key.equals("list")) {
			list(request, response);
		} else if (key.equals("map")) {
			map(request, response);
		} else if (key.equals("textJson")) {
			textJson(request, response);
		}
		
	}
	
	public void text(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		out.print("Welcome " + name);
	}
	
	public void json(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서비스 호출 >> dao 호출 >> 그 결과 받아서 ajax로 통신
		List<String> menu = Arrays.asList("ewr", "qwe", "zcx", "cxz", "asd", "dsa", "sad");
		
		//리스트 형태를 js가 알 수 있는 json 형태로 변환 >> 전용 라이브러리
		Gson gson = new Gson();
		String jsonArr = gson.toJson(menu);
		System.out.println(jsonArr + " jsonArr");
		
		PrintWriter out = response.getWriter();
		out.print(jsonArr);
	}

	public void dto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = new Member("ewr2", "park", 30, "Seoul");
		
		Gson gson = new Gson();
		String jsonArr = gson.toJson(member);
		System.out.println(jsonArr + " jsonArr");
		
		PrintWriter out = response.getWriter();
		out.print(jsonArr);
	}
	
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * List<Member> list = new ArrayList<>(); list.add(new Member("ewr2", "park",
		 * 30, "Seoul")); list.add(new Member("ewr3", "park2", 31, "a")); list.add(new
		 * Member("ewr4", "park3", 32, "b")); list.add(new Member("ewr5", "park4", 34,
		 * "c")); list.add(new Member("ewr6", "park5", 35, "d"));
		 */
		MemberDAO dao = new MemberDAOImpl();
		List<Member> list = dao.selectAll();
			
			//list > json
			Gson gson = new Gson();
			String jsonArr = gson.toJson(list);
			System.out.println(jsonArr);
			
			PrintWriter out = response.getWriter();
			out.print(jsonArr);

	}
	
	public void map(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> map = new HashMap<>();
		map.put("message", "ajax no jam");
		map.put("pageNo", 10);
		map.put("dto", new Member("ewr6", "park5", 35, "d"));
		
		List<Member> list = new ArrayList<>();
		list.add(new Member("ewr2", "park", 30, "Seoul"));
		list.add(new Member("ewr3", "park2", 31, "a"));
		list.add(new Member("ewr4", "park3", 32, "b"));
		list.add(new Member("ewr5", "park4", 34, "c"));
		list.add(new Member("ewr6", "park5", 35, "d"));
		map.put("memberList", list);
		
		Gson gson = new Gson();
		String jsonArr = gson.toJson(map);
		System.out.println(jsonArr);
		
		PrintWriter out = response.getWriter();
		out.print(jsonArr);
	}
	
	public void textJson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String addr = request.getParameter("addr");
		
		System.out.println(name + " " + age + " " + addr);
		
		JsonObject obj = new JsonObject();
		if(name.equals("park")) {
			obj.addProperty("info", "success");
		} else {
			obj.addProperty("info", "fail");
		}
		
		Gson gson = new Gson();
		String jsonArr = gson.toJson(obj);
		System.out.println(jsonArr);
		
		PrintWriter out = response.getWriter();
		out.print(jsonArr);
	}
	

}
