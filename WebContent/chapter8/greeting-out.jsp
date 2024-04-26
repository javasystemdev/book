<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%-- リクエストの日本語設定 --%>
<% request.setCharacterEncoding("UTF-8"); %>
<p>こんにちは、<%=request.getParameter("user") %>さん！</p>

<%@include file="../footer.html" %>
