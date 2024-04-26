<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%-- コレクションをインポート --%>
<%@page import="java.util.List, java.util.ArrayList" %>
<%@page import="java.util.Map, java.util.HashMap" %>

<%
int[] array={0, 1, 2}; //整数型の配列を初期化
request.setAttribute("array", array);
List<String> list=new ArrayList<>(); //ArrayListクラスを実体化
list.add("zero"); //add()メソッドでArrayListにデータを追加する
list.add("one");
list.add("two");
request.setAttribute("list", list);
Map<String, String> map=new HashMap<>(); //HashMapクラスを実体化
map.put("zero", "零"); //push()メソッドでArrayListにデータを追加する
map.put("one", "壱");
map.put("two", "弐");
request.setAttribute("map", map);
%>

${array[1]}<br>
${list[2]}<br>
${map["one"]}<br>
${map.two}

<%@include file="../footer.html" %>
