<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>exams</title>
 </head>
 
 <body>
   <a href="/exam/new">Add New Exam</a>
            &nbsp;&nbsp;&nbsp;
 
        <c:forEach var="exam" items="${listExam}"><br>
        	<form action="update" method="post">
        		<input type="hidden" name="id" value="${exam.id}"> ${exam.id}<br>
        		
  				<input type="radio" name="1" value="${exam.answer1}"> ${exam.answer1}<br>
  				<input type="radio" name="2" value="${exam.answer2}"> ${exam.answer2}<br>
                <input type="radio" name="3" value="${exam.answer3}"> ${exam.answer3}<br>
                <input type="radio" name="4" value="${exam.answer4}"> ${exam.answer4}<br>
                
                <input type="text" name="selected" class="seleted" value="${exam.selected}"><br>
                <input type="hidden" name="correct" value="${exam.correct}"><br>
        		<input type="hidden" name="answer1" value="${exam.answer1}"> 
        		<input type="hidden" name="answer2" value="${exam.answer2}"> 
        		<input type="hidden" name="answer3" value="${exam.answer3}"> 
        		<input type="hidden" name="answer4" value="${exam.answer4}">

            	<input type="submit" value="Save" />
        	</form>
        </c:forEach>
    
    
    
    
    <%--For displaying Previous link except for the 1st page --%>
    <c:if test="${currentPage != 1}">
        <td><a href="exam?page=${currentPage - 1}">Previous</a></td>
    </c:if>
    <%--For displaying Page numbers.
    The when condition does not display a link for the current page--%>
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="exam?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
    <%--For displaying Next link --%>
    <c:if test="${currentPage lt noOfPages}">
        <td><a href="exam?page=${currentPage + 1}">Next</a></td>
    </c:if>
 </body>
</html>
