<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Exams Store Application</title>
</head>
<body>
	<center>
		<h1>Exams Management</h1>
        <h2>
        	<a href="new">Add New exam</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All exams</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${exam != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${exam == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${exam != null}">
            			Edit exam
            		</c:if>
            		<c:if test="${exam == null}">
            			Add New exam
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${exam != null}">
        			<input type="hidden" name="id" value="<c:out value='${exam.id}' />" />
        		</c:if>            
            <tr>
                <th>answer1: </th>
                <td>
                	<input type="text" name="title" size="45"
                			value="<c:out value='${exam.answer1}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>answer2: </th>
                <td>
                	<input type="text" name="author" size="45"
                			value="<c:out value='${exam.answer2}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>answer3: </th>
                <td>
                	<input type="text" name="price" size="5"
                			value="<c:out value='${exam.answer3}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
             <tr>
                <th>selected: </th>
                <td>
                	<input type="text" name="title" size="45"
                			value="<c:out value='${exam.selected}' />"
                		/>
                </td>
            </tr>
             <tr>
                <th>correct: </th>
                <td>
                	<input type="text" name="title" size="45"
                			value="<c:out value='${exam.correct}' />"
                		/>
                </td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
