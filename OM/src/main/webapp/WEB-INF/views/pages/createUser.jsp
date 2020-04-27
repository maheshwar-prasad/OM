<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="<c:url value='/static/bower_components/jquery/dist/jquery.min.js'/>"></script>
 
 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
      Create User
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Items</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
   
    <div class="box box-default">
        <div class="box-header with-border">
          <h3 class="box-title">User</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
          </div>
        </div>
        <!-- /.box-header -->
        <form role="form">
        <div class="box-body">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label>Type</label>
                <select class="form-control select2" name="userType" id="userType" style="width: 100%;">
                  <option selected="selected">Admin</option>
                  <option>APP</option>
                  
                </select>
              </div>
              <!-- /.form-group -->
              <div class="form-group">
                  <label for="exampleInputEmail1">Name</label>
                  <input type="text" id="name" name="name" class="form-control"  placeholder="Enter Name" value="${user.name}">
                </div>
              <!-- /.form-group -->
            </div>
            <!-- /.col -->
             <div class="col-md-6">
             <div class="form-group">
                <label>Phone Number:</label>
                <div class="input-group">
                  <div class="input-group-addon">
                    <i class="fa fa-phone"></i>
                  </div>
                  <input type="text" id="mobileNo" name="mobileNo" class="form-control"  placeholder="Enter MobileNo" value="${user.username}" data-mask="" maxlength="10">
                </div>
                <!-- /.input group -->
              </div>
              <!-- /.form-group -->
             <div class="form-group">
                  <label for="exampleInputEmail1">Address</label>
                  <input type="text" name="address" id="address"  class="form-control" placeholder="Enter Address" style="margin: 0px 2px 0px 0px;" value="${user.address1}"></textarea>
                </div>
              <!-- /.form-group -->
            </div>
         </div>
          <!-- /.row -->
        </div>
        <div class="box-footer" style="text-align: -webkit-center">
                <button type="button" onclick="insertData();" class="btn btn-primary">Submit</button>
                 <button type="reset" class="btn btn-default">Reset</button>
        </div>
        </form>
      </div>
    </section>
    <!-- /.content -->
    <input type="hidden" id="userListUrl" value="${pageContext.request.contextPath}/activeUser">
  </div>
  <!-- /.content-wrapper -->
  <script>
  $(function () {
    //Initialize Select2 Elements
    $('.select2').select2()
    });
  function insertData(){
	  var userType= $("#userType option:selected" ).text();
	  var mobileNo= $('#mobileNo').val();
	  var name= $('#name').val();
	  var address= $('#address').val();
	  var userListUrl=$('#userListUrl').val();
	  var pathname = window.location.pathname;
	  var api_url = pathname+'/rest/user';
		  $.ajax({
		        url: api_url + "/" + mobileNo + "/" + userType+"/"+name+"/"+address,
		        contentType: "application/json",
		        dataType: 'json',
		        success: function(result){
		            console.log(result);
		           if(result.status=="Success"){
		        	   var r=confirm("Data save successfully! Go to User list");
		            	if(r==true){
		            		window.location=userListUrl;
		            	}
		            	//window.location="";
		            }else{
		            	alert("Please check some error occur.");
		            }
		        }
		    });
  }
   </script>