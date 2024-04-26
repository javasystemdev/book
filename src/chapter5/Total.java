package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

@WebServlet(urlPatterns={"/chapter5/total"})
public class Total extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();

		try {
			request.setCharacterEncoding("UTF-8");
			//キーワードpriceの値を取得し、整数型の変数priceに代入
			int price=Integer.parseInt(request.getParameter("price"));
			//キーワードcountの値を取得し、整数型の変数countに代入
			int count=Integer.parseInt(request.getParameter("count"));

			Page.header(out);
			out.println(price+"円×");
			out.println(count+"個＝");
			out.println(price*count+"円"); //price × count を計算
			Page.footer(out);
		} catch (NumberFormatException e) {
			out.println("数値を入力してください。");
		}
	}
}
