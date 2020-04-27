 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="<c:url value='/static/bower_components/jquery/dist/jquery.min.js'/>"></script>
 
 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
      Create Customer
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Customer</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
   
    <div class="box box-default">
        <div class="box-header with-border">
          <h3 class="box-title">Customer</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
          </div>
        </div>
        <!-- /.box-header -->
        <form role="form" method="post">
        <div class="box-body">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label>Type</label>
               <select class="form-control select2" id="type" style="width: 100%;">
                  <option selected="selected">Select Type</option>
                  <c:forEach items="${types}" var="type" varStatus="status">
                  <option value="${type.id}">${type.itemTypeName}</option>
                  </c:forEach>
                </select> 
               <%--  <form:select path = "country">
                     <form:option value = "NONE" label = "Select"/>
                     <form:options items = "${countryList}" />
                  </form:select>   --%>
              </div>
              <!-- /.form-group -->
              <div class="form-group">
                  <label for="exampleInputEmail1">Quantity</label> 
                  <input type="text" class="form-control" id="quantity" name="quantity" placeholder="Enter Quantity">
                </div>
              <!-- /.form-group -->
            </div>
            <!-- /.col -->
             <div class="col-md-6">
              <div class="form-group">
                  <label for="exampleInputEmail1">Name</label>
                  <input type="text" class="form-control" id="itemName" name="itemName" placeholder="Enter Name">
                </div>
              <!-- /.form-group -->
              <div class="form-group">
                  <label for="exampleInputEmail1">Available Quantity</label>
                  <input type="text" class="form-control" id="availableQty" name="availableQty" placeholder="Enter Available Qty.">
                </div>
              <!-- /.form-group -->
            </div>
             <div class="col-md-6">
              <div class="form-group">
                  <label for="exampleInputEmail1">Old Price(Rs.)</label>
                  <input type="text" class="form-control" id="oldPrice" name="oldPrice" placeholder="Enter Old Price">
                </div>
              <!-- /.form-group -->
              <div class="form-group">
                  <label for="exampleInputEmail1">Current Price(Rs.)</label>
                  <input type="text" class="form-control" id="currentprice" name="currentprice" placeholder="Enter Current Price">
                </div>
              <!-- /.form-group -->
            </div>
             <div class="col-md-6">
               <div class="form-group">
                <label>Status</label>
                <select class="form-control select3" id="status" name="status" style="width: 100%;">
                  <option selected="selected">Active</option>
                  <option>Inactive</option>
                </select>
              </div>
              <!-- /.form-group -->
              <div class="form-group">
                  <label for="exampleInputEmail1">Pack</label>
                  <input type="text" class="form-control" id="pack" name="pack" placeholder="Enter Pack(Kg/Gm/ltr/ml)">
                </div>
              <!-- /.form-group -->
            </div>
             
             <div class="col-md-6">
              <!-- /.form-group -->
             <!--  <div class="form-group">
                  <label for="exampleInputEmail1">Pack</label>
                  <input type="email" class="form-control" id="pack" name="pack" placeholder="Enter Pack(Kg/Gm/ltr/ml)">
                </div> -->
             <div class="form-group">
                  <label for="exampleInputFile">Selact Image</label>
                  <input type="file" id="imagepath" name="file" >
                </div>
              <!-- /.form-group -->
            </div>
            <!-- /.col -->
          </div>
          <!-- /.row -->
        </div>
        <div class="box-footer">
                <button type="submit" id="btn-save" class="btn btn-primary">Submit</button>
                 <button type="reset" class="btn btn-default">Reset</button>
                 
        </div>
         <input type="hidden" id=imagepath name="imagepath">
        </form>
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
		 alert('pathname-->'+filePath);
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
   </script>