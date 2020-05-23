<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="<c:url value='/static/bower_components/jquery/dist/jquery.min.js'/>"></script>

 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       AdminUser List
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">AdminUser</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Info boxes -->
      
      <!-- /.row -->

      <div class="row">
        <div class="col-md-12">
          <div class="box">
            <!-- <div class="box-header">
              <h3 class="box-title"><a href="#" class="btn btn-block btn-primary btn-flat">Create Member +</a></h3>
            </div> -->
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead style="background-color: #3c8dbc;color: #fdfdfd;">
                <tr>
                  <th>ID.</th>
                  <th>Full Name</th>
                  <th>Mobile No.</th>
                  <th>Company Name</th>
                  <th>Address</th>
                  <th>Status</th>
                  <th>Created Date</th>
                  <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userList}" var="user" varStatus="status">
				<tr>
					<td>${user.user_id}</td>
					<td>${user.name}</td>
					<td>${user.phone}</td>
					<td>${user.companyName}</td>
					<td>${user.address1}</td>
					<c:choose>
					 <c:when test="${user.status == 'Success'}">
					 <td><span class="label label-success">${user.status}</span></td>
					 </c:when>
					  <c:when test="${user.status == 'Pending'}">
					  <td><span class="label label-warning">${user.status}</span></td>
					  </c:when>
					   <c:otherwise>
				          <td><span class="label label-danger">${user.status}</span></td>    
				         </c:otherwise>
				      </c:choose>
				
					<td>${user.createdDate}</td>
					<td><span class="label label-success" onclick="javascript:edit(${user.user_id},'1');">Approved</span>&nbsp;<span class="label label-warning" onclick="javascript:edit(${user.user_id},'2');">Pending</span>&nbsp;<span class="label label-danger" onclick="javascript:edit(${user.user_id},'0');">Denied</span></td>
					<%-- <td><i class="fa fa-fw fa-bank" onclick="javascript:edit(${user.user_id});"></i> <i class="fa fa-fw fa-trash-o" onclick="javascript:deleteUser(${user.user_id});"></i></td> --%>
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
     <input type="hidden" id="activeItemUrl" value="${pageContext.request.contextPath}/apiItems">
  </div>
  <!-- /.content-wrapper -->
  <script type="text/javascript">
  $( document ).ready(function() {
	  
  });
  function edit(userId,status){
	  
	  var path=$('#activeItemUrl').val();
	  var pathname = window.location.pathname;
	    $.ajax({
	        url: "/OM/permissionUpdate/" + userId+"/"+status,
	        contentType: "application/json",
	        dataType: 'json',
	        success: function(result){
	           if(result.status=="Success"){
	            		window.location="/OM/userPermission";
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