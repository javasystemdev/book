package chapter24;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class LogoutAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		//セッション情報を取得する
		HttpSession session=request.getSession();
		//セッション情報があるかどうかを確認する
		if (session.getAttribute("customer")!=null) {
			//セッション情報のcustomerを削除する
			session.removeAttribute("customer");
			return "logout-out.jsp";
		}

		return "logout-error.jsp";
	}
}
