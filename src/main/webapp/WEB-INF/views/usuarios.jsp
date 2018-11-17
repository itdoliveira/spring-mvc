<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Spring MVC</title>
      <style>
      	.error {
			color: red;
		}
		
		table {
			width: 50%;
			border-collapse: collapse;
			border-spacing: 0px;
		}
		
		table td {
			border: 1px solid #565454;
			padding: 20px;
		}
      </style>
   </head>
   <body>
      <h1>Input Form</h1>
      <form:form action="usuario/adicionar" method="post" modelAttribute="usuario">
         <table>
            <tr>
               <td>Name</td>
               <td>
                  <form:input path="nome" />
                  <br />
                  <form:errors path="nome" cssClass="error" />
               </td>
            </tr>
            <tr>
               <td>Email</td>
               <td>
                  <form:input path="email" />
                  <br />
                  <form:errors path="email" cssClass="error" />
               </td>
            </tr>
            <tr>
               <td colspan="2"><button type="submit">Submit</button></td>
            </tr>
         </table>
      </form:form>
      <h2>Users List</h2>
      <table>
         <tr>
            <td><strong>Name</strong></td>
            <td><strong>Email</strong></td>
         </tr>
         <c:forEach items="${usuarios}" var="usuario">
            <tr>
               <td>${usuario.nome}</td>
               <td>${usuario.email}</td>
            </tr>
         </c:forEach>
      </table>
   </body>
</html>