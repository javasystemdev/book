package chapter18;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//Cookieクラスを使用するためのインポート
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter18/add"})
public class Add extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		String name="name"; //キーワード
		String value="value"; //値
		//Cookieクラスを実体化する
		Cookie cookie=new Cookie(name, value);
		//クッキーの生存期間を秒単位で指定する
		cookie.setMaxAge(60*60*24);
		//レスポンスにクッキーを含める
		response.addCookie(cookie);
	}
}
