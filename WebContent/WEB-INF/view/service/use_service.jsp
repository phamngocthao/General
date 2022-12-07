<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<div class="row mt-5 w-50">
                <div class="col-12 text-center">
                    <h3>Đăng ký sử dụng dịch vụ</h3>
                </div>
           <form:form action="service/use-service" modelAttribute="useService" class="row" method="POST">     
                <div class="col-12">
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Mã khách hàng</label>
                        <form:select path="customer.customerId" class="form-control" id="exampleFormControlSelect1">
                            <form:options items="${customers}"/>
                        </form:select>
                    </div>
                </div>
                <div class="col-12">
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Mã dịch vụ</label>
                        <form:select path="service.serviceId" class="form-control" id="exampleFormControlSelect1">
                            <form:options items="${services}"/>
                        </form:select>
                    </div>
                </div>
                <div class="col-12">
                    <div class="form-group">
                        <form:label path="dateUseService">Ngày sử dụng</form:label>
                        <form:input path="dateUseService" type="date" class="form-control" />
                        
                    </div>
                </div>
                <div class="col-12">
                    <div class="form-group">
                        <form:label path="timeUseService">Giờ sử dụng</form:label>
                        <form:input path="timeUseService" type="time" class="form-control" aria-describedby="helpId"/>
                        
                    </div>
                </div>
                <div class="col-12">
                    <div class="form-group">
                        <form:label path="quantity">Số lượng</form:label>
                        <form:input path="quantity" type="input" class="form-control" aria-describedby="helpId" placeholder="Số lượng"/>
                       
                    </div>
                </div>
                <div class="col-12">
                    <button id="" class="btn btn-primary mt-2" role="button">Thêm mới</button>
                    <a name="" id="" class="btn btn-success mt-2" href="#" role="button">Quay lại</a>
                </div>
           </form:form>
</div>