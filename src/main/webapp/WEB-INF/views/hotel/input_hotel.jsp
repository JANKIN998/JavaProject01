<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../common/head.jsp" %>
<script type="text/javascript" src="/hotelsys5/static/js/base.js"></script>
</head>
<body>
   <!-- 
     bootstrap container:  1) container  2)container-fluid(全屏幕，全宽度的容器)
    -->
   <%@ include file="../common/menubar.jsp"%>
   <!-- 面包屑导航条 -->
   <nav aria-label="breadcrumb">
		  <ol class="breadcrumb" style="border-radius:0em">
		    <li class="breadcrumb-item">首页</li>
		    <li class="breadcrumb-item">分店管理</li>
		    <li class="breadcrumb-item active">新增分店</li>
		  </ol>
   </nav>
   <div class="container-fluid">
      <div class="row">
         <!-- bootstrap栅格系统 -->
         <div class="col-12 col-md-6 col-lg-5">
            <form action="<c:url value="/hotels"/>" method="post" enctype="multipart/form-data">
                 <div class="form-group">
				    <label>分店名称</label>
				    <input name="hotelName" class="form-control" placeholder="请输入分店名称信息">
				 </div>
				 <div class="form-group">
			        <label>分店照片</label><br>
			        <img id="picImg" src="/hotelsys5/static/pics/no-pic.jpg" width="200" height="130" class="py-1"><br>
			        <input type="file" name="hotelPhoto" class="form-control-file" onchange="previewImage(this)">
			     </div>
                 <div class="form-group">
			        <label>分店地址</label>
			        <input name="hotelAddr" class="form-control" placeholder="请输入分店地址信息">
			     </div>
			     <div class="form-group">
			        <label>联络电话</label>
			        <input name="hotelPhone" class="form-control" placeholder="请输入分店座机或手机联络信息">
			     </div>
			     <input type="submit" class="btn btn-primary" value="新建分店">				 
            </form>
         </div>
      </div>
   </div>   
   <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>