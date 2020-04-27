 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       Order List
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Order</li>
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
              <h3 class="box-title"><a href="${pageContext.request.contextPath}/create" class="btn btn-block btn-primary btn-flat">Create Order +</a></h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead style="background-color: #3c8dbc;color: #fdfdfd;">
                <tr>
                  <th>OrderNo</th>
                  <th>Item Name</th>
                  <th>Requested Date</th>
                  <th>No.of Quantity</th>
                  <th>Total Amount</th>
                  <th>Status</th>
                   <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <td><a href="pages/examples/invoice.html">OR9842</a></td>
                  <td>ONION</td>
                  <td>2020-04-10 18:33:32</td>
                  <td> 4 KG</td>
                   <td>4000</td>
                  <td><span class="label label-success">Shipped</span></td>
                   <td><a class="btn btn-primary btn-xs">Accept</a><a class="btn btn-danger btn-xs">Reject</a></td>
                </tr>
                 <tr>
                  <td><a href="pages/examples/invoice.html">OR9GH8</a></td>
                  <td>POTATO</td>
                  <td>2020-04-10 18:33:32</td>
                  <td>10 KG</td>
                   <td>4000</td>
                  <td><span class="label label-warning">Pending</span></td>
                   <td><a class="btn btn-primary btn-xs">Accept</a><a class="btn btn-danger btn-xs">Reject</a></td>
                </tr>
                 <tr>
                  <td><a href="pages/examples/invoice.html">89HH42</a></td>
                  <td>TOMATO</td>
                  <td>2020-04-10 18:33:32</td>
                  <td>1/2 KG</td>
                   <td>4000</td>
                  <td><span class="label label-danger">Delivered</span></td>
                   <td><a class="btn btn-primary btn-xs">Accept</a><a class="btn btn-danger btn-xs">Reject</a></td>
                </tr>
                <tr>
                  <td><a href="pages/examples/invoice.html">ORRR42</a></td>
                  <td>WATER MILLON</td>
                  <td>2020-04-10 18:33:32</td>
                  <td>4 Pices</td>
                   <td>4000</td>
                  <td><span class="label label-info">Processing</span></td>
                   <td><a class="btn btn-primary btn-xs">Accept</a><a class="btn btn-danger btn-xs">Reject</a></td>
                </tr>
                </tbody>
                <tfoot>
                <tr>
                  <!-- <th>Rendering engine</th>
                  <th>Browser</th>
                  <th>Platform(s)</th>
                  <th>Engine version</th>
                  <th>CSS grade</th> -->
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
  </div>
  <!-- /.content-wrapper -->