package chapter3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8080/book/chapter3/hello
//にアクセスするとHelloと現在の日時が表示される

//WebServletアノテーションでサーブレットのURLを指定する
@WebServlet(urlPatterns={"/chapter3/hello"})
public class Hello extends HttpServlet { //HttpServletクラスを継承
	//メソッド
	public void doGet ( //オーバーライド
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("Hello Servlet!"); //画面にHelloを表示する
		out.println(new java.util.Date()); //画面に今日の日付を表示する
	}

}