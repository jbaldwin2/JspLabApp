<%-- 
    Document   : index
    Created on : Oct 1, 2012, 11:18:08 AM
    Author     : jbaldwin2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Waiter App!</title>
    </head>
    <body>
        <h2>Welcome to the Waiter Application</h2>
        <p><a href="form.html">Click here to get advice</a></p>
        <br>
        <form>
        Or click here if you're ready to order:
        <input type="button" name="blah" onclick="document.location.href='main?action=newList'">
        </form> 
    </body>
</html>
