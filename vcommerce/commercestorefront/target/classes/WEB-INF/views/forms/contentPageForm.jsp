<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add customer</title>
</head>
<body>
<form action="content/save" method="POST">
 Page name<input type="text" name="pageName"/><br/>
 code<input type="text" name="code"/><br/>
 name<input type="text" name="name"/><br/>
 pageTemplate<input type="text" name="pageTemplate"/><br/>
 <input type="submit" value="save"/>
 </form>
</body>
</html>