<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    
        <meta charset="UTF-8">
        <title>SendTK | Coco - Responsive Bootstrap Admin Template</title>   
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <meta name="description" content="">
        <meta name="keywords" content="coco bootstrap template, coco admin, bootstrap,admin template, bootstrap admin,">
        <meta name="author" content="Huban Creative">

        <!-- Base Css Files -->
        <link href="/sendtk/assets/libs/jqueryui/ui-lightness/jquery-ui-1.10.4.custom.min.css" rel="stylesheet" />
        <link href="/sendtk/assets/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link href="/sendtk/assets/libs/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
        <link href="/sendtk/assets/libs/fontello/css/fontello.css" rel="stylesheet" />
        <link href="/sendtk/assets/libs/animate-css/animate.min.css" rel="stylesheet" />
        <link href="/sendtk/assets/libs/nifty-modal/css/component.css" rel="stylesheet" />
        <link href="/sendtk/assets/libs/magnific-popup/magnific-popup.css" rel="stylesheet" /> 
        <link href="/sendtk/assets/libs/ios7-switch/ios7-switch.css" rel="stylesheet" /> 
        <link href="/sendtk/assets/libs/pace/pace.css" rel="stylesheet" />
        <link href="/sendtk/assets/libs/sortable/sortable-theme-bootstrap.css" rel="stylesheet" />
        <link href="/sendtk/assets/libs/bootstrap-datepicker/css/datepicker.css" rel="stylesheet" />
        <link href="/sendtk/assets/libs/jquery-icheck/skins/all.css" rel="stylesheet" />
        <!-- Code Highlighter for Demo -->
        <link href="/sendtk/assets/libs/prettify/github.css" rel="stylesheet" />
        
                <!-- Extra CSS Libraries Start -->
                <link href="/sendtk/assets/css/style.css" rel="stylesheet" type="text/css" />
                <!-- Extra CSS Libraries End -->
        <link href="/sendtk/assets/css/style-responsive.css" rel="stylesheet" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->

        <link rel="shortcut icon" href="/sendtk/assets/img/favicon.ico">
        <link rel="apple-touch-icon" href="/sendtk/assets/img/apple-touch-icon.png" />
        <link rel="apple-touch-icon" sizes="57x57" href="/sendtk/assets/img/apple-touch-icon-57x57.png" />
        <link rel="apple-touch-icon" sizes="72x72" href="/sendtk/assets/img/apple-touch-icon-72x72.png" />
        <link rel="apple-touch-icon" sizes="76x76" href="/sendtk/assets/img/apple-touch-icon-76x76.png" />
        <link rel="apple-touch-icon" sizes="114x114" href="/sendtk/assets/img/apple-touch-icon-114x114.png" />
        <link rel="apple-touch-icon" sizes="120x120" href="/sendtk/assets/img/apple-touch-icon-120x120.png" />
        <link rel="apple-touch-icon" sizes="144x144" href="/sendtk/assets/img/apple-touch-icon-144x144.png" />
        <link rel="apple-touch-icon" sizes="152x152" href="/sendtk/assets/img/apple-touch-icon-152x152.png" />
    </head>
    <body class="fixed-left">
        <!-- Modal Start -->        				
			<!-- Modal Logout -->
			<div class="md-modal md-just-me" id="logout-modal">
				<div class="md-content">
					<h3><strong>Logout</strong> Confirmation</h3>
					<div>
						<p class="text-center">Are you sure want to logout from this awesome system?</p>
						<p class="text-center">
						<button class="btn btn-danger md-close">Nope!</button>
						<a href="login.html" class="btn btn-success md-close">Yeah, I'm sure</a>
						</p>
					</div>
				</div>
			</div>
		<!-- Modal End -->	
		<!-- Begin page -->
	<div id="wrapper">
		
<!-- Top Bar Start -->
	<jsp:include page="../menus/topbar.jsp"/>
<!-- Top Bar End -->
		    <!-- Left Sidebar Start -->
        <jsp:include page="../menus/rightmenu.jsp"/>
    <!-- Left Sidebar End -->

        <!-- Right Sidebar Start -->
   
    <!-- Right Sidebar End -->
		<!-- Start right content -->
        <div class="content-page">
			<!-- ============================================================== -->
			<!-- Start Content here -->
			<!-- ============================================================== -->
            <div class="content">
            					<!-- Page Heading Start -->
				<div class="page-heading">
            		<h1><i class='fa fa-file'></i>Offer</h1>
            		<h3>Gestion des offres</h3>            
            	</div>
            	<!-- Page Heading End-->				

            	<div class="row">
					<div class="col-md-12 portlets">
						<!-- Your awesome content goes here -->
						<div class="widget animated fadeInDown">
							<form id="myWizard">

								<!-- Offer Section -->
								
									${Offer.getName()} ${Offer.getReference()}: ${Offer.getPayout()}
									<br />
									<c:forEach items="${Offer.getFroms()}" var="from"  >
										<br> ** ${from}
									</c:forEach>
								<!-- End Offer -->
								
								<input type="button" value="click" name="btn" id="btn"> 
							</form>
						</div>
					</div>
				</div>

				
			<!-- Footer Start -->
			<jsp:include page="../menus/footer.jsp"></jsp:include>   
            <!-- Footer End -->			
            </div>
			<!-- ============================================================== -->
			<!-- End content here -->
			<!-- ============================================================== -->

        </div>
		<!-- End right content -->

	</div>
	<!-- End of page -->
		<!-- the overlay modal element -->
	<div class="md-overlay"></div>
	<!-- End of eoverlay modal -->
	<script>
		var resizefunc = [];
	</script>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="/sendtk/assets/libs/jquery/jquery-1.11.1.min.js"></script>
	<script src="/sendtk/assets/libs/bootstrap/js/bootstrap.min.js"></script>
	<script src="/sendtk/assets/libs/jqueryui/jquery-ui-1.10.4.custom.min.js"></script>
	<script src="/sendtk/assets/libs/jquery-ui-touch/jquery.ui.touch-punch.min.js"></script>
	<script src="/sendtk/assets/libs/jquery-detectmobile/detect.js"></script>
	<script src="/sendtk/assets/libs/jquery-animate-numbers/jquery.animateNumbers.js"></script>
	<script src="/sendtk/assets/libs/ios7-switch/ios7.switch.js"></script>
	<script src="/sendtk/assets/libs/fastclick/fastclick.js"></script>
	<script src="/sendtk/assets/libs/jquery-blockui/jquery.blockUI.js"></script>
	<script src="/sendtk/assets/libs/bootstrap-bootbox/bootbox.min.js"></script>
	<script src="/sendtk/assets/libs/jquery-slimscroll/jquery.slimscroll.js"></script>
	<script src="/sendtk/assets/libs/jquery-sparkline/jquery-sparkline.js"></script>
	<script src="/sendtk/assets/libs/nifty-modal/js/classie.js"></script>
	<!-- script src="/sendtk/assets/libs/nifty-modal/js/modalEffects.js"></script> -->
	<script src="/sendtk/assets/libs/sortable/sortable.min.js"></script>
	<script src="/sendtk/assets/libs/bootstrap-fileinput/bootstrap.file-input.js"></script>
	<script src="/sendtk/assets/libs/bootstrap-select/bootstrap-select.min.js"></script>
	<script src="/sendtk/assets/libs/bootstrap-select2/select2.min.js"></script>
	<script src="/sendtk/assets/libs/magnific-popup/jquery.magnific-popup.min.js"></script> 
	<script src="/sendtk/assets/libs/pace/pace.min.js"></script>
	<script src="/sendtk/assets/libs/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script src="/sendtk/assets/libs/jquery-icheck/icheck.min.js"></script>	
	<script src="/sendtk/assets/libs/prettify/prettify.js"></script>
	<script src="/sendtk/assets/js/init.js"></script>
	<!--  pages specific js files -->
	<script src="/sendtk/assets/libs/bootstrap-select/bootstrap-select.min.js"></script>
	<script src="/sendtk/assets/libs/bootstrap-inputmask/inputmask.js"></script>
	<script src="/sendtk/assets/libs/summernote/summernote.js"></script>
	<script src="/sendtk/assets/js/pages/forms.js"></script>.
	
	<script src="/sendtk/assets/libs/jquery-wizard/jquery.easyWizard.js"></script>
	<script src="/sendtk/assets/js/pages/form-wizard.js"></script>
	<script src="/sendtk/assets/js/scripts/OfferOps.js"></script>
	
	</body>
</html>