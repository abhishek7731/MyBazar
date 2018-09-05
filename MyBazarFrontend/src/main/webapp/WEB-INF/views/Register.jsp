<%@ page language="java" contentType="text/html"%>

<%@include file="Header.jsp"%>
<h3>Register Page</h3>

<div id="signupbox" style=" margin-top: 50px"
	class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="panel-title">Sign Up</div>
			<div
				style="float: right; font-size: 85%; position: relative; top: -10px">
				<a id="signinlink" href="#"
					onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a>
			</div>
		</div>
		<div class="panel-body">
			<form id="signupform" class="form-horizontal"
				action="${pageContext.request.contextPath}/registersave"
				method="post" role="form">

				<div id="signupalert" 
					class="alert alert-danger">
					<p>${error}</p>
					<span></span>
				</div>

				

				<div class="form-group">
					<label for="username" class="col-md-3 control-label">Login Name</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="username"
							placeholder="Enter Username to Login." required="">
					</div>
				</div>

				<div class="form-group">
					<label for="email" class="col-md-3 control-label">Email</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="email"
							placeholder="Email Address" required="">
					</div>
				</div>

				<div class="form-group">
					<label for="firstname" class="col-md-3 control-label">First
						Name</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="firstname"
							placeholder="First Name" required="">
					</div>
				</div>
				<div class="form-group">
					<label for="lastname" class="col-md-3 control-label">Last
						Name</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="lastname"
							placeholder="Last Name" required="">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-md-3 control-label">Password</label>
					<div class="col-md-9">
						<input type="password" class="form-control" name="password"
							placeholder="Password" required="">
					</div>
				</div>

				<div class="form-group">
					<label for="address" class="col-md-3 control-label">Address</label>
					<div class="col-md-9">
						<textarea class="form-control" name="address" placeholder=""></textarea>
					</div>
				</div>

				<div class="form-group">
					<label for="mobile" class="col-md-3 control-label">Mobile</label>
					<div class="col-md-9">
						<input type="text" required="" min="0" maxlength="10"
							pattern="[678]{1}[0-9]{9}" class="form-control" name="mobile"
							placeholder="mobile">
					</div>
				</div>


				<div class="form-group">
					<!-- Button -->
					<div class="col-md-offset-3 col-md-9">
						<button id="btn-signup" type="submit" class="btn btn-info">
							<i class="icon-hand-right"></i> &nbsp Sign Up
						</button>
						<span style="margin-left: 8px;">or</span>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>