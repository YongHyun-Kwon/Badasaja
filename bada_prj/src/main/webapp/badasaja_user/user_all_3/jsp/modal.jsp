<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    info=""%>
<!DOCTYPE html>
<!-- https://getbootstrap.com/docs/4.0/components/modal/
��Ʈ��Ʈ�� ��� �ּ� -->
<html>
<head>
<style type="text/css">


</style>
<!-- jquery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- boot Strap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function () {

	$('#testBtn').click(function(e){
		e.preventDefault();
		$('#testModal').modal("show");
	});
	
	$('#ss').click(function(e){
		e.preventDefault();
		$('#testModal').modal("hide");
	});
	
	$('#testBtn2').click(function(e){
		e.preventDefault();
		$('#testModal2').modal("show");
	});
	
	$('#testBtn3').click(function(e){
		e.preventDefault();
		$('#testModal3').modal("show");
	});
	
	$('#testBtn4').click(function(e){
		e.preventDefault();
		$('#testModal4').modal("show");
	});
	
	$('#search').click(function(e){
		e.preventDefault();
		$('#testModal4_1').modal("show");
	});
	
	$('#testBtn5').click(function(e){
		e.preventDefault();
		$('#testModal5').modal("show");
	});
	
	$('#testBtn6').click(function(e){
		e.preventDefault();
		$('#testModal6').modal("show");
	});
	$('#testBtn7').click(function(e){
		e.preventDefault();
		$('#testModal7').modal("show");
	});
	$('#testBtn8').click(function(e){
		e.preventDefault();
		$('#testModal8').modal("show");
	});
	
	$('#testBtn9').click(function(e){
		e.preventDefault();
		$('#testModal9').modal("show");
	});
})//ready
</script>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
  <button id="testBtn" class="btn">�α����� �ʿ��� �����Դϴ�.</button>
  <!-- ȸ������ Ȯ�� Modal-->
<!-- Modal -->
<div class="modal fade" id="testModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">�� �ٴٻ��� ȸ���� �ƴϽñ���!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        �α����� �ʿ��� �����Դϴ�.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="ss">CANCEL</button>
        <button type="button" class="btn btn-primary">LOGIN</button>
      </div>
    </div>
  </div>
</div>

  <button id="testBtn2" class="btn">���̵�ã��</button>
<div class="modal fade" id="testModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">���̵� ã��</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">E-Mail�Է�</label>
            <input type="text" class="form-control" id="recipient-name" placeholder="���Խ� �Է��Ͻ� �̸����� �����ּ���.">
            <span style="font-size: 5px; color: #ff0000;">��ġ�ϴ� �̸����� �����ϴ�.</span>
          </div>
			 <div class="modal-body">
        		�Է��Ͻ� ���Ϸ� ���۵Ǿ����ϴ�.
      		</div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Send message</button>
      </div>
    </div>
  </div>
</div>

  <button id="testBtn3" class="btn">�α��� ����</button>
  <!-- ȸ������ Ȯ�� Modal-->
<!-- Modal -->
<div class="modal fade" id="testModal3" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">�α��� ����</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" style="color: #ff0000;">
        ��������
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">OK</button>

      </div>
    </div>
  </div>
</div>

  <button id="testBtn4" class="btn">��й�ȣã��</button>
<div class="modal fade" id="testModal4" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">��й�ȣ ã��</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">���̵� �Է�</label>
            <input type="text" class="form-control" id="recipient-name" placeholder="���̵� �Է����ּ���">
            <span style="font-size: 5px; color: #ff0000;">��ġ�ϴ� ȸ���� �����ϴ�.</span>
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">���Խ� �Է��Ͻ� �̸����� �����ּ���.</label>
            <input type="text" class="form-control" id="recipient-name" placeholder="���Խ� �Է��Ͻ� �̸����� �����ּ���.">
            <span style="font-size: 5px; color: #ff0000;">��ġ�ϴ� �̸����� �����ϴ�.</span>
          </div>          

        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">CANCEL</button>
        <button type="button" class="btn btn-primary" id="search">SEARCH</button>
      </div>
    </div>
  </div>
</div>

<!--  -->
<div class="modal fade" id="testModal4_1" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">��й�ȣ ã��</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Name���� �ӽ� ��й�ȣ�� �̸��Ϸ� ���۵Ǿ����ϴ�.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">OK</button>
      </div>
    </div>
  </div>
</div>

<!--  -->
<button id="testBtn5" class="btn">�Խñ� ���ε� ����</button>

<div class="modal fade" id="testModal5" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">�Խñ� ���ε� ����</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       �Խñ� ���� Ȥ�� ���뿡 ���� �ܾ �ֽ��ϴ�.<br>
       �����ڰ� Ȯ�� �� �Խñ��� ���ε� Ȥ�� �����˴ϴ�.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">OK</button>
      </div>
    </div>
  </div>
</div>

<!--  -->
<button id="testBtn6" class="btn">�Խñ� �ۼ� �Ϸ�</button>

<div class="modal fade" id="testModal6" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">�Խñ� �ۼ� �Ϸ�</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <span style="font-weight: bold;">�Խñ� �ۼ��� �Ϸ�Ǿ����ϴ�.</span><br/>
      �ٸ� �е��� �Խñ��� �����Ϸ� �������?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">OK</button>
      </div>
    </div>
  </div>
</div>

<button id="testBtn7" class="btn">ȸ�� Ż��</button>

<div class="modal fade" id="testModal7" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">ȸ�� Ż��</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <input type="checkbox" value="exit">
      Ż�� Ȯ�� ��ư�� �����ø� ȸ�� ������ �Ұ����մϴ�.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">���</button>
        <button type="button" class="btn btn-primary" id="search">Ż�� Ȯ��</button>
      </div>
    </div>
  </div>
</div>

<button id="testBtn8" class="btn">�Խñ� �Ű�</button>
<div class="modal fade" id="testModal8" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">�Խñ� �Ű�</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">
				 <span style="float: left;">�Խñ� �Ű�</span>
            </label>
             
             <select name="language" style=" float: right; margin-bottom: 1px;">
				    <option value="none">��������</option>
				    <option value="korean" >������ ����</option>
				    <option value="english">��� �Ÿ�</option>
				    <option value="chinese">����</option>
			</select>
            <input type="text" class="form-control" id="recipient-name" placeholder="����">
          </div>
          <div class="form-group">
          <label for="recipient-name" class="col-form-label"> </label>
            <textarea class="form-control" style="height: 300px;" id="message-text" placeholder="�Ű� ������ �Է����ּ���"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">CANCEL</button>
        <button type="button" class="btn btn-primary">SEND</button>
      </div>
    </div>
  </div>
</div>

<button id="testBtn9" class="btn">���� �Ű�</button>
<div class="modal fade" id="testModal9" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">���� �Ű�</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">
				 <span style="float: left;">���� �Ű�</span>
            </label>
             
             <select name="language" style=" float: right; margin-bottom: 1px;">
				    <option value="none">��������</option>
				    <option value="korean" >�弳</option>
				    <option value="english">���</option>
				    <option value="chinese">���</option>
			</select>
            <input type="text" class="form-control" id="recipient-name" placeholder="����">
          </div>
          <div class="form-group">
          <label for="recipient-name" class="col-form-label"> </label>
            <textarea class="form-control" style="height: 300px;" id="message-text" placeholder="�Ű� ������ �Է����ּ���"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">CANCEL</button>
        <button type="button" class="btn btn-primary">SEND</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>
