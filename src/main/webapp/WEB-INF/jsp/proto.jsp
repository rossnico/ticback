<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p> Yo </p>
	<form method="post" action="jdbctest">
		<fieldset>
	        <legend>SQL</legend>
	        <label>Votre requête</label>
	        <input type="text" name="requete" value="" size="40" maxlength="60" />
	        <br />
	        <input type="submit" value="Submit" class="sansLabel" />
         </fieldset>
     </form>
     <span>Le résultat attendu est : </span>
     <span>
		<%
		String res=(String)request.getSession().getAttribute("res");
		%>
	 	<%=res%>
	 </span> <br/>
     <span>Votre résultat est : </span>
     <span>
		 <%
			 String hisRes=(String)request.getSession().getAttribute("lmao");
		 %>
	 	<%=hisRes%>
	 </span>
</body>
</html>