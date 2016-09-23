<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    
<meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
<head>
        <meta charset="utf-8">
        <title>SendTK</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta content="" name="description" />
        <meta content="themes-lab" name="author" />
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/global/images/favicon.png">
        <link href="${pageContext.request.contextPath}/assets/global/css/style.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/assets/global/css/ui.css" rel="stylesheet">
    </head>
    <body class="error-page">
        <div class="row">
            <div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-12">
                <div class="error-container">
                    <div class="error-main">
                        <h1><span id="404"></span></h1>
                        <h3><span id="404-txt"></span></h3>
                        <h4><span id="404-txt-2"></span></h4>
                        <br>
                        <div class="row" id="content-404">
                            <div class="col-md-6 col-md-offset-3 text-center">
                                <div class="input-icon">
                                    <i class="fa fa-search"></i>
                                    <input type="text" class="form-control form-white" placeholder="Search for page">
                                </div>
                                <br>
                                <button class="btn btn-dark" type="button">Search</button>
                            </div>
                            <div class="col-md-12 text-center">
                                <br><br>
                                <p>OR</p>
                                <br><br><br>
                                <div class="btn-group">
                                    <button class="btn btn-white" id="goback" >
                                    <i class="fa fa-angle-left"></i> Go back
                                    </button>
                                    <a class="btn btn-white btn-home" href="${pageContext.request.contextPath}/home/dashboard">
                                    <i class="icon-home"></i> Home Page
                                    </a>
                                    <a class="btn btn-white" href="${pageContext.request.contextPath}/login">
                                    <i class="icon-login"></i> Login
                                    </a>
                                    <a class="btn btn-white btn-message" href="${pageContext.request.contextPath}/home/contact">
                                    <i class="icon-envelope"></i> Contact administrator
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer">
            <div class="copyright">� Copyright TKSoft, 2015.</div>
        </div>
        <script src="${pageContext.request.contextPath}/assets/global/plugins/jquery/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/global/js/jquery-ui.js"></script>
        <script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/global/plugins/typed/typed.js"></script>
        <script>
            $(function(){
            	$("#goback").click(function(e) {
            		window.history.back();
            	});

                $("#404").typed({
                    strings: ["404 !!"],
                    typeSpeed: 200,
                    backDelay: 500,
                    loop: false,
                    contentType: 'html',
                    loopCount: false,
                    callback: function() {
                        $('h1 .typed-cursor').css('-webkit-animation', 'none').animate({opacity: 0}, 400);
                        $("#404-txt").typed({
                            strings: ["It seems that this page doesn't exist."],
                            typeSpeed: 1,
                            backDelay: 500,
                            loop: false,
                            contentType: 'html', 
                            loopCount: false,
                            callback: function() {
                                $('h3 .typed-cursor').css('-webkit-animation', 'none').animate({opacity: 0}, 400);
                                $("#404-txt-2").typed({
                                    strings: ["Go back to DashBoard <a href='/home/dashboard'>Dashboard</a>"],
                                    typeSpeed: 1,
                                    backDelay: 500,
                                    loop: false,
                                    contentType: 'html', 
                                    loopCount: false,
                                    callback: function() {
                                        $('#content-404').delay(300).slideDown();
                                    },
                                }); 
                            }
                        });  
                    }
                });  
            });
        </script>
    </body>

<!-- Mirrored from themes-lab.com/make/admin/layout1/page-404.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 09 Jun 2015 15:10:30 GMT -->
</html>