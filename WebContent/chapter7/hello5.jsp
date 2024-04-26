<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%-- import 名前空間.クラス名 --%>
<%@page import="java.util.Date" %>

<p>Hello!</p>
<p>こんにちは！</p>

<%-- DateクラスをインポートしたことでDateクラスを短く記述できる --%>
<p><%=new Date() %></p>

<%@include file="../footer.html" %>
