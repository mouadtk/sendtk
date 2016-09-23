
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    
<!-- Mirrored from themes-lab.com/make/admin/layout1/page-500.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 09 Jun 2015 15:10:30 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
<head>
        <meta charset="utf-8">
        <title>Themes Lab - Creative Laborator</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta content="" name="description" />
        <meta content="themes-lab" name="author" />
        <link rel="shortcut icon" href="/sendtk/assets/global/images/favicon.png">
        <link href="/sendtk/assets/global/css/style.css" rel="stylesheet">
        <link href="/sendtk/assets/global/css/ui.css" rel="stylesheet">
    </head>
    <body class="error-page">
        <div class="row">
            <div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-12">
                <div class="error-container">
                    <div class="error-main">
                        <h1><span id="500"></span></h1>
                        <h3><span id="500-txt"></span></h3>
                        <h4><span id="500-txt-2"></span></h4>
                        <br>
                        <div class="row" id="content-500">
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
                                    <a class="btn btn-white" href="#">
                                    <i class="fa fa-angle-left"></i> Go back
                                    </a>
                                    <a class="btn btn-white btn-home" href="dashboard.html">
                                    <i class="icon-home"></i> Home Page
                                    </a>
                                    <a class="btn btn-white" href="user-login-v1.html">
                                    <i class="icon-login"></i> Login
                                    </a>
                                    <a class="btn btn-white btn-message" href="mailbox-send.html">
                                    <i class="icon-envelope"></i> Send us a message
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer">
            <div class="copyright">� Copyright Themes Lab, 2015 Themes Lab Inc.</div>
        </div>
        <script src="/sendtk/assets/global/plugins/jquery/jquery-1.11.1.min.js"></script>
        <script src="/sendtk/assets/global/js/jquery-ui.js"></script>
        <script src="/sendtk/assets/global/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="/sendtk/assets/global/plugins/typed/typed.js"></script>
        <script>
            $(function(){
                $("#500").typed({
                    strings: ["500"],
                    typeSpeed: 200,
                    backDelay: 500,
                    loop: false,
                    contentType: 'html',
                    loopCount: false,
                    callback: function() {
                        $('h1 .typed-cursor').css('-webkit-animation', 'none').animate({opacity: 0}, 400);
                        $("#500-txt").typed({
                            strings: ["Internal server error."],
                            typeSpeed: 1,
                            backDelay: 500,
                            loop: false,
                            contentType: 'html', 
                            loopCount: false,
                            callback: function() {
                                $('h3 .typed-cursor').css('-webkit-animation', 'none').animate({opacity: 0}, 400);
                                $("#500-txt-2").typed({
                                    strings: ["Go back to our site or <a href='mailbox-send.html'>contact us</a> about the problem. "],
                                    typeSpeed: 1,
                                    backDelay: 500,
                                    loop: false,
                                    contentType: 'html', 
                                    loopCount: false,
                                    callback: function() {
                                        $('#content-500').delay(300).slideDown();
                                    },
                                }); 
                            }
                        });  
                    }
                });  
            });
        </script>
    </body>

<!-- Mirrored from themes-lab.com/make/admin/layout1/page-500.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 09 Jun 2015 15:10:30 GMT -->
</html>