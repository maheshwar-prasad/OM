<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="<c:url value='/static/bower_components/jquery/dist/jquery.min.js'/>"></script>

 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       Order List
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Order</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Info boxes -->
      
      <!-- /.row -->

      <div class="row">
        <div class="col-md-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title"><a href="${pageContext.request.contextPath}/order" class="btn btn-block btn-primary btn-flat">Create Order +</a></h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead style="background-color: #3c8dbc;color: #fdfdfd;">
                <tr>
                  <th>Order Number</th>
                  <th>Quantity</th>
                  <th>Amount</th>
                  <th>Order Date</th>
                  <th>Order Status</th>
                  <th>Action</th>
                </tr>
                </thead>
                <tbody>
                   <c:forEach items="${orderList}" var="orders" varStatus="status">
                <tr>
                  <td>${orders.getSalesOrderDto().orderNumber}</td>
                  <td>${orders.qty}</td>
                  <td>${orders.amount}</td>
                  <td>${orders.orderDate}</td>
                  <td>${orders.orderStatus}</td>
                 <td><i class="fa fa-fw fa-bank" onclick="javascript:cancelOrder(${orders.getSalesOrderDto().orderNumber});"></i> <i class="fa fa-fw fa-trash-o" onclick="javascript:deleteOrder(${orders.id});"></i></td>
                </tr>
               </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                 
                </tr>
                </tfoot>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
      </div>
    </section>
    <!-- /.content -->
     <input type="hidden" id="activeItemUrl" value="${pageContext.request.contextPath}/items">
  </div>
  <!-- /.content-wrapper -->
  <script type="text/javascript">
  $( document ).ready(function() {
	 
	  
  });
  function edit(itemId){
	  
	  var path=$('#activeItemUrl').val();
	  var pathname = window.location.pathname;
	  var api_url = path+'/editItem'+"/"+itemId;
	  alert(api_url);
	  window.location=api_url;
	  /* $.ajax({
	        url: api_url + "/" + userId,
	        contentType: "application/json",
	        dataType: 'json',
	        success: function(result){
	            console.log(result);
	           if(result.status=="Success"){
	            		window.location=path;
	            }else{
	            	alert("Please check some error occur.");
	            }
	        }
	    }); */
  }
  function deleteOrder(orderId){
	  var path=$('#activeItemUrl').val();
	  var pathname = window.location.pathname;
	  var api_url = pathname+'/delete';
	  $.ajax({
	        url: api_url + "/" + orderId,
	        contentType: "application/json",
	        dataType: 'json',
	        success: function(result){
	            console.log(result);
	           if(result.status=="Success"){
	            		window.location="/OMart/order";
	            }else{
	            	alert("Please check some error occur.");
	            }
	        }
	    });
  }
  function cancelOrder(orderNo){
	  var path=$('#activeItemUrl').val();
	  var pathname = window.location.pathname;
	  var api_url = pathname+'/cancel';
	  $.ajax({
	        url: api_url + "/" + orderNo,
	        contentType: "application/json",
	        dataType: 'json',
	        success: function(result){
	            console.log(result);
	           if(result.status=="Success"){
	            		window.location="/OMart/order";
	            }else{
	            	alert("Please check some error occur.");
	            }
	        }
	    });
  }
  </script>