<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../common/head.jsp" %>
<script type="text/javascript">

     var delRoomId=0;
    
     function showRemoveDlg(roomId,roomNo,hotelName){
    	 delRoomId = roomId;
    	 $("#message").html("您确认要删除 &nbsp;["+hotelName+"-"+roomNo+"]&nbsp; 房间信息吗?");
    	 $('#removeRoomModal').modal('show');
     }
     
     function removeRoom(){
    	 location.href='<c:url value="/rooms"/>'+"/"+delRoomId;
		 document.forms[0].action += "/"+delRoomId;
		 document.forms[0].submit();
     }
     
     function updateRoom(roomid){
    	 location.href='<c:url value="/rooms"/>'+"/"+roomid;
     }
     
     function doQuery(pageNo){
	    	
   	   if(pageNo<1 || pageNo>${page.totalPageNum})
       {
             alert('页号超出范围，有效范围：[1-${page.totalPageNum}]!');
             $('#pageNo').select();
             return;
       }
       else{
   	         document.forms[1].pageNo.value=pageNo;
   	         document.forms[1].submit();
   	   }
   	   
     }      

</script>
</head>
<body>
   <%@ include file="../common/menubar.jsp"%>
   <form action="<c:url value="/rooms"/>" method="post">
	   <input type="hidden" name="_method" value="DELETE"/>
   </form>
   <!-- 面包屑导航条 -->
   <nav aria-label="breadcrumb">
		  <ol class="breadcrumb" style="border-radius:0em">
		    <li class="breadcrumb-item">首页</li>
		    <li class="breadcrumb-item">房间管理</li>
		    <li class="breadcrumb-item active">房间列表</li>
		  </ol>
   </nav>
   <div class="container-fluid">
      <div class="row">
          <div class="col-12">
             <form action="<c:url value="/rooms"/>" method="get">
             <input type="hidden" name="pageNo" value="1">
	         <div id="queryArea">
	            <!-- 表单组件是横向排列的 -->
	            <div class="form-row">
	                <div class="form-group col-md-3">
                        <select name="qryHotelNo" class="form-control">
                              <option value="">-请选择所属分店-</option>
                              <c:forEach var="hotel" items="${hotelList}">                              
                              <option value="${hotel.hotelId}" <c:if test="${hotel.hotelId==param.qryHotelNo}">selected</c:if>>${hotel.hotelName}</option>
                              </c:forEach>
			            </select>                            
                    </div>                   
                    <div class="form-group col-md-3">
                           <select name="qryRoomType" class="form-control">
                              <option value="">-请选择房间类型-</option>
                              <option value="a" <c:if test="${param.qryRoomType=='a'}">selected</c:if>>单人间</option>
                              <option value="b" <c:if test="${param.qryRoomType=='b'}">selected</c:if>>双人间</option>
                              <option value="c" <c:if test="${param.qryRoomType=='c'}">selected</c:if>>三人间</option>
                              <option value="d" <c:if test="${param.qryRoomType=='d'}">selected</c:if>>贵宾套房</option>
                              <option value="e" <c:if test="${param.qryRoomType=='e'}">selected</c:if>>豪华商务房</option>
			               </select>                            
                     </div>
                     <div class="form-group col-md-3">
                           <select name="qryRoomStatus" class="form-control">
                              <option value="">-请选择房间状态-</option>
                              <option value="a" <c:if test="${param.qryRoomStatus=='a'}">selected</c:if>>空置房间</option>
                              <option value="b" <c:if test="${param.qryRoomStatus=='b'}">selected</c:if>>已预订</option>
                              <option value="c" <c:if test="${param.qryRoomStatus=='c'}">selected</c:if>>退房保洁中</option>
                              <option value="d" <c:if test="${param.qryRoomStatus=='d'}">selected</c:if>>整理维修</option>
                              <option value="e" <c:if test="${param.qryRoomStatus=='e'}">selected</c:if>>已入住</option>
                              <option value="f" <c:if test="${param.qryRoomStatus=='f'}">selected</c:if>>未保洁</option>
			               </select>
                     </div>
                     <div class="form-group col-md-3">
                          <button class="btn btn-primary"> 查询房间 </button>
                     </div> 
	            </div>
	         </div>
	         </form>
	      </div> 
	      <c:if test="${not empty page.pageContent}">
          <table class="table">
			  <thead>
			    <tr>
			      <th scope="col">序号</th>
			      <th scope="col">房号</th>
			      <th scope="col">所属分店</th>
			      <th scope="col">房间类型</th>
			      <th scope="col">屋内设施</th>
			      <th scope="col">房间状态</th>
			      <th scope="col">房间状态</th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach var="room" items="${page.pageContent}">
			     <tr>
                  <td scope="row">${room.roomId}</td>
			      <td>${room.roomNo}</td>
			      <td>${room.hotel.hotelName}</td>
			      <td>
			         <c:if test="${room.roomType=='a'}">单人间</c:if>
					 <c:if test="${room.roomType=='b'}">双人间</c:if>
					 <c:if test="${room.roomType=='c'}">三人间</c:if>
					 <c:if test="${room.roomType=='d'}">贵宾套房</c:if>
					 <c:if test="${room.roomType=='e'}">豪华商务房</c:if>
			      </td>
			      <td>
			         <c:forEach var="equip" items="${room.roomEquip}">
                       <c:if test="${equip=='a'}">大屏液晶&nbsp;</c:if>
					   <c:if test="${equip=='b'}">中央空调&nbsp;</c:if>	 
					   <c:if test="${equip=='c'}">高级卫浴&nbsp;</c:if>	 
					   <c:if test="${equip=='d'}">互联网接入&nbsp;</c:if>	 
					   <c:if test="${equip=='e'}">冲浪浴缸&nbsp;</c:if>	 
					   <c:if test="${equip=='f'}">卫星电视&nbsp;</c:if>	 
					   <c:if test="${equip=='g'}">冰箱&nbsp;</c:if>
			         </c:forEach>
			      </td>
			      <td>
			         <c:if test="${room.roomStatus=='a'}">空置房间</c:if>
					 <c:if test="${room.roomStatus=='b'}">已预订</c:if>
					 <c:if test="${room.roomStatus=='c'}">退房保洁中</c:if>
					 <c:if test="${room.roomStatus=='d'}">整理维修</c:if>
					 <c:if test="${room.roomStatus=='e'}">已入住</c:if>
					 <c:if test="${room.roomStatus=='f'}">未保洁</c:if>	
			      </td>
			      <td>
			        <button class="btn btn-primary btn-sm" onclick="updateRoom(${room.roomId})">修改</button>
			        <button class="btn btn-danger btn-sm" onclick="showRemoveDlg(${room.roomId},'${room.roomNo}','${room.hotel.hotelName}');">删除</button>
			      </td>
			     </tr>
			    </c:forEach>
			  </tbody>
	      </table>
	      <div class="col-12 text-right">
			  共${page.totalRecNum}条, 当前显示${page.startIndex+1}-${page.endIndex}条, 第${page.pageNo}/${page.totalPageNum}页
			 <c:if test="${page.totalPageNum>1}">|</c:if>
		           <c:if test="${page.pageNo>1}">
		             <button class="btn btn-sm btn-outline-info" onclick="doQuery(1)">首页</button>&nbsp;
		           </c:if>
		           <c:if test="${page.prePage}">
		             <button class="btn btn-sm btn-outline-info" onclick="doQuery(${page.pageNo-1})">上一页</button>&nbsp;
		           </c:if>
		           <c:if test="${page.nextPage}">
		             <button class="btn btn-sm btn-outline-info" onclick="doQuery(${page.pageNo+1})">下一页</button>&nbsp;
		           </c:if>
		           <c:if test="${page.pageNo!=page.totalPageNum}">
		             <button class="btn btn-sm btn-outline-info" onclick="doQuery(${page.totalPageNum})">末页</button>&nbsp;
		           </c:if>
		      &nbsp;|&nbsp;
		                      到&nbsp;<input type="text" class="text-center" id="pageNo" size=4 style="text-align:right;"/> 页
		           <button class="btn btn-sm btn-success" onclick="doQuery(parseInt($('#pageNo').val()));"> 跳 转 </button>     
		  </div>
	      </c:if>
	      <c:if test="${empty page.pageContent}">
	        <div class="alert alert-danger text-center my-5 py-5 col-12 col-md-6 offset-md-3" role="alert">
			        没有任何符合条件的房间信息被查到！
			</div>	      
	      </c:if>		          
      </div>
   </div>
   <jsp:include page="../common/footer.jsp"></jsp:include>
   <!-- 删除房间模态窗 -->
   <div class="modal fade" id="removeRoomModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">操作提示</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <span id="message"></span>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" onclick="removeRoom()">确认删除</button>
	      </div>
	    </div>
	  </div>
	</div>   
</body>
</html>