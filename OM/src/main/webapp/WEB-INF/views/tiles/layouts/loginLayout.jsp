<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><tiles:getAsString name="title" /></title>
 <link rel="stylesheet" href="<c:url value='/static/login/css/bootstrap.min.css'/>" ></link>
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<c:url value='/static/login/font-awesome/css/font-awesome.min.css'/>" ></link>
  <!-- Ionicons -->
  <link rel="stylesheet" href="<c:url value='/static/login/Ionicons/css/ionicons.min.css'/>" ></link>
  <!-- Theme style -->
  <link rel="stylesheet" href="<c:url value='/static/login/css/AdminLTE.min.css'/>" ></link>	
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
 
<body class="hold-transition lockscreen">
		<section id="site-content">
			<tiles:insertAttribute name="body" />
		</section>
	
<script type="text/javascript" src="<c:url value='/static/login/js/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/login/js/bootstrap.min.js'/>"></script>

</body>
</html>