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

    .buttons_added {
        opacity:1;
        display:inline-block;
        display:-ms-inline-flexbox;
        display:inline-flex;
        white-space:nowrap;
        vertical-align:top;
    }
    .is-form {
        overflow:hidden;
        position:relative;
        background-color:#f9f9f9;
        height:2.2rem;
        width:1.9rem;
        padding:0;
        text-shadow:1px 1px 1px #fff;
        border:1px solid #ddd;
    }
    .is-form:focus,.input-text:focus {
        outline:none;
    }
    .is-form.minus {
        border-radius:4px 0 0 4px;
    }
    .is-form.plus {
        border-radius:0 4px 4px 0;
    }
    .input-qty {
        background-color:#fff;
        height:2.2rem;
        text-align:center;
        font-size:1rem;
        display:inline-block;
        vertical-align:top;
        margin:0;
        border-top:1px solid #ddd;
        border-bottom:1px solid #ddd;
        border-left:0;
        border-right:0;
        padding:0;
    }
    .input-qty::-webkit-outer-spin-button,.input-qty::-webkit-inner-spin-button {
        -webkit-appearance:none;
        margin:0;
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
                        <input type="hidden" name="customerID" value="${c.getId()}" />
                        <input type="hidden" name="roomID" value="${room.getID()}" />
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group"> <input name="checkIn" class="form-control" type="date" required> <span class="form-label">Check In</span> </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group"> <input name="checkOut" class="form-control" type="date" required> <span class="form-label">Check out</span> </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12" >
                                <p style="
                                   color: white;">Nếu bạn muốn order đồ ăn hãy ấn tại đây</p><input type="button" id="btn2" value="Hiển thị menu"/>
                                <div id="temp" style="display: none;color: white;">
                                    <c:forEach items="${list_p}" var="p">
                                        <div class="col-md-12">
                                            <input type="checkbox" name="product" value="${p.getID()}" />${p.getProductName()}
                                            | ${p.getCost()}
                                            <div class="buttons_added ">
                                                <input class="minus is-form" type="button" value="-">
                                                <input aria-label="quantity" class="input-qty" max="${p.getQuantity()}" min="0" name="quantity_product${p.getID()}" type="number" value="">
                                                <input class="plus is-form" type="button" value="+">
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <input type="button" id="btn1" value="Order" style="visibility: hidden;margin-top: 20px;"/>
                        <div class="row" style="color: white;margin-top: 20px;">
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
<script language="javascript">

    document.getElementById("btn1").onclick = function () {
        document.getElementById("temp").style.display = 'none';
        document.getElementById("btn1").style.visibility = 'hidden';
        document.getElementById("btn2").style.visibility = 'visible';
    };

    document.getElementById("btn2").onclick = function () {
        document.getElementById("temp").style.display = 'block';
        document.getElementById("btn2").style.visibility = 'hidden';
        document.getElementById("btn1").style.visibility = 'visible';
    };

    $('input.input-qty').each(function () {
        var $this = $(this),
                qty = $this.parent().find('.is-form'),
                min = Number($this.attr('min')),
                max = Number($this.attr('max'))
        if (min == 0) {
            var d = 0
        } else
            d = min
        $(qty).on('click', function () {
            if ($(this).hasClass('minus')) {
                if (d > min)
                    d += -1
            } else if ($(this).hasClass('plus')) {
                var x = Number($this.val()) + 1
                if (x <= max)
                    d += 1
            }
            $this.attr('value', d).val(d)
        })
    })

</script>

