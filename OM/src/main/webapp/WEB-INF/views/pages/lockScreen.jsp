<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="<c:url value='/static/bower_components/jquery/dist/jquery.min.js'/>"></script>
<div class="lockscreen-wrapper">
	<div class="lockscreen-logo">
		<a href="javascript:(0)"><b>Online Marts</b> Software Solution</a>
	</div>
	<!-- User name -->
	<!-- <div class="lockscreen-name">  Error</div> -->
	<div class="lockscreen-name" id="errorValue" style="color: #f30a55;">
		Your mobile no. is not authorized for this login. Please contact with
		Admin team!<br />
	</div>
	<div class="lockscreen-name">
		Online Marts<br />
	</div>
	<!-- START LOCK SCREEN ITEM -->
	<div class="lockscreen-item">
		<!-- lockscreen image -->
		<div class="lockscreen-image">
			<img src="static/dist/img/profile.png" alt="User Image">
		</div>
		<!-- /.lockscreen-image -->

		<!-- lockscreen credentials (contains the form) -->
		<form action="${pageContext.request.contextPath}/index"
			class="lockscreen-credentials">
			<div class="input-group">
				<input type="password" name="password" class="form-control"
					placeholder="You Mobile">

				<div class="input-group-btn">
					<button type="submit" class="btn">
						<i class="fa fa-arrow-right text-muted"></i>
					</button>
				</div>
			</div>
		</form>
		<!-- /.lockscreen credentials -->

	</div>
	<!-- /.lockscreen-item -->
	<div class="help-block text-center">Enter your password to
		retrieve your session</div>
	<div class="text-center">
		<a href="${pageContext.request.contextPath}/createCustomer">Or
			sign in as a different user</a>
	</div>
	<div class="lockscreen-footer text-center">
		Copyright &copy; 2019-2020 <b><a href="javascript:(0)"
			class="text-black">Umang Software Solution</a></b><br> All rights
		reserved
	</div>
</div>
<script>
	$(document).ready(function() {
		$('#errorValue').css('display', 'none');
		var tech = getUrlParameter('error');
		if (typeof tech === 'undefined') {
			$('#errorValue').css('display', 'none');
		} else if (tech === null) {
			$('#errorValue').css('display', 'none');
		} else {
			$('#errorValue').css('display', 'block');
		}
	});
	var getUrlParameter = function getUrlParameter(sParam) {
		var sPageURL = window.location.search.substring(1), sURLVariables = sPageURL
				.split('&'), sParameterName, i;

		for (i = 0; i < sURLVariables.length; i++) {
			sParameterName = sURLVariables[i].split('=');

			if (sParameterName[0] === sParam) {
				return sParameterName[1] === undefined ? true
						: decodeURIComponent(sParameterName[1]);
			}
		}
	};
</script>