<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../common/head.jsp" %>
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
		    <li class="breadcrumb-item">房间管理</li>
		    <li class="breadcrumb-item active">新增房间</li>
		  </ol>
   </nav>
   <div class="container-fluid">
      <div class="row">
         <!-- bootstrap栅格系统 -->
         <div class="col-12 col-md-8 col-lg-7">
            <form action="<c:url value="/rooms"/>" method="post">
                 <div class="form-group">
				    <label>房间号码</label>
				    <input name="roomNo" class="form-control" placeholder="请输入房间号码信息">
				 </div>
				 <div class="form-group">
				    <label>所属分店</label>
				    <select class="form-control" name="hotel.hotelId">
				      <option value="">-请选择-</option>
				      <c:forEach var="hotel" items="${hotelList}">
				      <option value="${hotel.hotelId}">${hotel.hotelName}</option>
				      </c:forEach>
				    </select>
				 </div>
				 <div class="form-group">
				    <label>房间类型</label><br>
				    <div class="form-check form-check-inline">			      
					  <input class="form-check-input" type="radio" name="roomType" value="a" checked>
					  <label class="form-check-label">单人间</label>
					</div>
				    <div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="roomType" value="b">
					  <label class="form-check-label">双人间</label>
					</div>
				    <div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="roomType" value="c">
					  <label class="form-check-label">三人间</label>
					</div>
				    <div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="roomType" value="d">
					  <label class="form-check-label">贵宾套房</label>
					</div>			
				    <div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="roomType" value="e">
					  <label class="form-check-label">豪华商务房</label>
					</div>																
			      </div>
                  <div class="form-group">
					<label>屋内设施</label><br>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="roomEquip" value="a">
					  <label class="form-check-label">大屏液晶</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="roomEquip" value="b">
					  <label class="form-check-label">中央空调</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="roomEquip" value="c">
					  <label class="form-check-label">高级卫浴</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="roomEquip" value="d">
					  <label class="form-check-label">互联网接入</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="roomEquip" value="e">
					  <label class="form-check-label">冲浪浴缸</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="roomEquip" value="f">
					  <label class="form-check-label">卫星电视</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="roomEquip" value="g">
					  <label class="form-check-label">冰箱</label>
					</div>																												
				  </div>
				  <div class="form-group">
				    <label>房间状态</label>
				    <select class="form-control" name="roomStatus">
				      <option value="">-请选择-</option>
				      <option value="a">空置房间</option>
				      <option value="b">已预订</option>
				      <option value="c">退房保洁中</option>
				      <option value="d">整理维修</option>
				      <option value="e">已入住</option>
				      <option value="f">未保洁</option>
				    </select>
				  </div>
				  <div class="form-group">
				    <label>备注说明</label>
				    <textarea name="roomMemo" rows="3" cols="50" class="form-control" placeholder="说明房间额外信息"></textarea>
				  </div>			      
			      <input type="submit" class="btn btn-primary" value="房间登记">				 
            </form>
         </div>
      </div>
   </div>  
   <jsp:include page="../common/footer.jsp"></jsp:include> 
</body>
</html>