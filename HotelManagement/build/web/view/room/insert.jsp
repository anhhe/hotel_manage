<%@page import="model.Room"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>room-list</title>
        <!-- HTML5 Shim and Respond.js IE11 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 11]>
                <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
                <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
                <![endif]-->
        <!-- Meta -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="description" content="Flash Able Bootstrap admin template made using Bootstrap 4 and it has huge amount of ready made feature, UI components, pages which completely fulfills any dashboard needs." />
        <meta name="keywords"
              content="admin templates, bootstrap admin templates, bootstrap 4, dashboard, dashboard templets, sass admin templets, html admin templates, responsive, bootstrap admin templates free download,premium bootstrap admin templates, Flash Able, Flash Able bootstrap admin template">
        <meta name="author" content="Codedthemes" />

        <!-- Favicon icon -->
        <link rel="icon" href="../assets/images/favicon.ico" type="image/x-icon">
        <!-- fontawesome icon -->
        <link rel="stylesheet" href="../assets/fonts/fontawesome/css/fontawesome-all.min.css">
        <!-- animation css -->
        <link rel="stylesheet" href="../assets/plugins/animation/css/animate.min.css">

        <!-- vendor css -->
        <link rel="stylesheet" href="../assets/css/style.css">
        
    </head>

    <body class="">
        <!-- [ Pre-loader ] start -->
        <div class="loader-bg">
            <div class="loader-track">
                <div class="loader-fill"></div>
            </div>
        </div>
        <!-- [ Pre-loader ] End -->

        <!-- [ navigation menu ] start -->
        <nav class="pcoded-navbar menupos-fixed menu-light brand-blue ">
            <div class="navbar-wrapper ">
                <div class="navbar-brand header-logo">
                    <a href="../admin/home" class="b-brand" style="color:white;">
                        HOTEL MANAGEMENT
                        <!--<img src="../assets/images/logo_holiday.jpeg" alt="" class="logo images">
                        <img src="../assets/images/logo_holiday.jpeg" alt="" class="logo-thumb images" >-->
                    </a>
                    <a class="mobile-menu" id="mobile-collapse" href="#!"><span></span></a>
                </div>
                <div class="navbar-content scroll-div">
                    <ul class="nav pcoded-inner-navbar">
                        <li class="nav-item pcoded-menu-caption">
                            <label>Navigation</label>
                        </li>
                        <li class="nav-item">
                            <a href="../admin/home" class="nav-link"><span class="pcoded-micon"><i class="feather icon-home"></i></span><span class="pcoded-mtext">Dashboard</span></a>
                        </li>
                        <li class="nav-item pcoded-menu-caption">
                            <label>UI Element</label>
                        </li>
                        <li class="nav-item pcoded-hasmenu">
                            <a href="#!" class="nav-link"><span class="pcoded-micon"><i class="feather icon-box"></i></span><span class="pcoded-mtext">Componant</span></a>
                            <ul class="pcoded-submenu">
                                <li class=""><a href="../roomtype/list" class="">Room Type</a></li>
                                <li class=""><a href="../room/list" class="">Room</a></li>
                                <li class=""><a href="../producttype/list" class="">Product Type</a></li>
                                <li class=""><a href="../ListProductController" class="">Product</a></li>
                                <li class=""><a href="../employeetype/list" class="">Employee Type</a></li>
                                <li class=""><a href="../employee/list" class="">Employee</a></li>
                                <li class=""><a href="../customer/list" class="">Customer</a></li>
                                <li class=""><a href="../payment/list" class="">Payment Manage</a></li>

                            </ul>
                        </li>

                </div>
            </div>
        </nav>
        <!-- [ navigation menu ] end -->

        <!-- [ Header ] start -->
        <header class="navbar pcoded-header navbar-expand-lg navbar-light headerpos-fixed">
            <div class="m-header">
                <a class="mobile-menu" id="mobile-collapse1" href="#!"><span></span></a>
                <a href="index.html" class="b-brand">
                    <img src="../assets/images/logo.svg" alt="" class="logo images">
                    <img src="../assets/images/logo-icon.svg" alt="" class="logo-thumb images">
                </a>
            </div>
            <a class="mobile-menu" id="mobile-header" href="#!">
                <i class="feather icon-more-horizontal"></i>
            </a>
            <div class="collapse navbar-collapse">
                <a href="#!" class="mob-toggler"></a>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <div class="main-search open">
                            
                        </div>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li style="font-weight: bold;">HELLO: ${sessionScope.account.getDisplayName()}</li>
                    <li><a href="../logout" style="text-decoration: none;">Logout</a></li>
                </ul>
            </div>
        </header>
        <!-- [ Header ] end -->

        <!-- [ Main Content ] start -->
        <div class="pcoded-main-container">
            <div class="pcoded-wrapper">
                <div class="pcoded-content">
                    <div class="pcoded-inner-content">
                        <div class="main-body">
                            <div class="page-wrapper">
                                <!-- [ breadcrumb ] start -->
                                <div class="page-header">
                                    <div class="page-block">
                                        <div class="row align-items-center">
                                            <div class="col-md-12">
                                                <div class="page-header-title">
                                                    <h5>Room</h5>
                                                </div>
                                                <ul class="breadcrumb">
                                                    <li class="breadcrumb-item"><a href="../admin/home"><i class="feather icon-home"></i></a></li>
                                                    <li class="breadcrumb-item"><a href="list">Room Management</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-xl-12 col-md-12" >
                                    <form action="insert" method="POST">
                                        <table class="table table-striped" style="border: 1px solid black;">
                                            <tr>
                                                <th scope="row">Room Name: </th>
                                                <td><input style="border: 1px solid black;" name="name" type="text" class="form-control" placeholder="Room name" aria-describedby="basic-addon1"></td>
                                            </tr>
                                            <tr>
                                                <th scope="row">Room Type: </th>
                                                <td>
                                                    <select name="roomtype">
                                                        <c:forEach items="${list}" var="rt">
                                                            <option value="${rt.getID()}" }>${rt.getRoomTypeName()}</option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th scope="row">Room Type: </th>
                                                <td>
                                                    <select name="status">
                                                        <option value="true"}>Con phong</option>
                                                        <option value="false"}>Het phong</option>
                                                    </select>
                                                </td>
                                            </tr>
                                        </table>
                                        <button type="submit" class="btn btn-primary">Insert</button>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="../assets/js/vendor-all.min.js"></script>
        <script src="../assets/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="../assets/js/pcoded.min.js"></script>

    </body>

</html>
