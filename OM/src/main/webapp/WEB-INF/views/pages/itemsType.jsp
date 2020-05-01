<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"
	src="<c:url value='/static/bower_components/jquery/dist/jquery.min.js'/>"></script>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>Create Item Type</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Items</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">

		<div class="box box-default">
			<div class="box-header with-border">
				<h3 class="box-title">Type</h3>

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
			<form:form role="form" method="post" modelAttribute="category"
				action="${pageContext.request.contextPath}/saveItemType"
				id="catForm">
				<div class="box-body">
					<div class="row">
						<div class="col-md-6">

							<!-- /.form-group -->
							<div class="form-group">
								<label for="exampleInputEmail1">Category Name</label>
								<form:input type="text" id="categoryName" name="categoryName"
									path="categoryName" class="form-control"
									placeholder="Enter Name" />
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Display Order</label>
								<form:input type="text" id="displayOrder" name="displayOrder"
									path="displayOrder" class="form-control"
									placeholder="Display Order" />
							</div>

							<!-- /.form-group -->
						</div>
						<!-- /.col -->

					</div>
					<!-- /.row -->
				</div>
				<div class="box-footer" style="text-align: -webkit-center">
					<button type="button" onclick="insertData();"
						class="btn btn-primary">Submit</button>
					<button type="reset" class="btn btn-default">Reset</button>
				</div>
			</form:form>
		</div>
	</section>
	<!-- /.content -->
	<input type="hidden" id="userListUrl"
		value="${pageContext.request.contextPath}/itemTypeList">
</div>
<!-- /.content-wrapper -->
<script>
	$(function() {
		//Initialize Select2 Elements
		$('.select2').select2()
	});
	function insertData() {
		document.getElementById("catForm").submit();

	}
</script>