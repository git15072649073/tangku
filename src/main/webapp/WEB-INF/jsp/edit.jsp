<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/12/012
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table  border="1px" style="text-align: center">
    <tr>
        <td>图书编号</td>
        <td>${book.bookCode}</td>
    </tr>
    <tr>
        <td>图书名称</td>
        <td>${book.bookName}</td>
    </tr>
    <tr>
        <td>图书分类</td>
        <%--<td>${book.bookType}</td>--%>
        <td>${book.bookTypes.typeName}</td>
    </tr>
    <tr>
        <td>作者</td>
        <td>${book.bookAuthor}</td>
    </tr>
    <tr>
        <td>出版社</td>
        <td>${book.publishPress}</td>
    </tr>
    <tr>
        <td>出版日期</td>
        <td><fmt:formatDate value="${book.publishDate}"  pattern="yyyy-MM-dd" /></td>
        <%--<td>${book.publishDate}</td>--%>
    </tr>

    <tr>
        <td colspan="2">
            <a  href="querybook.htm">返回首页</a>
        </td>
    </tr>
</table>
</body>
</html>
