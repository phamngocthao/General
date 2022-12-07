<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<div class="row mt-5 w-75">
                <div class="col-12 text-center mb-4">
                    <h3>Khách hàng</h3>
                </div>
            <form:form action="customer/add-customer" class="row" method="POST" modelAttribute="customer">   
                <div class="col-6">
                    <div class="form-group">
                        <form:label path="customerId">Mã khách hàng</form:label>
                        <form:input path="customerId" type="text" class="form-control" placeholder="Mã khách hàng" />
                        <form:errors path="customerId" class="form-text text-muted" />
                    </div>
                </div>
                <div class="col-6">
                    <div class="form-group">
                        <form:label path="name">Tên khách hàng</form:label>
                        <form:input path="name" type="text" class="form-control" placeholder="Tên khách hàng" />
                        <form:errors path="name" class="form-text text-muted" />
                    </div>
                </div>
                <div class="col-6">
                    <div class="form-group">
                        <form:label path="phone">Số điện thoại</form:label>
                        <form:input path="phone" type="text" class="form-control" placeholder="Số điện thoại" />
                        <form:errors path="phone" class="form-text text-muted" />
                    </div>
                </div>
                <div class="col-6">
                    <div class="form-group">
                        <form:label path="email">Địa chỉ email</form:label>
                        <form:input path="email" type="text" class="form-control" placeholder="Địa chỉ email"/>
                        <form:errors path="email" class="form-text text-muted" />
                    </div>
                </div>
                <div class="col-12">
                    <div class="form-group">
                        <form:label path="address">Địa chỉ</form:label>
                        <form:input path="address" type="text" class="form-control" placeholder="Địa chỉ"/>
                        <form:errors path="address" class="form-text text-muted" />
                    </div>
                </div>
                <div class="col-12">
                    <button class="btn btn-primary mt-2" role="button">Lưu</button>
                    <a id="" class="btn btn-success mt-2" href="customer/list-customer" role="button">Quay lại</a>
                </div>
           </form:form>     
</div>