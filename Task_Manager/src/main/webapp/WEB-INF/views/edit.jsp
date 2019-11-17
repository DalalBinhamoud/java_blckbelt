<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Task</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<h1>Edit <c:out value="${task.title}"/></h1>

<form:form action="/tasks/${task.id}/editTask" method="post" modelAttribute="task">

<input type="hidden" value="<c:out value="${user.name}"/>"/>
  <p>
        <form:label path="title">Task:</form:label>
        <form:errors path="title"/>
        <form:input path="title" value="${task.title}" required="required"/>
    </p>
    
    
    <p>
        Assignee:

  <select name="user">
      <option  value="${task.user.getId()}" > ${task.user.getName()}</option>

       <c:forEach items="${users}" var="user">
     
        <option  value="${user.id}" >  
            <c:out value="${user.name}"/>
        </option>
        </c:forEach>
            </select>    
    </p>
    
    
       <p>
        Priority:

  <select name="priority">
<%--    <option  value="${task.priority}" > ${task.priority}</option> --%>
    <c:if test = "${task.priority == 'a'}">
     <option>High</option>
      </c:if>
      
      <c:if test = "${task.priority == 'b'}">
     <option>Medium</option>
      </c:if>
      <c:if test = "${task.priority == 'c'}">
     <option>Low</option>
      </c:if>
   
 <option  value="a" > High </option>
  <option  value="b" > Medium </option>
   <option  value="c" > Low </option>

            </select>    
    </p>
    
    <input type="submit" value="Edit"/>
</form:form>   
</body>
</html>