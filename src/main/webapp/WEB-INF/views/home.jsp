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

    <jsp:include page="./common/menubar.jsp"></jsp:include>
    <!-- 面包屑导航条 -->
    <nav aria-label="breadcrumb">
		  <ol class="breadcrumb" style="border-radius:0em">
		    <li class="breadcrumb-item">首页</li>
		  </ol>
	</nav>    

     <div class="container my-2">
       <div class="row py-5">
		<div class="jumbotron">
		  <h1 class="display-4">欢迎来到ABC酒店管理</h1>
		  <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
		  <hr class="my-4">
		  <a class="btn btn-primary btn-lg col-md-3 mx-2" href='/hotelsys/hotelMgr?task=loadHotels'>分店管理</a>
		  <a class="btn btn-success btn-lg col-md-3 mx-2" href="#" role="button">员工管理</a>
		  <a class="btn btn-info btn-lg col-md-3 mx-2" href='/hotelsys/roomMgr?task=loadRooms'>房间管理</a>
		</div>       
       </div>
    </div>
    <jsp:include page="./common/footer.jsp"></jsp:include> 
  </body>
</html>
