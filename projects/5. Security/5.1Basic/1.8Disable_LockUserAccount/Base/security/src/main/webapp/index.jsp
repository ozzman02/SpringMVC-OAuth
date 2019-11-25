<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix= "sec" uri = "http://www.springframework.org/security/tags" %>
<html>
<body>
	<h2>Hello World!</h2>
	<c:url var="logoutUrl" value = "/logout" />
	<form action="${logoutUrl}" method="post">
		<sec:csrfInput/>
		<input type="submit" value="Logout">
	</form>
</body>
</html>
