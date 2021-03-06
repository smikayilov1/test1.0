<%-- 
    Document   : authentication
    Created on : Feb 20, 2021, 12:34:00 PM
    Author     : smikayilov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test</title>
        <link rel="shortcut icon" href="data:image/png;base64,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" 
              type="image/png"
              sizes="64x164"/> 
        <link rel="stylesheet" href="authen.css" />
    </head>
    <body>
        <%  if (session.getAttribute("email") == null) {
                response.sendRedirect("index.html");
            }%>
        <div class="container">
            <form id="form" action="/FirstApp/SignUp" method="post">
                <h1>TWO-FACTOR AUTHENTICATION</h1>
                <div class="form__group form__pincode">
                    <label>Enter 6-digit code from your authenticator application</label>
                    <input
                        type="tel"
                        name="pincode-1"
                        maxlength="1"
                        pattern="[\d]*"
                        tabindex="1"
                        placeholder="??"
                        autocomplete="off"
                        />
                    <input
                        type="tel"
                        name="pincode-2"
                        maxlength="1"
                        pattern="[\d]*"
                        tabindex="2"
                        placeholder="??"
                        autocomplete="off"
                        />
                    <input
                        type="tel"
                        name="pincode-3"
                        maxlength="1"
                        pattern="[\d]*"
                        tabindex="3"
                        placeholder="??"
                        autocomplete="off"
                        />
                    <input
                        type="tel"
                        name="pincode-4"
                        maxlength="1"
                        pattern="[\d]*"
                        tabindex="4"
                        placeholder="??"
                        autocomplete="off"
                        />
                    <input
                        type="tel"
                        name="pincode-5"
                        maxlength="1"
                        pattern="[\d]*"
                        tabindex="5"
                        placeholder="??"
                        autocomplete="off"
                        />
                    <input
                        type="tel"
                        name="pincode-6"
                        maxlength="1"
                        pattern="[\d]*"
                        tabindex="6"
                        placeholder="??"
                        autocomplete="off"
                        />
                </div>
                <div class="form__buttons">
                    
                    <input type="submit" value="Continue" class="button button--primary" >
                   
                </div>
            </form>
    </body>
</html>
