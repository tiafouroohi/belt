<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1><c:out value="${task.name }"></c:out></h1>

<h2>Assigned To:<c:out value="${task.user.name }"></c:out></h2>
<h2>Created By:<c:out value="${task.user.name }"></c:out></h2>
<h2>Priority Level:<c:out value="${task.priority.name }"></c:out></h2>


<a href="/edit/task/${task.id }">Edit Task</a>
<a href="/dashboard">Back to Dash</a>



</body>
</html>