<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tasks</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<div class="w3-bar w3-top w1 w3-large">
  <button class=" w3-right"><a href="/logout" > Logout</a></button>
</div>
<h1>  Welcome, <c:out value="${user.name}"/></h1>

<label style="margin-right:20px;"><a href="/tasks/Asc" > Priority High-Low</a>  </label><label> <a href="/tasks/Dsc" > Priority Low-High</a></label>



<div class="container">
<div class="table-responsive">
    <div class=class="w3-container">
    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
<th>Task</th>
<th>Creator</th>
<th>Assignee</th>
<th>Priority</th>


 <c:forEach items="${tasks}" var="task">
     <tr>
     <td> <a href="/tasks/${task.id}"><c:out value="${task.title}"/></a></td>
     <td><c:out value="${task.creator}"/></td>
     <td><c:out value="${task.user.getName()}"/></td>
     
     <c:if test = "${task.priority == 'a'}">
     <td>High</td>
      </c:if>
      
      <c:if test = "${task.priority == 'b'}">
     <td>Medium</td>
      </c:if>
      <c:if test = "${task.priority == 'c'}">
     <td>Low</td>
      </c:if>
     </tr>
        </c:forEach>

</table> 
</div></div></div>
 <button class="w3-button w3-dark-grey"><a href="/tasks/new"> Create Task</a><i class="fa fa-arrow-right"></i></button>

</body>
</html>