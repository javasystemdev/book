package chapter6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

@WebServlet(urlPatterns={"/chapter6/control"})
public class Control extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();

		Page.header(out);

		request.setCharacterEncoding("UTF-8");

		//getParamerName()でパラメータ名の一覧を取得し、コレクションに代入
		List<String> names=Collections.list(request.getParameterNames());
		//拡張for文（外側）
		for (String name : names) {
			//getParameterValues(name)でそれぞれのパラメータ値を取得
			String[] values=request.getParameterValues(name);
			//拡張for文（内側）
			for (String value : values) {
				out.println("<p>"+name+"="+value+"</p>");
			}
		}
		Page.footer(out);
	}
}
