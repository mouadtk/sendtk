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
	<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/assets/global/images/favicon.png"
	type="image/png">
	<title>Make Admin Template &amp; Builder</title>
	<link
	href="${pageContext.request.contextPath}/assets/global/css/style.css"
	rel="stylesheet">
	<link
	href="${pageContext.request.contextPath}/assets/global/css/theme.css"
	rel="stylesheet">
	<link href="${pageContext.request.contextPath}/assets/global/css/ui.css"
	rel="stylesheet">
	<link
	href="${pageContext.request.contextPath}/assets/admin/layout1/css/layout.css"
	rel="stylesheet">
    <link 
    href="${pageContext.request.contextPath}/assets/global/plugins/font-awesome-animation/font-awesome-animation.min.css" 
    rel="stylesheet">
	<script
	src="${pageContext.request.contextPath}/assets/global/plugins/modernizr/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>

<body class="fixed-topbar fixed-sidebar theme-sdtl color-default">
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
    			<div class="header">
    				<h2>
    					<strong>Campaigns</strong> Page
    				</h2>
    				<div class="breadcrumb-wrapper">
    					<ol class="breadcrumb">
    						<li><a href="dashboard.html">SendTK</a></li>
    						<li><a href="#">Pages</a></li>
    						<li class="active">Dashboard</li>
    					</ol>
    				</div>
    			</div>
    			<div class="row">
    				<div class="col-lg-12" style="height: 720px">
    					<!-- HERE COMES YOUR CONTENT -->
    					<div class="row">
    						<div class="col-lg-12 portlets">
    							<div class="panel">
    								<div class="panel-header panel-controls">
    									<h3><i class="fa fa-table"></i> <strong>${firstname}  Campaigns </strong></h3>
    								</div>
    								<div class="panel-content">
    									<table class="table dataTable" id="CampaignListing">
    										<thead>
    											<tr>
    												<th class="" 			tabindex="0" rowspan="1" colspan="1" style="width: 5%;" >
    												</th>	
    												<th class="sorting_asc" tabindex="0" rowspan="1" colspan="1" style="width: 128px;">
    													Reference
    												</th>
    												<th class="sorting center" tabindex="0" rowspan="1" colspan="1" style="width: 173px;">
    													Offer
    												</th>
    												<th class="sorting center" tabindex="0" rowspan="1" colspan="1" style="width: 145px;">
    													Vertical
    												</th>
    												<th class="sorting center" tabindex="0" rowspan="1" colspan="1" style="width: 143px;">
    													State
    												</th>
    												<th class="sorting center" tabindex="0" rowspan="1" colspan="1" style="width: 160px;">
    													Affiliate
    												</th>
    												<th class="sorting center" tabindex="0" rowspan="1" colspan="1" style="width: 151px;">
    													Servers
    												</th>
    												<th class="sorting center" tabindex="0" rowspan="1" colspan="1" style="width: 151px;">
    													Settings
    												</th>
                                                    <th   tabindex="0" rowspan="1" colspan="1" style="width:300px !important, text-align: center;"> Action </th>
                                                    <th class="hidden">details1</th>
                                                    <th class="hidden">details2</th>
                                                    <th class="hidden">details3</th>    
                                                    <th class="hidden">details4</th>
                                                    <th class="hidden">details5</th>
                                                    <th class="hidden">details6</th>                                            
    											</tr>
    										</thead>
    										
    										<tbody role="alert" aria-live="polite" aria-relevant="all">
    										
    										<c:forEach items="${Campaigns}" var="camp">						
    											<tr class="gradeA odd">
    												<td class="center"></td>
    												<td class="sorting_1">${camp.getRef()}</td>
    												<td class="">${camp.getOffer().getName()}</td>
    												<td class="">${camp.getOffer().getVertical()}</td>
    												<td > 
    													<c:choose>
														    <c:when test="${camp.getStatus() == 'New'}">
														       <span class="label label-success">
														    </c:when>
														    <c:when test="${camp.getStatus() == 'Pause'}">
														        <span class="label label-dark">
														    </c:when>
														    <c:when test="${camp.getStatus() == 'Complete'}">
														        <span class="label label-primary">
														    </c:when>
														    <c:otherwise>
														        <span class="label label-default">
														    </c:otherwise>
														</c:choose>
    													${camp.getStatus()}</span>
    												</td>
    												<td class="center ">${camp.getOffer().getAffiliate()}</td>
    												<td class="center ">${camp.getServer().size()}</td>
    												<td class="center ">${camp.getDate()}</td>
                                                    <td class="center " style="align-content: center;">
                                                        <a href="#"  class  ="btn btn-sm btn-primary font-animation"
                                                        	style="margin: 5px 1px 0px 0px;"  >
                                                            <label style="  margin: 5px;" class="fa fa-envelope faa-shake animated-hover "></label>
                                                        </a>
                                                        <a  href="#"  class  ="btn btn-sm btn-dark font-animation"
                                                        	style="margin: 5px 1px 0px 0px;"  >
                                                            <label style="  margin: 5px;" class="fa fa-pause faa-pulse animated-hover " ></label>
                                                        </a>
                                                        <a href="#"   class ="btn btn-sm btn-default font-animation"
                                                        	style="margin: 5px 1px 0px 0px;"  >
                                                            <label style="  margin: 5px;" class="fa fa-gears faa-spin animated-hover" ></label>
                                                        </a>
                                                        <a href="#"   class ="btn btn-sm btn-danger font-animation"
                                                        	style="margin: 5px 1px 0px 0px;"  >
                                                            <label style="  margin: 5px;" class="fa fa-remove faa-flash  animated-hover" ></label>
                                                        </a>
                                                    </td>
                                                    <td class="hidden ">${camp.getSettings().getMsg_Per_IP()}</td>
                                                    <td class="hidden ">${camp.getSettings().getSed()}</td>
                                                    <td class="hidden ">${camp.getSettings().getxDelay()}</td>
                                                    <td class="hidden ">${camp.getSettings().getCountDelay()}</td>
                                                    <td class="hidden ">${camp.getSettings().getFraction()}</td>
                                                    <td class="hidden ">${camp.getSettings().get_Index()}</td>
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
		<script
		src="${pageContext.request.contextPath}/assets/global/plugins/select2/select2.min.js"></script>
		<!-- Select Inputs -->
		<script
		src="${pageContext.request.contextPath}/assets/global/plugins/icheck/icheck.min.js"></script>
		<!-- Checkbox & Radio Inputs -->
		<script
		src="${pageContext.request.contextPath}/assets/global/plugins/backstretch/backstretch.min.js"></script>
		<!-- Background Image -->
		<script
		src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
		<!-- Animated Progress Bar -->
		<script
		src="${pageContext.request.contextPath}/assets/global/plugins/charts-chartjs/Chart.min.js"></script>
		<script
		src="${pageContext.request.contextPath}/assets/global/js/builder.js"></script>
		<!-- Theme Builder -->
		<script
		src="${pageContext.request.contextPath}/assets/global/js/sidebar_hover.js"></script>
		<!-- Sidebar on Hover -->
		<script
		src="${pageContext.request.contextPath}/assets/global/js/widgets/notes.js"></script>
		<!-- Notes Widget -->
		<script
		src="${pageContext.request.contextPath}/assets/global/js/quickview.js"></script>
		<!-- Chat Script -->
		<script
		src="${pageContext.request.contextPath}/assets/global/js/plugins.js"></script>
		<!-- Main Plugin Initialization Script -->
		<script
		src="${pageContext.request.contextPath}/assets/global/js/application.js"></script>
		<!-- Main Application Script -->
		<script
		src="${pageContext.request.contextPath}/assets/admin/layout1/js/layout.js"></script>
		<!-- Main Application Script -->

		<!-- Specified page Script -->
		<script 
		src="${pageContext.request.contextPath}/assets/global/plugins/datatables/jquery.dataTables.min.js"></script> 
		<script 
		src="${pageContext.request.contextPath}/assets/global/scripts/CampaignListing.js"></script>

        <script 
        src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-loading/lada.min.js"></script>

        <script 
        src="${pageContext.request.contextPath}/assets/global/js/pages/animations.js"></script>
 <!-- Buttons Loading State -->
    	<!--  Script -->
	</body>

	</html>