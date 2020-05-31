
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"
	src="<c:url value='/static/bower_components/jquery/dist/jquery.min.js'/>"></script>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>Create Stock</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Create Stock</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">

		<div class="box box-default">
			<div class="box-header with-border">
				<h3 class="box-title">Stock</h3>

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


			<form:form role="form" method="post" modelAttribute="stockForm"
				action="${pageContext.request.contextPath}/clientSaveStock" id="stockForm">
				<div class="box-body">
					<div class="row">
						<div class="box-body">
							<table id="example1" class="table table-bordered table-striped">
								<tr>
									<th>No.</th>
									<th>Item Name</th>
									<th>Quantity</th>

								</tr>
								<c:forEach items="${stocks}" var="stck" varStatus="status">
									<tr>
										<td align="center">${status.count}</td>
										<td><form:input type="hidden"
												path="stock[${status.count-1}].dto.id" name="${stck.dto.id}"
												value="${stck.dto.id}" /> <input
											name="${stck.dto.itemName}" value="${stck.dto.itemName} (${stck.dto.pack})" /></td>
										<td><form:input name="${stck.dto.id}qty"
												path="stock[${status.count-1}].qty" value="${stck.qty}" /></td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
				<br />
				<div class="box-footer" style="text-align: center;">
					<button type="submit"  class="btn btn-primary">Submit</button>
					<button type="button" onclick="javascript:gotoBack();"
						class="btn btn-default">Back</button>

				</div>
			</form:form>
		</div>
	</section>
	<!-- /.content -->
	<input type="hidden" id="itemListUrl" name="itemListUrl"
		value="${pageContext.request.contextPath}/clientItems">
</div>
<!-- /.content-wrapper -->
<script>
	$(document).ready(function() {
		var status = "${status}";
		if (status != null && status != "null" && status != "")
			alert("Problem to create stock!");
	});
	function gotoBack() {
		window.location = "/OM/clientStock";
	}
</script>