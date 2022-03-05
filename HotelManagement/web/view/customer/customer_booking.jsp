<%-- 
    Document   : customer_booking
    Created on : Mar 4, 2022, 11:50:34 PM
    Author     : Duc Anh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<style>
    body {
        background-image: linear-gradient(to right, #7B1FA2, #E91E63)
    }

    .section {
        position: relative;
        height: 100vh
    }

    .section .section-center {
        position: absolute;
        top: 50%;
        left: 0;
        right: 0;
        -webkit-transform: translateY(-50%);
        transform: translateY(-50%)
    }

    #booking {
        font-family: 'Raleway', sans-serif
    }

    .booking-form {
        position: relative;
        max-width: 642px;
        width: 100%;
        margin: auto;
        padding: 40px;
        overflow: hidden;
        background-image: url('https://i.imgur.com/8z1tx3u.jpg');
        background-size: cover;
        border-radius: 5px;
        z-index: 20
    }

    .booking-form::before {
        content: '';
        position: absolute;
        left: 0;
        right: 0;
        bottom: 0;
        top: 0;
        background: rgba(0, 0, 0, 0.7);
        z-index: -1
    }

    .booking-form .form-header {
        text-align: center;
        position: relative;
        margin-bottom: 30px
    }

    .booking-form .form-header h1 {
        font-weight: 700;
        text-transform: capitalize;
        font-size: 42px;
        margin: 0px;
        color: #fff
    }

    .booking-form .form-group {
        position: relative;
        margin-bottom: 30px
    }

    .booking-form .form-control {
        background-color: rgba(255, 255, 255, 0.2);
        height: 60px;
        padding: 0px 25px;
        border: none;
        border-radius: 40px;
        color: #fff;
        -webkit-box-shadow: 0px 0px 0px 2px transparent;
        box-shadow: 0px 0px 0px 2px transparent;
        -webkit-transition: 0.2s;
        transition: 0.2s
    }

    .booking-form .form-control::-webkit-input-placeholder {
        color: rgba(255, 255, 255, 0.5)
    }

    .booking-form .form-control:-ms-input-placeholder {
        color: rgba(255, 255, 255, 0.5)
    }

    .booking-form .form-control::placeholder {
        color: rgba(255, 255, 255, 0.5)
    }

    .booking-form .form-control:focus {
        -webkit-box-shadow: 0px 0px 0px 2px #ff8846;
        box-shadow: 0px 0px 0px 2px #ff8846
    }

    .booking-form input[type="date"].form-control {
        padding-top: 16px
    }

    .booking-form input[type="date"].form-control:invalid {
        color: rgba(255, 255, 255, 0.5)
    }

    .booking-form input[type="date"].form-control+.form-label {
        opacity: 1;
        top: 10px
    }

    .booking-form select.form-control {
        -webkit-appearance: none;
        -moz-appearance: none;
        appearance: none
    }

    .booking-form select.form-control:invalid {
        color: rgba(255, 255, 255, 0.5)
    }

    .booking-form select.form-control+.select-arrow {
        position: absolute;
        right: 15px;
        top: 50%;
        -webkit-transform: translateY(-50%);
        transform: translateY(-50%);
        width: 32px;
        line-height: 32px;
        height: 32px;
        text-align: center;
        pointer-events: none;
        color: rgba(255, 255, 255, 0.5);
        font-size: 14px
    }

    .booking-form select.form-control+.select-arrow:after {
        content: '\279C';
        display: block;
        -webkit-transform: rotate(90deg);
        transform: rotate(90deg)
    }

    .booking-form select.form-control option {
        color: #000
    }

    .booking-form .form-label {
        position: absolute;
        top: -10px;
        left: 25px;
        opacity: 0;
        color: #ff8846;
        font-size: 11px;
        font-weight: 700;
        text-transform: uppercase;
        letter-spacing: 1.3px;
        height: 15px;
        line-height: 15px;
        -webkit-transition: 0.2s all;
        transition: 0.2s all
    }

    .booking-form .form-group.input-not-empty .form-control {
        padding-top: 16px
    }

    .booking-form .form-group.input-not-empty .form-label {
        opacity: 1;
        top: 10px
    }

    .booking-form .submit-btn {
        color: #fff;
        background-color: #e35e0a;
        font-weight: 700;
        height: 60px;
        padding: 10px 30px;
        width: 100%;
        border-radius: 40px;
        border: none;
        text-transform: uppercase;
        font-size: 16px;
        letter-spacing: 1.3px;
        -webkit-transition: 0.2s all;
        transition: 0.2s all
    }

    .booking-form .submit-btn:hover,
    .booking-form .submit-btn:focus {
        opacity: 0.9
    }
</style>
<div id="booking" class="section">
    <div class="section-center">
        <div class="container">
            <div class="row">
                <div class="booking-form">
                    <div class="form-header">
                        <h1>Mẫu đặt phòng</h1>
                    </div>
                    <div class="form-header" style="color: white;">
                        <p>Bạn đang đặt phòng: ${room.getRoomName()}</p>
                        <p>Thuộc loại phòng: ${room.getRoomType().getRoomTypeName()}</p>
                        <p>Có giá: ${room.getRoomType().getPrice()}</p>
                    </div>
                    <form action="../customer/booking" method="POST">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group"> <input name="checkIn" class="form-control" type="date" required> <span class="form-label">Check In</span> </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group"> <input name="checkOut" class="form-control" type="date" required> <span class="form-label">Check out</span> </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group"> <select class="form-control" required name="product">
                                        <option value="" selected hidden>Bạn có thể đặt sản phẩm</option>
                                        <c:forEach items="${list_p}" var="p">
                                            <option value="${p.getID()}">${p.getProductName()}</option>
                                        </c:forEach>
                                    </select> <span class="select-arrow"></span> <span class="form-label">Rooms</span> </div>
                            </div>
                        </div>
                        <div class="row" style="color: white;">
                            <div class="col-md-6">
                                <p>Số điện thoại đặt phòng: ${c.getPhone()}</p>
                            </div>
                            <div class="col-md-6">
                                <p>Email của bạn: ${c.getEmail()}</p>
                            </div>
                        </div>

                        <div class="form-btn"> <button class="submit-btn">Đặt phòng</button> </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
