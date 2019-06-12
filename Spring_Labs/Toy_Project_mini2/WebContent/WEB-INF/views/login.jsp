<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


					<!-- your content here -->
					<div class="card">
						<div class="card-body">
							<form action="Ex02_JDBC_loginok.jsp" method="post" name="loginForm" id="joinForm">
								<div class="form-group">
									<label for="">ID</label> 
									<input type="text" class="form-control" id="exampleInputId1" name="id" placeholder="Enter ID">
									<small class="form-text text-muted">
									We'll never share your ID with anyone else.</small>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password</label> 
									<input type="password" class="form-control" id="exampleInputPassword1" name="pwd" placeholder="Password">
								</div>
								
								<div class="form-check">
									<label class="form-check-label"> 
									<input class="form-check-input" type="checkbox" value="" checked>
										Keep me signed in <span class="form-check-sign"> 
										<span class="check"></span>
									</span>
									</label>
								</div>
								<br>
								<button type="submit" class="btn btn-primary">Sign in</button>
							</form>
						</div>
					</div>
