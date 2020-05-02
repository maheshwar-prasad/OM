
<!-- ============================================== HEADER : END ============================================== -->
<div class="breadcrumb">
	<div class="container">
		<div class="breadcrumb-inner">
			<ul class="list-inline list-unstyled">
				<li><a href="home.html">Home</a></li>
				<li class='active'>Login</li>
			</ul>
		</div><!-- /.breadcrumb-inner -->
	</div><!-- /.container -->
</div><!-- /.breadcrumb -->

<div class="body-content">
	<div class="container">
		<div class="sign-in-page">
<div class="row">
				<!-- Sign-in -->			
<!-- <div class="col-md-6 col-sm-6 sign-in">
	<h4 class="">Sign in</h4>
	<p class="">Hello, Welcome to your account.</p>
	<div class="social-sign-in outer-top-xs">
		<a href="#" class="facebook-sign-in"><i class="fa fa-facebook"></i> Sign In with Facebook</a>
		<a href="#" class="twitter-sign-in"><i class="fa fa-twitter"></i> Sign In with Twitter</a>
	</div>
	<form class="register-form outer-top-xs" role="form">
		<div class="form-group">
		    <label class="info-title" for="exampleInputEmail1">Email Address <span>*</span></label>
		    <input type="email" class="form-control unicase-form-control text-input" id="exampleInputEmail1" >
		</div>
	  	<div class="form-group">
		    <label class="info-title" for="exampleInputPassword1">Password <span>*</span></label>
		    <input type="password" class="form-control unicase-form-control text-input" id="exampleInputPassword1" >
		</div>
		<div class="radio outer-xs">
		  	<label>
		    	<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">Remember me!
		  	</label>
		  	<a href="#" class="forgot-password pull-right">Forgot your Password?</a>
		</div>
	  	<button type="submit" class="btn-upper btn btn-primary checkout-page-button">Login</button>
	</form>					
</div> -->
<!-- Sign-in -->

<!-- create a new account -->
<div class="col-md-6 col-sm-6 create-new-account">
	<h4 class="checkout-subtitle">Shipping Address</h4>
	<form class="register-form outer-top-xs" role="form">
        <div class="form-group">
		    <label class="info-title" for="exampleInputEmail1">Name <span>*</span></label>
		    <input type="text" class="form-control unicase-form-control text-input" id="name" value="${user.name}">
		</div>
        <div class="form-group">
		    <label class="info-title" for="exampleInputEmail1">Phone Number <span>*</span></label>
		    <input type="text" class="form-control unicase-form-control text-input" id="phone" value="${user.phone}">
		</div>
		<div class="form-group">
	    	<label class="info-title" for="exampleInputEmail2">Email Address <span>(Optional)</span></label>
	    	<input type="text" class="form-control unicase-form-control text-input" id="email" value="${user.email}">
	  	</div>
	  	<div class="form-group">
	    	<label class="info-title" for="exampleInputEmail2">Shipping Address <span>*</span></label>
	    	<input type="text" class="form-control unicase-form-control text-input" id="address1" value="${user.address1}">
	  	</div>
        <div class="form-group">
		    <label class="info-title" for="exampleInputEmail1">Country <span>*</span></label>
		    <input type="text" class="form-control unicase-form-control text-input" id="country" value="${user.county}">
		</div>
         <div class="form-group">
		    <label class="info-title" for="exampleInputEmail1">State/Province<span>*</span></label>
		    <input type="text" class="form-control unicase-form-control text-input" id="state" value="${user.state}">
		</div>
		 <div class="form-group">
		    <label class="info-title" for="exampleInputEmail1">City<span>*</span></label>
		    <input type="text" class="form-control unicase-form-control text-input" id="city" value="${user.city}">
		</div>
		 <div class="form-group">
		    <label class="info-title" for="exampleInputEmail1">Zip/Postal Code<span>*</span></label>
		    <input type="text" class="form-control unicase-form-control text-input" id="zip" value="${user.zip}">
		</div>
	  	<button type="button" id="btn-save" class="btn-upper btn btn-primary checkout-page-button">Save</button>
	  	<button type="reset" id="btn-reset" class="btn-upper btn btn-primary checkout-page-button">Reset</button>
	</form>
</div>	
</div><!-- /.row -->
</div><!-- /.sigin-in-->
		<!-- ============================================== BRANDS CAROUSEL ============================================== -->

<!-- ============================================== BRANDS CAROUSEL : END ============================================== -->	</div><!-- /.container -->
</div><!-- /.body-content -->
<script type="text/javascript">
$(document ).ready(function() {
});
$("#btn-save").click(function(event) {
	var formData = {};
	formData["name"] = $('#name').val();
   	formData["phone"] = $('#phone').val();
	formData["email"] = $('#email').val();
	formData["address1"] = $('#address1').val();
	formData["country"] = $('#country').val();
	formData["state"] = $('#state').val();
	formData["city"] = $('#city').val();
	formData["zip"] = $('#zip').val();
	formData["username"] = "Guest";
		$.ajax({
			contentType: 'application/json',
           type: "POST",
           dataType: 'text',
           url: "/OM/webusrReg",
           data: JSON.stringify(formData),
           success: function (data) {
        	   alert(data);
        	   $('.Message').html('');
        	   $('.userdetail').html('Login');
           /* 	$('.product-summary').html('');
           	$('.total-price-basket').html('0.00');
           	$('.basket-item-count').html('0'); */
           	var json = JSON.parse(data);
           	if(json["status"]=="Success"){
           	 $('.Message').html('<span style="color: #ffffff;background-color: darkblue;"> Registration Successfully.</span>');
           	 $("#regForm").trigger("reset");
           	 $('.userdetail').html(json.user.name);
   		
           	}else{
           		 //$("#add-cart").prop("disabled", false);
           	}
           },
           error: function (e) {
               $("#btn-save").prop("disabled", false);
               //...
           }
		});
});
$("#btn-login").click(function(event) {
	alert('ok');
	var formData = {};
	formData["email"] = $('#email').val();
   	formData["password"] = $('#password').val();
		$.ajax({
			contentType: 'application/json',
           type: "POST",
           dataType: 'text',
           url: "/OM/webusrLogin",
           data: JSON.stringify(formData),
           success: function (data) {
        	   alert(data);
        	   $('.Message').html('');
        	   $('.userdetail').html('Login');
           /* 	$('.product-summary').html('');
           	$('.total-price-basket').html('0.00');
           	$('.basket-item-count').html('0'); */
           	var json = JSON.parse(data);
           	if(json["status"]=="Success"){
           		window.location="/OM/";
           	 //$('.Message').html('<span style="color: #ffffff;background-color: darkblue;"> Registration Successfully.</span>');
           	 $("#loginForm").trigger("reset");
           	 $('.userdetail').html(json.user.name);
   		
           	}else{
           		 //$("#add-cart").prop("disabled", false);
           	}
           },
           error: function (e) {
               $("#btn-save").prop("disabled", false);
               //...
           }
		});
});
$("#btn-save").click(function(event) {
	var radioValue = $("input[name='regradio']:checked"). val();
	if(radioValue=="register"){
		window.location="/OM/signIn.do";
	}else if(radioValue=="guest"){
		window.location="/OM/shippingAddress.do";
	}
});
</script>


