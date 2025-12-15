
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	
	

    <title>Hello JSP</title>
	<%!
	public int square(int n){
		return n*n;
	}
	%>
</head>
<body>	
	<c:forEach items="{pay}"
  <%
	out.println("<h1>"+square(4)+"</h1>");
	for(int i = 1; i < 10; i++) {
	    out.println("<h1> hello from JSP</h1>");
	}
	%>
	<%=new java.util.Date()
	
 %>
 
 

</body>
</html>


