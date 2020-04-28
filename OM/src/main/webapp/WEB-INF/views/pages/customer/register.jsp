<!DOCTYPE html>
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<script type="text/javascript" src="<c:url value='/static/bower_components/jquery/dist/jquery.min.js'/>"></script>

<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href="javascript:(0)"><b>Online</b>Mart</a>
  </div>

  <div class="register-box-body">
    <p class="login-box-msg" style="color: forestgreen;font-family: fantasy;">Register a new membership</p>

    <form id="submitForm"  role="form" method="post">
      <div class="form-group has-feedback">
        <input type="text" id="name" class="form-control" placeholder="Full name">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="text" id="mobno" class="form-control" placeholder="Mobile No.">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="text" id="companyname" class="form-control" placeholder="Company Name">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="text" id="address" class="form-control" placeholder="Address">
        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
      </div>
       <div class="form-group has-feedback">
        <input type="text" id="type" class="form-control" placeholder="" value="Customer" disabled="disabled">
      </div>
      <div class="row">
        <div class="col-xs-6">
          <div class="">
            <button type="button" onclick="javascript:goToLogin();" class="btn btn-primary btn-block btn-flat">Login</button>
         </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-6">
          <button type="button" id="btn-save" class="btn btn-primary btn-block btn-flat">Register</button>
        </div>
        <!-- /.col -->
      </div>
    </form>


    <a href="login.html" class="text-center">I already have a membership</a>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->


<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' /* optional */
    });
  });
  function goToLogin(){
	 window.location="/OM"; 
  }
 $('#btn-save').click(function(event) {
	 alert('hello');
	 var formData = {};
	 formData["name"] = $("#name").val();
	 formData["username"] = $("#mobno").val();
	 formData["companyName"] = $("#companyname").val();
	 formData["address1"] = $("#address").val();
	 formData["userType"] = $("#type").val();
	 $.ajax({
         type: "POST",
         contentType: "application/json",
         url: "/OM/saveCustomer",
         data: JSON.stringify(formData),
         dataType: 'json',
         timeout: 600000,
         success: function (data) {
        	 alert(data);
         	if(data.status=="Success"){
         		 var r=confirm("Data save successfully! Go to Item list");
		            	if(r==true){
		            		window.location=itemListUrl;
		            	}else{
		            		$("#btn-save").prop("disabled", true);	
		            	}
         	}else{
         		 $("#btn-save").prop("disabled", false);
         		 alert(data.status);
         	}
         },
         error: function (e) {
             $("#btn-save").prop("disabled", false);
         }
		});
	/*  $.ajax({
         type: form.attr('method'), // method attribute of form
         url: form.attr('action'),  // action attribute of form
         dataType : 'json',
	    // convert form data to json format
         data : JSON.stringify(formData),
     }); */
	}); 
</script>
</body>

<!-- Mirrored from adminlte.io/themes/AdminLTE/pages/examples/register.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 02 Apr 2020 14:13:28 GMT -->
</html>
