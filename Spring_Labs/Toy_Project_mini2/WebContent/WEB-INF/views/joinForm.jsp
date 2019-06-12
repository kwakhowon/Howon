<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



         <!-- your content here -->
  <div class="card">
  <div class="card-body">
    <form action="Ex02_JDBC_JoinOK.jsp" method="post" name="joinForm" id="joinForm">
      <div class="form-row">
        <div class="form-group col-md-6">
          <label for="">ID</label>
          <input type="text" class="form-control" id="id" name="id" placeholder="아이디">
        </div>
        <div class="form-group col-md-6">
          <label for="">Password</label>
          <input type="password" class="form-control" id="pwd" name="pwd" placeholder="비밀번호">
        </div>
        <div class="form-group col-md-6">
          <label for="">Name</label>
          <input type="text" class="form-control" id="mname" name="mname" placeholder="이름">
        </div>
        <div class="form-group col-md-6">
          <label for="">Age</label>
          <input type="text" class="form-control" id="age" name="age" maxlength="3" placeholder="나이">
        </div>
      </div>

      <div class="form-row">
        <div class="form-group col-md-12">
          <label for="">Email</label>
          <input type="email" class="form-control" id="email" name="email" placeholder="이메일">
        </div></div>
        
        <div class="form-row">
        <div class="form-group col-md-12">
          <label for="form-check-label">Gender</label><br>
			  <div class="form-check form-check-radio form-check-inline">
			      <label class="form-check-label">
			        <input class="form-check-input" type="radio" name="gender" id="gender" value="남자"> 남자
			        <span class="form-check-sign"></span>
			      </label> </div>
			        <div class="form-check form-check-radio form-check-inline">
			      <label class="form-check-label">
			        <input class="form-check-input" type="radio" name="gender" id="gender" value="여자"> 여자
			        <span class="form-check-sign"></span>
			      </label> </div>
        </div>
      </div>
	<br>

      <button class="btn btn-primary animation-on-hover" type="submit">Create your account</button>
      <button class="btn btn-primary btn-simple" type="reset">Re-enter</button>
    </form>
  </div>
</div>

