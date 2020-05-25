<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="<c:url value='/static/bower_components/jquery/dist/jquery.min.js'/>"></script>

 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       Offer List
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Offer</li>
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
              <h3 class="box-title"><a href="${pageContext.request.contextPath}/clientOffer" class="btn btn-block btn-primary btn-flat">Create Offer +</a></h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead style="background-color: #3c8dbc;color: #fdfdfd;">
                <tr>
                  <th>Offer Name</th>
                  <th>Item Name</th>
                  <th>Purchase Type</th>
                  <th>Offer Gift</th>
                  <th>Offer On Purchase Amount</th>
                  <th>Offer From</th>
                  <th>Offer Till</th>
                  <th>Offer Period</th>
                  <th>Status</th>
                  <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${offer_list.size()>0}">
                   <c:forEach items="${offer_list}" var="offer" varStatus="status">
                <tr>
                  <td>${offer.offerName}</td>
                  <td>${offer.itemsDto.itemName}</td>
                  <td>${offer.type}</td>
                  <td>${offer.gift}</td>
                  <td>${offer.purchase}</td>
                  <td><c:set var="date_from" value="${offer.durationFrom}" /> <fmt:formatDate
												type="date" value="${date_from}" /></td>
				  <td><c:set var="date_to" value="${offer.durationTo}" /> <fmt:formatDate
												type="date" value="${date_to}" /></td>
				  <td>${offer.duration}</td>
				  <td>${offer.active}</td>
                  <td><a class="fa fa-fw fa-bank" href="${pageContext.request.contextPath}/clientget-offer?id=${offer.id}"></a> <a class="fa fa-fw fa-trash-o" href="${pageContext.request.contextPath}/clientdelete-offer?id=${offer.id}"></a></td>
                </tr>
               </c:forEach>
               </c:if>
                </tbody>
                <tfoot>
                <tr>
                 
                </tr>
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
     <input type="hidden" id="activeItemUrl" value="${pageContext.request.contextPath}/clientItems">
  </div>
  <!-- /.content-wrapper -->
<script type="text/javascript">
  $( document ).ready(function() {
	  
  });
 function deleteOffer(var id){
	window.location = "${pageContext.request.contextPath}/clientdelete-offer?id="+id;
 }
  
  </script>