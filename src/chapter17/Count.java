package chapter17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//セッションを使用するクラスをインポート
import javax.servlet.http.HttpSession;

import tool.Page;

@WebServlet(urlPatterns={"/chapter17/count"})
public class Count extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		//HttpSessionオブジェクトを取得する
		HttpSession session=request.getSession();

		//sessionオブジェクトのgetAttributeメソッドから
		//キーワードcountの値を取得する（nullが代入される）
		Integer count=(Integer)session.getAttribute("count");
		//もしcountがnullなら0を代入する
		if (count==null) count=0;
		count++; //インクリメント
		//セッションの中にcountを保存する
		session.setAttribute("count", count);

		//countを画面に表示する
		out.println("<p>"+count+"</p>");
		//セッションＩＤを画面に表示する
		out.println("<p>"+session.getId()+"</p>");
		Page.footer(out);
	}
}
