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
		    <li class="breadcrumb-item active">房间修改</li>
		  </ol>
   </nav>
   <div class="container-fluid">
      <div class="row">
         <!-- bootstrap栅格系统 -->
         <div class="col-12 col-md-8 col-lg-7">
            <form action="<c:url value="/rooms"/>/${room.roomId}" method="post">
                 <input type="hidden" name="_method" value="PUT"/>
                 <div class="form-group">
				    <label>房间号码</label>
				    <input name="roomNo" class="form-control" placeholder="请输入房间号码信息" value="${room.roomNo}">
				 </div>
				 <div class="form-group">
				    <label>所属分店</label>
				    <select class="form-control" name="hotel.hotelId">
				      <option value="">-请选择-</option>
				      <c:forEach var="hotel" items="${hotelList}">
				      <option value="${hotel.hotelId}"<c:if test="${room.hotel.hotelId==hotel.hotelId}"> selected</c:if>>${hotel.hotelName}</option>
				      </c:forEach>
				    </select>				    
				 </div>
				 <div class="form-group">
				    <label>房间类型</label><br>
				    <div class="form-check form-check-inline">			      
					  <input class="form-check-input" type="radio" name="roomType" value="a" <c:if test="${room.roomType=='a'}">checked</c:if>>
					  <label class="form-check-label">单人间</label>
					</div>
				    <div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="roomType" value="b" <c:if test="${room.roomType=='b'}">checked</c:if>>
					  <label class="form-check-label">双人间</label>
					</div>
				    <div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="roomType" value="c" <c:if test="${room.roomType=='c'}">checked</c:if>>
					  <label class="form-check-label">三人间</label>
					</div>
				    <div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="roomType" value="d" <c:if test="${room.roomType=='d'}">checked</c:if>>
					  <label class="form-check-label">贵宾套房</label>
					</div>			
				    <div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="roomType" value="e" <c:if test="${room.roomType=='e'}">checked</c:if>>
					  <label class="form-check-label">豪华商务房</label>
					</div>																
			      </div>
                  <div class="form-group">
					<label>屋内设施</label><br>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="roomEquip" value="a"
					  <c:forEach var="equip" items="${room.roomEquip}">
					   <c:if test="${equip=='a'}">checked</c:if>
					  </c:forEach>
					  >
					  <label class="form-check-label">大屏液晶</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="roomEquip" value="b"
					  <c:forEach var="equip" items="${room.roomEquip}">
					   <c:if test="${equip=='b'}">checked</c:if>
					  </c:forEach>
					  >
					  <label class="form-check-label">中央空调</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="roomEquip" value="c"
					  <c:forEach var="equip" items="${room.roomEquip}">
					   <c:if test="${equip=='c'}">checked</c:if>
					  </c:forEach>
					  >
					  <label class="form-check-label">高级卫浴</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="roomEquip" value="d"
					  <c:forEach var="equip" items="${room.roomEquip}">
					   <c:if test="${equip=='d'}">checked</c:if>
					  </c:forEach>
					  >
					  <label class="form-check-label">互联网接入</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="roomEquip" value="e"
					  <c:forEach var="equip" items="${room.roomEquip}">
					   <c:if test="${equip=='e'}">checked</c:if>
					  </c:forEach>
					  >
					  <label class="form-check-label">冲浪浴缸</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="roomEquip" value="f"
					<c:forEach var="equip" items="${room.roomEquip}">
					   <c:if test="${equip=='f'}">checked</c:if>
					</c:forEach>  				  
					  >
					  <label class="form-check-label">卫星电视</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="roomEquip" value="g"
					  <c:forEach var="equip" items="${room.roomEquip}">
					   <c:if test="${equip=='g'}">checked</c:if>
					</c:forEach>
					  >
					  <label class="form-check-label">冰箱</label>
					</div>																												
				  </div>
				  <div class="form-group">
				    <label>房间状态</label>
				    <select class="form-control" name="roomStatus">
				      <option value="">-请选择-</option>
				      <option value="a"<c:if test="${room.roomStatus=='a'}"> selected</c:if>>空置房间</option>
				      <option value="b"<c:if test="${room.roomStatus=='b'}"> selected</c:if>>已预订</option>
				      <option value="c"<c:if test="${room.roomStatus=='c'}"> selected</c:if>>退房保洁中</option>
				      <option value="d"<c:if test="${room.roomStatus=='d'}"> selected</c:if>>整理维修</option>
				      <option value="e"<c:if test="${room.roomStatus=='e'}"> selected</c:if>>已入住</option>
				      <option value="f"<c:if test="${room.roomStatus=='f'}"> selected</c:if>>未保洁</option>
				    </select>
				  </div>
				  <div class="form-group">
				    <label>备注说明</label>
				    <textarea name="roomMemo" rows="3" cols="50" class="form-control" placeholder="说明房间额外信息">${room.roomMemo}</textarea>
				  </div>			      
			      <input type="submit" class="btn btn-primary" value="房间登记">				 
            </form>
         </div>
      </div>
   </div> 
   <jsp:include page="../common/footer.jsp"></jsp:include>  
</body>
</html>