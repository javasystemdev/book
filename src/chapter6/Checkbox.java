package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

@WebServlet(urlPatterns={"/chapter6/checkbox"})
public class Checkbox extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();

		request.setCharacterEncoding("UTF-8");
		//getParameterValues(キーワード)で"配列"genreに代入
		String[] genre=request.getParameterValues("genre");

		Page.header(out);
		//配列genreがnullかどうか調べる
		if (genre!=null) { //nullじゃないとき
			//拡張for文
			//genre配列の中から値をひとつずつ取り出しitemに代入して、ループする
			for (String item : genre) {
				out.println("「"+item+"」");
			}
			out.println("に関するお買い得情報をお送りします。");
		} else {
			out.println("お買い得情報はお送りしません。");
		}
		Page.footer(out);
	}
}
