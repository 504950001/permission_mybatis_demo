<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<body>
<h2>Hello World! LIST</h2>

<c:forEach items="${list}" var="menu" varStatus="vs">
    <tr>
        <td>
            <s:property value="#vs.index+1"/>
        </td>
        <td align = "center">${menu.id}</td>
        <td align = "center">${menu.name}</td>
        <td align = "center">${menu.url}</td>
    </tr>
</c:forEach>
</body>
</html>
