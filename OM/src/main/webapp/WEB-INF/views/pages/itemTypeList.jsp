<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="<c:url value='/static/bower_components/jquery/dist/jquery.min.js'/>"></script>

 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       Items Type List
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
              <h3 class="box-title"><a href="${pageContext.request.contextPath}/itemType" class="btn btn-block btn-primary btn-flat">Create Item Type +</a></h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead style="background-color: #3c8dbc;color: #fdfdfd;">
                <tr>
                  <th>Name</th>
                  <th>Status</th>
                  <th>Action</th>
                </tr>
                </thead>
                <tbody>
               <c:forEach items="${itemTypeList}" var="type" varStatus="tstatus">
                <tr>
                  <td>${type.categoryName}</td>
                  <td>${type.displayOrder}</td>
                  <td><i class="fa fa-fw fa-bank" onclick="javascript:(0);"></i> <i class="fa fa-fw fa-trash-o" onclick="javascript:deleteUser(${type.id});"></i></td>
                </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr> </tr>
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
  </div>
  <!-- /.content-wrapper -->
  <script type="text/javascript">
  $( document ).ready(function() {
	 
	  
  });
  function edit(userId){
	  
	  var path=$('#activeUserUrl').val();
	  alert(path);
	  var pathname = window.location.pathname;
	  var api_url = path+'/editUser'+"/"+userId;
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
	    });*/
  }
  function deleteUser(userId){
	  var path=$('#activeUserUrl').val();
	  var pathname = window.location.pathname;
	  var api_url = pathname+'/rest/user/delete';
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
  </script>