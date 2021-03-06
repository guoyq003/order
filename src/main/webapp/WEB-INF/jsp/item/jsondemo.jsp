<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Json测试</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        //请求json，输出是json
        function requestJson() {
            $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath }/requestJson.action',
                contentType: 'application/json;charset=utf-8',
                //数据格式是json串，商品信息
                data: '{"name":"小米note","price":1800}',
                success: function (data) {//返回json结果
                    alert(data);
                }
            });
        }
        //请求key/value，输出是json
        function responseJson() {

            $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath }/responseJson.action',
                //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
                //contentType:'application/json;charset=utf-8',
                //数据格式是json串，商品信息
                data: 'name=笔记本&price=7000',
                success: function (data) {//返回json结果
                    alert(data.name);
                }
            });
        }
    </script>
</head>
<body>
<input type="button" onclick="requestJson()" value="请求json，输出是json"/>
<input type="button" onclick="responseJson()" value="请求key/value，输出是json"/>
</body>
</html>