 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="<c:url value='/static/bower_components/jquery/dist/jquery.min.js'/>"></script>
 
 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
      Create Product
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Items</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
   
    <div class="box box-default">
        <div class="box-header with-border">
          <h3 class="box-title">Item</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
          </div>
        </div>
        <!-- /.box-header -->
    <%--     <form role="form" method="post"> --%>
  <form:form method="post" action="/OMart/saveItem" modelAttribute="itemsDto" >
        <div class="box-body">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label>Type</label>
               <select class="form-control select2" id="types" style="width: 100%;" onchange="selectCategory();">
                  <option selected="selected">Select Type</option>
                  <c:forEach items="${types}" var="type" varStatus="status">
                  <option value="${type.id}">${type.itemTypeName}</option>
                  </c:forEach>
                </select> 
 				<input type="hidden" id="category" name="category" value="">
              </div>
              <!-- /.form-group -->
              <div class="form-group" >
                  <label for="exampleInputEmail1">Item Desc.</label> 
                  <input type="text" class="form-control" id="description" name="description" placeholder="Enter Item Description">
                </div>
              <!-- /.form-group -->
            </div>
            <!-- /.col -->
             <div class="col-md-6">
              <div class="form-group">
                  <label for="exampleInputEmail1">Name</label>
                  <input type="text" class="form-control" id="itemName" name="itemName" placeholder="Enter Item Name">
                </div>
              <!-- /.form-group -->
               <div class="form-group">
                  <label for="exampleInputEmail1">MRP(Rs.)</label>
                  <input type="text" class="form-control" id="mrp" name="mrp" placeholder="Enter Price (Rs.)">
                </div>
              <!-- /.form-group -->
            </div>
             <div class="col-md-6">
             <div class="form-group">
                <label>Status</label>
                <select class="form-control select3" id="status" name="status" style="width: 100%;" onchange="selectStatus();">
                  <option selected="selected">Active</option>
                  <option>Inactive</option>
                </select>
                <input type="hidden" id="active" name="active" value="true">
              </div>
                <div class="form-group">
                  <label for="exampleInputEmail1">Pack</label>
                  <input type="text" class="form-control" id="pack" name="pack" placeholder="Enter Pack(Kg/Gm/ltr/ml)">
                </div>
            </div>
         <div class="col-md-6">
            <div class="form-group">
                  <label for="exampleInputEmail1">Unit Price</label>
                  <input type="text" class="form-control" id="unitPrice" name="unitPrice" placeholder="Enter Offer_units">
                </div>
                
            </div>
             <div class="col-md-6">
              <!-- /.form-group -->
             <div class="form-group">
                  <label for="exampleInputFile">Item Image</label>
                  <input type="file" name="file" onchange="uploadImage();" id="file"   accept="image/jpeg, image/png"  >
               	<input type="hidden" id="itemImage" name="itemImage" value="">
				</div>
            </div>
            <!-- /.col -->
          </div>
          <!-- /.row -->
        </div>
        <div class="box-footer">
                <button type="submit"  class="btn btn-primary">Submit</button>
                 <button type="reset" class="btn btn-default">Reset</button>
                 
        </div>
         <input type="hidden" id=imagepath name="imagepath">
       </form:form>
      </div>
    </section>
    <input type="hidden" id="error" value="${error}">
    <!-- /.content -->
    <input type="hidden" id="itemListUrl" name="itemListUrl"  value="${pageContext.request.contextPath}/items"> 
  </div>
  <!-- /.content-wrapper -->
  <script>
  $(function () {
	var error=$('#error').val();
	if((error == "")){
	}else{
		alert('This Item already exist');	
	}
	var fileName="";
    $("#btn-save").click(function(event) {
    	 var imagePath=$('#imagePath').val();
   	  alert(imagePath);
    	var filename = $('input[type=file]').val().replace(/.*(\/|\\)/, '');
    	var type= $("#type option:selected" ).val();
    	var status=$("#status option:selected" ).text(); 
    	var offerType=$("#offerprice option:selected" ).text(); 
    	var itemListUrl =$('#itemListUrl').val(); 
    	var formData = {};
    	alert($("#itemName").val());
    	formData["itemName"] = $("#itemName").val();
    	formData["description"] = $("#description").val();
    	formData["mrp"] = $("#mrp").val();
    	formData["pack"] = $("#pack").val();
    	formData["unitPrice"] = $("#unitPrice").val();
		if(status=="Success"){
			formData["active"] = true;
		}else{
			formData["active"] = false;
		}
		formData["category"] = type;
		formData["offerType"] = offerType;
		formData["itemImage"] =filename;
		$("#btn-save").prop("disabled", true);
		 var pathname = window.location.pathname;
		 var filePath=$('input[type=file]').val(); 
		
		$.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/OMart/saveItem",
            data: JSON.stringify(formData),
            dataType: 'json',
            timeout: 600000,
            success: function (data) {
            	if(data.status=="Success"){
            		 var r=confirm("Data save successfully! Go to Item list");
		            	if(r==true){
		            		window.location="/OMart/apiItems";
		            	}else{
		            		$("#btn-save").prop("disabled", true);	
		            	}
            	}else{
            		 $("#btn-save").prop("disabled", false);
            	}
            },
            error: function (e) {
                $("#btn-save").prop("disabled", false);
                //...
            }
		});
    	
    });
    
    
    
    });
  $('#imageFile').change( function(event) {	 // var tmppath = event.target.files[0].name;
	  //$("img").fadeIn("fast").attr('src',URL.createObjectURL(event.target.files[0]));
	 
  });
 function uploadImage(){
	 var tmppath =  URL.createObjectURL(event.target.files[0]);
	 var imageFile =$("#imageFile").val();
	 $('#itemImage').val(imageFile);
	 alert(imageFile);
 } 
  function selectCategory(){
	  var type= $("#types option:selected" ).val();
	  $('#category').val(type);
  } 
  function selectStatus(){
	  var status=$("#status option:selected" ).text(); 
	 
	  if(status=="Active"){
		  $('#active').val(true); 
		  alert(status);
	  }else{
		  $('#active').val(false); 
		  alert('Active -->'+status);
	  }
  }
  
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