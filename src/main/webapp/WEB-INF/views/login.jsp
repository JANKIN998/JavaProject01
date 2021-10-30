<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="./common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

    <%@ include file="./common/head.jsp" %>
  </head>
  
  <body>

    <div class="container">
       <div class="row col-12 col-md-6 offset-md-2" style="margin-top:100px">
         <h2><b>ABC酒店管理系统 v2.0</b></h2>
         <hr>
       </div>
       <div class="row py-5">
        <form action="<c:url value="/login"/>" method="post" class="col-12 col-md-6 offset-md-3">
           <input type="hidden" name="task" value="login"/>
           <div class="form-group">
		    <label>账户名称</label>
		    <input type="text" name="userNo" class="form-control" placeholder="请输入6位账号信息" maxlength="6" value="${param.userNo}">
		   </div>
           <div class="form-group">
		    <label>账户密码</label>
		    <input type="password" name="userPwd" class="form-control" placeholder="请输入密码信息" maxlength="6">
		   </div>
           <c:if test="${not empty errMsg}">
            <div class="alert alert-danger text-center">
			  ${errMsg}
		    </div>		
		   </c:if>		   	   
		   <div>
		    <button class="btn btn-primary">系统登录</button>
		   </div>		   		               
        </form>
      </div>
    </div>
    <jsp:include page="./common/footer.jsp"></jsp:include>
  </body>
</html>
