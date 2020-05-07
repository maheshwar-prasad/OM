<%-- <nav>
	<a href="${pageContext.request.contextPath}/"><img class="logo" src="${pageContext.request.contextPath}/static/img/Linux-icon.png"></a>
	<ul id="menu">
		<li><a href="${pageContext.request.contextPath}/">Home</a></li>
       <li><a href="${pageContext.request.contextPath}/products">Products</a></li>
       <li><a href="${pageContext.request.contextPath}/contactus">Contact Us</a></li>
	</ul>
</nav> --%>
 <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${pageContext.request.contextPath}/static/dist/img/maheshwar3.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${user.name}</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online Mart</a>
        </div>
      </div>
      <!-- search form -->
    <!--   <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
          <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat">
                  <i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form> -->
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">MAIN NAVIGATION</li>
        <li>
          <a href="${pageContext.request.contextPath}/dashboard"><i class="fa fa-dashboard"></i> <span>Dashboard</span></a>
 		</li>
 		<li class="treeview">
          <a href="#">
            <i class="fa fa-folder"></i> <span>Master</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
          	<li><a href="${pageContext.request.contextPath}/apiCustomer"><i class="fa fa-circle-o"></i>Customer</a></li>
            <li><a href="${pageContext.request.contextPath}/itemTypeList"><i class="fa fa-circle-o"></i>Item Type</a></li>
            <%-- <li><a href="${pageContext.request.contextPath}/itemType"><i class="fa fa-circle-o"></i> Item Type</a></li> --%>
            <li><a href="${pageContext.request.contextPath}/apiItems"><i class="fa fa-book"></i> <span>Items</span></a></li>
            <li><a href="${pageContext.request.contextPath}/offers"><i class="fa fa-circle-o"></i>Offer</a>
           <%--  <li><a href="${pageContext.request.contextPath}/currentReq"><i class="fa fa-circle-o"></i> Current Request</a></li>
            <li><a href="${pageContext.request.contextPath}/orderList"><i class="fa fa-circle-o"></i> Order List</a></li>
            <li><a href="${pageContext.request.contextPath}/invoiceList"><i class="fa fa-circle-o"></i> Order Invoice</a></li> --%>
          </ul>
        </li>
 		 <li class="treeview">
          <a href="#">
            <i class="fa fa-laptop"></i> <span>Inventory</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
          <li><a href="${pageContext.request.contextPath}/stock"><i class="fa fa-book"></i> <span>Stock</span></a></li>
          </ul>
        </li>
         <li class="treeview">
          <a href="#">
            <i class="fa fa-laptop"></i> <span>Order Summary</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
          <li><a href="${pageContext.request.contextPath}/order"><i class="fa fa-book"></i> <span>Order</span></a></li>
          </ul>
        </li>
		<%-- <li class="treeview">
          <a href="#">
            <i class="fa fa-laptop"></i>
            <span>APP Activity</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath}/activeUser"><i class="fa fa-circle-o"></i>Active User</a></li>
            <li><a href="${pageContext.request.contextPath}/currentReq"><i class="fa fa-circle-o"></i> Current Request</a></li>
            <li><a href="${pageContext.request.contextPath}/previousReq"><i class="fa fa-circle-o"></i> Previous Request</a></li>
            <li><a href="${pageContext.request.contextPath}/orderList"><i class="fa fa-circle-o"></i> Order List</a></li>
            <li><a href="${pageContext.request.contextPath}/invoiceList"><i class="fa fa-circle-o"></i> Order Invoice</a></li>
          </ul>
        </li> --%>
  	  <li class="treeview">
          <a href="#">
            <i class="fa fa-gears"></i> <span>Setting</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
           <li><a href="#"><i class="fa fa-circle-o"></i>Database Setting</a></li>
           <li><a href="#"><i class="fa fa-circle-o"></i> Email Configuration</a></li>
           <li><a href="#"><i class="fa fa-circle-o"></i> SMS Configuration</a></li>
           <li><a href="#"><i class="fa fa-circle-o"></i>Page Configuration</a></li>
          </ul>
        </li>   
        <li><a href="#"><i class="fa fa-book"></i> <span>Documentation</span></a></li>
        <!-- <li class="header">LABELS</li>
        <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Important</span></a></li>
        <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Warning</span></a></li>
        <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li> -->
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>