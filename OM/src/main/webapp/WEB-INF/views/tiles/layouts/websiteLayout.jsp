<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><tiles:getAsString name="title" /></title>

  <link href="<c:url value='/static/website/assets/css/bootstrap.min.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/assets/css/main.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/assets/css/blue.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/assets/css/owl.carousel.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/assets/css/owl.transitions.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/assets/css/animate.min.css' />" rel="stylesheet"></link>
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

</body>
</html>