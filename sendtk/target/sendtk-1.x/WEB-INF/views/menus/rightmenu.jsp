<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

 <!-- BEGIN SIDEBAR -->
      <div class="sidebar">
        <div class="logopanel">
          <h1>
            <a href="/Home/dashboard"></a>
          </h1>
        </div>
        <div class="sidebar-inner">
          <div class="sidebar-top">
            <form action="/sendtk/Home/dashboard" method="post" class="searchform" id="search-results">
              <input type="text" class="form-control" name="keyword" placeholder="Search...">
            </form>
            <div class="userlogged clearfix">
              <i class="icon icons-faces-users-01"></i>
              <div class="user-details">
                <h4>
                	${firstname} &nbsp;<br>
                	${lastname}
                </h4>
              </div>
            </div>
          </div>
          <div class="menu-title">
            Navigation 
            <div class="pull-right menu-settings">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true" data-delay="300"> 
              <i class="icon-settings"></i>
              </a>
              <ul class="dropdown-menu">
	                <li><a href="#" id="reorder-menu" 		class="reorder-menu">Reorder menu</a></li>
	                <li><a href="#" id="remove-menu" 		class="remove-menu">Remove elements</a></li>
	                <li><a href="#" id="hide-top-sidebar" 	class="hide-top-sidebar">Hide user &amp; search</a></li>
              </ul>
            </div>
          </div>
          
          <ul class="nav nav-sidebar">
           
            <li><a href="${pageContext.request.contextPath}/Campaign/dashboard"><i class="icon-home"></i><span>Dashboard</span></a></li>
            
            <li class="nav-parent">
              <a href="#"><i class="icon-puzzle"></i><span>Campaign</span> <span class="fa arrow"></span></a>
              <ul class="children collapse">
              	<sec:authorize access="hasRole('MAILER') OR hasRole('ADMIN')" >
                <li><a href="${pageContext.request.contextPath}/Campaign/PreparCampaign"> Build Campaign</a></li>
                </sec:authorize>
                <sec:authorize access="hasRole('MAILER')" >
                <li><a href="${pageContext.request.contextPath}/Campaign/MailerCampaigns"> My Campaigns</a></li>
                </sec:authorize>
                
                <sec:authorize access="hasRole('ADMIN')" >
                <li><a href="${pageContext.request.contextPath}/Campaign/Listing"> All Campaign </a></li>
                <li><a href="${pageContext.request.contextPath}/Campaign/statistics"> Statistic Charts  </a></li>
                </sec:authorize>
              </ul>
            </li>
            
            <li class="nav-parent">
              <a href="#"><i class="fa icon-bulb"></i><span>Offer</span> <span class="fa arrow"></span></a>
              <ul class="children collapse">
               	<sec:authorize access="hasRole('OFFERMANAGER') OR hasRole('ADMIN')" >
				<li><a href="${pageContext.request.contextPath}/Offer/newOffer" >New Offer  </a></li>
				</sec:authorize>
                <li><a href="${pageContext.request.contextPath}/Offer/ShowOffers" >Current Offers  </a></li>
                <sec:authorize access="hasRole('ADMIN')" >
                <li><a href="${pageContext.request.contextPath}/Offer/statistics" >Offer Statistics</a></li>
                </sec:authorize>
              </ul>
            </li>
            
            <li class="nav-parent">
              <a href="#"><i class="fa fa-laptop"></i><span>Server</span> <span class="fa arrow"></span></a>
              <ul class="children collapse">
                <li><a href="${pageContext.request.contextPath}/Server/Dashboard"> Dashboard</a></li>
                <li><a href="${pageContext.request.contextPath}/Server/List"> Servers List</a></li>
                <li><a href="${pageContext.request.contextPath}/Server/New"> New Server</a></li>
              </ul>
            </li>
        </div>
      </div>
      <!-- END SIDEBAR -->