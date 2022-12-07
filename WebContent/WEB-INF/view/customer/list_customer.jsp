<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<div class="col-12 mt-5 w-75">
                <div class="col-12 text-center">
                    <h3>Danh sách khách hàng</h3>
                </div>
                <div class="col-4" style="left: 65%;">
                    <form class="d-flex" method="get">
                        <input class="form-control me-2" type="search" name="search" value="${pagination.search }" placeholder="Search"
                            aria-label="Search">
                        <button class="btn btn-outline-success ml-2" type="submit">Search</button>
                    </form>
                </div>
                <div class="col-12 mt-2 table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Mã khách hàng</th>
                                <th>Tên khách hàng</th>
                                <th>Địa chỉ</th>
                                <th>Số điện thoại</th>
                                <th>Email</th>
                                <th>Hành động</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach items="${pagination.object}" var="customer">
                        		<tr>
	                               <td scope="row">${customer.customerId}</td>
	                               <td>${customer.name}</td>
	                               <td>${customer.address }</td>
	                               <td>${customer.phone }</td>
	                               <td>${customer.email }</td>
	                               <td>
	                                   <a id="" class="btn btn-success" href="customer/edit-customer/${customer.customerId}" role="button">Chỉnh sửa</a>
	                                   <a name="" id="" class="btn btn-danger" onclick="openModalConfirmDelete('${customer.customerId}')" role="button">Xóa</a>
	                               </td>
                            	</tr>
                        	</c:forEach>
                            

                        </tbody>
                    </table>
                </div>
                <div class="col-12 mt-5">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                            <li class="page-item">
                                <c:if test="${pagination.index > 1 }">
                                	<c:choose>
		                               	<c:when test="${pagination.search == '' }">                                		
			                                <a class="page-link" href="customer/list-customer?page=${pagination.index-1}">Trước</a>
		                               	</c:when>
		                               	<c:when test="${pagination.search != '' }">
		                               		<a class="page-link" href="customer/list-customer?page=${pagination.index-1}&search=${pagination.search}">Trước</a>
		                               	</c:when>
                                	</c:choose>
                                </c:if>
                            </li>
                            <c:forEach begin="1" end="${pagination.totalPage}" var="i">
                            	<c:choose>
                            		<c:when test="${i == pagination.index }">
                            			<li class="page-item active"><a class="page-link">${i}</a></li>
                            		</c:when>
                            		<c:when test="${pagination.search == '' }">
                            			<li class="page-item"><a class="page-link" href="customer/list-customer?page=${i}">${i}</a></li>	
                            		</c:when>
                            		<c:when test="${pagination.search != ''}">
                            			<li class="page-item"><a class="page-link" href="customer/list-customer?page=${i}&search=${pagination.search}">${i}</a></li>
                            		</c:when>
                            		<c:otherwise>
                            			<li class="page-item"><a class="page-link" href="customer/list-customer?page=${i}">${i}</a></li>
                            		</c:otherwise>
                            	</c:choose>
                            </c:forEach>     
                            <li class="page-item">  
                                <c:if test="${pagination.index < pagination.totalPage }">
                                	<c:choose>
		                               	<c:when test="${pagination.search == '' }">                                		
			                                <a class="page-link" href="customer/list-customer?page=${pagination.index+1}">Sau</a>
		                               	</c:when>
		                               	<c:when test="${pagination.search != '' }">
		                               		<a class="page-link" href="customer/list-customer?page=${pagination.index+1}&search=${pagination.search}">Sau</a>
		                               	</c:when>
                                	</c:choose>
                                </c:if>
                            </li>
                        </ul>
                    </nav>
                </div>
</div>