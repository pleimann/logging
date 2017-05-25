<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.apache.logging.log4j.Level" %>
<%@ page import="org.apache.logging.log4j.LogManager" %>
<%@ page import="org.apache.logging.log4j.Logger" %>
<html>
<head>
    <title>Logging Example</title>
</head>
<body>
<%
    Logger LOG = LogManager.getLogger();

    for (Level level : Level.values()) {
        %><p><%=level%></p><%
        LOG.log(level, "Log Level {}", level);
    }
%>
</body>
</html>
