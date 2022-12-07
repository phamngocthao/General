<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Trang chủ</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <jsp:include page="../common/style/css.jsp" />  
</head>

<body>

   <div class="container-fluid main-section">
		<jsp:include page="../common/header.jsp"></jsp:include>
		<div class="row justify-content-center" style="min-height: 600px;">
            <div class="row mt-5 w-75">
                <img src="https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/5eeea355389655.59822ff824b72.gif" alt="Lỗi rồi">
            </div>
        </div>
        
        <jsp:include page="../common/footer.jsp"></jsp:include>
    </div>
	<jsp:include page="../common/style/script.jsp" />
</body>

</html>