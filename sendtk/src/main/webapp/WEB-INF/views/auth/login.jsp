<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%-- <sec:authorize access="isAuthenticated()" url="/sendtk/Auth/login?logout"> --%>
<%

%>	
<%-- </sec:authorize> --%>

<!DOCTYPE html>
<html>
    
<!-- Mirrored from themes-lab.com/make/admin/layout1/user-login-v1.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 09 Jun 2015 15:10:52 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
<head>
        <meta charset="utf-8">
        <title>Themes Lab - Creative Laborator</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta content="" name="description" />
        <meta content="themes-lab" name="author" />
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/global/images/favicon.png">
        <link href="${pageContext.request.contextPath}/assets/global/css/style.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/assets/global/css/ui.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-loading/lada.min.css" rel="stylesheet">
    </head>
    <body class="account separate-inputs" data-page="login">
        <!-- BEGIN LOGIN BOX -->
        <div class="container" id="login-block">
            <div class="row">
                <div class="col-sm-6 col-md-4 col-md-offset-4">
                    <div class="account-wall">
                        <i class="user-img icons-faces-users-03"></i>
                        <form class="form-signin"  role="form" method="post" action ="${pageContext.request.contextPath}/Auth/Validate">
                            <div class="append-icon">
                                <input type="text" name="username" id="username" class="form-control form-white username" 
                                	placeholder="Username" required>
                                <i class="icon-user"></i>
                            </div> 
                            <div class="append-icon ">
                                <input type="password" name="password" id="password" class="form-control form-white password" placeholder="Password" required>
                                <i class="icon-lock"></i>
                            </div>
                            <button type="submit" id="submit" class="btn btn-lg btn-danger btn-block ladda-button" data-style="expand-left">Sign In</button>
                            <div class="clearfix">
                                <p class="pull-left m-t-20"><a id="password" href="#">Forgot password?</a></p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <p class="account-copyright">
                <span>Copyright © 2015 </span><span>TKSoft</span>.<span>All rights reserved.</span>
            </p>
        </div> 
        <script src="${pageContext.request.contextPath}/assets/global/plugins/jquery/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/global/plugins/jquery/jquery-migrate-1.2.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/global/plugins/gsap/main-gsap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/global/plugins/backstretch/backstretch.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-loading/lada.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/global/js/pages/login.js"></script>
    </body>

</html>