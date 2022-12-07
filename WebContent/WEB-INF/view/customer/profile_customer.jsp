<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<div class="col-12 mt-5 w-75">
                <div class="col-12 text-center">
                    <h3>Danh sách khách hàng</h3>
                </div>
                <div class="col-4 mt-4" style="left: 65%;">
                    <form class="d-flex" method="get">
                        <input class="form-control me-2" type="search" name="search" placeholder="Search"
                            aria-label="Search">
                        <button class="btn btn-outline-success ml-2" type="submit">Search</button>
                    </form>
                </div>
                <div class="col-12 mt-2 table-responsive">
                    <table class="table text-center" style="min-width: 2000px;">
                        <thead>
                            <tr>
                                <th scope="col">Mã khách hàng</th>
                                <th>Tên khách hàng</th>
                                <th>Vị trí</th>
                                <th>Trạng thái</th>
                                <th>Ngày bắt đầu sử dụng máy</th>
                                <th>Giờ bắt đầu sử dụng máy</th>
                                <th>Thời gian sử dụng máy</th>
                                <th>Mã dịch vụ</th>
                                <th>Ngày sử dụng dịch vụ</th>
                                <th>Giờ sử dụng dịch vụ</th>
                                <th>Số lượng</th>
                                <th>Tổng tiền</th>
                                <th>Hành động</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pagination.object}" var="customer">
                        	<tr>
                                <td scope="row">${customer.customerId }</td>
                                <td>${customer.customerName }</td>
                                <td>${customer.locationComputer }</td>
                               <%--  <c:choose >
                                	<c:when test="${customer.statusComputer == 0}">
                                		<td>Rảnh</td>
                                	</c:when>
                                	<c:when test="${customer.statusComputer == 1}">
                                		<td>Đang sử dụng</td>
                                	</c:when>
                                	<c:when test="${customer.statusComputer == 2}">
                                		<td>Đang bảo trì</td>
                                	</c:when>
                                </c:choose> --%>
                                <td>${customer.statusComputer}</td>
                                <td>${customer.dateStartUseComputer }</td>
                                <td>${customer.timeStartUseComputer }</td>
                                <td>${customer.timeUseComputer } phút</td>
                                <td>${customer.serviceId }</td>
                                <td>${customer.dateUseService }</td>
                                <td>${customer.timeUseService }</td>
                                <td>${customer.quantity }</td>
                                <td>${customer.totalMoney }VNĐ</td>
                                <td>
                                    <a name="" id="" class="btn btn-success" href="#" role="button">Chỉnh sửa</a>
                                    <a name="" id="" class="btn btn-danger" href="#" role="button">Xóa</a>
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
                                                             		
			                        <a class="page-link" href="customer/profile-customer?page=${pagination.index-1}">Trước</a>
		                               	
                                </c:if>
                            </li>
                            <c:forEach begin="1" end="${pagination.totalPage}" var="i">
                            	<c:choose>
                            		<c:when test="${i == pagination.index }">
                            			<li class="page-item active"><a class="page-link">${i}</a></li>
                            		</c:when>
                            		<c:otherwise>
                            			<li class="page-item"><a class="page-link" href="customer/profile-customer?page=${i}">${i}</a></li>
                            		</c:otherwise>
                            	</c:choose>
                            </c:forEach>     
                            <li class="page-item">  
                                <c:if test="${pagination.index < pagination.totalPage }">
                                	                           		
			                         <a class="page-link" href="customer/profile-customer?page=${pagination.index+1}">Sau</a>
		                               	
                                </c:if>
                            </li>
                        </ul>
                    </nav>
                </div>
</div>