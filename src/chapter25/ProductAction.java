package chapter25;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import dao.ProductDAO;
import tool.Action;

public class ProductAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		//セッション情報を取得する
		HttpSession session=request.getSession();

		String keyword=request.getParameter("keyword");
		if (keyword==null) keyword="";

		ProductDAO dao=new ProductDAO();
		List<Product> list=dao.search(keyword);

		session.setAttribute("list", list);

		return "product.jsp";
	}
}
