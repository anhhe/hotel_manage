<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>roomtype-list</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="description" content="Flash Able Bootstrap admin template made using Bootstrap 4 and it has huge amount of ready made feature, UI components, pages which completely fulfills any dashboard needs." />
        <meta name="keywords"
              content="admin templates, bootstrap admin templates, bootstrap 4, dashboard, dashboard templets, sass admin templets, html admin templates, responsive, bootstrap admin templates free download,premium bootstrap admin templates, Flash Able, Flash Able bootstrap admin template">
        <meta name="author" content="Codedthemes" />

        <link rel="icon" href="../assets/images/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="../assets/fonts/fontawesome/css/fontawesome-all.min.css">
        <link rel="stylesheet" href="../assets/plugins/animation/css/animate.min.css">

        <link rel="stylesheet" href="../assets/css/style.css">
    </head>

    <body class="">
        <div class="loader-bg">
            <div class="loader-track">
                <div class="loader-fill"></div>
            </div>
        </div>

        <nav class="pcoded-navbar menupos-fixed menu-light brand-blue ">
            <div class="navbar-wrapper ">
                <div class="navbar-brand header-logo">
                    <a href="../admin/home" class="b-brand" style="color:white;">
                        HOTEL MANAGEMENT
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
                                <li class=""><a href="list" class="">Room Type</a></li>
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
                            <div class="input-group">
                                <form action="../roomtype/search" method="POST">
                                    <div class="row">
                                        <div>
                                            <input type="text" id="m-search" name="text_search" class="form-control" placeholder="Search for name">
                                        </div>
                                        <div>
                                            <span class="input-group-append search-btn btn btn-primary">
                                                <button type="submit" class="btn btn-primary" >Search</button>
                                            </span>
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li style="font-weight: bold;">HELLO: ${sessionScope.account.getDisplayName()}</li>
                    <li><a href="../logout" style="text-decoration: none;">Logout</a></li>
                </ul>
            </div>
        </header>

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
                                                    <h5>Room Type</h5>
                                                </div>
                                                <ul class="breadcrumb">
                                                    <li class="breadcrumb-item"><a href="../admin/home"><i class="feather icon-home"></i></a></li>
                                                    <li class="breadcrumb-item"><a href="list">Room Type Management</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div style="margin-bottom: 20px;">
                                    <button type="button" class="btn btn-primary">
                                        <a href="../roomtype/insert" style="text-decoration: none;color: white;">Insert</a></button>
                                </div>

                                <div class="col-xl-12 col-md-12">
                                    <div class="card table-card">
                                        <div class="card-header">
                                            <h5>List Room Type</h5>
                                        </div>
                                        <div class="card-body px-0 py-0">
                                            <div class="table-responsive" >
                                                <div class="session-scroll" style="height:478px;position:relative;">
                                                    <table class="table table-hover m-b-0">
                                                        <thead>
                                                            <tr>
                                                                <th><span>STT</span></th>
                                                                <th><span>Name</span></th>
                                                                <th><span>Number Of People</span></th>
                                                                <th><span>Cost</span></th>
                                                                <th><span>Description </span></th>
                                                                <th><span>Update</span></th>
                                                                <th><span>Delete</span></th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach items="${list_roomtype}" var="rt" varStatus="status">
                                                                <tr>
                                                                    <td>${status.count}</td>
                                                                    <td>${rt.getRoomTypeName()}</td>
                                                                    <td>${rt.getNumberOfPeople() == 0 ? "dành cho nhiều người":rt.getNumberOfPeople()}</td>
                                                                    <td>${rt.getPrice()} (VNĐ)</td>
                                                                    <td>${rt.getDescription()}</td> 
                                                                    <td><button type="button" class="btn btn-primary"><a style="text-decoration: none;color: white;" href="../roomtype/update?roomtypeID=${rt.getID()}">Update</a></button></td> 
                                                                    <td><button type="button" class="btn btn-danger"><a style="text-decoration: none;color: white;" href="../roomtype/delete?roomtypeID=${rt.getID()}">Delete</a></button></td> 
                                                                </tr>
                                                            </c:forEach>


                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
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
