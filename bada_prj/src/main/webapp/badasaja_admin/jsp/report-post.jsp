<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
  <html
        lang="en"
        class="light-style layout-menu-fixed"
        dir="ltr"
        data-theme="theme-default"
        data-assets-path="../assets/"
        data-template="vertical-menu-template-free"
>
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"
    />

    <title>Tables - Basic Tables | Sneat - Bootstrap 5 HTML Admin Template - Pro</title>

    <meta name="description" content="" />

    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="../assets/img/favicon/favicon.ico" />

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
      rel="stylesheet"
    />

    <!-- Icons. Uncomment required icon fonts -->
    <link rel="stylesheet" href="../assets/vendor/fonts/boxicons.css" />

    <!-- Core CSS -->
    <link rel="stylesheet" href="../assets/vendor/css/core.css" class="template-customizer-core-css" />
    <link rel="stylesheet" href="../assets/vendor/css/theme-default.css" class="template-customizer-theme-css" />
    <link rel="stylesheet" href="../assets/css/demo.css" />

    <!-- Vendors CSS -->
    <link rel="stylesheet" href="../assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />

    <!-- Page CSS -->

    <!-- Helpers -->
    <script src="../assets/vendor/js/helpers.js"></script>

    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
    <script src="../assets/js/config.js"></script>
 </head>


<body>

<%@ include file="nav.jsp"%>

<div class="layout-wrapper layout-content-navbar">
    <div class="layout-container">
      <!-- Menu -->
      <%@ include file="sidemenu.jsp"%>
      <!-- / Menu -->
      <div class="layout-page">
        <!-- Content wrapper -->
        <div class="content-wrapper">
          <!-- Content -->
       	  <div class="container-xxl flex-grow-1 container-p-y">
       		 <div class="tab-content doc-example-content" id="tab-tabContent" data-label="Example">
    			<!-- Report -->
    			<h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Report /</span>게시글 신고 리스트</h4>
   				<div class="card" style="height:500px; overflow-y:scroll;">
                        <!-- Search -->
                        <div class="navbar-nav mb-3">
                            <div class="nav-item d-inline">
                                <button type="button" class="btn btn-outline-primary dropdown-toggle float-end" data-bs-toggle="dropdown" style="margin:15px;" >상태</button>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="javascript:void(0);">처리중</a></li>
                                    <li><a class="dropdown-item" href="javascript:void(0);">처리완료</a></li>
                                </ul>
                                <button type="button" class="btn btn-outline-primary dropdown-toggle float-end" data-bs-toggle="dropdown" style="margin-top:15px; margin-left:20px;" >카테고리 필터</button>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="javascript:void(0);">사기매물</a></li>
                                    <li><a class="dropdown-item" href="javascript:void(0);">욕설</a></li>
                                    <li><a class="dropdown-item" href="javascript:void(0);">성희롱</a></li>
                                </ul>
                                <a href="#" class="btn btn-primary float-end shadow-none" style="margin-top:15px; margin-left:10px">검색</a>
                                <input
                                        type="text"
                                        class="form-control shadow-none float-end"
                                        placeholder="작성자_ID검색"
                                        style="margin-top: 15px;width: 150px;"
                                />
                            </div>
                        </div>
                   <!-- /Search -->
                    	<div class="table-responsive text-nowrap">
        					<table class="table table-hover">
       							<thead>
        						  <tr>
          							<th>번호</th>
        							<th>작성자</th>
          							<th>본문</th>
        						    <th>카테고리</th>
        							<th>작성일</th>
         							<th>상태</th>
       							  </tr>
      						    </thead>
       						    <tbody class="table-border-bottom-0">
       							 <tr>
						          <td><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>1</strong></td>
						          <td>cok894</td>
						          <td>술을올림...</td>
						          <td>금지상품</td>
						          <td>2022.04.03</td>
						          <td>
           							 <span class="badge bg-label-primary me-1">처리완료</span>
          						  </td>
       							 </tr>
     			   				 <tr>	
          						  <td><i class="fab fa-react fa-lg text-info me-3"></i> <strong>2</strong></td>
          						  <td>ked872</td>
          						  <td>담배올림...</td>
						          <td>금지상품</td>
						          <td>2022.04.01</td>
						          <td>
						            <span class="badge bg-label-info me-1">처리중</span>
						          </td>
        						 </tr>
     						    </tbody>
    					  </table>
   						</div>
  					</div>
   				<!-- /Report -->		
   						<h5 class="card-header">상세보기</h5>
  						<div class="card">
     						<div class="card-body" >
        						ddd
      						</div>
    					</div>
    			 </div>
      		  </div>
     	   </div>
        </div>   
    </div>
</div>


<!-- Core JS -->
<!-- build:js assets/vendor/js/core.js -->
<script src="../assets/vendor/libs/jquery/jquery.js"></script>
<script src="../assets/vendor/libs/popper/popper.js"></script>
<script src="../assets/vendor/js/bootstrap.js"></script>
<script src="../assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

<script src="../assets/vendor/js/menu.js"></script>
<!-- endbuild -->

<!-- Vendors JS -->

<!-- Main JS -->
<script src="../assets/js/main.js"></script>

<!-- Page JS -->

<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="https://buttons.github.io/buttons.js"></script>

</body>
</html>

