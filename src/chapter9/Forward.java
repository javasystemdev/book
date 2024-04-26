package chapter9;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter9/forward"})
public class Forward extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		//getRequestDispatcher("jspファイル名").forword(request,response)
		//でjspにフォワードする
		request.getRequestDispatcher("forward.jsp").forward(request, response);
	}
}
