package ex0328.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Servlet implementation class LifecycleServlet
 */
public class LifecycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LifecycleServlet() {
       System.out.println("LifecycleServet의 생성자 호출됨...");
    }

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LivecycleServlet init 호출됨...");
	}


	public void destroy() {
		System.out.println("LivecycleServlet destroy 호출됨...");
	}

	/**
	 * 사용자요청이 들어오면 service 호출된다. 
	 * 원래 service의 기능은 사용자 요청방식에 따라 doGet or doPost를 호출한다.
	 * 재정의(오버라이딩) 하면 원래 메소드가 실행되지 않으므로 주석처리해보기.
	 */
	/*
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * System.out.println("LivecycleServlet service 호출됨..."); }
	 */

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("LivecycleServlet doGet 호출됨...");
		//브라우저에 출력하고 싶다면?
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><tilte>Servlet실습중</title></head>");
		out.print("<body>");
		out.print("<h1 style = 'color : red'>Servlet 신기해요~</h1>");
		
		out.println("<script>");
		out.println("alert('script도 실행 가능');");
		out.println("</script>");
		
		out.print("</body>");
		out.print("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LivecycleServlet doPost 호출됨...");
	}

}
