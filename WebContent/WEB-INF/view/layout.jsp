<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${page.title}</title>
<base href="/general/">
<jsp:include page="./common/style/css.jsp" />  
</head>
<body>


	<div class="container-fluid main-section">
		<jsp:include page="./common/header.jsp"></jsp:include>
		<div class="row justify-content-center" style="min-height: 600px;">
			<jsp:include page="./${page.content }"></jsp:include>
		</div>
		<jsp:include page="./common/footer.jsp"></jsp:include>
	</div>
	
	<jsp:include page="./common/style/script.jsp" />
        
        
     <c:if test="${page.javaScript != null }">
     		<jsp:include page="./common/script/${page.javaScript}" />
     </c:if>   
        
    <c:if test="${success != null }">
  		<script type="text/javascript">
		Swal.fire({
			  position: 'top-end',
			  icon: 'success',
			  title: 'Thành công !!!',
			  showConfirmButton: false,
			  timer: 1500
			})
		</script>
  	</c:if>
  	<c:if test="${error != null }">
		<script type="text/javascript">
		Swal.fire({
			  position: 'top-end',
			  icon: 'error',
			  title: 'Có lỗi xảy ra !!!',
			  showConfirmButton: false,
			  timer: 1500
			})
		</script>
	</c:if>
</body>
</html>