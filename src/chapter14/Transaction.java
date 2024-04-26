package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

@WebServlet(urlPatterns={"/chapter14/transaction"})
public class Transaction extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {//下4行はおまじない
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/book");
			Connection con=ds.getConnection();

			//リクエストパラメータを受け取る
			String name=request.getParameter("name");
			int price=Integer.parseInt(request.getParameter("price"));
			//自動コミットをオフ
			con.setAutoCommit(false);

			PreparedStatement st=con.prepareStatement(
				"insert into product values(null, ?, ?)");
			st.setString(1, name);
			st.setInt(2, price);
			st.executeUpdate();

			st=con.prepareStatement(
				"select * from product where name=?");
			st.setString(1, name);
			ResultSet rs=st.executeQuery();
			int line=0;
			while (rs.next()) {
				line++; //lineを1増加する
			}

			if (line==1) { //正しく一行分のデータを追加できたとき
				con.commit(); //ここで実際にDBに反映させる
				out.println("商品を登録しました。");
			} else {//正しく一行分のデータを追加できなかったとき
				con.rollback(); //DBをロールバックする
				out.println("商品は既に登録されています。");
			}
			//自動コミットをオンにする
			con.setAutoCommit(true);

			//DB接続を切るおまじない
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
