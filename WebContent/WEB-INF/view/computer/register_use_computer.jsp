<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<div class="row mt-5 w-50">
                <div class="col-12 text-center">
                    <h3>Đăng ký sử dụng máy</h3>
                </div>
         <form:form action="computer/use-computer" class="row" method="POST" modelAttribute="useComputer">       
                <div class="col-12">
                    <div class="form-group">
                        <form:label path="customer.customerId" for="exampleFormControlSelect1">Mã khách hàng</form:label>
                        <form:select path="customer.customerId" class="form-control" id="exampleFormControlSelect1">
                            <form:options items="${customers}"/>
                        </form:select>
                    </div>
                </div>
                <div class="col-12">
                    <div class="form-group">
                        <form:label path="computer.computerId" for="exampleFormControlSelect1">Mã máy</form:label>
                        <form:select path="computer.computerId" class="form-control" id="exampleFormControlSelect1">
                            <form:options items="${computers}"/>
                        </form:select>
                    </div>
                </div>
                <div class="col-12">
                    <div class="form-group">
                        <form:label path="dateStartUse">Ngày bắt đầu sử dụng</form:label>
                        <form:input path="dateStartUse" type="date" class="form-control" />
                       
                    </div>
                </div>
                <div class="col-12">
                    <div class="form-group">
                        <form:label path="timeStartUse">Giờ bắt đầu sử dụng</form:label>
                        <form:input path="timeStartUse" type="time" class="form-control" />
                        
                    </div>
                </div>
                <div class="col-12">
                    <div class="form-group">
                        <form:label path="timeUse">Thời gian sử dụng</form:label>
                        <form:input path="timeUse" type="input" class="form-control" />
                        
                    </div>
                </div>
                <div class="col-12">
                    <button type="submit" class="btn btn-primary mt-2" role="button">Thêm mới</button>
                    <a name="" id="" class="btn btn-success mt-2" href="#" role="button">Quay lại</a>
                </div>
          </form:form>
</div>