<%--
  Created by IntelliJ IDEA.
  User: seohuisu
  Date: 2022/04/12
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
    #searchArea{
        margin-left: 30px;
        font-family: 'NanumSquareRound';
    }
    .main_banner{
        margin-left: 30px;
        font-family: 'NanumSquareRound';
    }
    #container{margin: 0px auto;}
    #span1{
        font-style: bold;
        font-size: 15px;
        color: #333;
        font-family: 'NanumSquareRound';
    }

    #span2{text-align: right; }

    .container1{
        width: 700px;
        margin: 0px auto;
        font-family: 'NanumSquareRound';
        color: #333;
    }
    .container2{
        margin: 0px auto;
        font-family: 'NanumSquareRound';
        color: #333;
    }
    .container3{
        margin: 0px auto;
        font-family: 'NanumSquareRound';
        color: #333;
    }
    .container4{text-align: center;
        font-family: 'NanumSquareRound';
        color: #333;
    }

    .banner_line{
        border: 0px;
        background-color: #fada95;;
        height: 25px;
        margin-bottom: 10px;
    }

    #nickname{
        font-weight: bold;
        color: #333;
        vertical-align: middle;

    }
    #mainLogo{
        width : 300px;
        height: 100px;
    }
</style>
<header class="site-navbar" role="banner" style="z-index: 1;">
    <div class="site-navbar-top">
        <div class="container">
            <div class="row align-items-center">

                <div class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">

                </div>

                <div class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
                    <div>
                        <a href="index.jsp" ><img src="../images/main_logo.png.jpg" id="mainLogo"></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
<%
String idd="null";
if(session.getAttribute("cId")!=null){
	idd="exist";
}
%>
<script type="text/javascript">
$(function () {
	$('#cancel').click(function(e){
		e.preventDefault();
		$('#Modal').modal("hide");
	});
	
	$('#login').click(function(e){
		e.preventDefault();
		$('#Modal').modal("hide");
		location.href="login.jsp";
	});

})//ready

function load2() {
	if($("#hid").val()=="null"){
		$('#Modal').modal("show");
	}else{
		location.href="trade.jsp";
	}
}
</script>
    <nav class="site-navigation text-right text-md-center" role="navigation">
        <div class="container">
<input type="hidden" value="<%=idd%>">
            <a href="javascript:void(0)" onclick="load2()" class="main_banner">물물교환</a>
		<!--<a href="trade.jsp" class="main_banner">물물교환</a> -->
<!--             <a href="ranking.jsp" class="main_banner">우리 동네 랭킹</a>
            <input type="text" placeholder="동네, 물품을 검색해주세요"
                   id="searchArea" style="width:300px"/>
            <input type="button" value="검색" id="btnSearch" style="background-color: #e0e0e0; border: 0px; border-radius:5px; width:60px; font-weight: bold;
             font-family: 'NanumSquareRound';"> -->
        
            <%if(session.getAttribute("cId")==null ){%>	
			<a href="login.jsp" style="margin-left: 50px;">로그인</a>
			<%}else{	 %>
		    <a href="write_forum.jsp" class="main_banner">글쓰기</a>
            <a href="favorites.jsp"><span style="margin-left: 20px; margin-top:10px; font-size: 25px ">♡</span></a>
			
			<a href="settings_password.jsp"><span class="icon icon-person" style="margin-left: 10px;"></span></a>
			<a href="logout.jsp" style="margin-left: 10px;">로그아웃</a>
			<%} %>
            
        </div>
    </nav>
</header>

    <!-- 로그인이 필요한 서비스입니다. -->
<div class="modal fade" id="Modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">앗 바다사자 회원이 아니시군요!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        로그인이 필요한 서비스입니다.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="cancel">CANCEL</button>
        <button type="button" class="btn btn-primary" id="login">LOGIN</button>
      </div>
    </div>
  </div>
</div>
<div class="banner_line"></div>


