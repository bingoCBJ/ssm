<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.min.css"></link>
<link rel="stylesheet" href="../css/bootstrap-theme.min.css"></link>
</head>
<body>
	<p>用户：${username }</p>
	<p>密码:${password }</p>
	<a class="btn btn-primary" href="/myssm/html/mymap.html">地图</a>
	<a class="btn btn-primary" href="/myssm/html/fileupload.html">上传文件</a>
	
	<!-- Button trigger modal 模态框 -->
	<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
	  上传个人头像
	</button>
	
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
	      </div>
	      <div class="modal-body">
<!-- 上传开始 -->
    
<!-- 上传结束 -->
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Save changes</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- 模态框结束 -->
	
	<!-- JavaScript is here -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="../js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/md5.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		alert("载入页面");
		/* $('#myModal').on('shown.bs.modal', function () {
			  $('#myInput').focus()
			}); */
	});
	
	
	</script>
</body>
</html>