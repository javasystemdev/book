package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

@WebServlet(urlPatterns={"/chapter5/greeting2"})
public class Greeting2 extends HttpServlet {

	public void doPost ( //オーバーライド
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		//レスポンスの日本語設定
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();

		//リクエストの日本語設定
		request.setCharacterEncoding("UTF-8");
		//userキーワードの値を取得し、文字列変数userに代入
		String user=request.getParameter("user");

		Page.header(out);
		out.println("<p>こんにちは、"+user+"さん！</p>");
		Page.footer(out);
	}
}
