<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./taglibs.jsp" %>

<script type="text/javascript">
  
  function showQuitDlg(){
      
	  $("#exitMsg").html("尊敬的${loginedUser.userName},您确认要退出系统吗?");
	  $("#exitModal").modal('show');
	  
  }
  
  
  function logout(){
	  location.href="<c:url value='/logout'/>";
  }
  
</script>


   <nav class="navbar navbar-expand-md navbar-light bg-light">
       <a class="navbar-brand" href="#"><b>酒店房间管理系统</b></a>
       <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
	   </button>
	   <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav mr-auto">
	          <li class="nav-item active">
		        <a class="nav-link" href="/hotelsys/securityMgr?task=main">首页</a>
		      </li>
              <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		                       分店管理
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">          		          
		          <a class="dropdown-item" href="<c:url value="/hotels/input"/>">新开分店</a>
		          <a class="dropdown-item" href='<c:url value="/hotels"/>'>分店列表</a>
		        </div>
		      </li>	
		      <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		                      房间管理
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item" href="<c:url value="/rooms/input"/>">房间登记</a>
		          <a class="dropdown-item" href="<c:url value="/rooms"/>">房间列表</a>
		        </div>
		      </li>
		      <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		                        系统维护           
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item" href="#">操作员管理</a>
		        </div>
		      </li>			      
		  </ul>
		  <ul class="navbar-nav ml-auto">
		       <li class="nav-item">
		           <a class="nav-link">
		             <i class="fas fa-user" style="color:deeppink"></i> &nbsp;${loginedUser.userName}
		           </a>
		       </li>
               <li class="nav-item">
		        <a class="nav-link" href="javascript:showQuitDlg();">退出系统</a>
		      </li>		       
		   </ul>
	   </div> 
   </nav>
   
 <div class="fade modal" id="exitModal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">系统操作</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p id="exitMsg"></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" onclick="logout()">确定</button>
      </div>
    </div>
  </div>
</div>