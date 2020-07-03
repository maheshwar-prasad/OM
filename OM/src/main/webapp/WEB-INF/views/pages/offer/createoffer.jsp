<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"
	src="<c:url value='/static/bower_components/jquery/dist/jquery.min.js'/>"></script>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>Create Offer</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Offer</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">

		<div class="box box-default">
			<div class="box-header with-border">
				<h3 class="box-title">Offer</h3>

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
			<form:form role="form" method="post" modelAttribute="offer"
				action="${pageContext.request.contextPath}/saveOffer" id="offerForm"
				enctype="multipart/form-data">
				<div class="box-body">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="exampleInputEmail1">Article Name.</label>
								<form:input type="text" class="form-control" id="article"
									name="article" path="article" placeholder="Enter Article Name." />
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Purchase Type.</label>
								<form:select class="form-control" id="type" name="type"
									path="type">
									<form:option value="A">Amount Off On Purchase</form:option>
									<form:option value="U">Unit Free On Purchase</form:option>
								</form:select>
							</div>
							<!-- /.form-group -->

							<!-- /.form-group -->
						</div>
						<!-- /.col -->
						<div class="col-md-6">
							<div class="form-group">
								<label for="exampleInputEmail1">On Purchase Of</label>
								<form:input type="text" class="form-control" id="purchase"
									name="purchase" path="purchase"
									placeholder="Enter Purchase Limit For Offer" />
							</div>
							<!-- /.form-group -->
							<div class="form-group">
								<label>Status</label> <select class="form-control select3"
									id="status" name="status" style="width: 100%;"
									onchange="selectStatus();">
									<option selected="selected" value="true">Active</option>
									<option value="false">Inactive</option>
								</select> <input type="hidden" id="active" name="active" value="true">
							</div>

							<!-- /.form-group -->
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>Duration From:</label>

								<div class="input-group date">
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<input type="text" class="form-control pull-right dateinput"
										id="datepicker1" name="durationFrom"
										data-date-format="dd/mm/yyyy" placeholder="dd/MM/yyyy">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputFile"> Offer Image</label> <input
									type="file" name="file" id="file"
									accept="image/jpeg, image/png"> <input type="hidden"
									id="imageUrl" name="imageUrl" value="">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>Duration To:</label>

								<div class="input-group date">
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<input type="text" class="form-control pull-right"
										id="datepicker" name="durationTo"
										data-date-format="dd/mm/yyyy" placeholder="dd/MM/yyyy">
								</div>
							</div>
						</div>
					</div>
					<!-- /.row -->
				</div>
				<div class="box-footer">
					<button type="submit" id="btn-save" class="btn btn-primary">Submit</button>
					<button type="reset" class="btn btn-default">Reset</button>
					<a href="${pageContext.request.contextPath}/offers"><button
							type="button"
							style="background-color: firebrick !important; color: white"
							class="btn btn-default" onclick="">Back</button></a>
				</div>
			</form:form>
		</div>
	</section>
	<input type="hidden" id="error" value="${error}">
	<!-- /.content -->
	<input type="hidden" id="itemListUrl" name="itemListUrl"
		value="${pageContext.request.contextPath}/items">
</div>
<!-- /.content-wrapper -->
<script>
	$(document).ready(function() {
		$('#datepicker').datepicker({
			autoclose : true
		})
		$('#datepicker1').datepicker({
			autoclose : true
		})
		var status = "${status}";
		if (status != null && status != "null" && status != "")
			alert("Offer Saved Successfully");

	});
	$('#imageUrl').change(function(event) { // var tmppath = event.target.files[0].name;
		//$("img").fadeIn("fast").attr('src',URL.createObjectURL(event.target.files[0]));

	});
	function uploadImage() {
		var tmppath = URL.createObjectURL(event.target.files[0]);
		var imageFile = $("#imageUrl").val();
		$('#imageUrl').val(imageFile);
	}
	function selectCategory() {
		var type = $("#types option:selected").val();
		$('#category').val(type);
	}
	function selectStatus() {
		var status = $("#status option:selected").text();
		if (status == "Active") {
			$('#active').val(true);
		} else {
			$('#active').val(false);
		}
	}

	/* 	function insertData() {
	 var userType = $("#userType option:selected").text();
	 var mobileNo = $('#mobileNo').val();
	 var name = $('#name').val();
	 var address = $('#address').val();
	 var userListUrl = $('#userListUrl').val();
	 var pathname = window.location.pathname;
	 var api_url = pathname + '/rest/user';
	 $.ajax({
	 url : api_url + "/" + mobileNo + "/" + userType + "/" + name + "/"
	 + address,
	 contentType : "application/json",
	 dataType : 'json',
	 success : function(result) {
	 console.log(result);
	 if (result.status == "Success") {
	 var r = confirm("Data save successfully! Go to User list");
	 if (r == true) {
	 window.location = userListUrl;
	 }
	 //window.location="";
	 } else {
	 alert("Please check some error occur.");
	 }
	 }
	 });
	 } */
</script>