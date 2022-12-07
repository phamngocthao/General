<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Trang chủ</a>
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                aria-label="Toggle navigation"></button>
            <c:if test="${sessionScope['account'] != null }">
            	<div class="collapse navbar-collapse" id="collapsibleNavId">
	                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
	                	<li class="nav-item dropdown">
	                        <a class="nav-link dropdown-toggle" href="#" id="customer" data-toggle="dropdown"
	                            aria-haspopup="true" aria-expanded="false">Khách hàng</a>
	                        <div class="dropdown-menu" aria-labelledby="customer">
	                            <a class="dropdown-item" href="customer/add-customer">Thêm mới khách hàng</a>
	                            <a class="dropdown-item" href="customer/list-customer">Danh sách khách hàng</a>
	                            <a class="dropdown-item" href="customer/profile-customer">Thông tin khách hàng</a>
	                        </div>
	                    </li>
	                    <li class="nav-item dropdown">
	                        <a class="nav-link dropdown-toggle" href="#" id="computer" data-toggle="dropdown"
	                            aria-haspopup="true" aria-expanded="false">Máy tính</a>
	                        <div class="dropdown-menu" aria-labelledby="computer">
	                            <a class="dropdown-item" href="computer/use-computer">Đăng ký dùng máy</a>
	                            <a class="dropdown-item" href="computer/add-computer">Thêm mới máy</a>
	                            <a class="dropdown-item" href="computer/list-computer">Danh sách máy</a>
	                        </div>
	                    </li>
	                    <li class="nav-item dropdown">
	                        <a class="nav-link dropdown-toggle" href="#" id="service" data-toggle="dropdown"
	                            aria-haspopup="true" aria-expanded="false">Dịch vụ</a>
	                        <div class="dropdown-menu" aria-labelledby="service">
	                            <a class="dropdown-item" href="service/use-service">Đăng ký dịch vụ</a>
	                            <a class="dropdown-item" href="service/add-service">Thêm mới dịch vụ</a>
	                            <a class="dropdown-item" href="service/list-service">Danh sách dịch vụ</a>
	                        </div>
	                    </li>
	                    
	                </ul>
	                <ul class="navbar-nav mt-2 mt-lg-0">
	                    <li class="nav-item dropdown">
	                        <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" aria-haspopup="true"
	                            aria-expanded="false">Xin chào <strong class="text-white">${sessionScope['account'].username }</strong></a>
	                        <div class="dropdown-menu" aria-labelledby="dropdownId">
	                            <a class="dropdown-item" href="/general/account/logout">Đăng xuất</a>
	                        </div>
	                    </li>
	                </ul>
                
            	</div>
            </c:if>
            <c:if test="${sessionScope['account'] == null }">
                	<div>
                		<a class="nav-link text-white float-right" href="/general/account/login">Đăng nhập</a>
            		</div>
            </c:if>
            
</nav>