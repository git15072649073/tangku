<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/11/011
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>添加书籍</title>
    <style type="text/css">
        #body {
            margin: 0px auto;
            width: 800px;
            height: 600px;
        }
    </style>
</head>
<body>
<div id="body">
    <div style="margin: 0px auto; width: 500px;">
        <form action="/addbook.htm" method="post" id="dd"  enctype="multipart/form-data">
            <table border="1px" style="text-align: center;">
                <tr>
                    <td>图书编号</td>
                    <td><input id="code" name="bookCode" onblur="checkCode();"><span
                            id="codeMessage"></span></td>
                </tr>
                <tr>
                    <td>图书名称</td>
                    <td><input name="bookName"></td>
                </tr>
                <tr>
                    <td>图书分类</td>
                    <td style="text-align: left;"><select name="bookType">
                        <c:forEach items="${bookTypes}" var="bookType">
                            <option value="${bookType.id }">${bookType.typeName}</option>
                        </c:forEach>
                    </select></td>
                </tr>
                <tr>
                    <td>作者</td>
                    <td><input name="bookAuthor"></td>
                </tr>
                <tr>
                    <td>出版社</td>
                    <td><input name="publishPress"></td>
                </tr>
                <tr>
                    <td>出版时间</td>
                    <td><input name="publishDate"></td>
                </tr>
                <tr>
                    <td>图片上传</td>
                    <td><img id="img" src="">
                        <input type="file" name="fileImage" onchange="uploadImage()">
                        <input type="hidden" name="bookPath" id="pic"  >
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="提交"> <input
                            type="button" value="取消"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
<script src="/resource/js/jquery-1.8.3.min.js"></script>
<script src="/resource/js/jquery.form.js" ></script>
<%--加表单--%>
<script>
    function  uploadImage()  {
        //编写ajax
        var obj={
            url:"/upload.do",
            dataType:"json",
            type:"post",
            success:function(data){
                $("#img").attr("src",data.imagePath);
                $("#pic").val( data.imagePath);
            }
        };
        //2提交form
        $("#dd").ajaxSubmit(obj);
    }
</script>

</html>
