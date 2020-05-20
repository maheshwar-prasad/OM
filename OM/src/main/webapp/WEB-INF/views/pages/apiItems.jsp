<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="<c:url value='/static/bower_components/jquery/dist/jquery.min.js'/>"></script>

 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       Items List
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Items</li>
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
              <h3 class="box-title"><a href="${pageContext.request.contextPath}/itemCreate" class="btn btn-block btn-primary btn-flat">Create Item +</a></h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead style="background-color: #3c8dbc;color: #fdfdfd;">
                <tr>
                  <th>Item Code</th>
                  <th>Item Name</th>
                  <th>Item Type</th>
                  <th>Description</th>
                  <th>MRP(Rs.)</th>
                  <th>Pack</th>
                  <th>Display Order</th>
                  <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${itemList.size()>0}">
                   <c:forEach items="${itemList}" var="items" varStatus="status">
                <tr>
                  <td>${items.itemCode}</td>
                  <td>${items.itemName}</td>
                  <td></td>
                  <td>${items.description}</td>
                  <td>${items.mrp}</td>
                  <td>${items.pack}</td>
                  <td>${items.displayOrder}</td>
                  <td><i class="fa fa-fw fa-bank" onclick="javascript:edit(${items.id});"></i> <i class="fa fa-fw fa-trash-o" onclick="javascript:deleteItem(${items.id});"></i></td>
                </tr>
               </c:forEach>
               </c:if>
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
     <input type="hidden" id="activeItemUrl" value="${pageContext.request.contextPath}/apiItems">
  </div>
  <!-- /.content-wrapper -->
  <script type="text/javascript">
  $( document ).ready(function() {
	  
  });
  function edit(itemId){
	  
	  var path=$('#activeItemUrl').val();
	  var pathname = window.location.pathname;
	  var api_url = path+'/editItem'+"/"+itemId;
	  window.location=api_url;
	   $.ajax({
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
	    }); 
  }
  function deleteItem(itemId){
	  var path=$('#activeItemUrl').val();
	  var pathname = window.location.pathname;
	  var api_url = pathname+'/rest/item/delete';
	  var r=confirm("Are you sure ! You want to delete Tthis Item");
  	if(r==true){
	  $.ajax({
	        url: api_url + "/" + itemId,
	        contentType: "application/json",
	        dataType: 'json',
	        success: function(result){
	            console.log(result);
	           if(result.status=="Success"){
	            		window.location="/OM/apiItems";
	            }else{
	            	alert("Please check some error occur.");
	            }
	        }
	    });
     }
  }
  </script>