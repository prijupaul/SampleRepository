<%@ page language="java" contentType="text/html; charset=windows-31j"
	pageEncoding="windows-31j"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
<title>Insert title here</title>
</head>
<body>
	<%
		if (request.getSession(false) != null) {
			out.println("Session ID = " + request.getSession(false).getId());
			out.println("<br/>");
			out.println("name = " + request.getSession(false).getAttribute("name"));
		} else {
			out.write("No Session.");
		}
	%>
</body>
</html>