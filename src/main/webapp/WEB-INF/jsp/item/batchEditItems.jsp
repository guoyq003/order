<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列表</title>
    <script type="text/javascript">
    function batchEditItemsSubmit(){
    	//提交form
    	document.itemsForm.action="${pageContext.request.contextPath }/item/batchEditItemsSubmit.action";
    	document.itemsForm.submit();
    }
    </script>
</head>
<body>
<form name="itemsForm" action="${pageContext.request.contextPath }/item/batchEditItems.action" method="post">
    商品列表：
    <table width="100%" border=1>
    <tr>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>生产日期</td>
        <td>商品描述</td>
    </tr>
    <c:forEach items="${itemsList }" var="item" varStatus="status">
               <tr>
                    <td><input name="itemsCustoms$[status.index].name" value="${item.name }"/></td>
                    <td><input name="itemsCustoms$[status.index].price" value="${item.price }"/></td>
                    <td><input name="itemsCustoms$[status.index].createTime" value="<fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
                    <td><input name="itemsCustoms$[status.index].detail" value="${item.detail }"/></td>
                </tr>
    </c:forEach>
</table>
    <table width="100%" border=1>
        <tr>
            <td width="10%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="button" value="提交" onclick="batchEditItemsSubmit()"/>
            </td>
        </tr>
    </table>
</form>
        </body>
        </html>