<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="<c:url value='/static/bower_components/jquery/dist/jquery.min.js'/>"></script>

 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       Customer List
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Customer</li>
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
              <h3 class="box-title"><a href="${pageContext.request.contextPath}/apiCustomerCreate" class="btn btn-block btn-primary btn-flat">Create Item +</a></h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead style="background-color: #3c8dbc;color: #fdfdfd;">
                <tr>
                  <th>Name</th>
                  <th>M.No</th>
                  <th>Email</th>
                  <th>GST NO.</th>
                  <th>Shope Name</th>
                  <th>SGSTCode</th>
                  <th>State</th>
                  <th>City</th>
                  <th>Pincode</th>
                  <!-- <th>Area</th> -->
                  <th>land Mark</th>
                  <th>Action</th>
                </tr>
                </thead>
                <tbody>
                   <c:forEach items="${customerResponses.data}" var="registeredCust" varStatus="status">
                <tr>
                  <td>${registeredCust.personName}</td>
                  <td>${registeredCust.mob}</td>
                  <td>${registeredCust.email}</td>
				  <td>${registeredCust.gstNo}</td>
                  <td>${registeredCust.shopName}</td>
                  <td>${registeredCust.stateGstCode}</td>
                  <td>${registeredCust.stateName}</td>
                  <td>${registeredCust.city}</td>
                  <td>${registeredCust.pincode}</td>
                 <%--  <td>${registeredCust.area}</td> --%>
                  <td>${registeredCust.landMark}</td>
                  <td><i class="fa fa-fw fa-bank" onclick="javascript:cancelCustomer(${registeredCust.id});"></i> <i class="fa fa-fw fa-trash-o" onclick="javascript:deleteCustomer(${registeredCust.id});"></i></td>
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
        <!-- /.col -->
      </div>
      <!-- /.row -->
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
  function deleteCustomer(customerId){
	  var path=$('#activeItemUrl').val();
	  var pathname = window.location.pathname;
	  var api_url = pathname+'/rest/customer/delete';
	  $.ajax({
	        url: api_url + "/" + userId,
	        contentType: "application/json",
	        dataType: 'json',
	        success: function(result){
	            console.log(result);
	           if(result.status=="Success"){
	            		window.location="/OM/apiCustomer";
	            }else{
	            	alert("Please check some error occur.");
	            }
	        }
	    });
  }
  </script>