<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/static/website/assets/images/favicon.ico">
	<title><tiles:getAsString name="title" /></title>

  <link href="<c:url value='/static/website/assets/css/bootstrap.min.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/assets/css/main.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/assets/css/blue.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/assets/css/owl.carousel.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/assets/css/owl.transitions.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/assets/css/animate.min.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/assets/css/rateit.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/assets/css/bootstrap-select.min.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/assets/css/font-awesome.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/assets/css/lightbox.css' />" rel="stylesheet"></link>


<link href='http://fonts.googleapis.com/css?family=Roboto:300,400,500,700' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,600italic,700,700italic,800' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>

</head>
 
<body class="hold-transition skin-blue sidebar-mini">
<%-- <%
    session=request.getSession(false);
    if(session.getAttribute("user")==null)
    {
        response.sendRedirect("redirect:/");
    }

%> --%>
<div class="wrapper">
		<header id="header">
			<tiles:insertAttribute name="header" />
		</header>
	
		<section id="sidemenu">
			<tiles:insertAttribute name="menu" />
		</section>
			
		<section id="site-content">
			<tiles:insertAttribute name="body" />
		</section>
		
		<footer id="footer">
			<tiles:insertAttribute name="footer" />
		</footer>
</div>
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
       <!--  <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div> -->
        <div class="modal-body">
          <p style="font-weight: 800;text-align: center;font-size: x-large;">Coming Soon..</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  

<script type="text/javascript" src="<c:url value='/static/website/assets/js/jquery-1.11.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/website/assets/js/bootstrap.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/website/assets/js/bootstrap-hover-dropdown.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/website/assets/js/owl.carousel.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/website/assets/js/echo.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/website/assets/js/jquery.easing-1.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/website/assets/js/bootstrap-slider.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/website/assets/js/jquery.rateit.min.js'/>"></script>

<script type="text/javascript" src="<c:url value='/static/website/assets/js/lightbox.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/website/assets/js/bootstrap-select.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/website/assets/js/wow.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/website/assets/js/scripts.js'/>"></script>

<script type="text/javascript">
$( document ).ready(function() {
	 showCart();
});
function showCart(){
	  $.ajax({
		  contentType: 'application/json',
        type: "POST",
        dataType: 'text',
        url: "/OM/showCart",
        success: function (data) {
        	$('.product-summary').html('');
        	$('.total-price-basket').html('cart -&#x20b9; 0.00');
      	$('.basket-item-count').html('0');
      	$('.userdetail').html('Login');
        	var json = JSON.parse(data);
        	if(json["status"]=="Success"){
        		var html;
        		$('.basket-item-count').html("<span class='count'> "+json["count"]+"</span>");
        		if(json["totalamount"] == null){
        			$("#checkOut").css("display", "none");
        			$('.total-price-basket').html('<span class="lbl">cart -</span> <span class="total-price"> <span class="sign">&#x20b9; </span><span class="value">'+"0.00"+'</span> </span>');
        		}else{
        			$('.total-price-basket').html('<span class="lbl">cart -</span> <span class="total-price"> <span class="sign">&#x20b9; </span><span class="value">'+json["totalamount"]+'</span> </span>');
        		$("#checkOut").css("display", "block");
        		}
        		
        		$.each(json.addcartData , function(index, item) { 
        			var html ='<div class="row"><div class="col-xs-4"><div class="image"> <a href="detail.html"><img src='+item.imagePath+'  alt=""></a> </div></div>  <div class="col-xs-7"><h3 class="name"><a href="index8a95.html?page-detail">'+item.itemName+'</a></h3><div class="price"> &#x20b9; '+item.price+'</div></div> <div class="col-xs-1 action"> <a href="javascript:deleteCard('+item.productId+')"><i class="fa fa-trash"></i></a> </div> </div><hr>';
        			$('.product-summary').append(html);
        			$('.userdetail').html(json.user.name);
        		});
        	}else{
        		 //$("#add-cart").prop("disabled", false);
        	}
        },
        error: function (e) {
            $("#btn-save").prop("disabled", false);
            //...
        }
		});
}
function deleteCard(action){
	  $.ajax({
		  contentType: 'application/json',
        type: "GET",
        dataType: 'text',
        url: "/OM/deleteCart/"+action,
        success: function (data) {
        	$('.product-summary').html('');
        	$('.basket-item-count').html('0');
        	$('.total-price-basket').html('cart -&#x20b9; 0.00');
        	var json = JSON.parse(data);
        	if(json['message']=="Success"){
        		var html;
        		$('.basket-item-count').html("<span class='count'> "+json["count"]+"</span>");
        		/* $('.total-price-basket').html('<span class="lbl">cart -</span> <span class="total-price"> <span class="sign">&#x20b9;</span><span class="value">'+json["totalamount"]+'</span> </span>'); */
        		if(json["totalamount"] == null){
        			$("#checkOut").css("display", "none");
        			$('.total-price-basket').html('<span class="lbl">cart -</span> <span class="total-price"> <span class="sign">&#x20b9; </span><span class="value">'+"0.00"+'</span> </span>');
        		}else{
        			$('.total-price-basket').html('<span class="lbl">cart -</span> <span class="total-price"> <span class="sign">&#x20b9; </span><span class="value">'+json["totalamount"]+'</span> </span>');
        		$("#checkOut").css("display", "block");
        		}
        		$.each(json.addcartData , function(index, item) { 
        			var html ='<div class="row"><div class="col-xs-4"><div class="image"> <a href="detail.html"><img src='+item.imagePath+'  alt=""></a> </div></div>  <div class="col-xs-7"><h3 class="name"><a href="index8a95.html?page-detail">'+item.itemName+'</a></h3><div class="price"> &#x20b9; '+item.price+'</div></div> <div class="col-xs-1 action"> <a href="javascript:deleteCard('+item.productId+')"><i class="fa fa-trash"></i></a> </div> </div><hr>';
        			$('.product-summary').append(html);
        		});
        	}else{
        		 //$("#add-cart").prop("disabled", false);
        	}
        },
        error: function (e) {
            $("#btn-save").prop("disabled", false);
            //...
        }
		});
}
</script>
</body>
</html>