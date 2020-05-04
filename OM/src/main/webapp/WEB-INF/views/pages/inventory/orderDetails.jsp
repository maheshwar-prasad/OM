<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript"
	src="<c:url value='/static/bower_components/jquery/dist/jquery.min.js'/>"></script>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>Order Details</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Order Details</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
<div class="row">
			<div class="col-md-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">
							<a href="${pageContext.request.contextPath}/deleteOrder?order-number=${orderDetail.orderNumber}"
								class="btn btn-block btn-primary btn-flat">Delete Order</a>
						</h3>
						<h3 class="box-title">
							<a href="${pageContext.request.contextPath}/markDelivered?order-number=${orderDetail.orderNumber}"
								class="btn btn-block btn-primary btn-flat">Mark Delivered</a>
						</h3>
						<h3 class="box-title">
							<a href="${pageContext.request.contextPath}/cancelOrder?order-number=${orderDetail.orderNumber}"
								class="btn btn-block btn-primary btn-flat">Cancel Order</a>
						</h3>
						<h3 class="box-title">
							<a href="${pageContext.request.contextPath}/acceptOrder?order-number=${orderDetail.orderNumber}"
								class="btn btn-block btn-primary btn-flat">Accept Order</a>
						</h3>
					</div>
					<!-- /.box-header -->
					</div>
					</div>
					</div>
		<div class="box box-default">
			<div class="box-header with-border">
				<h3 class="box-title">Order</h3>

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
			<div class="box-body">
				<table id="example1" class="table table-bordered table-striped">
					<tr>
						<td>Order No. ${orderDetail.orderNumber}</td>
						<td>Total Amount INR. ${orderDetail.totalAmount}</td>
						<td>Order Date : <c:set var="order_date"
								value="${orderDetail.orderDate}" /> <fmt:formatDate type="both"
								value="${order_date}" />
						</td>
						<td>Order Status : ${orderDetail.orderStatus}</td>
						<td>Rejected On : <c:if test="${not empty orderDetail.rejectedOn}">
						<c:set var="reject_date"
								value="${orderDetail.rejectedOn}" /> <fmt:formatDate type="both"
								value="${reject_date}" />
						</c:if>
						</td>
					</tr>
					<tr>
						<td>Accepted On : <c:if test="${not empty orderDetail.acceptedOn}">
						<c:set var="accept_date"
								value="${orderDetail.acceptedOn}" /> <fmt:formatDate type="both"
								value="${accept_date}" />
						</c:if></td>
						<td>Delivered On : <c:if test="${not empty orderDetail.deliveredOn}">
						<c:set var="dilivered_date"
								value="${orderDetail.deliveredOn}" /> <fmt:formatDate type="both"
								value="${dilivered_date}" />
						</c:if></td>
						<td>Remarks : <c:if test="${not empty orderDetail.remark}">${orderDetail.remark}</c:if> </td>
						<td>Cancelled By : <c:if test="${not empty orderDetail.cancelledBy}">${orderDetail.cancelledBy}</c:if> </td>
					</tr>
					<c:if test="${not empty orderDetail.customerDto}">
					<tr>
						<td>Shop Name : ${orderDetail.customerDto.shopName}</td>
						<td>GST No. : ${orderDetail.customerDto.gstNo}</td>
						<td>Plot No. : ${orderDetail.customerDto.plotNo}</td>
						<td>Road Name : ${orderDetail.customerDto.roadName}</td>
						<td>Area : ${orderDetail.customerDto.area}</td>
					</tr>
					<tr>
						<td>Pincode : ${orderDetail.customerDto.pincode}</td>
						<td>LandMark : ${orderDetail.customerDto.landMark}</td>
						<td>Shop Phone : ${orderDetail.customerDto.shopPhone}</td>
						<td>State : ${orderDetail.customerDto.stateName}</td>
						<td>GST Code : ${orderDetail.customerDto.stateGstCode}</td>
					</tr>
					
					<tr>
						<td>City : ${orderDetail.customerDto.city}</td>
						<td>Customer Name : ${orderDetail.customerDto.personName}</td>
						<td>Email : ${orderDetail.customerDto.email}</td>
						<td>Mobile : ${orderDetail.customerDto.mob}</td>
					</tr>
                 </c:if>
                 <c:if test="${not empty orderDetail.consigneeDto}">
					<tr>
						<td>Plot No. : ${orderDetail.consigneeDto.plotNo}</td>
						<td>Road Name : ${orderDetail.consigneeDto.roadName}</td>
						<td>Area : ${orderDetail.consigneeDto.area}</td>
						<td>Pincode : ${orderDetail.consigneeDto.pincode}</td>
						<td>Landmark : ${orderDetail.consigneeDto.landMark}</td>
					</tr>
					<tr>
						<td>Customer Name : ${orderDetail.consigneeDto.consigneeName}</td>
						<td>Email : ${orderDetail.consigneeDto.email}</td>
						<td>Mobile : ${orderDetail.consigneeDto.mob}</td>
						<td>Address Line1 : ${orderDetail.consigneeDto.addressLine1}</td>
						<td>Address Line2 :  ${orderDetail.consigneeDto.addressLine2}</td>
					</tr>
                 </c:if>
                 <c:forEach items="${orderDetail.ordersDtos}" var="orders" varStatus="status">
                 <tr>
						<td>Amount INR : ${orders.amount}</td>
						<td>Order Date : <c:set var="ordr_date"
								value="${orders.orderDate}" /> <fmt:formatDate type="both"
								value="${ordr_date}" /></td>
						<td>Item : ${orders.itemsDto.itemName}</td>
						<td>Status : ${orders.orderStatus}</td>
						<td>Qty :  ${orders.qty}</td>
					</tr>
					<tr>
						<td>Unit Price : ${orders.itemsDto.unitPrice}</td>
						<td>Mrp. : ${orders.itemsDto.mrp}</td>
					</tr>
                 </c:forEach>
                 
				</table>
			</div>
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