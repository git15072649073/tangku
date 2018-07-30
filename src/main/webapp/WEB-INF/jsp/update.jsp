<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form  id="imm" action="/updateBook.htm" method="post"  enctype="multipart/form-data">
    <table border="1px" style="text-align: center;">
        <tr>
            <td>图书编号</td>
            <td><input name="bookCode" value="${book.bookCode }"></td>
        </tr>
        <tr>
            <td>图书名称</td>
            <td><input name="bookName" value="${book.bookName }">
            </td>
        </tr>
        <tr>
            <td>图书分类</td>
            <td><select name="bookTypes.id">
                <c:forEach items="${bookTypes}" var="type">
                    <option value="${type.id}"
                            <c:if test="${type.id==book.bookTypes.id}">selected="selected"</c:if>>${type.typeName}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td>作者</td>
            <td><input type="text" name="bookAuthor"
                       value="${book.bookAuthor }"></td>
        </tr>
        <tr>
            <td>出版社</td>
            <td><input type="text" name="publishPress"
                       value="${book.publishPress }"></td>
        </tr>
        <tr>
            <td>出版时间</td>
            <td><input type="text" name="publishDate"
                       value="<fmt:formatDate value="${book.publishDate }" pattern="yyyy-MM-dd"/> ">
            </td>
        </tr>
        <tr>
            <td>图片上传</td>
            <td><img id="img" src="${book.bookPath}">
                <!-- 显示图片的 -->
       <input name="fileImage" type="file" onchange="uploadImage();">
       <input type="hidden" name="bookPath" id="pic" value="${book.bookPath}"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="hidden" name="bookId"
 value="${book.bookId }"> <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
<script src="/resource/js/jquery-1.8.3.min.js"></script>
<script src="/resource/js/jquery.form.js"></script>
<script>
    function uploadImage() {
        //编写ajax
        var obj = {

            url:"/upload.do",
            dataType : "json",
            type : "post",
            success : function(data) {
                alert(data.imagePath);
                $("#img").attr("src", data.imagePath);
                $("#pic").val(data.imagePath);
            }
        };

        //提交form
        $("#imm").ajaxSubmit(obj);
    }
</script>
</html>
