<%-- 
    Document   : newjsp
    Created on : Feb 20, 2021, 9:12:25 PM
    Author     : smikayilov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test</title>
        <link rel="shortcut icon" href="data:image/png;base64,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" 
              type="image/png"
              sizes="64x164"/>

        <link rel="stylesheet" href="logout.css" />
    </head>
    <body>
        <%  if (session.getAttribute("email") == null) {
                response.sendRedirect("index.html");
            }
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", 0); // Proxies.
%>
        <h4>
            <div class="background background--light">
                <p>
                <form action="/FirstApp/Logout" method="post">
                    <button class="logoutButton logoutButton--dark">
                        <svg class="doorway" viewBox="0 0 100 100">
                        <path
                            d="M93.4 86.3H58.6c-1.9 0-3.4-1.5-3.4-3.4V17.1c0-1.9 1.5-3.4 3.4-3.4h34.8c1.9 0 3.4 1.5 3.4 3.4v65.8c0 1.9-1.5 3.4-3.4 3.4z"
                            />
                        <path
                            class="bang"
                            d="M40.5 43.7L26.6 31.4l-2.5 6.7zM41.9 50.4l-19.5-4-1.4 6.3zM40 57.4l-17.7 3.9 3.9 5.7z"
                            />
                        </svg>
                        <svg class="figure" viewBox="0 0 100 100">
                        <circle cx="52.1" cy="32.4" r="6.4" />
                        <path
                            d="M50.7 62.8c-1.2 2.5-3.6 5-7.2 4-3.2-.9-4.9-3.5-4-7.8.7-3.4 3.1-13.8 4.1-15.8 1.7-3.4 1.6-4.6 7-3.7 4.3.7 4.6 2.5 4.3 5.4-.4 3.7-2.8 15.1-4.2 17.9z"
                            />
                        <g class="arm1">
                        <path
                            d="M55.5 56.5l-6-9.5c-1-1.5-.6-3.5.9-4.4 1.5-1 3.7-1.1 4.6.4l6.1 10c1 1.5.3 3.5-1.1 4.4-1.5.9-3.5.5-4.5-.9z"
                            />
                        <path
                            class="wrist1"
                            d="M69.4 59.9L58.1 58c-1.7-.3-2.9-1.9-2.6-3.7.3-1.7 1.9-2.9 3.7-2.6l11.4 1.9c1.7.3 2.9 1.9 2.6 3.7-.4 1.7-2 2.9-3.8 2.6z"
                            />
                        </g>
                        <g class="arm2">
                        <path
                            d="M34.2 43.6L45 40.3c1.7-.6 3.5.3 4 2 .6 1.7-.3 4-2 4.5l-10.8 2.8c-1.7.6-3.5-.3-4-2-.6-1.6.3-3.4 2-4z"
                            />
                        <path
                            class="wrist2"
                            d="M27.1 56.2L32 45.7c.7-1.6 2.6-2.3 4.2-1.6 1.6.7 2.3 2.6 1.6 4.2L33 58.8c-.7 1.6-2.6 2.3-4.2 1.6-1.7-.7-2.4-2.6-1.7-4.2z"
                            />
                        </g>
                        <g class="leg1">
                        <path
                            d="M52.1 73.2s-7-5.7-7.9-6.5c-.9-.9-1.2-3.5-.1-4.9 1.1-1.4 3.8-1.9 5.2-.9l7.9 7c1.4 1.1 1.7 3.5.7 4.9-1.1 1.4-4.4 1.5-5.8.4z"
                            />
                        <path
                            class="calf1"
                            d="M52.6 84.4l-1-12.8c-.1-1.9 1.5-3.6 3.5-3.7 2-.1 3.7 1.4 3.8 3.4l1 12.8c.1 1.9-1.5 3.6-3.5 3.7-2 0-3.7-1.5-3.8-3.4z"
                            />
                        </g>
                        <g class="leg2">
                        <path
                            d="M37.8 72.7s1.3-10.2 1.6-11.4 2.4-2.8 4.1-2.6c1.7.2 3.6 2.3 3.4 4l-1.8 11.1c-.2 1.7-1.7 3.3-3.4 3.1-1.8-.2-4.1-2.4-3.9-4.2z"
                            />
                        <path
                            class="calf2"
                            d="M29.5 82.3l9.6-10.9c1.3-1.4 3.6-1.5 5.1-.1 1.5 1.4.4 4.9-.9 6.3l-8.5 9.6c-1.3 1.4-3.6 1.5-5.1.1-1.4-1.3-1.5-3.5-.2-5z"
                            />
                        </g>
                        </svg>
                        <svg class="door" viewBox="0 0 100 100">
                        <path
                            d="M93.4 86.3H58.6c-1.9 0-3.4-1.5-3.4-3.4V17.1c0-1.9 1.5-3.4 3.4-3.4h34.8c1.9 0 3.4 1.5 3.4 3.4v65.8c0 1.9-1.5 3.4-3.4 3.4z"
                            />
                        <circle cx="66" cy="50" r="3.7" />
                        </svg>

                        <span class="button-text">Log Out</span>
                    </button>

                    <script src="logout.js"></script>
                </form>
                <s:set var="start" value="0"></s:set>
                <s:set var="stop" value="4"></s:set>
                <s:set var="rad" value="1"></s:set>
                    <form action="/FirstApp/Home" method="Post">
                    <s:forEach items="${questions}" var="qes">
                        <s:out value="${qes}"></s:out></br></br>
                        <s:forEach items="${answers}" var="ans" begin="${start}" end="${stop}">
                            <input type="radio" name="${rad}" value="${ans}"/><s:out value="${ans}"></s:out></br></br>
                        </s:forEach>
                        <s:set var="start" value="${stop+1}"></s:set>
                        <s:set var="stop" value="${stop+5}"></s:set>
                        <s:set var="rad" value="${rad+1}"></s:set>
                    </s:forEach>
                    <div align="center">
                        <input type="submit" value="Submit" name="Submit"/>
                    </div>
                </form>

                </p>
            </div>
        </h4>

    </body>
</html>
