
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
<div class="col-md-6 col-sm-6 sign-in">
	<h4 class="">Sign in</h4>
	<p class="">Hello, Welcome to your account.</p>
	<div class="social-sign-in outer-top-xs">
		<a href="#" class="facebook-sign-in"><i class="fa fa-facebook"></i> Sign In with Facebook</a>
		<a href="#" class="twitter-sign-in"><i class="fa fa-twitter"></i> Sign In with Twitter</a>
	</div>
	<form class="register-form outer-top-xs" role="form" id="loginForm">
		<div class="form-group">
		    <label class="info-title" for="exampleInputEmail1">Email Address <span>*</span></label>
		    <input type="text" name="email"  class="form-control unicase-form-control text-input" id="email" >
		</div>
	  	<div class="form-group">
		    <label class="info-title" for="exampleInputPassword1">Password <span>*</span></label>
		    <input type="password" name="password" class="form-control unicase-form-control text-input" id="password" >
		</div>
		<div class="radio outer-xs">
		  	<label>
		    	<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">Remember me!
		  	</label>
		  	<a href="#" class="forgot-password pull-right">Forgot your Password?</a>
		</div>
	  	<button type="button" id="btn-login" class="btn-upper btn btn-primary checkout-page-button">Login</button>
	</form>					
</div>
<!-- Sign-in -->

<!-- create a new account -->
<div class="col-md-6 col-sm-6 create-new-account">
	<h4 class="checkout-subtitle">Create a new account</h4>
	<p class="text title-tag-line Message"></p>
	<form class="register-form outer-top-xs" role="form" id="regForm">
		<div class="form-group">
	    	<label class="info-title" for="exampleInputEmail2">Email Address <span>*</span></label>
	    	<input type="text" name="email" id ="email" class="form-control unicase-form-control text-input" >
	  	</div>
        <div class="form-group">
		    <label class="info-title" for="exampleInputEmail1">Full Name <span>*</span></label>
		    <input type="text"  name="fullname" id ="fullname" class="form-control unicase-form-control text-input" >
		</div>
        <div class="form-group">
		    <label class="info-title" for="exampleInputEmail1">Phone Number <span>*</span></label>
		    <input type="text"  name="phone" id ="phone" class="form-control unicase-form-control text-input">
		</div>
		<div class="form-group">
		    <label class="info-title" for="exampleInputEmail1">User Name<span>*</span></label>
		    <input type="text"  name="username" id ="username"  class="form-control unicase-form-control text-input" >
		</div>
        <div class="form-group">
		    <label class="info-title" for="exampleInputEmail1">Password <span>*</span></label>
		    <input type="password" name="password" id ="password"  class="form-control unicase-form-control text-input" >
		</div>
         
	  	<button type="button" id="btn-registration" class="btn-upper btn btn-primary checkout-page-button">Sign Up</button>
	</form>
	
	
</div>	
<!-- create a new account -->			</div><!-- /.row -->
		</div><!-- /.sigin-in-->
		<!-- ============================================== BRANDS CAROUSEL ============================================== -->
<%-- <div id="brands-carousel" class="logo-slider wow fadeInUp">

		<div class="logo-slider-inner">	
			<div id="brand-slider" class="owl-carousel brand-slider custom-carousel owl-theme">
				<div class="item m-t-15">
					<a href="#" class="image">
						<img data-echo="${pageContext.request.contextPath}/static/website/assets/images/brands/brand1.png" src="${pageContext.request.contextPath}/static/website/assets/images/blank.gif" alt="">
					</a>	
				</div><!--/.item-->

				<div class="item m-t-10">
					<a href="#" class="image">
						<img data-echo="${pageContext.request.contextPath}/static/website/assets/images/brands/brand2.png" src="${pageContext.request.contextPath}/static/website/assets/images/blank.gif" alt="">
					</a>	
				</div><!--/.item-->

				<div class="item">
					<a href="#" class="image">
						<img data-echo="${pageContext.request.contextPath}/static/website/assets/images/brands/brand3.png" src="${pageContext.request.contextPath}/static/website/assets/images/blank.gif" alt="">
					</a>	
				</div><!--/.item-->

				<div class="item">
					<a href="#" class="image">
						<img data-echo="${pageContext.request.contextPath}/static/website/assets/images/brands/brand4.png" src="${pageContext.request.contextPath}/static/website/assets/images/blank.gif" alt="">
					</a>	
				</div><!--/.item-->

				<div class="item">
					<a href="#" class="image">
						<img data-echo="${pageContext.request.contextPath}/static/website/assets/images/brands/brand5.png" src="${pageContext.request.contextPath}/static/website/assets/images/blank.gif" alt="">
					</a>	
				</div><!--/.item-->

				<div class="item">
					<a href="#" class="image">
						<img data-echo="${pageContext.request.contextPath}/static/website/assets/images/brands/brand6.png" src="${pageContext.request.contextPath}/static/website/assets/images/blank.gif" alt="">
					</a>	
				</div><!--/.item-->

				<div class="item">
					<a href="#" class="image">
						<img data-echo="${pageContext.request.contextPath}/static/website/assets/images/brands/brand2.png" src="${pageContext.request.contextPath}/static/website/assets/images/blank.gif" alt="">
					</a>	
				</div><!--/.item-->

				<div class="item">
					<a href="#" class="image">
						<img data-echo="${pageContext.request.contextPath}/static/website/assets/images/brands/brand4.png" src="${pageContext.request.contextPath}/static/website/assets/images/blank.gif" alt="">
					</a>	
				</div><!--/.item-->

				<div class="item">
					<a href="#" class="image">
						<img data-echo="${pageContext.request.contextPath}/static/website/assets/images/brands/brand1.png" src="${pageContext.request.contextPath}/static/website/assets/images/blank.gif" alt="">
					</a>	
				</div><!--/.item-->

				<div class="item">
					<a href="#" class="image">
						<img data-echo="${pageContext.request.contextPath}/static/website/assets/images/brands/brand5.png" src="${pageContext.request.contextPath}/static/website/assets/images/blank.gif" alt="">
					</a>	
				</div><!--/.item-->
		    </div><!-- /.owl-carousel #logo-slider -->
		</div><!-- /.logo-slider-inner -->
	
</div> --%><!-- /.logo-slider -->
<!-- ============================================== BRANDS CAROUSEL : END ============================================== -->	</div><!-- /.container -->
</div><!-- /.body-content -->
<script type="text/javascript">
$(document ).ready(function() {
	 $('.Message').html('');
});
$("#btn-registration").click(function(event) {
	var formData = {};
	formData["username"] = $('#username').val();
   	formData["password"] = $('#password').val();
	formData["name"] = $('#fullname').val();
	formData["email"] = $('#email').val();
	formData["phone"] = $('#phone').val();
		$.ajax({
			contentType: 'application/json',
           type: "POST",
           dataType: 'text',
           url: "/OM/webusrReg",
           data: JSON.stringify(formData),
           success: function (data) {
        	   $('.Message').html('');
        	   $('.userdetail').html('Login');
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


