<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<div class="row mt-5 w-75">
                <div class="col-12 text-center mb-4">
                    <h3>Thêm mới dịch vụ</h3>
                </div>
           <form:form action="service/add-service" class="row" method="POST" modelAttribute="service">     
                <div class="col-6">
                    <div class="form-group">
                        <form:label path="serviceId">Mã dịch vụ</form:label>
                        <form:input path="serviceId" type="text" class="form-control" placeholder="Mã dịch vụ"/>
                        <form:errors path="serviceId" class="form-text text-muted"></form:errors>
                    </div>
                </div>
                <div class="col-6">
                    <div class="form-group">
                        <form:label path="serviceName">Tên dịch vụ</form:label>
                        <form:input path="serviceName" type="text" class="form-control" placeholder="Tên dịch vụ"/>
                        <form:errors path="serviceName" class="form-text text-muted"></form:errors>
                    </div>
                </div>
                <div class="col-12">
                    <div class="form-group">
                        <form:label path="serviceUnit">Đơn vị tính</form:label>
                        <form:select path="serviceUnit" class="form-control" id="exampleFormControlSelect1">
                            <form:options items="${units}"/>
                        </form:select>
                        <form:errors path="serviceUnit" class="form-text text-muted"></form:errors>
                    </div>
                </div>
                
                <div class="col-12">
                    <div class="form-group">
                        <form:label path="price">Đơn giá</form:label>
                        <form:input path="price" type="text" class="form-control" placeholder="Đơn giá"/>
                         <form:errors path="price" class="form-text text-muted"></form:errors>
                    </div>
                </div>
                
                <div class="col-12">
                    <button type="submit" class="btn btn-primary mt-2" role="button">Lưu</button>
                    <a name="" id="" class="btn btn-success mt-2" href="#" role="button">Quay lại</a>
                </div>
           </form:form>
</div>