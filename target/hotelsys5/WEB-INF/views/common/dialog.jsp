<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<c:if test="${not empty errMsg}">
	<!-- 提示框 -->
	<div class="modal fade" id="messageModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">操作提示</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <span id="promptMsg"></span>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" data-dismiss="modal"> 确 定 </button>
	      </div>
	    </div>
	  </div>
	</div> 

	<script type="text/javascript">
	    $("#promptMsg").html('${errMsg}');
	    $('#messageModal').modal('show');
	</script>

	</c:if>
    <%
	   session.removeAttribute("errMsg");
    %>