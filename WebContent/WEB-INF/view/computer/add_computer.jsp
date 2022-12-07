<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<div class="row mt-5 w-50">
         
   		<div class="col-12 text-center">
       			<h3>${computer.computerId == '' || computer.computerId == null ? 'Thêm mới máy' : 'Chỉnh sửa máy'}</h3>
  		</div>

         <form:form action="computer/add-computer" method="POST" class="row" modelAttribute="computer">
		       	<div class="col-12">
		           <div class="form-group">
		               <form:label path="computerId">Mã máy</form:label>
		               <form:input path="computerId" type="text" class="form-control" aria-describedby="helpId" placeholder="Mã máy"/>
		               <form:errors path="computerId" class="form-text text-muted" />	
		           </div>
		       </div>
		       <div class="col-12">
		           <div class="form-group">
		               <form:label path="location">Vị trí</form:label>
		               <form:input type="text" class="form-control" path="location" aria-describedby="helpId" placeholder="Vị trí"/>
		              	<form:errors path="location" class="form-text text-muted" />
		           </div>
		       </div>
		       <div class="col-12">
		           <label for="">Trạng thái</label>
		           <div class="form-group">
		               <div class="form-check form-check-inline">
		                   <form:radiobutton class="form-check-input" path="status" value="0"/>
		                   <form:label class="form-check-label" path="status">Rảnh</form:label>
		               </div>
		               <div class="form-check form-check-inline">
		                   <form:radiobutton class="form-check-input" path="status" value="1"/>
		                   <form:label class="form-check-label" path="status">Đang sử dụng</form:label>
		               </div>
		               <div class="form-check form-check-inline">
		              <form:radiobutton class="form-check-input" path="status" value="2"/> 
		                   <form:label class="form-check-label" path="status">Bảo trì</form:label>
		               </div>
		               <form:errors path="status" class="form-text text-muted" />
		           </div>
		
		       </div>
		       <div class="col-12">
		           <form:button type="submit" class="btn btn-primary mt-2" role="button">Lưu</form:button>
		           <a name="" id="" class="btn btn-success mt-2" href="computer/list-computer" role="button">Quay lại</a>
			   </div>
         </form:form>
</div>