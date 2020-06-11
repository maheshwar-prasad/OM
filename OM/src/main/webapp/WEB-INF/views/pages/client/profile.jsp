<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"
	src="<c:url value='/static/bower_components/jquery/dist/jquery.min.js'/>"></script>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>Create Product</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Items</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">

		<div class="box box-default">
			<div class="box-header with-border">
				<h3 class="box-title">Item</h3>

				<div class="box-tools pull-right">
					<button type="button" class="btn btn-box-tool"
						data-widget="collapse">
						<i class="fa fa-minus"></i>
					</button>
					<button type="button" class="btn btn-box-tool" data-widget="remove">
						<i class="fa fa-remove"></i>
					</button>
				</div>
			</div>
			<!-- /.box-header -->
			<%--     <form role="form" method="post"> --%>
			<form:form method="post"
				action="${pageContext.request.contextPath}/updateProfile"
				modelAttribute="profile" enctype="multipart/form-data">
				<div class="box-body">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>First Name</label> <input type="text" id="first-name"
									name="first-name" value="${profile.firstName}"> <input
									type="hidden" id="saller-id" name="saller-id"
									value="${profile.id}">
							</div>
							<!-- /.form-group -->
							<div class="form-group">
								<label>Last Name</label> <input type="text" id="last-name"
									name="last-name" value="${profile.lastName}">
							</div>
							<!-- /.form-group -->
						</div>
						<!-- /.col -->
						<div class="col-md-6">
							<div class="form-group">
								<label for="exampleInputEmail1">GST No.</label> <input
									type="text" id="gst-no" name="gst-no" value="${profile.gstNo}">
							</div>
							<!-- /.form-group -->
							<div class="form-group">
								<label for="exampleInputEmail1">Company Name</label> <input
									type="text" id="company-name" name="company-name"
									value="${profile.companyName}">
							</div>
							<!-- /.form-group -->
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>User Name</label> <input type="number" id="user-name"
									name="user-name" value="${profile.userName}">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Password</label> <input
									type="password" id="password" name="password"
									value="${profile.password}">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="exampleInputEmail1">Address 1</label> <input
									type="text" id="address1" name="address1"
									value="${profile.address1}">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Address 2</label> <input
									type="text" id="address2" name="address2"
									value="${profile.address2}">

							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="exampleInputEmail1">City Name</label> <input
									type="text" id="city" name="city" value="${profile.city}">
							</div>
							<div class="form-group">
								<label for="text">State Name</label> <input type="text"
									id="state-name" name="state-name" value="${profile.stateName}">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="exampleInputEmail1">State GST Code</label> <input
									type="text" id="state-gst-code" name="state-gst-code"
									value="${profile.stateGstCode}">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Pincode</label> <input
									type="text" id="pincode" name="pincode"
									value="${profile.pincode}">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="exampleInputEmail1">Customer Care Number</label> <input
									type="text" id="cc-no" name="cc-no" value="${profile.ccNo}">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email</label> <input type="text"
									id="email" name="email" value="${profile.email}">
							</div>
						</div>
						<div class="col-md-6">
							<!-- /.form-group -->
							<div class="form-group">
								<label for="exampleInputFile">Terms & Condition</label> <input
									type="file" name="terms" id="terms">
								<c:if test="${not empty profile.termsUri}">
									<a href="${profile.termsUri}">T&C</a>
								</c:if>
							</div>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<div class="box-footer">
					<button type="submit" class="btn btn-primary">Submit</button>
					<button type="reset" class="btn btn-default">Reset</button>
					<a href="${pageContext.request.contextPath}/clientdashboard"><button
							type="button"
							style="background-color: firebrick !important; color: white"
							class="btn btn-default" onclick="">Back</button></a>
				</div>
			</form:form>
		</div>
	</section>
</div>
<!-- /.content-wrapper -->
