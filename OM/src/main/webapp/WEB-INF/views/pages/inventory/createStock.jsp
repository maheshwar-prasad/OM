 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="<c:url value='/static/bower_components/jquery/dist/jquery.min.js'/>"></script>
 
 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
      Create Stock
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Create Stock</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
   
    <div class="box box-default">
        <div class="box-header with-border">
          <h3 class="box-title">Stock</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
          </div>
        </div>
        <!-- /.box-header -->
       <%--  <form role="form" method="post">
        <div class="box-body">
          <div class="row">
           <div class="box-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead style="background-color: #3c8dbc;color: #fdfdfd;">
                <tr>
                  <th>Item Id</th>
                  <th>Quantity</th>
                  <th>Action</th>
                </tr>
                </thead>
                <tbody>
                
                </tbody>
                
                </table>
               </div>
          </div>
          <!-- /.row -->
        </div>
        <div class="box-footer">
                <button type="submit" id="btn-save" class="btn btn-primary">Submit</button>
                 <button type="reset" class="btn btn-default">Reset</button>
                 
        </div>
         <input type="hidden" id=imagepath name="imagepath">
        </form> --%>
        
<form:form method="post" action="/OMart/saveStock" modelAttribute="contactForm">
         <div class="box-body">
          <div class="row">
           <div class="box-body">
		<table id="example1" class="table table-bordered table-striped">
		  <tr>
				<th>No.</th>
				<th>Item Name</th>
				<th>Quantity</th>
				
			</tr>			
	<c:forEach items="${ItemsResponses.data}" var="item" varStatus="status">
		<tr>
			<td align="center">${status.count}</td>
			<td><input type="hidden" name="data[${status.index}].id" value="${item.id}"/>
			<input name="data[${status.index}].itemName" value="${item.itemName}" /></td>
			<td><input name="data[${status.index}].pack" value="${item.pack}"/></td>
		</tr>
	</c:forEach>
</table>	
 </div>
</div>
</div>
<br/>
<div class="box-footer" style="text-align: center;">
                <button type="submit" id="btn-save" class="btn btn-primary">Submit</button>
                 <button type="button" onclick="javascript:gotoBack();" class="btn btn-default">Back</button>
                 
        </div>
</form:form>
      </div>
    </section>
    <!-- /.content -->
    <input type="hidden" id="itemListUrl" name="itemListUrl"  value="${pageContext.request.contextPath}/items"> 
  </div>
  <!-- /.content-wrapper -->
  <script>
  $(function () {
	  var fileName="";
    //Initialize Select2 Elements
    $("#btn-save").click(function(event) {
    	var filename = $('input[type=file]').val().replace(/.*(\/|\\)/, '');
    	var type= $("#type option:selected" ).val();
    	var status=$("#status option:selected" ).text(); 
    	var itemListUrl =$('#itemListUrl').val(); 
    	var data = {};
		data["id"] = $("#id").val();
		data["itemName"] = $("#itemName").val();
		data["quantity"] = $("#quantity").val();
		data["availableQty"] = $("#availableQty").val();
		data["oldPrice"] = $("#oldPrice").val();
		data["currentPrice"] = $("#currentprice").val();
		data["status"] = status;
		data["type"] = type;
		data["pack"] = $("#pack").val();
		data["imagepath"] =filename;
		$("#btn-save").prop("disabled", true);
		 var pathname = window.location.pathname;
		 var filePath=$('input[type=file]').val(); 
		$.ajax({
            type: "POST",
            contentType: "application/json",
            url: pathname+"/item/save",
            data: JSON.stringify(data),
            dataType: 'json',
            timeout: 600000,
            success: function (data) {
            	if(data.status=="Success"){
            		 var r=confirm("Data save successfully! Go to Item list");
		            	if(r==true){
		            		window.location=itemListUrl;
		            	}else{
		            		$("#btn-save").prop("disabled", true);	
		            	}
            	}else{
            		 $("#btn-save").prop("disabled", false);
            	}
            },
            error: function (e) {
                $("#btn-save").prop("disabled", false);
            }
		});
    });
 });
function insertData(){
	  var userType= $("#userType option:selected" ).text();
	  var mobileNo= $('#mobileNo').val();
	  var name= $('#name').val();
	  var address= $('#address').val();
	  var userListUrl=$('#userListUrl').val();
	  alert(address);
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
  function gotoBack(){
	  window.location="/OMart/stock";
  }
   </script>