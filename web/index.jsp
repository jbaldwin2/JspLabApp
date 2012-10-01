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
        <form>
                <!-- keep the form tag outside of the table data cell or it will make it larger -->
         
                    <!-- If you want color in the navbar, you can add this style="background-color: #302C38; color: #81b2da; font-weight: bold; font-size: 10pt" But this will cause some problems in Netscape 4.7... Netscape 6 and Opera 6 will have no problems with this -->
                    <select name="quicknav" size="1" onChange='top.location.href=this.form.quicknav.options[this.form.quicknav.selectedIndex].value'>
                        <option selected>Quick Jump</option>
                        <!-- follow the examples below to modify or add links to the QuickJump -->
                        <option value="main?action=newList">Place Order With Lists</option>
                        <option value="main?action=newCheckboxes">Place Order With Checkboxes</option>
                    </select>
             
                <!-- keep the FORM tag outside of the table data cell or it will make it larger -->
            </form>
    </body>
</html>
