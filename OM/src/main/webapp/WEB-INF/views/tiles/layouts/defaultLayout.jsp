<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
	<title><tiles:getAsString name="title" /></title>
  <link href="<c:url value='/static/bower_components/bootstrap/dist/css/bootstrap.min.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/bower_components/font-awesome/css/font-awesome.min.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/bower_components/Ionicons/css/ionicons.min.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/bower_components/bootstrap-daterangepicker/daterangepicker.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css' />" rel="stylesheet"></link>
  
   <link href="<c:url value='/static/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/bower_components/jvectormap/jquery-jvectormap.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/bower_components/jvectormap/jquery-jvectormap.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/bower_components/select2/dist/css/select2.min.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/dist/css/AdminLTE.min.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/dist/css/skins/_all-skins.min.css' />" rel="stylesheet"></link>
	
</head>
 
<body class="hold-transition skin-blue sidebar-mini">
<%
    session=request.getSession(true);
    if(session.getAttribute("user")==null)
    {
        response.sendRedirect("redirect:/");
    }
%>
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

<script type="text/javascript" src="<c:url value='/static/bower_components/jquery/dist/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/bower_components/bootstrap/dist/js/bootstrap.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/bower_components/fastclick/lib/fastclick.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/dist/js/adminlte.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/bower_components/datatables.net/js/jquery.dataTables.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js'/>"></script>

<script type="text/javascript" src="<c:url value='/static/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/plugins/jvectormap/jquery-jvectormap-world-mill-en.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/bower_components/jquery-slimscroll/jquery.slimscroll.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/bower_components/chart.js/Chart.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/dist/js/pages/dashboard2.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/dist/js/demo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/bower_components/select2/dist/js/select2.full.min.js'/>"></script>

<script type="text/javascript" src="<c:url value='/static/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js'/>"></script>

<script>
  $(function () {
    $('#example1').DataTable()
    $('#example2').DataTable({
      'paging'      : true,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false
    })
  })
</script>
</body>
</html>