<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%-- bean.Productをインポートする --%>
<%@page import="bean.Product" %>

<%-- 渡されたデータを受け取るときの記述 --%>
<% Product p=(Product)request.getAttribute("product"); %>
<%=p.getId() %>：<%=p.getName() %>：<%=p.getPrice() %><br>

<%@include file="../footer.html" %>
