<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../common/head.jsp" %>
<script type="text/javascript">

     var delHotelId=0;
    
     function showRemoveDlg(hotelid,hotelName){
    	 delHotelId = hotelid;
    	 $("#message").text("您确认要删除分店  ["+hotelName+"] 信息吗?");
    	 $('#removeHotelModal').modal('show');
     }
     
     function removeHotel(){
    	 document.forms[0].action+="/"+delHotelId;
    	 document.forms[0].submit();
     }
     
     function updateHotel(hotelid){
    	 location.href='<c:url value="/hotels"/>/'+hotelid;
     }

</script>
</head>
<body>
   <!-- 
     bootstrap container:  1) container  2)container-fluid(全屏幕，全宽度的容器)
    -->
   <form action="<c:url value="/hotels"/>" method="post">
       <input type="hidden" name="_method" value="DELETE"/>
   </form>
   <%@ include file="../common/menubar.jsp"%>
   <!-- 面包屑导航条 -->
   <nav aria-label="breadcrumb">
		  <ol class="breadcrumb" style="border-radius:0em">
		    <li class="breadcrumb-item">首页1</li>
		    <li class="breadcrumb-item">分店管理</li>
		    <li class="breadcrumb-item active">分店列表</li>
		  </ol>
   </nav>
   <div class="container-fluid">
      <div class="row">
          <table class="table">
			  <thead>
			    <tr>
			      <th scope="col">序号</th>
			      <th scope="col">分店名称</th>
			      <th scope="col">分店地址</th>
			      <th scope="col">分店电话</th>
			      <th scope="col">房间总数</th>
			      <th scope="col">操作</th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach var="hotel" items="${hotelList}">
			     <tr>
                  <td scope="row">${hotel.hotelId}</td>
			      <td>
				      <img style="margin-bottom:2px;" width="140" height="100" src="<c:url value="/hotels/${hotel.hotelId}/pic"/>">
				      <br>
				      ${hotel.hotelName}
			      </td>
			      <td>${hotel.hotelAddr}</td>
			      <td>${hotel.hotelPhone}</td>
 			      <td>${hotel.hotelRoomCount}</td>
			      <td>
			        <button class="btn btn-primary btn-sm" onclick="updateHotel(${hotel.hotelId})">修改</button>
			        <button class="btn btn-danger btn-sm" onclick="showRemoveDlg(${hotel.hotelId},'${hotel.hotelName}');">删除</button>
			      </td>
			     </tr>
			    </c:forEach>
			  </tbody>
	      </table>		          
      </div>
   </div>
   <!-- 删除分店模态窗 -->
   <div class="modal fade" id="removeHotelModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
	        <button type="button" class="btn btn-primary" onclick="removeHotel()">确认删除</button>
	      </div>
	    </div>
	  </div>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
	<%@ include file="../common/dialog.jsp" %>

</body>
</html>