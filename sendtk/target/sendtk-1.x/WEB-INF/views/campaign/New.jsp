<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
	<meta name="description" content="admin-themes-lab">
	<meta name="author" content="themes-lab">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/global/images/favicon.png" type="image/png">
	<title>Building new Campaign</title>
	<link      href="${pageContext.request.contextPath}/assets/global/css/style.css"           rel="stylesheet">
	<link      href="${pageContext.request.contextPath}/assets/global/css/theme.css"           rel="stylesheet">
	<link      href="${pageContext.request.contextPath}/assets/global/css/ui.css"              rel="stylesheet">
	<link      href="${pageContext.request.contextPath}/assets/admin/layout1/css/layout.css"   rel="stylesheet">
    <link      href="${pageContext.request.contextPath}/assets/global/plugins/font-awesome-animation/font-awesome-animation.min.css"  rel="stylesheet">
	<link      href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet">
    <link      href="${pageContext.request.contextPath}/assets/global/plugins/rateit/rateit.css" rel="stylesheet">
    <link      href="${pageContext.request.contextPath}/assets/global/plugins/dropzone/dropzone.min.css" rel="stylesheet">
    <link      href="${pageContext.request.contextPath}/assets/global/plugins/input-text/style.min.css" rel="stylesheet">
    <link      href="${pageContext.request.contextPath}/assets/global/css/multiple-select.css" rel="stylesheet">
    <script    src ="${pageContext.request.contextPath}/assets/global/plugins/modernizr/modernizr-2.6.2-respond-1.1.0.min.js"></script>

</head>

<body class="fixed-topbar fixed-sidebar theme-sdtl color-purple">
	<!--[if lt IE 7]>
    <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->
    <section>
    	<!-- BEGIN SIDEBAR -->
    	<jsp:include page="../menus/rightmenu.jsp" />
    	<!-- END SIDEBAR -->
    	<div class="main-content">
    		<!-- BEGIN TOPBAR -->
    		<jsp:include page="../menus/topbar.jsp" />
    		<!-- END TOPBAR -->
    		<!-- BEGIN PAGE CONTENT -->
    		<div class="page-content">
    			<div class="page-content">
                      <div class="header">
                        <h2><strong>Build Campaign </strong></h2>
                        <div class="breadcrumb-wrapper">
                          <ol class="breadcrumb">
                            <li><a href="#">Make</a>
                            </li>
                            <li><a href="#">Forms</a>
                            </li>
                            <li class="active">Forms Validation</li>
                          </ol>
                        </div>
                      </div>
                      <div class="row">

                        <!-- Offer Section      -->
                        <div class="col-md-11">
                            <div class="panel panel-default no-bd">
                            <div class="panel-header  " style="background-color: #6e62b5;">
                              <h2 class="panel-title" style="color: white;"><strong>Offer</strong></h2>
                            </div>
                            <div class="panel-body bg-white panel-content">
                              <div class="row">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                  <form role="form" class="form-validation" >
                                    <div class="row" id="offerSearchRow">
                                        
                                        <div class="col-sm-4" >   
                                        	<div class="form-group">                                                                                                                              
	                                            <label>Affiliate</label>
	                                            <select class="form-control "  id="affiliateSelect">
                                                    <option value="addemand">Addemand</option>
                                                    <option value="onblaze">Onblaze</option>
                                                    <option value="tr4k">trk4</option>
                                                </select>
	                                        </div>
	                                      </div>
                                        
                                        <div class="col-sm-4">                                        
                                            <label> Name</label>
                                            <div>
                                                <input type="text" class="form-control" id="offername">
                                            </div>
                                        </div>
                                    
                                        <div class="col-sm-2" > 
                                           	<label></label>
                                            <button type="button" id="validateOffer" class="btn btn-dark" style="height: 33px;margin-top: 24px;">
                                               	Validate
                                            </button>
                                        </div>
                                    </div>
                                 	
                                 	<div class="row hidden" id="offerSlectedChoice" >
                                 		<div class="col-sm-4" >a</div>
                                 		<div class="col-sm-4" >a</div>
                                 		<div class="col-sm-2" >a</div>
                                 	</div>
                                 
                                  </form>
                                </div>
                              </div>
                            </div>
                            </div>
                        </div>
                        <!-- End Offer Section  -->
                        <!--  Message section   -->
                        <div class="col-md-7">
                          <div class="panel panel-default">
                            <div class="panel-header " style="background-color: #6e62b5;">
                              <h2 class="panel-title" style="color: white;"> <strong> Prepare message</strong> </h2>
                            </div>
                            <div class="panel-content" style="background-color: rgb(221, 223, 225);"   >
                              <div class="row">
                              	
                                  <br>
                                  <form role="form" class="form-horizontal form-validation">
                                    <div class="form-group">
                                      <label class="col-sm-3 control-label" style=" padding-left: 35px;">Mail From
                                      </label>
                                      <div class="col-sm-5 prepend-icon">
                                        <input type="text" name="mailfrom" class="form-control" placeholder="From name <mailfrom@domain.com>" required>
                                        <i class="icon-user"></i>
                                      </div>
                                    </div>
                                    <div class="form-group">
                                      <label class="col-sm-3 control-label" style=" padding-left: 35px;">Return path
                                      </label>
                                      <div class="col-sm-5 prepend-icon">
                                        <input type="text" name="returnpath" class="form-control" placeholder="mailfrom@domain.com" required>
                                        <i class="icon-user"></i>
                                      </div>
                                    </div>
                                    <div class="form-group">
              										<label class="col-sm-3 control-label" style=" padding-left: 35px;">Subject</label>
              										<div class="col-sm-7">
              											<textarea name="headers" rows="2" class="form-control" placeholder="subject "  required>
              											</textarea>
                									</div>
                									</div>
                  									<div class="form-group">
                  										<label class="col-sm-3 control-label" style=" padding-left: 35px;">Headers</label>
                  											<div class="col-sm-7">
                  												<textarea name="headers" rows="6" class="form-control" placeholder="Headers "  required>
                  												</textarea>
                  											</div>
                  									</div>
                                    <div class="form-group">
                                      <label class="col-sm-3 control-label" style=" padding-left: 35px;" >Message Body
                                      </label>
                                      <div class="col-sm-7">
                                        <textarea name="msgBody" rows="10" class="form-control" placeholder="Write your message here... "  required></textarea>
                                      </div>
                                    </div>
                                  </form>
                                </div>
                              </div>
                            </div>
                          </div>
                        <!--  End Message body section-->
                        <!--  Servers section-->
                        <div class="col-md-4">
                          <div class="panel panel-default no-bd">
                            <div class="panel-header " style="background-color: #6e62b5;">
                              <h2 class="panel-title" style="color: white;"><strong>Servers</strong></h2>
                            </div>
                            <div class="panel-body bg-white panel-content">
                              <div class="row">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                  <form role="form" class="form-validation">
                                    
                                    <div class="row">
                                        <div class="col-sm-6" >
                                        	<select id="example-multiple-optgroups"  multiple="multiple">
                  											    <optgroup label="Server 1">
                  											        <option value="1-1" >Option 1.1 </option>
                  											        <option value="1-2" >Option 1.2</option>
                  											        <option value="1-3" >Option 1.3</option>
                  											    </optgroup>
                  											    <optgroup label="Server 2">
                  											        <option value="2-1" >Option 2.1</option>
                  											        <option value="2-2" >Option 2.2</option>
                  											        <option value="2-3" >Option 2.3</option>
                  											    </optgroup>
                  											  </select>
                                        </div>
                                    </div>

                                  </form>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        <!--  End servers section-->  

                        <!-- MailListe Section-->
                        <div class="col-md-4">
                          <div class="panel panel-default no-bd">
                            <div class="panel-header " style="background-color: #6e62b5;">
                              <h2 class="panel-title" style="color: white;"><strong>DATA Lists</strong></h2>
                            </div>
                            <div class="panel-body bg-white panel-content">
                              <div class="row">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                  <form role="form" class="form-validation">
                                      <div class="col-sm-4" >   
                                        <div class="form-group">                                                                                                                              
                                            <label>DATA</label>
                                            <select class="form-control "  id="affiliateSelect">
                                                  <option value="addemand">Addemand</option>
                                                  <option value="onblaze">Onblaze</option>
                                                  <option value="tr4k">trk4</option>
                                              </select>
                                        </div>
                                      </div>
                                  </form>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        <!--  End MailList section-->  

                        <!--  Settings section-->
                        <div class="col-md-4">
                          <div class="panel panel-default no-bd">
                            <div class="panel-header " style="background-color: #6e62b5;">
                              <h2 class="panel-title" style="color: white;"><strong>Settings</strong></h2>
                            </div>
                            <div class="panel-body bg-white panel-content">
                              <div class="row">
                                <div class="col-md-12 col-sm-12 col-xs-12 ">
                                	
                                  <form role="form" class="form-validation">
                                  	
                                    <div class="row">
                                    	
                                        <div class="col-sm-6" >                                            
                                            <div class="form-group" style="width:170px"  >
                                                <label class="form-label"  >Message per IP</label>
                                                <input type="text" name="msg_ip" id="msg_ip" value="60" data-max="1000" data-step="10" class="numeric-stepper form-control" style="text-align: right;"/>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group"  style="width:170px"   >
                                                <label class="form-label">Fraction</label>
                                                <input type="text" name="fraction" id="fraction" value="10000" data-max="20000" data-step="100" class="numeric-stepper form-control" style="text-align: right;" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group"  style="width:170px" >
                                                <label class="form-label">Seed</label>
                                                <input type="text" name="seed" id="seed" value="100" data-max="20000" data-step="100" class="numeric-stepper form-control" style="text-align: right;" />
                                            </div>
                                            <div class="form-group" style="margin-top: 45px;" >
                                            		<label class="form-label">X</label>
			                                        <input type="text" name="x_var" class="form-control"  style="text-align: right;width:70px" >
                                                	<label class="form-label">Y</label>
			                                        <input type="text" name="y_var" class="form-control numeric"  style="text-align: right;width:70px" >
                                            </div>
                                        </div>
                                        <div class="col-sm-6" >
                                            <div class="form-group"  style="width:70px" >
                                                <label class="form-label">Count </label>
                                                <input type="text" name="countDelay" data-vertical="true" value="80" data-step="1" class="numeric-stepper form-control" style="text-align: right;width:70px" /><br>
                                                <label class="form-label"> xDelay</label>
                                                <input type="text" name="x_Delay" data-vertical="true" value="80" data-step="1" class="numeric-stepper form-control" style="text-align: right;width:70px" />
                                            </div>
                                        </div>
                                    </div>
                                  </form>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        <!-- Ends ttings section-->
                        
                        
                    </div>
                </div>
    		</div>
    		<jsp:include page="../menus/footer.jsp" />
    	</div>
    	<!-- END PAGE CONTENT -->
    <!-- END MAIN CONTENT -->
    <!-- BEGIN BUILDER -->
    
    <!-- END BUILDER -->
</section>
<!-- BEGIN QUICKVIEW SIDEBAR -->
<!-- END QUICKVIEW SIDEBAR -->

<!-- END QUICKVIEW SIDEBAR -->
<!-- BEGIN PRELOADER -->
<div class="loader-overlay">
	<div class="spinner">
		<div class="bounce1"></div>
		<div class="bounce2"></div>
		<div class="bounce3"></div>
	</div>
</div>
<!-- END PRELOADER -->
<a href="#" class="scrollup"><i class="fa fa-angle-up"></i></a>
<script
src="${pageContext.request.contextPath}/assets/global/plugins/jquery/jquery-1.11.1.min.js"></script>
<script
src="${pageContext.request.contextPath}/assets/global/plugins/jquery/jquery-migrate-1.2.1.min.js"></script>
<script
src="${pageContext.request.contextPath}/assets/global/plugins/jquery-ui/jquery-ui-1.11.2.min.js"></script>
<script
src="${pageContext.request.contextPath}/assets/global/plugins/gsap/main-gsap.min.js"></script>
<script
src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
src="${pageContext.request.contextPath}/assets/global/plugins/jquery-cookies/jquery.cookies.min.js"></script>
<!-- Jquery Cookies, for theme -->
<script
src="${pageContext.request.contextPath}/assets/global/plugins/jquery-block-ui/jquery.blockUI.min.js"></script>
<!-- simulate synchronous behavior when using AJAX -->
<script
src="${pageContext.request.contextPath}/assets/global/plugins/bootbox/bootbox.min.js"></script>
<!-- Modal with Validation -->
<script
src="${pageContext.request.contextPath}/assets/global/plugins/mcustom-scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
<!-- Custom Scrollbar sidebar -->
<script
src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-dropdown/bootstrap-hover-dropdown.min.js"></script>
<!-- Show Dropdown on Mouseover -->
<script
src="${pageContext.request.contextPath}/assets/global/plugins/charts-sparkline/sparkline.min.js"></script>
	<!-- Charts Sparkline --
	<script
		src="${pageContext.request.contextPath}/assets/global/plugins/retina/retina.min.js"></script>
	<!-- Retina Display -->
	<script src="${pageContext.request.contextPath}/assets/global/plugins/select2/select2.min.js"></script>             		 <!--  Select Inputs -->
	<script src="${pageContext.request.contextPath}/assets/global/plugins/icheck/icheck.min.js"></script>         				 <!-- Checkbox & Radio Inputs -->
	<script src="${pageContext.request.contextPath}/assets/global/plugins/backstretch/backstretch.min.js"></script>           	 <!-- Background Image -->
	<script 
	src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>  <!-- Animated Progress Bar -->
	<script src="${pageContext.request.contextPath}/assets/global/plugins/charts-chartjs/Chart.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/global/js/builder.js"></script>              						 <!-- Theme Builder -->
	<script src="${pageContext.request.contextPath}/assets/global/js/sidebar_hover.js"></script>        						 <!-- Sidebar on Hover -->
	<script src="${pageContext.request.contextPath}/assets/global/js/widgets/notes.js"></script>      							 <!-- Notes Widget -->
	<script src="${pageContext.request.contextPath}/assets/global/js/quickview.js"></script>      								 <!-- Chat Script -->
	<!--    script src="${pageContext.request.contextPath}/assets/global/js/plugins.js"></script>-->        					 <!-- Main Plugin Initialization Script -->
	<script src="${pageContext.request.contextPath}/assets/global/js/application.js"></script>          						 <!-- Main Application Script -->
	<script src="${pageContext.request.contextPath}/assets/admin/layout1/js/layout.js"></script>        						 <!-- Main Application Script -->
    
    <!-- Specified page Script -->
    <script src="${pageContext.request.contextPath}/assets/global/plugins/touchspin/jquery.bootstrap-touchspin.min.js"></script> <!-- A mobile and touch friendly input spinner component for Bootstrap -->
    <script src="${pageContext.request.contextPath}/assets/global/plugins/timepicker/jquery-ui-timepicker-addon.min.js"></script><!-- Time Picker -->
    <script src="${pageContext.request.contextPath}/assets/global/plugins/multidatepicker/multidatespicker.min.js"></script> 	 <!-- Multi dates Picker -->
    <script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script><!-- >Bootstrap Date Picker -->
    <script src="${pageContext.request.contextPath}/assets/global/plugins/colorpicker/spectrum.min.js"></script> 				 <!-- Color Picker -->
    <script src="${pageContext.request.contextPath}/assets/global/plugins/rateit/jquery.rateit.min.js"></script> 				 <!-- Rating star plugin -->
    <script src="${pageContext.request.contextPath}/assets/global/js/pages/form_plugins.js"></script>
    <script src="${pageContext.request.contextPath}/assets/global/plugins/switchery/switchery.min.js"></script> <!-- IOS Switch -->
    <script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-tags-input/bootstrap-tagsinput.min.js"></script> <!-- Select Inputs -->
    <script src="${pageContext.request.contextPath}/assets/global/plugins/dropzone/dropzone.min.js"></script>  <!-- Upload Image & File in dropzone -->
    <script src="${pageContext.request.contextPath}/assets/global/js/pages/form_icheck.js"></script>
    <script src="${pageContext.request.contextPath}/assets/global/scripts/BuildCampaign.js"></script>
    <script src="${pageContext.request.contextPath}/assets/global/js/jquery.multiple.select.js"></script> <!--  Multiselect with checkboxe -->
    <!-- Buttons Loading State -->
    <!--  Script -->
	</body>

 